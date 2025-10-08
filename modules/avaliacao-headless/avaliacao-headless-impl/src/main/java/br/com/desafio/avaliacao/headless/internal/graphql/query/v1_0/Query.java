package br.com.desafio.avaliacao.headless.internal.graphql.query.v1_0;

import br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoCompleta;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoDetalheResource;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author sea
 * @generated
 */
@Generated("")
public class Query {

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

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allAvaliacoes(page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Lista todas as avaliações do sistema")
	public AvaliacaoPage allAvaliacoes(
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> new AvaliacaoPage(
				avaliacaoResource.getAllAvaliacoes(
					Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {avaliacaoById(avaliacaoId: ___){avaliacaoId, funcionarioId, dataAvaliacao, periodoDesafio, observacoesGerais, areaAtuacao}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Busca uma avaliação específica por ID")
	public Avaliacao avaliacaoById(@GraphQLName("avaliacaoId") Long avaliacaoId)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> avaliacaoResource.getAvaliacaoById(
				avaliacaoId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {avaliacoesByFuncionario(funcionarioId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Lista todas as avaliações de um funcionário específico"
	)
	public AvaliacaoPage avaliacoesByFuncionario(
			@GraphQLName("funcionarioId") Long funcionarioId)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> new AvaliacaoPage(
				avaliacaoResource.getAvaliacoesByFuncionario(funcionarioId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {avaliacaoByFuncionarioAndPeriodo(funcionarioId: ___, periodoDesafio: ___){avaliacaoId, funcionarioId, dataAvaliacao, periodoDesafio, observacoesGerais, areaAtuacao}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Busca a avaliação específica de um funcionário em um período determinado (30, 60 ou 90 dias)"
	)
	public Avaliacao avaliacaoByFuncionarioAndPeriodo(
			@GraphQLName("funcionarioId") Long funcionarioId,
			@GraphQLName("periodoDesafio") Integer periodoDesafio)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource ->
				avaliacaoResource.getAvaliacaoByFuncionarioAndPeriodo(
					funcionarioId, periodoDesafio));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {avaliacaoCompletaById(avaliacaoId: ___){avaliacaoId, funcionarioId, dataAvaliacao, periodoDesafio, observacoesGerais, areaAtuacao, avaliacaoDetalhes}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Busca uma avaliação completa (com todos os detalhes) por ID"
	)
	public AvaliacaoCompleta avaliacaoCompletaById(
			@GraphQLName("avaliacaoId") Long avaliacaoId)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoResource -> avaliacaoResource.getAvaliacaoCompletaById(
				avaliacaoId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allAvaliacaoDetalhes(avaliacaoId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Lista todos os detalhes (TechLead, Gerente, RH) de uma avaliação específica"
	)
	public AvaliacaoDetalhePage allAvaliacaoDetalhes(
			@GraphQLName("avaliacaoId") Long avaliacaoId)
		throws Exception {

		return _applyComponentServiceObjects(
			_avaliacaoDetalheResourceComponentServiceObjects,
			this::_populateResourceContext,
			avaliacaoDetalheResource -> new AvaliacaoDetalhePage(
				avaliacaoDetalheResource.getAllAvaliacaoDetalhes(avaliacaoId)));
	}

	@GraphQLTypeExtension(Avaliacao.class)
	public class GetAvaliacaoCompletaByIdTypeExtension {

		public GetAvaliacaoCompletaByIdTypeExtension(Avaliacao avaliacao) {
			_avaliacao = avaliacao;
		}

		@GraphQLField(
			description = "Busca uma avaliação completa (com todos os detalhes) por ID"
		)
		public AvaliacaoCompleta completaById() throws Exception {
			return _applyComponentServiceObjects(
				_avaliacaoResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				avaliacaoResource -> avaliacaoResource.getAvaliacaoCompletaById(
					_avaliacao.getAvaliacaoId()));
		}

		private Avaliacao _avaliacao;

	}

	@GraphQLTypeExtension(Avaliacao.class)
	public class GetAllAvaliacaoDetalhesTypeExtension {

		public GetAllAvaliacaoDetalhesTypeExtension(Avaliacao avaliacao) {
			_avaliacao = avaliacao;
		}

		@GraphQLField(
			description = "Lista todos os detalhes (TechLead, Gerente, RH) de uma avaliação específica"
		)
		public AvaliacaoDetalhePage allAvaliacaoDetalhes() throws Exception {
			return _applyComponentServiceObjects(
				_avaliacaoDetalheResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				avaliacaoDetalheResource -> new AvaliacaoDetalhePage(
					avaliacaoDetalheResource.getAllAvaliacaoDetalhes(
						_avaliacao.getAvaliacaoId())));
		}

		private Avaliacao _avaliacao;

	}

	@GraphQLTypeExtension(AvaliacaoDetalhe.class)
	public class GetAvaliacaoByIdTypeExtension {

		public GetAvaliacaoByIdTypeExtension(
			AvaliacaoDetalhe avaliacaoDetalhe) {

			_avaliacaoDetalhe = avaliacaoDetalhe;
		}

		@GraphQLField(description = "Busca uma avaliação específica por ID")
		public Avaliacao avaliacaoById() throws Exception {
			return _applyComponentServiceObjects(
				_avaliacaoResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				avaliacaoResource -> avaliacaoResource.getAvaliacaoById(
					_avaliacaoDetalhe.getAvaliacaoId()));
		}

		private AvaliacaoDetalhe _avaliacaoDetalhe;

	}

	@GraphQLName("AvaliacaoPage")
	public class AvaliacaoPage {

		public AvaliacaoPage(Page avaliacaoPage) {
			actions = avaliacaoPage.getActions();

			items = avaliacaoPage.getItems();
			lastPage = avaliacaoPage.getLastPage();
			page = avaliacaoPage.getPage();
			pageSize = avaliacaoPage.getPageSize();
			totalCount = avaliacaoPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<Avaliacao> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("AvaliacaoDetalhePage")
	public class AvaliacaoDetalhePage {

		public AvaliacaoDetalhePage(Page avaliacaoDetalhePage) {
			actions = avaliacaoDetalhePage.getActions();

			items = avaliacaoDetalhePage.getItems();
			lastPage = avaliacaoDetalhePage.getLastPage();
			page = avaliacaoDetalhePage.getPage();
			pageSize = avaliacaoDetalhePage.getPageSize();
			totalCount = avaliacaoDetalhePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<AvaliacaoDetalhe> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	}

	private static ComponentServiceObjects<AvaliacaoResource>
		_avaliacaoResourceComponentServiceObjects;
	private static ComponentServiceObjects<AvaliacaoDetalheResource>
		_avaliacaoDetalheResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}