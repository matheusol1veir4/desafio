package br.com.desafio.avaliacao.headless.internal.resource.v1_0;

import br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoCompleta;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.internal.converter.ConverterDto;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoResource;
import br.com.example.model.avaliacao.service.AvaliacaoDetalheLocalService;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import br.com.example.model.avaliacao.service.search.AvaliacaoSearchHelper;
import br.com.example.model.avaliacao.service.search.AvaliacaoSearchService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.vulcan.pagination.Page;

import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


/**
 * Resource implementation para gerenciamento de avaliações via REST API.
 *
 * @author sea
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/avaliacao.properties",
		scope = ServiceScope.PROTOTYPE,
		service = AvaliacaoResource.class
)
public class AvaliacaoResourceImpl extends BaseAvaliacaoResourceImpl {



	/**
	 * Busca uma avaliação específica por ID.
	 *
	 * @param avaliacaoId ID da avaliação
	 * @return DTO da avaliação encontrada
	 * @throws PortalException se a avaliação não for encontrada
	 */
	@Override
	public Avaliacao getAvaliacaoById(Long avaliacaoId) throws PortalException {

		// Busca avaliação no banco via LocalService
		br.com.example.model.avaliacao.model.Avaliacao entity =
				_avaliacaoLocalService.getAvaliacao(avaliacaoId);

		return ConverterDto.entityToDto(entity); // Converte entity para DTO
	}


	/**
	 * Busca todas as avaliações de um funcionário específico.
	 *
	 * @param funcionarioId ID do funcionário
	 * @return página contendo lista de avaliações do funcionário
	 * @throws PortalException se houver erro ao acessar o banco de dados
	 */
	@Override
	public Page<Avaliacao> getAvaliacoesByFuncionario(Long funcionarioId)
			throws PortalException {

		// Busca entidades no banco via LocalService
		List<br.com.example.model.avaliacao.model.Avaliacao> entities =
				_avaliacaoLocalService.findByFuncionarioId(funcionarioId);

		// Retorna página vazia se não houver dados
		if (entities == null || entities.isEmpty()) {
			return Page.of(new ArrayList<>());
		}

		List<Avaliacao> dtos = ConverterDto.entityListToDtoList(entities);

		return Page.of(dtos); // Retorna página com DTOs
	}

	/**
	 * Busca a avaliação específica de um funcionário em determinado período.
	 *
	 * @param funcionarioId ID do funcionário
	 * @param periodoDesafio período do desafio (1=30, 2=60, 3=90 dias)
	 * @return DTO da avaliação encontrada
	 * @throws PortalException se a avaliação não for encontrada
	 */
	@Override
	public Avaliacao getAvaliacaoByFuncionarioAndPeriodo(Long funcionarioId, Integer periodoDesafio)
			throws PortalException {

		// Busca avaliação no banco via LocalService
		br.com.example.model.avaliacao.model.Avaliacao entity =
				_avaliacaoLocalService.findByFuncionarioIdAndPeriodoDesafio(funcionarioId, periodoDesafio);

		if (entity == null) {
			throw new PortalException("Avaliação não encontrada para funcionário " + funcionarioId +
					" no período " + periodoDesafio);
		}

		return convertEntityToDTO(entity); // Converte entity para DTO
	}

	/**
	 * Busca avaliação completa com todos os detalhes de avaliadores.
	 *
	 * @param avaliacaoId ID da avaliação
	 * @return AvaliacaoCompleta DTO com avaliação + array de detalhes
	 * @throws PortalException se a avaliação não existir
	 */
	@Override
	public AvaliacaoCompleta getAvaliacaoCompletaById(Long avaliacaoId) throws PortalException {

		// 1. Busca a avaliação principal
		br.com.example.model.avaliacao.model.Avaliacao avaliacaoEntity =
				_avaliacaoLocalService.getAvaliacao(avaliacaoId);

		// 2. Busca TODOS os detalhes relacionados
		List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> detalhesEntities =
				_avaliacaoDetalheLocalService.findByAvaliacaoId(avaliacaoId);

		// 3. NOVO: Usa ConverterDto para montar DTO composto
		return ConverterDto.toAvaliacaoCompleta(avaliacaoEntity, detalhesEntities);
	}

	/**
	 * Busca avaliações com filtros opcionais.
	 *
	 * Endpoint: GET /o/desafio-avaliacao/v1.0/avaliacoes/search
	 */
	@Override
	public Page<Avaliacao> searchAvaliacoes(
			String nome,
			String email,
			String data,
			Integer area,
			Integer periodo,
			Pagination pagination
	) throws Exception {

		long companyId = PortalUtil.getCompanyId(contextHttpServletRequest);

		// Validações
		if (!_searchHelper.isValidDateFormat(data)) {
			throw new IllegalArgumentException("Formato de data inválido. Use: yyyy-MM-dd");
		}

		if (!_searchHelper.isValidArea(area)) {
			throw new IllegalArgumentException("Área inválida. Valores permitidos: 1-5");
		}

		if (!_searchHelper.isValidPeriodo(periodo)) {
			throw new IllegalArgumentException("Período inválido. Valores permitidos: 1-3");
		}

		// Normalizar email
		email = _searchHelper.normalizeEmail(email);

		// Executar busca
		AvaliacaoSearchService.SearchResult searchResult = _searchService.searchAvaliacoes(
				nome,
				email,
				data,
				area,
				periodo,
				companyId,
				pagination.getStartPosition(),
				pagination.getEndPosition()
		);

		// Converter entidades para DTOs
		List<br.com.example.model.avaliacao.model.Avaliacao> entities = searchResult.getItems();
		List<Avaliacao> dtos = ConverterDto.entityListToDtoList(entities);

		// Retornar página com DTOs
		return Page.of(dtos, pagination, searchResult.getTotalCount());
	}



	/**
	 * Cria uma nova avaliação de desafio para um funcionário.
	 *
	 * @param avaliacao DTO contendo dados da nova avaliação
	 * @return DTO da avaliação criada com ID gerado
	 * @throws PortalException se os dados forem inválidos
	 */
	@Override
	public Avaliacao createAvaliacao(Avaliacao avaliacao) throws PortalException {

		// Chama LocalService para persistir nova avaliação
		br.com.example.model.avaliacao.model.Avaliacao entity =
				_avaliacaoLocalService.addAvaliacao(
						avaliacao.getFuncionarioId(),        // ID do funcionário
						avaliacao.getDataAvaliacao(),        // Date direto do DTO
						avaliacao.getPeriodoDesafio(),       // Período (30/60/90 dias)
						avaliacao.getObservacoesGerais(),    // Observações gerais
						avaliacao.getAreaAtuacao(),          // Área de atuação
						createServiceContext()               // Contexto da requisição
				);

		return ConverterDto.entityToDto(entity);  // Converte entity salva para DTO
	}

	/**
	 * Cria uma avaliação completa (avaliação + todos os detalhes) em uma única requisição.
	 * Endpoint: POST /o/desafio-avaliacao/v1.0/avaliacoes/completa
	 *
	 * @param avaliacaoCompleta DTO com avaliação + array de detalhes (TechLead, Gerente, RH)
	 * @return AvaliacaoCompleta DTO com IDs gerados
	 * @throws PortalException se dados inválidos ou erro ao salvar
	 */
	@Override
	public AvaliacaoCompleta createAvaliacaoCompleta(AvaliacaoCompleta avaliacaoCompleta)
			throws PortalException {

		ServiceContext serviceContext = createServiceContext();

		// 1. Cria a AVALIAÇÃO principal
		br.com.example.model.avaliacao.model.Avaliacao avaliacaoEntity =
				_avaliacaoLocalService.addAvaliacao(
						avaliacaoCompleta.getFuncionarioId(),
						avaliacaoCompleta.getDataAvaliacao(),
						avaliacaoCompleta.getPeriodoDesafio(),
						avaliacaoCompleta.getObservacoesGerais(),
						avaliacaoCompleta.getAreaAtuacao(),
						serviceContext
				);

		// 2. Obtem o avaliacaoId gerado
		long avaliacaoId = avaliacaoEntity.getAvaliacaoId();

		// 3. Cria TODOS os DETALHES (TechLead, Gerente, RH)
		List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> detalhesEntities =
				new ArrayList<>();

		AvaliacaoDetalhe[] detalhesDTO = avaliacaoCompleta.getAvaliacaoDetalhes();

		if (detalhesDTO != null && detalhesDTO.length > 0) {
			for (AvaliacaoDetalhe detalheDTO : detalhesDTO) {
				br.com.example.model.avaliacao.model.AvaliacaoDetalhe detalheEntity =
						_avaliacaoDetalheLocalService.addAvaliacaoDetalhe(
								avaliacaoEntity,
								detalheDTO.getTipoAvaliador(),
								detalheDTO.getNomeAvaliador(),
								detalheDTO.getObservacoesAvaliador(),
								detalheDTO.getDesempenho(),
								serviceContext
						);

				detalhesEntities.add(detalheEntity);
			}
		}

		// 4. Converte tudo de volta para DTO composto
		return ConverterDto.toAvaliacaoCompleta(avaliacaoEntity, detalhesEntities);
	}


	/**
	 * Atualiza uma avaliação existente.
	 * Não permite alterar o funcionário após criação.
	 *
	 * @param avaliacaoId ID da avaliação a ser atualizada
	 * @param avaliacao DTO contendo novos dados da avaliação
	 * @return DTO da avaliação atualizada
	 * @throws PortalException se a avaliação não existir ou dados forem inválidos
	 */
	@Override
	public Avaliacao updateAvaliacao(Long avaliacaoId, Avaliacao avaliacao)
			throws PortalException {

		// Chama LocalService para atualizar avaliação existente
		br.com.example.model.avaliacao.model.Avaliacao entity =
				_avaliacaoLocalService.updateAvaliacao(
						avaliacaoId,                         // ID da avaliação a atualizar
						avaliacao.getDataAvaliacao(),        // Nova data
						avaliacao.getPeriodoDesafio(),       // Novo período
						avaliacao.getObservacoesGerais(),    // Novas observações
						avaliacao.getAreaAtuacao(),          // Nova área
						createServiceContext()               // Contexto da requisição
				);

		return convertEntityToDTO(entity);  // Retorna DTO atualizado
	}

	/**
	 * Remove uma avaliação e todos os seus detalhes relacionados (cascade delete).
	 *
	 * @param avaliacaoId ID da avaliação a ser removida
	 * @return Response HTTP 204 (No Content)
	 * @throws PortalException se a avaliação não for encontrada
	 */
	@Override
	public Response deleteAvaliacao(Long avaliacaoId) throws PortalException {

		// LocalService faz deleção em cascata (avaliacao + detalhes)
		_avaliacaoLocalService.deleteAvaliacao(avaliacaoId);

		return Response.noContent().build();  // HTTP 204 No Content
	}

	/**
	 * Converte entidade de domínio para DTO REST.
	 *
	 * @param entity entidade de domínio Avaliacao do banco
	 * @return DTO Avaliacao pronto para serialização JSON/XML
	 */
	private Avaliacao convertEntityToDTO(
			br.com.example.model.avaliacao.model.Avaliacao entity) {

		Avaliacao dto = new Avaliacao();  // Cria novo DTO

		dto.setAvaliacaoId(entity.getAvaliacaoId());        // Mapeia ID
		dto.setFuncionarioId(entity.getFuncionarioId());    // Mapeia funcionário
		dto.setDataAvaliacao(entity.getDataAvaliacao());    // Date direto, sem conversão
		dto.setPeriodoDesafio(entity.getPeriodoDesafio());  // Mapeia período
		dto.setObservacoesGerais(entity.getObservacoesGerais()); // Mapeia observações
		dto.setAreaAtuacao(entity.getAreaAtuacao());        // Mapeia área

		return dto;  // Retorna DTO preenchido
	}

	/**
	 * Cria ServiceContext a partir do contexto HTTP da requisição REST.
	 *
	 * @return ServiceContext configurado para a requisição atual
	 * @throws PortalException se não conseguir obter informações do contexto
	 */
	private ServiceContext createServiceContext() throws PortalException {
		ServiceContext serviceContext = new ServiceContext();  // Cria contexto

		if (contextHttpServletRequest != null) {  // Se há requisição HTTP
			// Extrai companyId da requisição
			serviceContext.setCompanyId(
					PortalUtil.getCompanyId(contextHttpServletRequest)
			);

			// Extrai groupId (escopo) da requisição
			serviceContext.setScopeGroupId(
					PortalUtil.getScopeGroupId(contextHttpServletRequest)
			);

			try {
				// Tenta extrair userId do usuário autenticado
				serviceContext.setUserId(
						PortalUtil.getUserId(contextHttpServletRequest)
				);
			} catch (Exception e) {
				serviceContext.setUserId(0L);  // Usuário guest se não autenticado
			}
		}

		return serviceContext;  // Retorna contexto configurado
	}

	@Reference
	private AvaliacaoLocalService _avaliacaoLocalService;

	@Reference
	private AvaliacaoDetalheLocalService _avaliacaoDetalheLocalService;

	@Reference
	private AvaliacaoSearchService _searchService;

	@Reference
	private AvaliacaoSearchHelper _searchHelper;

}
