package br.com.desafio.avaliacao.headless.internal.graphql.mutation.v1_0;

import br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoCompleta;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoDetalheResource;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author sea
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setAvaliacaoResourceComponentServiceObjects(
		ComponentServiceObjects<AvaliacaoResource>
			avaliacaoResourceComponentServiceObjects) {

		_avaliacaoResourceComponentServiceObjects =
			avaliacaoResourceComponentServiceObjects;
	}

	public static void setAvaliacaoDetalheResourceComponentServiceObjects(
		ComponentServiceObjects<AvaliacaoDetalheResource>
			avaliacaoDetalheResourceComponentServiceObjects) {

		_avaliacaoDetalheResourceComponentServiceObjects =
			avaliacaoDetalheResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Cria uma nova avaliação")
	public Avaliacao createAvaliacao(
			@GraphQLName("avaliacao") Avaliacao avaliacao)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> avaliacaoResource.createAvaliacao(avaliacao));
	}

	@GraphQLField(
		description = "Deleta uma avaliação e todos os seus detalhes (cascade delete)"
	)
	public Response deleteAvaliacao(
			@GraphQLName("avaliacaoId") Long avaliacaoId)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> avaliacaoResource.deleteAvaliacao(
				avaliacaoId));
	}

	@GraphQLField
	public Response deleteAvaliacaoBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> avaliacaoResource.deleteAvaliacaoBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Atualiza uma avaliação existente")
	public Avaliacao updateAvaliacao(
			@GraphQLName("avaliacaoId") Long avaliacaoId,
			@GraphQLName("avaliacao") Avaliacao avaliacao)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> avaliacaoResource.updateAvaliacao(
				avaliacaoId, avaliacao));
	}

	@GraphQLField(
		description = "Cria uma avaliação completa (avaliação + todos os detalhes) em uma única requisição"
	)
	public AvaliacaoCompleta createAvaliacaoCompleta(
			@GraphQLName("avaliacaoCompleta") AvaliacaoCompleta
				avaliacaoCompleta)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> avaliacaoResource.createAvaliacaoCompleta(
				avaliacaoCompleta));
	}

	@GraphQLField(
		description = "Atualiza uma avaliação completa (avaliação + detalhes) em uma única requisição"
	)
	public AvaliacaoCompleta updateAvaliacaoCompleta(
			@GraphQLName("avaliacaoId") Long avaliacaoId,
			@GraphQLName("avaliacaoCompleta") AvaliacaoCompleta
				avaliacaoCompleta)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> avaliacaoResource.updateAvaliacaoCompleta(
				avaliacaoId, avaliacaoCompleta));
	}

	@GraphQLField(
		description = "Adiciona um novo detalhe à avaliação (TechLead, Gerente ou RH)"
	)
	public AvaliacaoDetalhe createAvaliacaoDetalhe(
			@GraphQLName("avaliacaoId") Long avaliacaoId,
			@GraphQLName("avaliacaoDetalhe") AvaliacaoDetalhe avaliacaoDetalhe)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoDetalheResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoDetalheResource ->
				avaliacaoDetalheResource.createAvaliacaoDetalhe(
					avaliacaoId, avaliacaoDetalhe));
	}

	@GraphQLField(description = "Deleta um detalhe específico de avaliação")
	public Response deleteAvaliacaoDetalhe(
			@GraphQLName("avaliacaoDetalheId") Long avaliacaoDetalheId)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoDetalheResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoDetalheResource ->
				avaliacaoDetalheResource.deleteAvaliacaoDetalhe(
					avaliacaoDetalheId));
	}

	@GraphQLField
	public Response deleteAvaliacaoDetalheBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoDetalheResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoDetalheResource ->
				avaliacaoDetalheResource.deleteAvaliacaoDetalheBatch(
					callbackURL, object));
	}

	@GraphQLField(description = "Atualiza um detalhe específico de avaliação")
	public AvaliacaoDetalhe updateAvaliacaoDetalhe(
			@GraphQLName("avaliacaoDetalheId") Long avaliacaoDetalheId,
			@GraphQLName("avaliacaoDetalhe") AvaliacaoDetalhe avaliacaoDetalhe)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoDetalheResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoDetalheResource ->
				avaliacaoDetalheResource.updateAvaliacaoDetalhe(
					avaliacaoDetalheId, avaliacaoDetalhe));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(AvaliacaoResource avaliacaoResource)
		throws Exception {

		avaliacaoResource.setContextAcceptLanguage(_acceptLanguage);
		avaliacaoResource.setContextCompany(_company);
		avaliacaoResource.setContextHttpServletRequest(_httpServletRequest);
		avaliacaoResource.setContextHttpServletResponse(_httpServletResponse);
		avaliacaoResource.setContextUriInfo(_uriInfo);
		avaliacaoResource.setContextUser(_user);
		avaliacaoResource.setGroupLocalService(_groupLocalService);
		avaliacaoResource.setRoleLocalService(_roleLocalService);

		avaliacaoResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private void _populateResourceContext(
			AvaliacaoDetalheResource avaliacaoDetalheResource)
		throws Exception {

		avaliacaoDetalheResource.setContextAcceptLanguage(_acceptLanguage);
		avaliacaoDetalheResource.setContextCompany(_company);
		avaliacaoDetalheResource.setContextHttpServletRequest(
			_httpServletRequest);
		avaliacaoDetalheResource.setContextHttpServletResponse(
			_httpServletResponse);
		avaliacaoDetalheResource.setContextUriInfo(_uriInfo);
		avaliacaoDetalheResource.setContextUser(_user);
		avaliacaoDetalheResource.setGroupLocalService(_groupLocalService);
		avaliacaoDetalheResource.setRoleLocalService(_roleLocalService);

		avaliacaoDetalheResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<AvaliacaoResource>
		_avaliacaoResourceComponentServiceObjects;
	private static ComponentServiceObjects<AvaliacaoDetalheResource>
		_avaliacaoDetalheResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;
	private VulcanBatchEngineImportTaskResource
		_vulcanBatchEngineImportTaskResource;

}