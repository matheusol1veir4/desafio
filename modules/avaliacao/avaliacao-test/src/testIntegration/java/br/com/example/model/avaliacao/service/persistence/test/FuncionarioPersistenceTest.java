/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.test;

import br.com.example.model.avaliacao.exception.NoSuchFuncionarioException;
import br.com.example.model.avaliacao.model.Funcionario;
import br.com.example.model.avaliacao.service.FuncionarioLocalServiceUtil;
import br.com.example.model.avaliacao.service.persistence.FuncionarioPersistence;
import br.com.example.model.avaliacao.service.persistence.FuncionarioUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
public class FuncionarioPersistenceTest {

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
		_persistence = FuncionarioUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Funcionario> iterator = _funcionarios.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Funcionario funcionario = _persistence.create(pk);

		Assert.assertNotNull(funcionario);

		Assert.assertEquals(funcionario.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Funcionario newFuncionario = addFuncionario();

		_persistence.remove(newFuncionario);

		Funcionario existingFuncionario = _persistence.fetchByPrimaryKey(
			newFuncionario.getPrimaryKey());

		Assert.assertNull(existingFuncionario);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFuncionario();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Funcionario newFuncionario = _persistence.create(pk);

		newFuncionario.setCompanyId(RandomTestUtil.nextLong());

		newFuncionario.setGroupId(RandomTestUtil.nextLong());

		newFuncionario.setUserId(RandomTestUtil.nextLong());

		newFuncionario.setCreateDate(RandomTestUtil.nextDate());

		newFuncionario.setModifiedDate(RandomTestUtil.nextDate());

		newFuncionario.setNome(RandomTestUtil.randomString());

		newFuncionario.setEmail(RandomTestUtil.randomString());

		newFuncionario.setAreaAtuacao(RandomTestUtil.nextInt());

		_funcionarios.add(_persistence.update(newFuncionario));

		Funcionario existingFuncionario = _persistence.findByPrimaryKey(
			newFuncionario.getPrimaryKey());

		Assert.assertEquals(
			existingFuncionario.getCompanyId(), newFuncionario.getCompanyId());
		Assert.assertEquals(
			existingFuncionario.getGroupId(), newFuncionario.getGroupId());
		Assert.assertEquals(
			existingFuncionario.getUserId(), newFuncionario.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingFuncionario.getCreateDate()),
			Time.getShortTimestamp(newFuncionario.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingFuncionario.getModifiedDate()),
			Time.getShortTimestamp(newFuncionario.getModifiedDate()));
		Assert.assertEquals(
			existingFuncionario.getFuncionarioId(),
			newFuncionario.getFuncionarioId());
		Assert.assertEquals(
			existingFuncionario.getNome(), newFuncionario.getNome());
		Assert.assertEquals(
			existingFuncionario.getEmail(), newFuncionario.getEmail());
		Assert.assertEquals(
			existingFuncionario.getAreaAtuacao(),
			newFuncionario.getAreaAtuacao());
	}

	@Test
	public void testCountByFuncionarioId() throws Exception {
		_persistence.countByFuncionarioId(RandomTestUtil.nextLong());

		_persistence.countByFuncionarioId(0L);
	}

	@Test
	public void testCountByEmail() throws Exception {
		_persistence.countByEmail("");

		_persistence.countByEmail("null");

		_persistence.countByEmail((String)null);
	}

	@Test
	public void testCountByAreaAtuacao() throws Exception {
		_persistence.countByAreaAtuacao(RandomTestUtil.nextInt());

		_persistence.countByAreaAtuacao(0);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Funcionario newFuncionario = addFuncionario();

		Funcionario existingFuncionario = _persistence.findByPrimaryKey(
			newFuncionario.getPrimaryKey());

		Assert.assertEquals(existingFuncionario, newFuncionario);
	}

	@Test(expected = NoSuchFuncionarioException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Funcionario> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FOO_Funcionario", "companyId", true, "groupId", true, "userId",
			true, "createDate", true, "modifiedDate", true, "funcionarioId",
			true, "nome", true, "email", true, "areaAtuacao", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Funcionario newFuncionario = addFuncionario();

		Funcionario existingFuncionario = _persistence.fetchByPrimaryKey(
			newFuncionario.getPrimaryKey());

		Assert.assertEquals(existingFuncionario, newFuncionario);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Funcionario missingFuncionario = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFuncionario);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Funcionario newFuncionario1 = addFuncionario();
		Funcionario newFuncionario2 = addFuncionario();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFuncionario1.getPrimaryKey());
		primaryKeys.add(newFuncionario2.getPrimaryKey());

		Map<Serializable, Funcionario> funcionarios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, funcionarios.size());
		Assert.assertEquals(
			newFuncionario1, funcionarios.get(newFuncionario1.getPrimaryKey()));
		Assert.assertEquals(
			newFuncionario2, funcionarios.get(newFuncionario2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Funcionario> funcionarios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(funcionarios.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Funcionario newFuncionario = addFuncionario();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFuncionario.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Funcionario> funcionarios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, funcionarios.size());
		Assert.assertEquals(
			newFuncionario, funcionarios.get(newFuncionario.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Funcionario> funcionarios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(funcionarios.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Funcionario newFuncionario = addFuncionario();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFuncionario.getPrimaryKey());

		Map<Serializable, Funcionario> funcionarios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, funcionarios.size());
		Assert.assertEquals(
			newFuncionario, funcionarios.get(newFuncionario.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			FuncionarioLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Funcionario>() {

				@Override
				public void performAction(Funcionario funcionario) {
					Assert.assertNotNull(funcionario);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Funcionario newFuncionario = addFuncionario();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Funcionario.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"funcionarioId", newFuncionario.getFuncionarioId()));

		List<Funcionario> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Funcionario existingFuncionario = result.get(0);

		Assert.assertEquals(existingFuncionario, newFuncionario);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Funcionario.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"funcionarioId", RandomTestUtil.nextLong()));

		List<Funcionario> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Funcionario newFuncionario = addFuncionario();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Funcionario.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("funcionarioId"));

		Object newFuncionarioId = newFuncionario.getFuncionarioId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"funcionarioId", new Object[] {newFuncionarioId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFuncionarioId = result.get(0);

		Assert.assertEquals(existingFuncionarioId, newFuncionarioId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Funcionario.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("funcionarioId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"funcionarioId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Funcionario addFuncionario() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Funcionario funcionario = _persistence.create(pk);

		funcionario.setCompanyId(RandomTestUtil.nextLong());

		funcionario.setGroupId(RandomTestUtil.nextLong());

		funcionario.setUserId(RandomTestUtil.nextLong());

		funcionario.setCreateDate(RandomTestUtil.nextDate());

		funcionario.setModifiedDate(RandomTestUtil.nextDate());

		funcionario.setNome(RandomTestUtil.randomString());

		funcionario.setEmail(RandomTestUtil.randomString());

		funcionario.setAreaAtuacao(RandomTestUtil.nextInt());

		_funcionarios.add(_persistence.update(funcionario));

		return funcionario;
	}

	private List<Funcionario> _funcionarios = new ArrayList<Funcionario>();
	private FuncionarioPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}