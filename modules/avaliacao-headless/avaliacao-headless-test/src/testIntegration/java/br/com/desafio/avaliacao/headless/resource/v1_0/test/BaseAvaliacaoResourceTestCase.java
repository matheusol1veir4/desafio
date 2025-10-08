package br.com.desafio.avaliacao.headless.resource.v1_0.test;

import br.com.desafio.avaliacao.headless.client.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.client.dto.v1_0.AvaliacaoCompleta;
import br.com.desafio.avaliacao.headless.client.http.HttpInvoker;
import br.com.desafio.avaliacao.headless.client.pagination.Page;
import br.com.desafio.avaliacao.headless.client.pagination.Pagination;
import br.com.desafio.avaliacao.headless.client.resource.v1_0.AvaliacaoResource;
import br.com.desafio.avaliacao.headless.client.serdes.v1_0.AvaliacaoSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author sea
 * @generated
 */
@Generated("")
public abstract class BaseAvaliacaoResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_avaliacaoResource.setContextCompany(testCompany);

		com.liferay.portal.kernel.model.User testCompanyAdminUser =
			UserTestUtil.getAdminUser(testCompany.getCompanyId());

		avaliacaoResource = AvaliacaoResource.builder(
		).authentication(
			testCompanyAdminUser.getEmailAddress(),
			PropsValues.DEFAULT_ADMIN_PASSWORD
		).endpoint(
			testCompany.getVirtualHostname(), 8080, "http"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = getClientSerDesObjectMapper();

		Avaliacao avaliacao1 = randomAvaliacao();

		String json = objectMapper.writeValueAsString(avaliacao1);

		Avaliacao avaliacao2 = AvaliacaoSerDes.toDTO(json);

		Assert.assertTrue(equals(avaliacao1, avaliacao2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = getClientSerDesObjectMapper();

		Avaliacao avaliacao = randomAvaliacao();

		String json1 = objectMapper.writeValueAsString(avaliacao);
		String json2 = AvaliacaoSerDes.toJSON(avaliacao);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	protected ObjectMapper getClientSerDesObjectMapper() {
		return new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Avaliacao avaliacao = randomAvaliacao();

		avaliacao.setObservacoesGerais(regex);

		String json = AvaliacaoSerDes.toJSON(avaliacao);

		Assert.assertFalse(json.contains(regex));

		avaliacao = AvaliacaoSerDes.toDTO(json);

		Assert.assertEquals(regex, avaliacao.getObservacoesGerais());
	}

	@Test
	public void testGetAllAvaliacoes() throws Exception {
		Page<Avaliacao> page = avaliacaoResource.getAllAvaliacoes(
			Pagination.of(1, 10));

		long totalCount = page.getTotalCount();

		Avaliacao avaliacao1 = testGetAllAvaliacoes_addAvaliacao(
			randomAvaliacao());

		Avaliacao avaliacao2 = testGetAllAvaliacoes_addAvaliacao(
			randomAvaliacao());

		page = avaliacaoResource.getAllAvaliacoes(Pagination.of(1, 10));

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(avaliacao1, (List<Avaliacao>)page.getItems());
		assertContains(avaliacao2, (List<Avaliacao>)page.getItems());
		assertValid(page, testGetAllAvaliacoes_getExpectedActions());
	}

	protected Map<String, Map<String, String>>
			testGetAllAvaliacoes_getExpectedActions()
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	@Test
	public void testGetAllAvaliacoesWithPagination() throws Exception {
		Page<Avaliacao> avaliacaoPage = avaliacaoResource.getAllAvaliacoes(
			null);

		int totalCount = GetterUtil.getInteger(avaliacaoPage.getTotalCount());

		Avaliacao avaliacao1 = testGetAllAvaliacoes_addAvaliacao(
			randomAvaliacao());

		Avaliacao avaliacao2 = testGetAllAvaliacoes_addAvaliacao(
			randomAvaliacao());

		Avaliacao avaliacao3 = testGetAllAvaliacoes_addAvaliacao(
			randomAvaliacao());

		// See com.liferay.portal.vulcan.internal.configuration.HeadlessAPICompanyConfiguration#pageSizeLimit

		int pageSizeLimit = 500;

		if (totalCount >= (pageSizeLimit - 2)) {
			Page<Avaliacao> page1 = avaliacaoResource.getAllAvaliacoes(
				Pagination.of(
					(int)Math.ceil((totalCount + 1.0) / pageSizeLimit),
					pageSizeLimit));

			Assert.assertEquals(totalCount + 3, page1.getTotalCount());

			assertContains(avaliacao1, (List<Avaliacao>)page1.getItems());

			Page<Avaliacao> page2 = avaliacaoResource.getAllAvaliacoes(
				Pagination.of(
					(int)Math.ceil((totalCount + 2.0) / pageSizeLimit),
					pageSizeLimit));

			assertContains(avaliacao2, (List<Avaliacao>)page2.getItems());

			Page<Avaliacao> page3 = avaliacaoResource.getAllAvaliacoes(
				Pagination.of(
					(int)Math.ceil((totalCount + 3.0) / pageSizeLimit),
					pageSizeLimit));

			assertContains(avaliacao3, (List<Avaliacao>)page3.getItems());
		}
		else {
			Page<Avaliacao> page1 = avaliacaoResource.getAllAvaliacoes(
				Pagination.of(1, totalCount + 2));

			List<Avaliacao> avaliacaos1 = (List<Avaliacao>)page1.getItems();

			Assert.assertEquals(
				avaliacaos1.toString(), totalCount + 2, avaliacaos1.size());

			Page<Avaliacao> page2 = avaliacaoResource.getAllAvaliacoes(
				Pagination.of(2, totalCount + 2));

			Assert.assertEquals(totalCount + 3, page2.getTotalCount());

			List<Avaliacao> avaliacaos2 = (List<Avaliacao>)page2.getItems();

			Assert.assertEquals(avaliacaos2.toString(), 1, avaliacaos2.size());

			Page<Avaliacao> page3 = avaliacaoResource.getAllAvaliacoes(
				Pagination.of(1, (int)totalCount + 3));

			assertContains(avaliacao1, (List<Avaliacao>)page3.getItems());
			assertContains(avaliacao2, (List<Avaliacao>)page3.getItems());
			assertContains(avaliacao3, (List<Avaliacao>)page3.getItems());
		}
	}

	protected Avaliacao testGetAllAvaliacoes_addAvaliacao(Avaliacao avaliacao)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testCreateAvaliacao() throws Exception {
		Avaliacao randomAvaliacao = randomAvaliacao();

		Avaliacao postAvaliacao = testCreateAvaliacao_addAvaliacao(
			randomAvaliacao);

		assertEquals(randomAvaliacao, postAvaliacao);
		assertValid(postAvaliacao);
	}

	protected Avaliacao testCreateAvaliacao_addAvaliacao(Avaliacao avaliacao)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteAvaliacao() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteAvaliacao() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetAvaliacaoById() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetAvaliacaoById() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetAvaliacaoByIdNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testUpdateAvaliacao() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetAvaliacoesByFuncionario() throws Exception {
		Long funcionarioId = testGetAvaliacoesByFuncionario_getFuncionarioId();
		Long irrelevantFuncionarioId =
			testGetAvaliacoesByFuncionario_getIrrelevantFuncionarioId();

		Page<Avaliacao> page = avaliacaoResource.getAvaliacoesByFuncionario(
			funcionarioId);

		long totalCount = page.getTotalCount();

		if (irrelevantFuncionarioId != null) {
			Avaliacao irrelevantAvaliacao =
				testGetAvaliacoesByFuncionario_addAvaliacao(
					irrelevantFuncionarioId, randomIrrelevantAvaliacao());

			page = avaliacaoResource.getAvaliacoesByFuncionario(
				irrelevantFuncionarioId);

			Assert.assertEquals(totalCount + 1, page.getTotalCount());

			assertContains(
				irrelevantAvaliacao, (List<Avaliacao>)page.getItems());
			assertValid(
				page,
				testGetAvaliacoesByFuncionario_getExpectedActions(
					irrelevantFuncionarioId));
		}

		Avaliacao avaliacao1 = testGetAvaliacoesByFuncionario_addAvaliacao(
			funcionarioId, randomAvaliacao());

		Avaliacao avaliacao2 = testGetAvaliacoesByFuncionario_addAvaliacao(
			funcionarioId, randomAvaliacao());

		page = avaliacaoResource.getAvaliacoesByFuncionario(funcionarioId);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(avaliacao1, (List<Avaliacao>)page.getItems());
		assertContains(avaliacao2, (List<Avaliacao>)page.getItems());
		assertValid(
			page,
			testGetAvaliacoesByFuncionario_getExpectedActions(funcionarioId));
	}

	protected Map<String, Map<String, String>>
			testGetAvaliacoesByFuncionario_getExpectedActions(
				Long funcionarioId)
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	protected Avaliacao testGetAvaliacoesByFuncionario_addAvaliacao(
			Long funcionarioId, Avaliacao avaliacao)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAvaliacoesByFuncionario_getFuncionarioId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAvaliacoesByFuncionario_getIrrelevantFuncionarioId()
		throws Exception {

		return null;
	}

	@Test
	public void testGetAvaliacaoByFuncionarioAndPeriodo() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetAvaliacaoByFuncionarioAndPeriodo()
		throws Exception {

		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetAvaliacaoByFuncionarioAndPeriodoNotFound()
		throws Exception {

		Assert.assertTrue(true);
	}

	@Test
	public void testCreateAvaliacaoCompleta() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetAvaliacaoCompletaById() throws Exception {
		Avaliacao postAvaliacao = testGetAvaliacao_addAvaliacao();

		AvaliacaoCompleta postAvaliacaoCompleta =
			testGetAvaliacaoCompletaById_addAvaliacaoCompleta(
				postAvaliacao.getId(), randomAvaliacaoCompleta());

		AvaliacaoCompleta getAvaliacaoCompleta =
			avaliacaoResource.getAvaliacaoCompletaById(postAvaliacao.getId());

		assertEquals(postAvaliacaoCompleta, getAvaliacaoCompleta);
		assertValid(getAvaliacaoCompleta);
	}

	protected AvaliacaoCompleta
			testGetAvaliacaoCompletaById_addAvaliacaoCompleta(
				long avaliacaoId, AvaliacaoCompleta avaliacaoCompleta)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateAvaliacaoCompleta() throws Exception {
		Avaliacao postAvaliacao = testPutAvaliacao_addAvaliacao();

		testUpdateAvaliacaoCompleta_addAvaliacaoCompleta(
			postAvaliacao.getId(), randomAvaliacaoCompleta());

		AvaliacaoCompleta randomAvaliacaoCompleta = randomAvaliacaoCompleta();

		AvaliacaoCompleta putAvaliacaoCompleta =
			avaliacaoResource.updateAvaliacaoCompleta(
				postAvaliacao.getId(), randomAvaliacaoCompleta);

		assertEquals(randomAvaliacaoCompleta, putAvaliacaoCompleta);
		assertValid(putAvaliacaoCompleta);
	}

	protected AvaliacaoCompleta
			testUpdateAvaliacaoCompleta_addAvaliacaoCompleta(
				long avaliacaoId, AvaliacaoCompleta avaliacaoCompleta)
		throws Exception {

		return avaliacaoResource.updateAvaliacaoCompleta(
			avaliacaoId, avaliacaoCompleta);
	}

	protected void assertContains(
		Avaliacao avaliacao, List<Avaliacao> avaliacaos) {

		boolean contains = false;

		for (Avaliacao item : avaliacaos) {
			if (equals(avaliacao, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			avaliacaos + " does not contain " + avaliacao, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Avaliacao avaliacao1, Avaliacao avaliacao2) {
		Assert.assertTrue(
			avaliacao1 + " does not equal " + avaliacao2,
			equals(avaliacao1, avaliacao2));
	}

	protected void assertEquals(
		List<Avaliacao> avaliacaos1, List<Avaliacao> avaliacaos2) {

		Assert.assertEquals(avaliacaos1.size(), avaliacaos2.size());

		for (int i = 0; i < avaliacaos1.size(); i++) {
			Avaliacao avaliacao1 = avaliacaos1.get(i);
			Avaliacao avaliacao2 = avaliacaos2.get(i);

			assertEquals(avaliacao1, avaliacao2);
		}
	}

	protected void assertEquals(
		AvaliacaoCompleta avaliacaoCompleta1,
		AvaliacaoCompleta avaliacaoCompleta2) {

		Assert.assertTrue(
			avaliacaoCompleta1 + " does not equal " + avaliacaoCompleta2,
			equals(avaliacaoCompleta1, avaliacaoCompleta2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Avaliacao> avaliacaos1, List<Avaliacao> avaliacaos2) {

		Assert.assertEquals(avaliacaos1.size(), avaliacaos2.size());

		for (Avaliacao avaliacao1 : avaliacaos1) {
			boolean contains = false;

			for (Avaliacao avaliacao2 : avaliacaos2) {
				if (equals(avaliacao1, avaliacao2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				avaliacaos2 + " does not contain " + avaliacao1, contains);
		}
	}

	protected void assertValid(Avaliacao avaliacao) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("areaAtuacao", additionalAssertFieldName)) {
				if (avaliacao.getAreaAtuacao() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("avaliacaoId", additionalAssertFieldName)) {
				if (avaliacao.getAvaliacaoId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dataAvaliacao", additionalAssertFieldName)) {
				if (avaliacao.getDataAvaliacao() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("funcionarioId", additionalAssertFieldName)) {
				if (avaliacao.getFuncionarioId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"observacoesGerais", additionalAssertFieldName)) {

				if (avaliacao.getObservacoesGerais() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("periodoDesafio", additionalAssertFieldName)) {
				if (avaliacao.getPeriodoDesafio() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Avaliacao> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<Avaliacao> page,
		Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<Avaliacao> avaliacaos = page.getItems();

		int size = avaliacaos.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);

		assertValid(page.getActions(), expectedActions);
	}

	protected void assertValid(
		Map<String, Map<String, String>> actions1,
		Map<String, Map<String, String>> actions2) {

		for (String key : actions2.keySet()) {
			Map action = actions1.get(key);

			Assert.assertNotNull(key + " does not contain an action", action);

			Map<String, String> expectedAction = actions2.get(key);

			Assert.assertEquals(
				expectedAction.get("method"), action.get("method"));
			Assert.assertEquals(expectedAction.get("href"), action.get("href"));
		}
	}

	protected void assertValid(AvaliacaoCompleta avaliacaoCompleta) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAvaliacaoCompletaAssertFieldNames()) {

			if (Objects.equals("areaAtuacao", additionalAssertFieldName)) {
				if (avaliacaoCompleta.getAreaAtuacao() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"avaliacaoDetalhes", additionalAssertFieldName)) {

				if (avaliacaoCompleta.getAvaliacaoDetalhes() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("avaliacaoId", additionalAssertFieldName)) {
				if (avaliacaoCompleta.getAvaliacaoId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dataAvaliacao", additionalAssertFieldName)) {
				if (avaliacaoCompleta.getDataAvaliacao() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("funcionarioId", additionalAssertFieldName)) {
				if (avaliacaoCompleta.getFuncionarioId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"observacoesGerais", additionalAssertFieldName)) {

				if (avaliacaoCompleta.getObservacoesGerais() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("periodoDesafio", additionalAssertFieldName)) {
				if (avaliacaoCompleta.getPeriodoDesafio() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalAvaliacaoCompletaAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao.
						class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Avaliacao avaliacao1, Avaliacao avaliacao2) {
		if (avaliacao1 == avaliacao2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("areaAtuacao", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacao1.getAreaAtuacao(),
						avaliacao2.getAreaAtuacao())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("avaliacaoId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacao1.getAvaliacaoId(),
						avaliacao2.getAvaliacaoId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dataAvaliacao", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacao1.getDataAvaliacao(),
						avaliacao2.getDataAvaliacao())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("funcionarioId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacao1.getFuncionarioId(),
						avaliacao2.getFuncionarioId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"observacoesGerais", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						avaliacao1.getObservacoesGerais(),
						avaliacao2.getObservacoesGerais())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("periodoDesafio", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacao1.getPeriodoDesafio(),
						avaliacao2.getPeriodoDesafio())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected boolean equals(
		AvaliacaoCompleta avaliacaoCompleta1,
		AvaliacaoCompleta avaliacaoCompleta2) {

		if (avaliacaoCompleta1 == avaliacaoCompleta2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAvaliacaoCompletaAssertFieldNames()) {

			if (Objects.equals("areaAtuacao", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoCompleta1.getAreaAtuacao(),
						avaliacaoCompleta2.getAreaAtuacao())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"avaliacaoDetalhes", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						avaliacaoCompleta1.getAvaliacaoDetalhes(),
						avaliacaoCompleta2.getAvaliacaoDetalhes())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("avaliacaoId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoCompleta1.getAvaliacaoId(),
						avaliacaoCompleta2.getAvaliacaoId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dataAvaliacao", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoCompleta1.getDataAvaliacao(),
						avaliacaoCompleta2.getDataAvaliacao())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("funcionarioId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoCompleta1.getFuncionarioId(),
						avaliacaoCompleta2.getFuncionarioId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"observacoesGerais", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						avaliacaoCompleta1.getObservacoesGerais(),
						avaliacaoCompleta2.getObservacoesGerais())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("periodoDesafio", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoCompleta1.getPeriodoDesafio(),
						avaliacaoCompleta2.getPeriodoDesafio())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		if (clazz.getClassLoader() == null) {
			return new java.lang.reflect.Field[0];
		}

		return TransformUtil.transform(
			ReflectionUtil.getDeclaredFields(clazz),
			field -> {
				if (field.isSynthetic()) {
					return null;
				}

				return field;
			},
			java.lang.reflect.Field.class);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_avaliacaoResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_avaliacaoResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		if (entityModel == null) {
			return Collections.emptyList();
		}

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		return TransformUtil.transform(
			getEntityFields(),
			entityField -> {
				if (!Objects.equals(entityField.getType(), type) ||
					ArrayUtil.contains(
						getIgnoredEntityFieldNames(), entityField.getName())) {

					return null;
				}

				return entityField;
			});
	}

	protected String getFilterString(
		EntityField entityField, String operator, Avaliacao avaliacao) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("areaAtuacao")) {
			sb.append(String.valueOf(avaliacao.getAreaAtuacao()));

			return sb.toString();
		}

		if (entityFieldName.equals("avaliacaoId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("dataAvaliacao")) {
			if (operator.equals("between")) {
				Date date = avaliacao.getDataAvaliacao();

				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(date.getTime() - (2 * Time.SECOND)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(date.getTime() + (2 * Time.SECOND)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(avaliacao.getDataAvaliacao()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("funcionarioId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("observacoesGerais")) {
			Object object = avaliacao.getObservacoesGerais();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		if (entityFieldName.equals("periodoDesafio")) {
			sb.append(String.valueOf(avaliacao.getPeriodoDesafio()));

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword(
			"test@liferay.com:" + PropsValues.DEFAULT_ADMIN_PASSWORD);

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Avaliacao randomAvaliacao() throws Exception {
		return new Avaliacao() {
			{
				areaAtuacao = RandomTestUtil.randomInt();
				avaliacaoId = RandomTestUtil.randomLong();
				dataAvaliacao = RandomTestUtil.nextDate();
				funcionarioId = RandomTestUtil.randomLong();
				observacoesGerais = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				periodoDesafio = RandomTestUtil.randomInt();
			}
		};
	}

	protected Avaliacao randomIrrelevantAvaliacao() throws Exception {
		Avaliacao randomIrrelevantAvaliacao = randomAvaliacao();

		return randomIrrelevantAvaliacao;
	}

	protected Avaliacao randomPatchAvaliacao() throws Exception {
		return randomAvaliacao();
	}

	protected AvaliacaoCompleta randomAvaliacaoCompleta() throws Exception {
		return new AvaliacaoCompleta() {
			{
				areaAtuacao = RandomTestUtil.randomInteger();
				avaliacaoId = RandomTestUtil.randomLong();
				dataAvaliacao = RandomTestUtil.nextDate();
				funcionarioId = RandomTestUtil.randomLong();
				observacoesGerais = RandomTestUtil.randomString();
				periodoDesafio = RandomTestUtil.randomInteger();
			}
		};
	}

	protected AvaliacaoResource avaliacaoResource;
	protected com.liferay.portal.kernel.model.Group irrelevantGroup;
	protected com.liferay.portal.kernel.model.Company testCompany;
	protected com.liferay.portal.kernel.model.Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = source.getClass();

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					_getAllDeclaredFields(sourceClass)) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				try {
					Method setMethod = _getMethod(
						targetClass, field.getName(), "set",
						getMethod.getReturnType());

					setMethod.invoke(target, getMethod.invoke(source));
				}
				catch (Exception e) {
					continue;
				}
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static List<java.lang.reflect.Field> _getAllDeclaredFields(
			Class<?> clazz) {

			List<java.lang.reflect.Field> fields = new ArrayList<>();

			while ((clazz != null) && (clazz != Object.class)) {
				for (java.lang.reflect.Field field :
						clazz.getDeclaredFields()) {

					fields.add(field);
				}

				clazz = clazz.getSuperclass();
			}

			return fields;
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseAvaliacaoResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoResource
		_avaliacaoResource;

}