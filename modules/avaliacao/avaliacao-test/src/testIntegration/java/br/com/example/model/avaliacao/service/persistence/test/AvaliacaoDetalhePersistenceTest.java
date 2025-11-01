/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.test;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacaoDetalheException;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;
import br.com.example.model.avaliacao.service.AvaliacaoDetalheLocalServiceUtil;
import br.com.example.model.avaliacao.service.persistence.AvaliacaoDetalhePersistence;
import br.com.example.model.avaliacao.service.persistence.AvaliacaoDetalheUtil;

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
public class AvaliacaoDetalhePersistenceTest {

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
		_persistence = AvaliacaoDetalheUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AvaliacaoDetalhe> iterator = _avaliacaoDetalhes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AvaliacaoDetalhe avaliacaoDetalhe = _persistence.create(pk);

		Assert.assertNotNull(avaliacaoDetalhe);

		Assert.assertEquals(avaliacaoDetalhe.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		_persistence.remove(newAvaliacaoDetalhe);

		AvaliacaoDetalhe existingAvaliacaoDetalhe =
			_persistence.fetchByPrimaryKey(newAvaliacaoDetalhe.getPrimaryKey());

		Assert.assertNull(existingAvaliacaoDetalhe);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAvaliacaoDetalhe();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AvaliacaoDetalhe newAvaliacaoDetalhe = _persistence.create(pk);

		newAvaliacaoDetalhe.setCompanyId(RandomTestUtil.nextLong());

		newAvaliacaoDetalhe.setGroupId(RandomTestUtil.nextLong());

		newAvaliacaoDetalhe.setUserId(RandomTestUtil.nextLong());

		newAvaliacaoDetalhe.setCreateDate(RandomTestUtil.nextDate());

		newAvaliacaoDetalhe.setModifiedDate(RandomTestUtil.nextDate());

		newAvaliacaoDetalhe.setAvaliacaoId(RandomTestUtil.nextLong());

		newAvaliacaoDetalhe.setTipoAvaliador(RandomTestUtil.nextInt());

		newAvaliacaoDetalhe.setNomeAvaliador(RandomTestUtil.randomString());

		newAvaliacaoDetalhe.setObservacoesAvaliador(
			RandomTestUtil.randomString());

		newAvaliacaoDetalhe.setDesempenho(RandomTestUtil.nextInt());

		_avaliacaoDetalhes.add(_persistence.update(newAvaliacaoDetalhe));

		AvaliacaoDetalhe existingAvaliacaoDetalhe =
			_persistence.findByPrimaryKey(newAvaliacaoDetalhe.getPrimaryKey());

		Assert.assertEquals(
			existingAvaliacaoDetalhe.getCompanyId(),
			newAvaliacaoDetalhe.getCompanyId());
		Assert.assertEquals(
			existingAvaliacaoDetalhe.getGroupId(),
			newAvaliacaoDetalhe.getGroupId());
		Assert.assertEquals(
			existingAvaliacaoDetalhe.getUserId(),
			newAvaliacaoDetalhe.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAvaliacaoDetalhe.getCreateDate()),
			Time.getShortTimestamp(newAvaliacaoDetalhe.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAvaliacaoDetalhe.getModifiedDate()),
			Time.getShortTimestamp(newAvaliacaoDetalhe.getModifiedDate()));
		Assert.assertEquals(
			existingAvaliacaoDetalhe.getAvaliacaoDetalheId(),
			newAvaliacaoDetalhe.getAvaliacaoDetalheId());
		Assert.assertEquals(
			existingAvaliacaoDetalhe.getAvaliacaoId(),
			newAvaliacaoDetalhe.getAvaliacaoId());
		Assert.assertEquals(
			existingAvaliacaoDetalhe.getTipoAvaliador(),
			newAvaliacaoDetalhe.getTipoAvaliador());
		Assert.assertEquals(
			existingAvaliacaoDetalhe.getNomeAvaliador(),
			newAvaliacaoDetalhe.getNomeAvaliador());
		Assert.assertEquals(
			existingAvaliacaoDetalhe.getObservacoesAvaliador(),
			newAvaliacaoDetalhe.getObservacoesAvaliador());
		Assert.assertEquals(
			existingAvaliacaoDetalhe.getDesempenho(),
			newAvaliacaoDetalhe.getDesempenho());
	}

	@Test
	public void testCountByAvaliacaoId() throws Exception {
		_persistence.countByAvaliacaoId(RandomTestUtil.nextLong());

		_persistence.countByAvaliacaoId(0L);
	}

	@Test
	public void testCountByTipoAvaliador() throws Exception {
		_persistence.countByTipoAvaliador(RandomTestUtil.nextInt());

		_persistence.countByTipoAvaliador(0);
	}

	@Test
	public void testCountByDesempenho() throws Exception {
		_persistence.countByDesempenho(RandomTestUtil.nextInt());

		_persistence.countByDesempenho(0);
	}

	@Test
	public void testCountByAvaliacaoIdTipoAvaliador() throws Exception {
		_persistence.countByAvaliacaoIdTipoAvaliador(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByAvaliacaoIdTipoAvaliador(0L, 0);
	}

	@Test
	public void testCountByTipoAvaliadorAndDesempenho() throws Exception {
		_persistence.countByTipoAvaliadorAndDesempenho(
			RandomTestUtil.nextInt(), RandomTestUtil.nextInt());

		_persistence.countByTipoAvaliadorAndDesempenho(0, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		AvaliacaoDetalhe existingAvaliacaoDetalhe =
			_persistence.findByPrimaryKey(newAvaliacaoDetalhe.getPrimaryKey());

		Assert.assertEquals(existingAvaliacaoDetalhe, newAvaliacaoDetalhe);
	}

	@Test(expected = NoSuchAvaliacaoDetalheException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AvaliacaoDetalhe> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"DESAFIO_AvaliacaoDetalhe", "companyId", true, "groupId", true,
			"userId", true, "createDate", true, "modifiedDate", true,
			"avaliacaoDetalheId", true, "avaliacaoId", true, "tipoAvaliador",
			true, "nomeAvaliador", true, "observacoesAvaliador", true,
			"desempenho", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		AvaliacaoDetalhe existingAvaliacaoDetalhe =
			_persistence.fetchByPrimaryKey(newAvaliacaoDetalhe.getPrimaryKey());

		Assert.assertEquals(existingAvaliacaoDetalhe, newAvaliacaoDetalhe);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AvaliacaoDetalhe missingAvaliacaoDetalhe =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAvaliacaoDetalhe);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AvaliacaoDetalhe newAvaliacaoDetalhe1 = addAvaliacaoDetalhe();
		AvaliacaoDetalhe newAvaliacaoDetalhe2 = addAvaliacaoDetalhe();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacaoDetalhe1.getPrimaryKey());
		primaryKeys.add(newAvaliacaoDetalhe2.getPrimaryKey());

		Map<Serializable, AvaliacaoDetalhe> avaliacaoDetalhes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, avaliacaoDetalhes.size());
		Assert.assertEquals(
			newAvaliacaoDetalhe1,
			avaliacaoDetalhes.get(newAvaliacaoDetalhe1.getPrimaryKey()));
		Assert.assertEquals(
			newAvaliacaoDetalhe2,
			avaliacaoDetalhes.get(newAvaliacaoDetalhe2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AvaliacaoDetalhe> avaliacaoDetalhes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(avaliacaoDetalhes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacaoDetalhe.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AvaliacaoDetalhe> avaliacaoDetalhes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, avaliacaoDetalhes.size());
		Assert.assertEquals(
			newAvaliacaoDetalhe,
			avaliacaoDetalhes.get(newAvaliacaoDetalhe.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AvaliacaoDetalhe> avaliacaoDetalhes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(avaliacaoDetalhes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacaoDetalhe.getPrimaryKey());

		Map<Serializable, AvaliacaoDetalhe> avaliacaoDetalhes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, avaliacaoDetalhes.size());
		Assert.assertEquals(
			newAvaliacaoDetalhe,
			avaliacaoDetalhes.get(newAvaliacaoDetalhe.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AvaliacaoDetalheLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AvaliacaoDetalhe>() {

				@Override
				public void performAction(AvaliacaoDetalhe avaliacaoDetalhe) {
					Assert.assertNotNull(avaliacaoDetalhe);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AvaliacaoDetalhe.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacaoDetalheId",
				newAvaliacaoDetalhe.getAvaliacaoDetalheId()));

		List<AvaliacaoDetalhe> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AvaliacaoDetalhe existingAvaliacaoDetalhe = result.get(0);

		Assert.assertEquals(existingAvaliacaoDetalhe, newAvaliacaoDetalhe);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AvaliacaoDetalhe.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacaoDetalheId", RandomTestUtil.nextLong()));

		List<AvaliacaoDetalhe> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AvaliacaoDetalhe.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("avaliacaoDetalheId"));

		Object newAvaliacaoDetalheId =
			newAvaliacaoDetalhe.getAvaliacaoDetalheId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"avaliacaoDetalheId", new Object[] {newAvaliacaoDetalheId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAvaliacaoDetalheId = result.get(0);

		Assert.assertEquals(existingAvaliacaoDetalheId, newAvaliacaoDetalheId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AvaliacaoDetalhe.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("avaliacaoDetalheId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"avaliacaoDetalheId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAvaliacaoDetalhe.getPrimaryKey()));
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

		AvaliacaoDetalhe newAvaliacaoDetalhe = addAvaliacaoDetalhe();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AvaliacaoDetalhe.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacaoDetalheId",
				newAvaliacaoDetalhe.getAvaliacaoDetalheId()));

		List<AvaliacaoDetalhe> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(AvaliacaoDetalhe avaliacaoDetalhe) {
		Assert.assertEquals(
			Long.valueOf(avaliacaoDetalhe.getAvaliacaoId()),
			ReflectionTestUtil.<Long>invoke(
				avaliacaoDetalhe, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "avaliacaoId"));
		Assert.assertEquals(
			Integer.valueOf(avaliacaoDetalhe.getTipoAvaliador()),
			ReflectionTestUtil.<Integer>invoke(
				avaliacaoDetalhe, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "tipoAvaliador"));
	}

	protected AvaliacaoDetalhe addAvaliacaoDetalhe() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AvaliacaoDetalhe avaliacaoDetalhe = _persistence.create(pk);

		avaliacaoDetalhe.setCompanyId(RandomTestUtil.nextLong());

		avaliacaoDetalhe.setGroupId(RandomTestUtil.nextLong());

		avaliacaoDetalhe.setUserId(RandomTestUtil.nextLong());

		avaliacaoDetalhe.setCreateDate(RandomTestUtil.nextDate());

		avaliacaoDetalhe.setModifiedDate(RandomTestUtil.nextDate());

		avaliacaoDetalhe.setAvaliacaoId(RandomTestUtil.nextLong());

		avaliacaoDetalhe.setTipoAvaliador(RandomTestUtil.nextInt());

		avaliacaoDetalhe.setNomeAvaliador(RandomTestUtil.randomString());

		avaliacaoDetalhe.setObservacoesAvaliador(RandomTestUtil.randomString());

		avaliacaoDetalhe.setDesempenho(RandomTestUtil.nextInt());

		_avaliacaoDetalhes.add(_persistence.update(avaliacaoDetalhe));

		return avaliacaoDetalhe;
	}

	private List<AvaliacaoDetalhe> _avaliacaoDetalhes =
		new ArrayList<AvaliacaoDetalhe>();
	private AvaliacaoDetalhePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}