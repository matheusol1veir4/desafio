package br.com.desafio.avaliacao.headless.resource.v1_0;

import br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoCompleta;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.odata.filter.ExpressionConvert;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.odata.sort.SortParserProvider;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/avaliacao-headless/v1.0
 *
 * @author sea
 * @generated
 */
@Generated("")
@ProviderType
public interface AvaliacaoResource {

	public Page<Avaliacao> getAllAvaliacoes(Pagination pagination)
		throws Exception;

	public Avaliacao createAvaliacao(Avaliacao avaliacao) throws Exception;

	public Response deleteAvaliacao(Long avaliacaoId) throws Exception;

	public Response deleteAvaliacaoBatch(String callbackURL, Object object)
		throws Exception;

	public Avaliacao getAvaliacaoById(Long avaliacaoId) throws Exception;

	public Avaliacao updateAvaliacao(Long avaliacaoId, Avaliacao avaliacao)
		throws Exception;

	public Page<Avaliacao> getAvaliacoesByFuncionario(Long funcionarioId)
		throws Exception;

	public Avaliacao getAvaliacaoByFuncionarioAndPeriodo(
			Long funcionarioId, Integer periodoDesafio)
		throws Exception;

	public AvaliacaoCompleta createAvaliacaoCompleta(
			AvaliacaoCompleta avaliacaoCompleta)
		throws Exception;

	public AvaliacaoCompleta getAvaliacaoCompletaById(Long avaliacaoId)
		throws Exception;

	public AvaliacaoCompleta updateAvaliacaoCompleta(
			Long avaliacaoId, AvaliacaoCompleta avaliacaoCompleta)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public void setExpressionConvert(
		ExpressionConvert<Filter> expressionConvert);

	public void setFilterParserProvider(
		FilterParserProvider filterParserProvider);

	public void setGroupLocalService(GroupLocalService groupLocalService);

	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService);

	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService);

	public void setRoleLocalService(RoleLocalService roleLocalService);

	public void setSortParserProvider(SortParserProvider sortParserProvider);

	public void setVulcanBatchEngineImportTaskResource(
		VulcanBatchEngineImportTaskResource
			vulcanBatchEngineImportTaskResource);

	public default Filter toFilter(String filterString) {
		return toFilter(
			filterString, Collections.<String, List<String>>emptyMap());
	}

	public default Filter toFilter(
		String filterString, Map<String, List<String>> multivaluedMap) {

		return null;
	}

	public default Sort[] toSorts(String sortsString) {
		return new Sort[0];
	}

	@ProviderType
	public interface Builder {

		public AvaliacaoResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder httpServletResponse(
			HttpServletResponse httpServletResponse);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder uriInfo(UriInfo uriInfo);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}