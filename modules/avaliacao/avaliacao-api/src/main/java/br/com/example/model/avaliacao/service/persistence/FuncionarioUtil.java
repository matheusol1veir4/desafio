/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.model.Funcionario;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the funcionario service. This utility wraps <code>br.com.example.model.avaliacao.service.persistence.impl.FuncionarioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FuncionarioPersistence
 * @generated
 */
public class FuncionarioUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Funcionario funcionario) {
		getPersistence().clearCache(funcionario);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Funcionario> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Funcionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Funcionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Funcionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Funcionario update(Funcionario funcionario) {
		return getPersistence().update(funcionario);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Funcionario update(
		Funcionario funcionario, ServiceContext serviceContext) {

		return getPersistence().update(funcionario, serviceContext);
	}

	/**
	 * Returns all the funcionarios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching funcionarios
	 */
	public static List<Funcionario> findByFuncionarioId(long funcionarioId) {
		return getPersistence().findByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns a range of all the funcionarios where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 */
	public static List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end) {

		return getPersistence().findByFuncionarioId(funcionarioId, start, end);
	}

	/**
	 * Returns an ordered range of all the funcionarios where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 */
	public static List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().findByFuncionarioId(
			funcionarioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the funcionarios where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching funcionarios
	 */
	public static List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFuncionarioId(
			funcionarioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public static Funcionario findByFuncionarioId_First(
			long funcionarioId,
			OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByFuncionarioId_First(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the first funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public static Funcionario fetchByFuncionarioId_First(
		long funcionarioId, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().fetchByFuncionarioId_First(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the last funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public static Funcionario findByFuncionarioId_Last(
			long funcionarioId,
			OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByFuncionarioId_Last(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the last funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public static Funcionario fetchByFuncionarioId_Last(
		long funcionarioId, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().fetchByFuncionarioId_Last(
			funcionarioId, orderByComparator);
	}

	/**
	 * Removes all the funcionarios where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	public static void removeByFuncionarioId(long funcionarioId) {
		getPersistence().removeByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns the number of funcionarios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching funcionarios
	 */
	public static int countByFuncionarioId(long funcionarioId) {
		return getPersistence().countByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns all the funcionarios where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching funcionarios
	 */
	public static List<Funcionario> findByEmail(String email) {
		return getPersistence().findByEmail(email);
	}

	/**
	 * Returns a range of all the funcionarios where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 */
	public static List<Funcionario> findByEmail(
		String email, int start, int end) {

		return getPersistence().findByEmail(email, start, end);
	}

	/**
	 * Returns an ordered range of all the funcionarios where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 */
	public static List<Funcionario> findByEmail(
		String email, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the funcionarios where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching funcionarios
	 */
	public static List<Funcionario> findByEmail(
		String email, int start, int end,
		OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public static Funcionario findByEmail_First(
			String email, OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the first funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public static Funcionario fetchByEmail_First(
		String email, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().fetchByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the last funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public static Funcionario findByEmail_Last(
			String email, OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByEmail_Last(email, orderByComparator);
	}

	/**
	 * Returns the last funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public static Funcionario fetchByEmail_Last(
		String email, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().fetchByEmail_Last(email, orderByComparator);
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where email = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public static Funcionario[] findByEmail_PrevAndNext(
			long funcionarioId, String email,
			OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByEmail_PrevAndNext(
			funcionarioId, email, orderByComparator);
	}

	/**
	 * Removes all the funcionarios where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public static void removeByEmail(String email) {
		getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of funcionarios where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching funcionarios
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Returns all the funcionarios where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the matching funcionarios
	 */
	public static List<Funcionario> findByAreaAtuacao(int areaAtuacao) {
		return getPersistence().findByAreaAtuacao(areaAtuacao);
	}

	/**
	 * Returns a range of all the funcionarios where areaAtuacao = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param areaAtuacao the area atuacao
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 */
	public static List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end) {

		return getPersistence().findByAreaAtuacao(areaAtuacao, start, end);
	}

	/**
	 * Returns an ordered range of all the funcionarios where areaAtuacao = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param areaAtuacao the area atuacao
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 */
	public static List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().findByAreaAtuacao(
			areaAtuacao, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the funcionarios where areaAtuacao = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param areaAtuacao the area atuacao
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching funcionarios
	 */
	public static List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAreaAtuacao(
			areaAtuacao, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public static Funcionario findByAreaAtuacao_First(
			int areaAtuacao, OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByAreaAtuacao_First(
			areaAtuacao, orderByComparator);
	}

	/**
	 * Returns the first funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public static Funcionario fetchByAreaAtuacao_First(
		int areaAtuacao, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().fetchByAreaAtuacao_First(
			areaAtuacao, orderByComparator);
	}

	/**
	 * Returns the last funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public static Funcionario findByAreaAtuacao_Last(
			int areaAtuacao, OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByAreaAtuacao_Last(
			areaAtuacao, orderByComparator);
	}

	/**
	 * Returns the last funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public static Funcionario fetchByAreaAtuacao_Last(
		int areaAtuacao, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().fetchByAreaAtuacao_Last(
			areaAtuacao, orderByComparator);
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public static Funcionario[] findByAreaAtuacao_PrevAndNext(
			long funcionarioId, int areaAtuacao,
			OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByAreaAtuacao_PrevAndNext(
			funcionarioId, areaAtuacao, orderByComparator);
	}

	/**
	 * Removes all the funcionarios where areaAtuacao = &#63; from the database.
	 *
	 * @param areaAtuacao the area atuacao
	 */
	public static void removeByAreaAtuacao(int areaAtuacao) {
		getPersistence().removeByAreaAtuacao(areaAtuacao);
	}

	/**
	 * Returns the number of funcionarios where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the number of matching funcionarios
	 */
	public static int countByAreaAtuacao(int areaAtuacao) {
		return getPersistence().countByAreaAtuacao(areaAtuacao);
	}

	/**
	 * Returns all the funcionarios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching funcionarios
	 */
	public static List<Funcionario> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the funcionarios where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 */
	public static List<Funcionario> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the funcionarios where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 */
	public static List<Funcionario> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the funcionarios where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching funcionarios
	 */
	public static List<Funcionario> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public static Funcionario findByGroupId_First(
			long groupId, OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public static Funcionario fetchByGroupId_First(
		long groupId, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public static Funcionario findByGroupId_Last(
			long groupId, OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public static Funcionario fetchByGroupId_Last(
		long groupId, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public static Funcionario[] findByGroupId_PrevAndNext(
			long funcionarioId, long groupId,
			OrderByComparator<Funcionario> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByGroupId_PrevAndNext(
			funcionarioId, groupId, orderByComparator);
	}

	/**
	 * Removes all the funcionarios where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of funcionarios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching funcionarios
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the funcionario in the entity cache if it is enabled.
	 *
	 * @param funcionario the funcionario
	 */
	public static void cacheResult(Funcionario funcionario) {
		getPersistence().cacheResult(funcionario);
	}

	/**
	 * Caches the funcionarios in the entity cache if it is enabled.
	 *
	 * @param funcionarios the funcionarios
	 */
	public static void cacheResult(List<Funcionario> funcionarios) {
		getPersistence().cacheResult(funcionarios);
	}

	/**
	 * Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	 *
	 * @param funcionarioId the primary key for the new funcionario
	 * @return the new funcionario
	 */
	public static Funcionario create(long funcionarioId) {
		return getPersistence().create(funcionarioId);
	}

	/**
	 * Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario that was removed
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public static Funcionario remove(long funcionarioId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().remove(funcionarioId);
	}

	public static Funcionario updateImpl(Funcionario funcionario) {
		return getPersistence().updateImpl(funcionario);
	}

	/**
	 * Returns the funcionario with the primary key or throws a <code>NoSuchFuncionarioException</code> if it could not be found.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public static Funcionario findByPrimaryKey(long funcionarioId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchFuncionarioException {

		return getPersistence().findByPrimaryKey(funcionarioId);
	}

	/**
	 * Returns the funcionario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario, or <code>null</code> if a funcionario with the primary key could not be found
	 */
	public static Funcionario fetchByPrimaryKey(long funcionarioId) {
		return getPersistence().fetchByPrimaryKey(funcionarioId);
	}

	/**
	 * Returns all the funcionarios.
	 *
	 * @return the funcionarios
	 */
	public static List<Funcionario> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the funcionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of funcionarios
	 */
	public static List<Funcionario> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the funcionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of funcionarios
	 */
	public static List<Funcionario> findAll(
		int start, int end, OrderByComparator<Funcionario> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the funcionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of funcionarios
	 */
	public static List<Funcionario> findAll(
		int start, int end, OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the funcionarios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of funcionarios.
	 *
	 * @return the number of funcionarios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FuncionarioPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FuncionarioPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FuncionarioPersistence _persistence;

}