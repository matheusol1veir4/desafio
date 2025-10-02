/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.test;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacoesException;
import br.com.example.model.avaliacao.model.Avaliacoes;
import br.com.example.model.avaliacao.service.AvaliacoesLocalServiceUtil;
import br.com.example.model.avaliacao.service.persistence.AvaliacoesPersistence;
import br.com.example.model.avaliacao.service.persistence.AvaliacoesUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AvaliacoesPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"br.com.example.model.avaliacao.service"));

	@Before
	public void setUp() {
		_persistence = AvaliacoesUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Avaliacoes> iterator = _avaliacoeses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Avaliacoes avaliacoes = _persistence.create(pk);

		Assert.assertNotNull(avaliacoes);

		Assert.assertEquals(avaliacoes.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Avaliacoes newAvaliacoes = addAvaliacoes();

		_persistence.remove(newAvaliacoes);

		Avaliacoes existingAvaliacoes = _persistence.fetchByPrimaryKey(
			newAvaliacoes.getPrimaryKey());

		Assert.assertNull(existingAvaliacoes);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAvaliacoes();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Avaliacoes newAvaliacoes = _persistence.create(pk);

		newAvaliacoes.setCompanyId(RandomTestUtil.nextLong());

		newAvaliacoes.setGroupId(RandomTestUtil.nextLong());

		newAvaliacoes.setUserId(RandomTestUtil.nextLong());

		newAvaliacoes.setCreateDate(RandomTestUtil.nextDate());

		newAvaliacoes.setModifiedDate(RandomTestUtil.nextDate());

		newAvaliacoes.setDescricaoDesafioId(RandomTestUtil.nextLong());

		newAvaliacoes.setTipoAvaliador(RandomTestUtil.randomString());

		newAvaliacoes.setNomeAvaliador(RandomTestUtil.randomString());

		newAvaliacoes.setObservacoesAvaliador(RandomTestUtil.randomString());

		newAvaliacoes.setDesempenho(RandomTestUtil.nextInt());

		_avaliacoeses.add(_persistence.update(newAvaliacoes));

		Avaliacoes existingAvaliacoes = _persistence.findByPrimaryKey(
			newAvaliacoes.getPrimaryKey());

		Assert.assertEquals(
			existingAvaliacoes.getCompanyId(), newAvaliacoes.getCompanyId());
		Assert.assertEquals(
			existingAvaliacoes.getGroupId(), newAvaliacoes.getGroupId());
		Assert.assertEquals(
			existingAvaliacoes.getUserId(), newAvaliacoes.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAvaliacoes.getCreateDate()),
			Time.getShortTimestamp(newAvaliacoes.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAvaliacoes.getModifiedDate()),
			Time.getShortTimestamp(newAvaliacoes.getModifiedDate()));
		Assert.assertEquals(
			existingAvaliacoes.getAvaliacoesId(),
			newAvaliacoes.getAvaliacoesId());
		Assert.assertEquals(
			existingAvaliacoes.getDescricaoDesafioId(),
			newAvaliacoes.getDescricaoDesafioId());
		Assert.assertEquals(
			existingAvaliacoes.getTipoAvaliador(),
			newAvaliacoes.getTipoAvaliador());
		Assert.assertEquals(
			existingAvaliacoes.getNomeAvaliador(),
			newAvaliacoes.getNomeAvaliador());
		Assert.assertEquals(
			existingAvaliacoes.getObservacoesAvaliador(),
			newAvaliacoes.getObservacoesAvaliador());
		Assert.assertEquals(
			existingAvaliacoes.getDesempenho(), newAvaliacoes.getDesempenho());
	}

	@Test
	public void testCountByAvaliacoesId() throws Exception {
		_persistence.countByAvaliacoesId(RandomTestUtil.nextLong());

		_persistence.countByAvaliacoesId(0L);
	}

	@Test
	public void testCountByDescricaoDesafioId() throws Exception {
		_persistence.countByDescricaoDesafioId(RandomTestUtil.nextLong());

		_persistence.countByDescricaoDesafioId(0L);
	}

	@Test
	public void testCountByDescricaoDesafioId_TipoAvaliador() throws Exception {
		_persistence.countByDescricaoDesafioId_TipoAvaliador(
			RandomTestUtil.nextLong(), "");

		_persistence.countByDescricaoDesafioId_TipoAvaliador(0L, "null");

		_persistence.countByDescricaoDesafioId_TipoAvaliador(0L, (String)null);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Avaliacoes newAvaliacoes = addAvaliacoes();

		Avaliacoes existingAvaliacoes = _persistence.findByPrimaryKey(
			newAvaliacoes.getPrimaryKey());

		Assert.assertEquals(existingAvaliacoes, newAvaliacoes);
	}

	@Test(expected = NoSuchAvaliacoesException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Avaliacoes> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FOO_Avaliacoes", "companyId", true, "groupId", true, "userId",
			true, "createDate", true, "modifiedDate", true, "avaliacoesId",
			true, "descricaoDesafioId", true, "tipoAvaliador", true,
			"nomeAvaliador", true, "observacoesAvaliador", true, "desempenho",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Avaliacoes newAvaliacoes = addAvaliacoes();

		Avaliacoes existingAvaliacoes = _persistence.fetchByPrimaryKey(
			newAvaliacoes.getPrimaryKey());

		Assert.assertEquals(existingAvaliacoes, newAvaliacoes);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Avaliacoes missingAvaliacoes = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAvaliacoes);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Avaliacoes newAvaliacoes1 = addAvaliacoes();
		Avaliacoes newAvaliacoes2 = addAvaliacoes();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacoes1.getPrimaryKey());
		primaryKeys.add(newAvaliacoes2.getPrimaryKey());

		Map<Serializable, Avaliacoes> avaliacoeses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, avaliacoeses.size());
		Assert.assertEquals(
			newAvaliacoes1, avaliacoeses.get(newAvaliacoes1.getPrimaryKey()));
		Assert.assertEquals(
			newAvaliacoes2, avaliacoeses.get(newAvaliacoes2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Avaliacoes> avaliacoeses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(avaliacoeses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Avaliacoes newAvaliacoes = addAvaliacoes();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacoes.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Avaliacoes> avaliacoeses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, avaliacoeses.size());
		Assert.assertEquals(
			newAvaliacoes, avaliacoeses.get(newAvaliacoes.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Avaliacoes> avaliacoeses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(avaliacoeses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Avaliacoes newAvaliacoes = addAvaliacoes();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacoes.getPrimaryKey());

		Map<Serializable, Avaliacoes> avaliacoeses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, avaliacoeses.size());
		Assert.assertEquals(
			newAvaliacoes, avaliacoeses.get(newAvaliacoes.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AvaliacoesLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Avaliacoes>() {

				@Override
				public void performAction(Avaliacoes avaliacoes) {
					Assert.assertNotNull(avaliacoes);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Avaliacoes newAvaliacoes = addAvaliacoes();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacoes.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacoesId", newAvaliacoes.getAvaliacoesId()));

		List<Avaliacoes> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Avaliacoes existingAvaliacoes = result.get(0);

		Assert.assertEquals(existingAvaliacoes, newAvaliacoes);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacoes.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacoesId", RandomTestUtil.nextLong()));

		List<Avaliacoes> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Avaliacoes newAvaliacoes = addAvaliacoes();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacoes.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("avaliacoesId"));

		Object newAvaliacoesId = newAvaliacoes.getAvaliacoesId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"avaliacoesId", new Object[] {newAvaliacoesId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAvaliacoesId = result.get(0);

		Assert.assertEquals(existingAvaliacoesId, newAvaliacoesId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacoes.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("avaliacoesId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"avaliacoesId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Avaliacoes newAvaliacoes = addAvaliacoes();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAvaliacoes.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Avaliacoes newAvaliacoes = addAvaliacoes();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacoes.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacoesId", newAvaliacoes.getAvaliacoesId()));

		List<Avaliacoes> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Avaliacoes avaliacoes) {
		Assert.assertEquals(
			Long.valueOf(avaliacoes.getDescricaoDesafioId()),
			ReflectionTestUtil.<Long>invoke(
				avaliacoes, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "descricaoDesafioId"));
		Assert.assertEquals(
			avaliacoes.getTipoAvaliador(),
			ReflectionTestUtil.invoke(
				avaliacoes, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "tipoAvaliador"));
	}

	protected Avaliacoes addAvaliacoes() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Avaliacoes avaliacoes = _persistence.create(pk);

		avaliacoes.setCompanyId(RandomTestUtil.nextLong());

		avaliacoes.setGroupId(RandomTestUtil.nextLong());

		avaliacoes.setUserId(RandomTestUtil.nextLong());

		avaliacoes.setCreateDate(RandomTestUtil.nextDate());

		avaliacoes.setModifiedDate(RandomTestUtil.nextDate());

		avaliacoes.setDescricaoDesafioId(RandomTestUtil.nextLong());

		avaliacoes.setTipoAvaliador(RandomTestUtil.randomString());

		avaliacoes.setNomeAvaliador(RandomTestUtil.randomString());

		avaliacoes.setObservacoesAvaliador(RandomTestUtil.randomString());

		avaliacoes.setDesempenho(RandomTestUtil.nextInt());

		_avaliacoeses.add(_persistence.update(avaliacoes));

		return avaliacoes;
	}

	private List<Avaliacoes> _avaliacoeses = new ArrayList<Avaliacoes>();
	private AvaliacoesPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}