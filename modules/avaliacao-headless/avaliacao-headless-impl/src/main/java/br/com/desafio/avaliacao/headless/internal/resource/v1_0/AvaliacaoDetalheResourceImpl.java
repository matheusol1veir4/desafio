package br.com.desafio.avaliacao.headless.internal.resource.v1_0;

import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoDetalheResource;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import br.com.example.model.avaliacao.service.AvaliacaoDetalheLocalService;

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
 * Resource implementation para gerenciamento de detalhes de avaliação via REST API.
 *
 * @author sea
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/avaliacao-detalhe.properties",
		scope = ServiceScope.PROTOTYPE,
		service = AvaliacaoDetalheResource.class
)
public class AvaliacaoDetalheResourceImpl extends BaseAvaliacaoDetalheResourceImpl {

	/**
	 * Lista todos os detalhes de uma avaliação específica.
	 *
	 * @param avaliacaoId ID da avaliação pai
	 * @return página contendo lista de detalhes da avaliação
	 * @throws PortalException se houver erro ao acessar o banco de dados
	 */
	@Override
	public Page<AvaliacaoDetalhe> getAllAvaliacaoDetalhes(Long avaliacaoId)
			throws PortalException {

		// Busca entidades no banco via LocalService
		List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> entities =
				_avaliacaoDetalheLocalService.findByAvaliacaoId(avaliacaoId);

		// Retorna página vazia se não houver dados
		if (entities == null || entities.isEmpty()) {
			return Page.of(new ArrayList<>());
		}

		// Converte entidades para DTOs usando stream
		List<AvaliacaoDetalhe> dtos = entities.stream()
				.map(this::convertEntityToDTO)  // Mapeia cada entity para DTO
				.collect(Collectors.toList());  // Coleta em lista

		return Page.of(dtos);  // Retorna página com DTOs
	}

	/**
	 * Adiciona novo detalhe à avaliação.
	 *
	 * @param avaliacaoId ID da avaliação pai
	 * @param avaliacaoDetalhe DTO contendo dados do novo detalhe
	 * @return DTO do detalhe criado com ID gerado
	 * @throws PortalException se os dados forem inválidos
	 */
	@Override
	public AvaliacaoDetalhe createAvaliacaoDetalhe(Long avaliacaoId,
												   AvaliacaoDetalhe avaliacaoDetalhe) throws PortalException {

		// Busca a avaliação pai para validação
		br.com.example.model.avaliacao.model.Avaliacao avaliacao =
				_avaliacaoLocalService.getAvaliacao(avaliacaoId);

		// Chama LocalService para persistir novo detalhe
		br.com.example.model.avaliacao.model.AvaliacaoDetalhe entity =
				_avaliacaoDetalheLocalService.addAvaliacaoDetalhe(
						avaliacao,                               // Avaliação pai
						avaliacaoDetalhe.getTipoAvaliador(),     // Tipo avaliador (1=Tech, 2=Gerente, 3=RH)
						avaliacaoDetalhe.getNomeAvaliador(),     // Nome do avaliador
						avaliacaoDetalhe.getObservacoesAvaliador(), // Observações
						avaliacaoDetalhe.getDesempenho(),        // Nota desempenho (1-5)
						createServiceContext()                   // Contexto da requisição
				);

		return convertEntityToDTO(entity);  // Converte entity salva para DTO
	}

	/**
	 * Atualiza detalhe específico de avaliação.
	 *
	 * @param avaliacaoDetalheId ID do detalhe a ser atualizado
	 * @param avaliacaoDetalhe DTO contendo novos dados do detalhe
	 * @return DTO do detalhe atualizado
	 * @throws PortalException se o detalhe não existir ou dados forem inválidos
	 */
	@Override
	public AvaliacaoDetalhe updateAvaliacaoDetalhe(Long avaliacaoDetalheId,
												   AvaliacaoDetalhe avaliacaoDetalhe) throws PortalException {

		// Chama LocalService para atualizar detalhe existente
		br.com.example.model.avaliacao.model.AvaliacaoDetalhe entity =
				_avaliacaoDetalheLocalService.updateAvaliacaoDetalhe(
						avaliacaoDetalheId,                      // ID do detalhe a atualizar
						avaliacaoDetalhe.getTipoAvaliador(),     // Novo tipo avaliador
						avaliacaoDetalhe.getNomeAvaliador(),     // Novo nome avaliador
						avaliacaoDetalhe.getObservacoesAvaliador(), // Novas observações
						avaliacaoDetalhe.getDesempenho(),        // Nova nota desempenho
						createServiceContext()                   // Contexto da requisição
				);

		return convertEntityToDTO(entity);  // Retorna DTO atualizado
	}

	/**
	 * Deleta detalhe específico de avaliação.
	 *
	 * @param avaliacaoDetalheId ID do detalhe a ser removido
	 * @return Response HTTP 204 (No Content)
	 * @throws PortalException se o detalhe não for encontrado
	 */
	@Override
	public Response deleteAvaliacaoDetalhe(Long avaliacaoDetalheId) throws PortalException {

		// LocalService faz deleção do detalhe
		_avaliacaoDetalheLocalService.deleteAvaliacaoDetalhe(avaliacaoDetalheId);

		return Response.noContent().build();  // HTTP 204 No Content
	}

	/**
	 * Converte entidade de domínio para DTO REST.
	 *
	 * @param entity entidade de domínio AvaliacaoDetalhe do banco
	 * @return DTO AvaliacaoDetalhe pronto para serialização JSON/XML
	 */
	private AvaliacaoDetalhe convertEntityToDTO(
			br.com.example.model.avaliacao.model.AvaliacaoDetalhe entity) {

		AvaliacaoDetalhe dto = new AvaliacaoDetalhe();  // Cria novo DTO

		dto.setAvaliacaoDetalheId(entity.getAvaliacaoDetalheId()); // Mapeia ID do detalhe
		dto.setAvaliacaoId(entity.getAvaliacaoId());               // Mapeia ID da avaliação pai
		dto.setTipoAvaliador(entity.getTipoAvaliador());           // Mapeia tipo avaliador
		dto.setNomeAvaliador(entity.getNomeAvaliador());           // Mapeia nome avaliador
		dto.setObservacoesAvaliador(entity.getObservacoesAvaliador()); // Mapeia observações
		dto.setDesempenho(entity.getDesempenho());                 // Mapeia nota desempenho

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
	private AvaliacaoLocalService _avaliacaoLocalService;  // Para buscar avaliação pai

	@Reference
	private AvaliacaoDetalheLocalService _avaliacaoDetalheLocalService;  // Para operações CRUD
}
