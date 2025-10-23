package br.com.desafio.avaliacao.headless.internal.resource.v1_0;

import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.internal.converter.ConverterDto;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoDetalheResource;
import br.com.example.model.avaliacao.permission.AvaliacaoPermissionChecker;
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
import java.util.List;

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

		List<AvaliacaoDetalhe> dtos = ConverterDto.detalheEntityListToDtoList(entities);  // Coleta em lista

		return Page.of(dtos);  // Retorna página com DTOs
	}

	/**
	 * Busca um detalhe específico por ID.
	 *
	 * @param avaliacaoDetalheId ID do detalhe
	 * @return DTO do detalhe encontrado
	 * @throws PortalException se o detalhe não for encontrado
	 */
	@Override
	public AvaliacaoDetalhe getAvaliacaoDetalheById(Long avaliacaoDetalheId)
			throws PortalException {

		// Busca detalhe no banco via LocalService
		br.com.example.model.avaliacao.model.AvaliacaoDetalhe entity =
				_avaliacaoDetalheLocalService.getAvaliacaoDetalhe(avaliacaoDetalheId);

		return ConverterDto.detalheEntityToDto(entity); // Converte entity para DTO
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

		return ConverterDto.detalheEntityToDto(entity);
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
	public AvaliacaoDetalhe updateAvaliacaoDetalhe(
			Long avaliacaoDetalheId,
			AvaliacaoDetalhe avaliacaoDetalhe) throws PortalException {

		// 1. Obter userId autenticado
		long userId = getUserIdFromRequest();

		// 2. Buscar entity existente
		br.com.example.model.avaliacao.model.AvaliacaoDetalhe detalheEntity =
				_avaliacaoDetalheLocalService.getAvaliacaoDetalhe(avaliacaoDetalheId);

		// 3. VALIDAR PERMISSÃO
		if (!_permissionChecker.podeEditarDetalhe(userId, detalheEntity)) {
			throw new PortalException(
					"Você não tem permissão para editar este detalhe. " +
					"Apenas o responsável autorizado pode modificar esta seção."
			);
		}

		// 4. Atualizar
		br.com.example.model.avaliacao.model.AvaliacaoDetalhe updatedEntity =
				_avaliacaoDetalheLocalService.updateAvaliacaoDetalhe(
						avaliacaoDetalheId,
						avaliacaoDetalhe.getTipoAvaliador(),
						avaliacaoDetalhe.getNomeAvaliador(),
						avaliacaoDetalhe.getObservacoesAvaliador(),
						avaliacaoDetalhe.getDesempenho(),
						createServiceContext()
				);

		// 5. Retornar DTO
		return ConverterDto.detalheEntityToDto(updatedEntity);
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

	private long getUserIdFromRequest() {
		if (contextHttpServletRequest != null) {
			try {
				return PortalUtil.getUserId(contextHttpServletRequest);
			} catch (Exception e) {
				return 0L;
			}
		}
		return 0L;
	}

	@Reference
	private AvaliacaoLocalService _avaliacaoLocalService;  // Para buscar avaliação pai

	@Reference
	private AvaliacaoDetalheLocalService _avaliacaoDetalheLocalService;  // Para operações CRUD

	@Reference
	private AvaliacaoPermissionChecker _permissionChecker;
}
