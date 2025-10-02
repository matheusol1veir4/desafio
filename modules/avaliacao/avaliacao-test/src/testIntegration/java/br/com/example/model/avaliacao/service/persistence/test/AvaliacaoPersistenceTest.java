/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.test;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacaoException;
import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.service.AvaliacaoLocalServiceUtil;
import br.com.example.model.avaliacao.service.persistence.AvaliacaoPersistence;
import br.com.example.model.avaliacao.service.persistence.AvaliacaoUtil;

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
public class AvaliacaoPersistenceTest {

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
		_persistence = AvaliacaoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Avaliacao> iterator = _avaliacaos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Avaliacao avaliacao = _persistence.create(pk);

		Assert.assertNotNull(avaliacao);

		Assert.assertEquals(avaliacao.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Avaliacao newAvaliacao = addAvaliacao();

		_persistence.remove(newAvaliacao);

		Avaliacao existingAvaliacao = _persistence.fetchByPrimaryKey(
			newAvaliacao.getPrimaryKey());

		Assert.assertNull(existingAvaliacao);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAvaliacao();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Avaliacao newAvaliacao = _persistence.create(pk);

		newAvaliacao.setCompanyId(RandomTestUtil.nextLong());

		newAvaliacao.setGroupId(RandomTestUtil.nextLong());

		newAvaliacao.setUserId(RandomTestUtil.nextLong());

		newAvaliacao.setCreateDate(RandomTestUtil.nextDate());

		newAvaliacao.setModifiedDate(RandomTestUtil.nextDate());

		newAvaliacao.setFuncionarioId(RandomTestUtil.nextLong());

		newAvaliacao.setDataAvaliacao(RandomTestUtil.nextDate());

		newAvaliacao.setPeriodoDesafio(RandomTestUtil.nextInt());

		newAvaliacao.setObservacoesGerais(RandomTestUtil.randomString());

		newAvaliacao.setAreaAtuacao(RandomTestUtil.nextInt());

		_avaliacaos.add(_persistence.update(newAvaliacao));

		Avaliacao existingAvaliacao = _persistence.findByPrimaryKey(
			newAvaliacao.getPrimaryKey());

		Assert.assertEquals(
			existingAvaliacao.getCompanyId(), newAvaliacao.getCompanyId());
		Assert.assertEquals(
			existingAvaliacao.getGroupId(), newAvaliacao.getGroupId());
		Assert.assertEquals(
			existingAvaliacao.getUserId(), newAvaliacao.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAvaliacao.getCreateDate()),
			Time.getShortTimestamp(newAvaliacao.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAvaliacao.getModifiedDate()),
			Time.getShortTimestamp(newAvaliacao.getModifiedDate()));
		Assert.assertEquals(
			existingAvaliacao.getAvaliacaoId(), newAvaliacao.getAvaliacaoId());
		Assert.assertEquals(
			existingAvaliacao.getFuncionarioId(),
			newAvaliacao.getFuncionarioId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAvaliacao.getDataAvaliacao()),
			Time.getShortTimestamp(newAvaliacao.getDataAvaliacao()));
		Assert.assertEquals(
			existingAvaliacao.getPeriodoDesafio(),
			newAvaliacao.getPeriodoDesafio());
		Assert.assertEquals(
			existingAvaliacao.getObservacoesGerais(),
			newAvaliacao.getObservacoesGerais());
		Assert.assertEquals(
			existingAvaliacao.getAreaAtuacao(), newAvaliacao.getAreaAtuacao());
	}

	@Test
	public void testCountByFuncionarioId() throws Exception {
		_persistence.countByFuncionarioId(RandomTestUtil.nextLong());

		_persistence.countByFuncionarioId(0L);
	}

	@Test
	public void testCountByFuncionarioIdPeriodoDesafio() throws Exception {
		_persistence.countByFuncionarioIdPeriodoDesafio(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByFuncionarioIdPeriodoDesafio(0L, 0);
	}

	@Test
	public void testCountByPeriodoDesafio() throws Exception {
		_persistence.countByPeriodoDesafio(RandomTestUtil.nextInt());

		_persistence.countByPeriodoDesafio(0);
	}

	@Test
	public void testCountByDataAvaliacaoBetween() throws Exception {
		_persistence.countByDataAvaliacaoBetween(
			RandomTestUtil.nextDate(), RandomTestUtil.nextDate());

		_persistence.countByDataAvaliacaoBetween(
			RandomTestUtil.nextDate(), RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByAreaAtuacao() throws Exception {
		_persistence.countByAreaAtuacao(RandomTestUtil.nextInt());

		_persistence.countByAreaAtuacao(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Avaliacao newAvaliacao = addAvaliacao();

		Avaliacao existingAvaliacao = _persistence.findByPrimaryKey(
			newAvaliacao.getPrimaryKey());

		Assert.assertEquals(existingAvaliacao, newAvaliacao);
	}

	@Test(expected = NoSuchAvaliacaoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Avaliacao> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"DESAFIO_Avaliacao", "companyId", true, "groupId", true, "userId",
			true, "createDate", true, "modifiedDate", true, "avaliacaoId", true,
			"funcionarioId", true, "dataAvaliacao", true, "periodoDesafio",
			true, "observacoesGerais", true, "areaAtuacao", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Avaliacao newAvaliacao = addAvaliacao();

		Avaliacao existingAvaliacao = _persistence.fetchByPrimaryKey(
			newAvaliacao.getPrimaryKey());

		Assert.assertEquals(existingAvaliacao, newAvaliacao);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Avaliacao missingAvaliacao = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAvaliacao);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Avaliacao newAvaliacao1 = addAvaliacao();
		Avaliacao newAvaliacao2 = addAvaliacao();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacao1.getPrimaryKey());
		primaryKeys.add(newAvaliacao2.getPrimaryKey());

		Map<Serializable, Avaliacao> avaliacaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, avaliacaos.size());
		Assert.assertEquals(
			newAvaliacao1, avaliacaos.get(newAvaliacao1.getPrimaryKey()));
		Assert.assertEquals(
			newAvaliacao2, avaliacaos.get(newAvaliacao2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Avaliacao> avaliacaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(avaliacaos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Avaliacao newAvaliacao = addAvaliacao();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacao.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Avaliacao> avaliacaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, avaliacaos.size());
		Assert.assertEquals(
			newAvaliacao, avaliacaos.get(newAvaliacao.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Avaliacao> avaliacaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(avaliacaos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Avaliacao newAvaliacao = addAvaliacao();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAvaliacao.getPrimaryKey());

		Map<Serializable, Avaliacao> avaliacaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, avaliacaos.size());
		Assert.assertEquals(
			newAvaliacao, avaliacaos.get(newAvaliacao.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AvaliacaoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Avaliacao>() {

				@Override
				public void performAction(Avaliacao avaliacao) {
					Assert.assertNotNull(avaliacao);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Avaliacao newAvaliacao = addAvaliacao();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacao.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacaoId", newAvaliacao.getAvaliacaoId()));

		List<Avaliacao> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Avaliacao existingAvaliacao = result.get(0);

		Assert.assertEquals(existingAvaliacao, newAvaliacao);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacao.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacaoId", RandomTestUtil.nextLong()));

		List<Avaliacao> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Avaliacao newAvaliacao = addAvaliacao();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacao.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("avaliacaoId"));

		Object newAvaliacaoId = newAvaliacao.getAvaliacaoId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"avaliacaoId", new Object[] {newAvaliacaoId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAvaliacaoId = result.get(0);

		Assert.assertEquals(existingAvaliacaoId, newAvaliacaoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacao.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("avaliacaoId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"avaliacaoId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Avaliacao newAvaliacao = addAvaliacao();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAvaliacao.getPrimaryKey()));
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

		Avaliacao newAvaliacao = addAvaliacao();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Avaliacao.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"avaliacaoId", newAvaliacao.getAvaliacaoId()));

		List<Avaliacao> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Avaliacao avaliacao) {
		Assert.assertEquals(
			Long.valueOf(avaliacao.getFuncionarioId()),
			ReflectionTestUtil.<Long>invoke(
				avaliacao, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "funcionarioId"));
		Assert.assertEquals(
			Integer.valueOf(avaliacao.getPeriodoDesafio()),
			ReflectionTestUtil.<Integer>invoke(
				avaliacao, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "periodoDesafio"));
	}

	protected Avaliacao addAvaliacao() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Avaliacao avaliacao = _persistence.create(pk);

		avaliacao.setCompanyId(RandomTestUtil.nextLong());

		avaliacao.setGroupId(RandomTestUtil.nextLong());

		avaliacao.setUserId(RandomTestUtil.nextLong());

		avaliacao.setCreateDate(RandomTestUtil.nextDate());

		avaliacao.setModifiedDate(RandomTestUtil.nextDate());

		avaliacao.setFuncionarioId(RandomTestUtil.nextLong());

		avaliacao.setDataAvaliacao(RandomTestUtil.nextDate());

		avaliacao.setPeriodoDesafio(RandomTestUtil.nextInt());

		avaliacao.setObservacoesGerais(RandomTestUtil.randomString());

		avaliacao.setAreaAtuacao(RandomTestUtil.nextInt());

		_avaliacaos.add(_persistence.update(avaliacao));

		return avaliacao;
	}

	private List<Avaliacao> _avaliacaos = new ArrayList<Avaliacao>();
	private AvaliacaoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}