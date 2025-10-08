package br.com.desafio.avaliacao.headless.internal.graphql.servlet.v1_0;

import br.com.desafio.avaliacao.headless.internal.graphql.mutation.v1_0.Mutation;
import br.com.desafio.avaliacao.headless.internal.graphql.query.v1_0.Query;
import br.com.desafio.avaliacao.headless.internal.resource.v1_0.AvaliacaoDetalheResourceImpl;
import br.com.desafio.avaliacao.headless.internal.resource.v1_0.AvaliacaoResourceImpl;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoDetalheResource;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoResource;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author sea
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setAvaliacaoResourceComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects);
		Mutation.setAvaliacaoDetalheResourceComponentServiceObjects(
			_avaliacaoDetalheResourceComponentServiceObjects);

		Query.setAvaliacaoResourceComponentServiceObjects(
			_avaliacaoResourceComponentServiceObjects);
		Query.setAvaliacaoDetalheResourceComponentServiceObjects(
			_avaliacaoDetalheResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "AvaliacaoHeadless";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/avaliacao-headless-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#createAvaliacao",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class, "createAvaliacao"));
					put(
						"mutation#deleteAvaliacao",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class, "deleteAvaliacao"));
					put(
						"mutation#deleteAvaliacaoBatch",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class,
							"deleteAvaliacaoBatch"));
					put(
						"mutation#updateAvaliacao",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class, "updateAvaliacao"));
					put(
						"mutation#createAvaliacaoCompleta",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class,
							"createAvaliacaoCompleta"));
					put(
						"mutation#updateAvaliacaoCompleta",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class,
							"updateAvaliacaoCompleta"));
					put(
						"mutation#createAvaliacaoDetalhe",
						new ObjectValuePair<>(
							AvaliacaoDetalheResourceImpl.class,
							"createAvaliacaoDetalhe"));
					put(
						"mutation#deleteAvaliacaoDetalhe",
						new ObjectValuePair<>(
							AvaliacaoDetalheResourceImpl.class,
							"deleteAvaliacaoDetalhe"));
					put(
						"mutation#deleteAvaliacaoDetalheBatch",
						new ObjectValuePair<>(
							AvaliacaoDetalheResourceImpl.class,
							"deleteAvaliacaoDetalheBatch"));
					put(
						"mutation#updateAvaliacaoDetalhe",
						new ObjectValuePair<>(
							AvaliacaoDetalheResourceImpl.class,
							"updateAvaliacaoDetalhe"));

					put(
						"query#allAvaliacoes",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class, "getAllAvaliacoes"));
					put(
						"query#avaliacaoById",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class, "getAvaliacaoById"));
					put(
						"query#avaliacoesByFuncionario",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class,
							"getAvaliacoesByFuncionario"));
					put(
						"query#avaliacaoByFuncionarioAndPeriodo",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class,
							"getAvaliacaoByFuncionarioAndPeriodo"));
					put(
						"query#avaliacaoCompletaById",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class,
							"getAvaliacaoCompletaById"));
					put(
						"query#allAvaliacaoDetalhes",
						new ObjectValuePair<>(
							AvaliacaoDetalheResourceImpl.class,
							"getAllAvaliacaoDetalhes"));

					put(
						"query#Avaliacao.completaById",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class,
							"getAvaliacaoCompletaById"));
					put(
						"query#Avaliacao.allAvaliacaoDetalhes",
						new ObjectValuePair<>(
							AvaliacaoDetalheResourceImpl.class,
							"getAllAvaliacaoDetalhes"));
					put(
						"query#AvaliacaoDetalhe.avaliacaoById",
						new ObjectValuePair<>(
							AvaliacaoResourceImpl.class, "getAvaliacaoById"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<AvaliacaoResource>
		_avaliacaoResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<AvaliacaoDetalheResource>
		_avaliacaoDetalheResourceComponentServiceObjects;

}