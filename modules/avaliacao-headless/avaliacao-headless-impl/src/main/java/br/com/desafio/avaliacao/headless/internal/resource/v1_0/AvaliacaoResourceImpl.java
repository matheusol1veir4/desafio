package br.com.desafio.avaliacao.headless.internal.resource.v1_0;

import br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoResource;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.vulcan.pagination.Page;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

		// Converte entidades para DTOs usando stream
		List<Avaliacao> dtos = entities.stream()
				.map(this::convertEntityToDTO)  // Mapeia cada entity para DTO
				.collect(Collectors.toList());  // Coleta em lista

		return Page.of(dtos);  // Retorna página com DTOs
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

		return convertEntityToDTO(entity);  // Converte entity salva para DTO
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
}
