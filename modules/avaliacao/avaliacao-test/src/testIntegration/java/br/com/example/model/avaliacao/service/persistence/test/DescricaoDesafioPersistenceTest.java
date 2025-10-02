/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.test;

import br.com.example.model.avaliacao.exception.NoSuchDescricaoDesafioException;
import br.com.example.model.avaliacao.model.DescricaoDesafio;
import br.com.example.model.avaliacao.service.DescricaoDesafioLocalServiceUtil;
import br.com.example.model.avaliacao.service.persistence.DescricaoDesafioPersistence;
import br.com.example.model.avaliacao.service.persistence.DescricaoDesafioUtil;

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
public class DescricaoDesafioPersistenceTest {

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
		_persistence = DescricaoDesafioUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DescricaoDesafio> iterator = _descricaoDesafios.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DescricaoDesafio descricaoDesafio = _persistence.create(pk);

		Assert.assertNotNull(descricaoDesafio);

		Assert.assertEquals(descricaoDesafio.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		_persistence.remove(newDescricaoDesafio);

		DescricaoDesafio existingDescricaoDesafio =
			_persistence.fetchByPrimaryKey(newDescricaoDesafio.getPrimaryKey());

		Assert.assertNull(existingDescricaoDesafio);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDescricaoDesafio();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DescricaoDesafio newDescricaoDesafio = _persistence.create(pk);

		newDescricaoDesafio.setCompanyId(RandomTestUtil.nextLong());

		newDescricaoDesafio.setGroupId(RandomTestUtil.nextLong());

		newDescricaoDesafio.setUserId(RandomTestUtil.nextLong());

		newDescricaoDesafio.setCreateDate(RandomTestUtil.nextDate());

		newDescricaoDesafio.setModifiedDate(RandomTestUtil.nextDate());

		newDescricaoDesafio.setFuncionarioId(RandomTestUtil.nextLong());

		newDescricaoDesafio.setDataAvaliacao(RandomTestUtil.nextDate());

		newDescricaoDesafio.setTipoDesafio(RandomTestUtil.nextInt());

		newDescricaoDesafio.setObservacoesGerais(RandomTestUtil.randomString());

		_descricaoDesafios.add(_persistence.update(newDescricaoDesafio));

		DescricaoDesafio existingDescricaoDesafio =
			_persistence.findByPrimaryKey(newDescricaoDesafio.getPrimaryKey());

		Assert.assertEquals(
			existingDescricaoDesafio.getCompanyId(),
			newDescricaoDesafio.getCompanyId());
		Assert.assertEquals(
			existingDescricaoDesafio.getGroupId(),
			newDescricaoDesafio.getGroupId());
		Assert.assertEquals(
			existingDescricaoDesafio.getUserId(),
			newDescricaoDesafio.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDescricaoDesafio.getCreateDate()),
			Time.getShortTimestamp(newDescricaoDesafio.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDescricaoDesafio.getModifiedDate()),
			Time.getShortTimestamp(newDescricaoDesafio.getModifiedDate()));
		Assert.assertEquals(
			existingDescricaoDesafio.getDescricaoDesafioId(),
			newDescricaoDesafio.getDescricaoDesafioId());
		Assert.assertEquals(
			existingDescricaoDesafio.getFuncionarioId(),
			newDescricaoDesafio.getFuncionarioId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDescricaoDesafio.getDataAvaliacao()),
			Time.getShortTimestamp(newDescricaoDesafio.getDataAvaliacao()));
		Assert.assertEquals(
			existingDescricaoDesafio.getTipoDesafio(),
			newDescricaoDesafio.getTipoDesafio());
		Assert.assertEquals(
			existingDescricaoDesafio.getObservacoesGerais(),
			newDescricaoDesafio.getObservacoesGerais());
	}

	@Test
	public void testCountByFuncionarioId() throws Exception {
		_persistence.countByFuncionarioId(RandomTestUtil.nextLong());

		_persistence.countByFuncionarioId(0L);
	}

	@Test
	public void testCountByDescricaoDesafioId() throws Exception {
		_persistence.countByDescricaoDesafioId(RandomTestUtil.nextLong());

		_persistence.countByDescricaoDesafioId(0L);
	}

	@Test
	public void testCountByFuncionarioId_TipoDesafio() throws Exception {
		_persistence.countByFuncionarioId_TipoDesafio(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByFuncionarioId_TipoDesafio(0L, 0);
	}

	@Test
	public void testCountByTipoDesafio() throws Exception {
		_persistence.countByTipoDesafio(RandomTestUtil.nextInt());

		_persistence.countByTipoDesafio(0);
	}

	@Test
	public void testCountByDataAvaliacaoBetween() throws Exception {
		_persistence.countByDataAvaliacaoBetween(
			RandomTestUtil.nextDate(), RandomTestUtil.nextDate());

		_persistence.countByDataAvaliacaoBetween(
			RandomTestUtil.nextDate(), RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		DescricaoDesafio existingDescricaoDesafio =
			_persistence.findByPrimaryKey(newDescricaoDesafio.getPrimaryKey());

		Assert.assertEquals(existingDescricaoDesafio, newDescricaoDesafio);
	}

	@Test(expected = NoSuchDescricaoDesafioException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DescricaoDesafio> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FOO_DescricaoDesafio", "companyId", true, "groupId", true,
			"userId", true, "createDate", true, "modifiedDate", true,
			"descricaoDesafioId", true, "funcionarioId", true, "dataAvaliacao",
			true, "tipoDesafio", true, "observacoesGerais", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		DescricaoDesafio existingDescricaoDesafio =
			_persistence.fetchByPrimaryKey(newDescricaoDesafio.getPrimaryKey());

		Assert.assertEquals(existingDescricaoDesafio, newDescricaoDesafio);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DescricaoDesafio missingDescricaoDesafio =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDescricaoDesafio);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DescricaoDesafio newDescricaoDesafio1 = addDescricaoDesafio();
		DescricaoDesafio newDescricaoDesafio2 = addDescricaoDesafio();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDescricaoDesafio1.getPrimaryKey());
		primaryKeys.add(newDescricaoDesafio2.getPrimaryKey());

		Map<Serializable, DescricaoDesafio> descricaoDesafios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, descricaoDesafios.size());
		Assert.assertEquals(
			newDescricaoDesafio1,
			descricaoDesafios.get(newDescricaoDesafio1.getPrimaryKey()));
		Assert.assertEquals(
			newDescricaoDesafio2,
			descricaoDesafios.get(newDescricaoDesafio2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DescricaoDesafio> descricaoDesafios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(descricaoDesafios.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDescricaoDesafio.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DescricaoDesafio> descricaoDesafios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, descricaoDesafios.size());
		Assert.assertEquals(
			newDescricaoDesafio,
			descricaoDesafios.get(newDescricaoDesafio.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DescricaoDesafio> descricaoDesafios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(descricaoDesafios.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDescricaoDesafio.getPrimaryKey());

		Map<Serializable, DescricaoDesafio> descricaoDesafios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, descricaoDesafios.size());
		Assert.assertEquals(
			newDescricaoDesafio,
			descricaoDesafios.get(newDescricaoDesafio.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DescricaoDesafioLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DescricaoDesafio>() {

				@Override
				public void performAction(DescricaoDesafio descricaoDesafio) {
					Assert.assertNotNull(descricaoDesafio);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DescricaoDesafio.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"descricaoDesafioId",
				newDescricaoDesafio.getDescricaoDesafioId()));

		List<DescricaoDesafio> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DescricaoDesafio existingDescricaoDesafio = result.get(0);

		Assert.assertEquals(existingDescricaoDesafio, newDescricaoDesafio);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DescricaoDesafio.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"descricaoDesafioId", RandomTestUtil.nextLong()));

		List<DescricaoDesafio> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DescricaoDesafio.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("descricaoDesafioId"));

		Object newDescricaoDesafioId =
			newDescricaoDesafio.getDescricaoDesafioId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"descricaoDesafioId", new Object[] {newDescricaoDesafioId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDescricaoDesafioId = result.get(0);

		Assert.assertEquals(existingDescricaoDesafioId, newDescricaoDesafioId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DescricaoDesafio.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("descricaoDesafioId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"descricaoDesafioId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newDescricaoDesafio.getPrimaryKey()));
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

		DescricaoDesafio newDescricaoDesafio = addDescricaoDesafio();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DescricaoDesafio.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"descricaoDesafioId",
				newDescricaoDesafio.getDescricaoDesafioId()));

		List<DescricaoDesafio> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(DescricaoDesafio descricaoDesafio) {
		Assert.assertEquals(
			Long.valueOf(descricaoDesafio.getFuncionarioId()),
			ReflectionTestUtil.<Long>invoke(
				descricaoDesafio, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "funcionarioId"));
		Assert.assertEquals(
			Integer.valueOf(descricaoDesafio.getTipoDesafio()),
			ReflectionTestUtil.<Integer>invoke(
				descricaoDesafio, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "tipoDesafio"));
	}

	protected DescricaoDesafio addDescricaoDesafio() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DescricaoDesafio descricaoDesafio = _persistence.create(pk);

		descricaoDesafio.setCompanyId(RandomTestUtil.nextLong());

		descricaoDesafio.setGroupId(RandomTestUtil.nextLong());

		descricaoDesafio.setUserId(RandomTestUtil.nextLong());

		descricaoDesafio.setCreateDate(RandomTestUtil.nextDate());

		descricaoDesafio.setModifiedDate(RandomTestUtil.nextDate());

		descricaoDesafio.setFuncionarioId(RandomTestUtil.nextLong());

		descricaoDesafio.setDataAvaliacao(RandomTestUtil.nextDate());

		descricaoDesafio.setTipoDesafio(RandomTestUtil.nextInt());

		descricaoDesafio.setObservacoesGerais(RandomTestUtil.randomString());

		_descricaoDesafios.add(_persistence.update(descricaoDesafio));

		return descricaoDesafio;
	}

	private List<DescricaoDesafio> _descricaoDesafios =
		new ArrayList<DescricaoDesafio>();
	private DescricaoDesafioPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}