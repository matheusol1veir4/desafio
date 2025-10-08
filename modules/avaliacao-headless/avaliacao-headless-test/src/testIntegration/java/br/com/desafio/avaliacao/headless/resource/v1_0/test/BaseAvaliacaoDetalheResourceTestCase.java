package br.com.desafio.avaliacao.headless.resource.v1_0.test;

import br.com.desafio.avaliacao.headless.client.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.client.http.HttpInvoker;
import br.com.desafio.avaliacao.headless.client.pagination.Page;
import br.com.desafio.avaliacao.headless.client.resource.v1_0.AvaliacaoDetalheResource;
import br.com.desafio.avaliacao.headless.client.serdes.v1_0.AvaliacaoDetalheSerDes;

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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
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
public abstract class BaseAvaliacaoDetalheResourceTestCase {

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

		_avaliacaoDetalheResource.setContextCompany(testCompany);

		com.liferay.portal.kernel.model.User testCompanyAdminUser =
			UserTestUtil.getAdminUser(testCompany.getCompanyId());

		avaliacaoDetalheResource = AvaliacaoDetalheResource.builder(
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

		AvaliacaoDetalhe avaliacaoDetalhe1 = randomAvaliacaoDetalhe();

		String json = objectMapper.writeValueAsString(avaliacaoDetalhe1);

		AvaliacaoDetalhe avaliacaoDetalhe2 = AvaliacaoDetalheSerDes.toDTO(json);

		Assert.assertTrue(equals(avaliacaoDetalhe1, avaliacaoDetalhe2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = getClientSerDesObjectMapper();

		AvaliacaoDetalhe avaliacaoDetalhe = randomAvaliacaoDetalhe();

		String json1 = objectMapper.writeValueAsString(avaliacaoDetalhe);
		String json2 = AvaliacaoDetalheSerDes.toJSON(avaliacaoDetalhe);

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

		AvaliacaoDetalhe avaliacaoDetalhe = randomAvaliacaoDetalhe();

		avaliacaoDetalhe.setNomeAvaliador(regex);
		avaliacaoDetalhe.setObservacoesAvaliador(regex);

		String json = AvaliacaoDetalheSerDes.toJSON(avaliacaoDetalhe);

		Assert.assertFalse(json.contains(regex));

		avaliacaoDetalhe = AvaliacaoDetalheSerDes.toDTO(json);

		Assert.assertEquals(regex, avaliacaoDetalhe.getNomeAvaliador());
		Assert.assertEquals(regex, avaliacaoDetalhe.getObservacoesAvaliador());
	}

	@Test
	public void testGetAllAvaliacaoDetalhes() throws Exception {
		Long avaliacaoId = testGetAllAvaliacaoDetalhes_getAvaliacaoId();
		Long irrelevantAvaliacaoId =
			testGetAllAvaliacaoDetalhes_getIrrelevantAvaliacaoId();

		Page<AvaliacaoDetalhe> page =
			avaliacaoDetalheResource.getAllAvaliacaoDetalhes(avaliacaoId);

		long totalCount = page.getTotalCount();

		if (irrelevantAvaliacaoId != null) {
			AvaliacaoDetalhe irrelevantAvaliacaoDetalhe =
				testGetAllAvaliacaoDetalhes_addAvaliacaoDetalhe(
					irrelevantAvaliacaoId, randomIrrelevantAvaliacaoDetalhe());

			page = avaliacaoDetalheResource.getAllAvaliacaoDetalhes(
				irrelevantAvaliacaoId);

			Assert.assertEquals(totalCount + 1, page.getTotalCount());

			assertContains(
				irrelevantAvaliacaoDetalhe,
				(List<AvaliacaoDetalhe>)page.getItems());
			assertValid(
				page,
				testGetAllAvaliacaoDetalhes_getExpectedActions(
					irrelevantAvaliacaoId));
		}

		AvaliacaoDetalhe avaliacaoDetalhe1 =
			testGetAllAvaliacaoDetalhes_addAvaliacaoDetalhe(
				avaliacaoId, randomAvaliacaoDetalhe());

		AvaliacaoDetalhe avaliacaoDetalhe2 =
			testGetAllAvaliacaoDetalhes_addAvaliacaoDetalhe(
				avaliacaoId, randomAvaliacaoDetalhe());

		page = avaliacaoDetalheResource.getAllAvaliacaoDetalhes(avaliacaoId);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			avaliacaoDetalhe1, (List<AvaliacaoDetalhe>)page.getItems());
		assertContains(
			avaliacaoDetalhe2, (List<AvaliacaoDetalhe>)page.getItems());
		assertValid(
			page, testGetAllAvaliacaoDetalhes_getExpectedActions(avaliacaoId));
	}

	protected Map<String, Map<String, String>>
			testGetAllAvaliacaoDetalhes_getExpectedActions(Long avaliacaoId)
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	protected AvaliacaoDetalhe testGetAllAvaliacaoDetalhes_addAvaliacaoDetalhe(
			Long avaliacaoId, AvaliacaoDetalhe avaliacaoDetalhe)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAllAvaliacaoDetalhes_getAvaliacaoId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetAllAvaliacaoDetalhes_getIrrelevantAvaliacaoId()
		throws Exception {

		return null;
	}

	@Test
	public void testCreateAvaliacaoDetalhe() throws Exception {
		AvaliacaoDetalhe randomAvaliacaoDetalhe = randomAvaliacaoDetalhe();

		AvaliacaoDetalhe postAvaliacaoDetalhe =
			testCreateAvaliacaoDetalhe_addAvaliacaoDetalhe(
				randomAvaliacaoDetalhe);

		assertEquals(randomAvaliacaoDetalhe, postAvaliacaoDetalhe);
		assertValid(postAvaliacaoDetalhe);
	}

	protected AvaliacaoDetalhe testCreateAvaliacaoDetalhe_addAvaliacaoDetalhe(
			AvaliacaoDetalhe avaliacaoDetalhe)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteAvaliacaoDetalhe() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteAvaliacaoDetalhe() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testUpdateAvaliacaoDetalhe() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(
		AvaliacaoDetalhe avaliacaoDetalhe,
		List<AvaliacaoDetalhe> avaliacaoDetalhes) {

		boolean contains = false;

		for (AvaliacaoDetalhe item : avaliacaoDetalhes) {
			if (equals(avaliacaoDetalhe, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			avaliacaoDetalhes + " does not contain " + avaliacaoDetalhe,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		AvaliacaoDetalhe avaliacaoDetalhe1,
		AvaliacaoDetalhe avaliacaoDetalhe2) {

		Assert.assertTrue(
			avaliacaoDetalhe1 + " does not equal " + avaliacaoDetalhe2,
			equals(avaliacaoDetalhe1, avaliacaoDetalhe2));
	}

	protected void assertEquals(
		List<AvaliacaoDetalhe> avaliacaoDetalhes1,
		List<AvaliacaoDetalhe> avaliacaoDetalhes2) {

		Assert.assertEquals(
			avaliacaoDetalhes1.size(), avaliacaoDetalhes2.size());

		for (int i = 0; i < avaliacaoDetalhes1.size(); i++) {
			AvaliacaoDetalhe avaliacaoDetalhe1 = avaliacaoDetalhes1.get(i);
			AvaliacaoDetalhe avaliacaoDetalhe2 = avaliacaoDetalhes2.get(i);

			assertEquals(avaliacaoDetalhe1, avaliacaoDetalhe2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<AvaliacaoDetalhe> avaliacaoDetalhes1,
		List<AvaliacaoDetalhe> avaliacaoDetalhes2) {

		Assert.assertEquals(
			avaliacaoDetalhes1.size(), avaliacaoDetalhes2.size());

		for (AvaliacaoDetalhe avaliacaoDetalhe1 : avaliacaoDetalhes1) {
			boolean contains = false;

			for (AvaliacaoDetalhe avaliacaoDetalhe2 : avaliacaoDetalhes2) {
				if (equals(avaliacaoDetalhe1, avaliacaoDetalhe2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				avaliacaoDetalhes2 + " does not contain " + avaliacaoDetalhe1,
				contains);
		}
	}

	protected void assertValid(AvaliacaoDetalhe avaliacaoDetalhe)
		throws Exception {

		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals(
					"avaliacaoDetalheId", additionalAssertFieldName)) {

				if (avaliacaoDetalhe.getAvaliacaoDetalheId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("avaliacaoId", additionalAssertFieldName)) {
				if (avaliacaoDetalhe.getAvaliacaoId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("desempenho", additionalAssertFieldName)) {
				if (avaliacaoDetalhe.getDesempenho() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nomeAvaliador", additionalAssertFieldName)) {
				if (avaliacaoDetalhe.getNomeAvaliador() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"observacoesAvaliador", additionalAssertFieldName)) {

				if (avaliacaoDetalhe.getObservacoesAvaliador() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tipoAvaliador", additionalAssertFieldName)) {
				if (avaliacaoDetalhe.getTipoAvaliador() == null) {
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

	protected void assertValid(Page<AvaliacaoDetalhe> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<AvaliacaoDetalhe> page,
		Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<AvaliacaoDetalhe> avaliacaoDetalhes =
			page.getItems();

		int size = avaliacaoDetalhes.size();

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

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe.
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

	protected boolean equals(
		AvaliacaoDetalhe avaliacaoDetalhe1,
		AvaliacaoDetalhe avaliacaoDetalhe2) {

		if (avaliacaoDetalhe1 == avaliacaoDetalhe2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals(
					"avaliacaoDetalheId", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						avaliacaoDetalhe1.getAvaliacaoDetalheId(),
						avaliacaoDetalhe2.getAvaliacaoDetalheId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("avaliacaoId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoDetalhe1.getAvaliacaoId(),
						avaliacaoDetalhe2.getAvaliacaoId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("desempenho", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoDetalhe1.getDesempenho(),
						avaliacaoDetalhe2.getDesempenho())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nomeAvaliador", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoDetalhe1.getNomeAvaliador(),
						avaliacaoDetalhe2.getNomeAvaliador())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"observacoesAvaliador", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						avaliacaoDetalhe1.getObservacoesAvaliador(),
						avaliacaoDetalhe2.getObservacoesAvaliador())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tipoAvaliador", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						avaliacaoDetalhe1.getTipoAvaliador(),
						avaliacaoDetalhe2.getTipoAvaliador())) {

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

		if (!(_avaliacaoDetalheResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_avaliacaoDetalheResource;

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
		EntityField entityField, String operator,
		AvaliacaoDetalhe avaliacaoDetalhe) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("avaliacaoDetalheId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("avaliacaoId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("desempenho")) {
			sb.append(String.valueOf(avaliacaoDetalhe.getDesempenho()));

			return sb.toString();
		}

		if (entityFieldName.equals("nomeAvaliador")) {
			Object object = avaliacaoDetalhe.getNomeAvaliador();

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

		if (entityFieldName.equals("observacoesAvaliador")) {
			Object object = avaliacaoDetalhe.getObservacoesAvaliador();

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

		if (entityFieldName.equals("tipoAvaliador")) {
			sb.append(String.valueOf(avaliacaoDetalhe.getTipoAvaliador()));

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

	protected AvaliacaoDetalhe randomAvaliacaoDetalhe() throws Exception {
		return new AvaliacaoDetalhe() {
			{
				avaliacaoDetalheId = RandomTestUtil.randomLong();
				avaliacaoId = RandomTestUtil.randomLong();
				desempenho = RandomTestUtil.randomInt();
				nomeAvaliador = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				observacoesAvaliador = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				tipoAvaliador = RandomTestUtil.randomInt();
			}
		};
	}

	protected AvaliacaoDetalhe randomIrrelevantAvaliacaoDetalhe()
		throws Exception {

		AvaliacaoDetalhe randomIrrelevantAvaliacaoDetalhe =
			randomAvaliacaoDetalhe();

		return randomIrrelevantAvaliacaoDetalhe;
	}

	protected AvaliacaoDetalhe randomPatchAvaliacaoDetalhe() throws Exception {
		return randomAvaliacaoDetalhe();
	}

	protected AvaliacaoDetalheResource avaliacaoDetalheResource;
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
		LogFactoryUtil.getLog(BaseAvaliacaoDetalheResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private
		br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoDetalheResource
			_avaliacaoDetalheResource;

}