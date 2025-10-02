/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.model.DescricaoDesafio;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the descricao desafio service. This utility wraps <code>br.com.example.model.avaliacao.service.persistence.impl.DescricaoDesafioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescricaoDesafioPersistence
 * @generated
 */
public class DescricaoDesafioUtil {

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
	public static void clearCache(DescricaoDesafio descricaoDesafio) {
		getPersistence().clearCache(descricaoDesafio);
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
	public static Map<Serializable, DescricaoDesafio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DescricaoDesafio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DescricaoDesafio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DescricaoDesafio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DescricaoDesafio update(DescricaoDesafio descricaoDesafio) {
		return getPersistence().update(descricaoDesafio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DescricaoDesafio update(
		DescricaoDesafio descricaoDesafio, ServiceContext serviceContext) {

		return getPersistence().update(descricaoDesafio, serviceContext);
	}

	/**
	 * Returns all the descricao desafios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId) {

		return getPersistence().findByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns a range of all the descricao desafios where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @return the range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end) {

		return getPersistence().findByFuncionarioId(funcionarioId, start, end);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().findByFuncionarioId(
			funcionarioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFuncionarioId(
			funcionarioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByFuncionarioId_First(
			long funcionarioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByFuncionarioId_First(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByFuncionarioId_First(
		long funcionarioId,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByFuncionarioId_First(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByFuncionarioId_Last(
			long funcionarioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByFuncionarioId_Last(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByFuncionarioId_Last(
		long funcionarioId,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByFuncionarioId_Last(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the descricao desafios before and after the current descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param descricaoDesafioId the primary key of the current descricao desafio
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio[] findByFuncionarioId_PrevAndNext(
			long descricaoDesafioId, long funcionarioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByFuncionarioId_PrevAndNext(
			descricaoDesafioId, funcionarioId, orderByComparator);
	}

	/**
	 * Removes all the descricao desafios where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	public static void removeByFuncionarioId(long funcionarioId) {
		getPersistence().removeByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns the number of descricao desafios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching descricao desafios
	 */
	public static int countByFuncionarioId(long funcionarioId) {
		return getPersistence().countByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns all the descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId) {

		return getPersistence().findByDescricaoDesafioId(descricaoDesafioId);
	}

	/**
	 * Returns a range of all the descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @return the range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end) {

		return getPersistence().findByDescricaoDesafioId(
			descricaoDesafioId, start, end);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().findByDescricaoDesafioId(
			descricaoDesafioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDescricaoDesafioId(
			descricaoDesafioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByDescricaoDesafioId_First(
			long descricaoDesafioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByDescricaoDesafioId_First(
			descricaoDesafioId, orderByComparator);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByDescricaoDesafioId_First(
		long descricaoDesafioId,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByDescricaoDesafioId_First(
			descricaoDesafioId, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByDescricaoDesafioId_Last(
			long descricaoDesafioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByDescricaoDesafioId_Last(
			descricaoDesafioId, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByDescricaoDesafioId_Last(
		long descricaoDesafioId,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByDescricaoDesafioId_Last(
			descricaoDesafioId, orderByComparator);
	}

	/**
	 * Removes all the descricao desafios where descricaoDesafioId = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 */
	public static void removeByDescricaoDesafioId(long descricaoDesafioId) {
		getPersistence().removeByDescricaoDesafioId(descricaoDesafioId);
	}

	/**
	 * Returns the number of descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the number of matching descricao desafios
	 */
	public static int countByDescricaoDesafioId(long descricaoDesafioId) {
		return getPersistence().countByDescricaoDesafioId(descricaoDesafioId);
	}

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or throws a <code>NoSuchDescricaoDesafioException</code> if it could not be found.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByFuncionarioId_TipoDesafio(
			long funcionarioId, int tipoDesafio)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio);
	}

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio) {

		return getPersistence().fetchByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio);
	}

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio, boolean useFinderCache) {

		return getPersistence().fetchByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio, useFinderCache);
	}

	/**
	 * Removes the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the descricao desafio that was removed
	 */
	public static DescricaoDesafio removeByFuncionarioId_TipoDesafio(
			long funcionarioId, int tipoDesafio)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().removeByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio);
	}

	/**
	 * Returns the number of descricao desafios where funcionarioId = &#63; and tipoDesafio = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the number of matching descricao desafios
	 */
	public static int countByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio) {

		return getPersistence().countByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio);
	}

	/**
	 * Returns all the descricao desafios where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByTipoDesafio(int tipoDesafio) {
		return getPersistence().findByTipoDesafio(tipoDesafio);
	}

	/**
	 * Returns a range of all the descricao desafios where tipoDesafio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @return the range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end) {

		return getPersistence().findByTipoDesafio(tipoDesafio, start, end);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where tipoDesafio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().findByTipoDesafio(
			tipoDesafio, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where tipoDesafio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTipoDesafio(
			tipoDesafio, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByTipoDesafio_First(
			int tipoDesafio,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByTipoDesafio_First(
			tipoDesafio, orderByComparator);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByTipoDesafio_First(
		int tipoDesafio,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByTipoDesafio_First(
			tipoDesafio, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByTipoDesafio_Last(
			int tipoDesafio,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByTipoDesafio_Last(
			tipoDesafio, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByTipoDesafio_Last(
		int tipoDesafio,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByTipoDesafio_Last(
			tipoDesafio, orderByComparator);
	}

	/**
	 * Returns the descricao desafios before and after the current descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param descricaoDesafioId the primary key of the current descricao desafio
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio[] findByTipoDesafio_PrevAndNext(
			long descricaoDesafioId, int tipoDesafio,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByTipoDesafio_PrevAndNext(
			descricaoDesafioId, tipoDesafio, orderByComparator);
	}

	/**
	 * Removes all the descricao desafios where tipoDesafio = &#63; from the database.
	 *
	 * @param tipoDesafio the tipo desafio
	 */
	public static void removeByTipoDesafio(int tipoDesafio) {
		getPersistence().removeByTipoDesafio(tipoDesafio);
	}

	/**
	 * Returns the number of descricao desafios where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @return the number of matching descricao desafios
	 */
	public static int countByTipoDesafio(int tipoDesafio) {
		return getPersistence().countByTipoDesafio(tipoDesafio);
	}

	/**
	 * Returns all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @return the matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao) {

		return getPersistence().findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao);
	}

	/**
	 * Returns a range of all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @return the range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end) {

		return getPersistence().findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, start, end);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByDataAvaliacaoBetween_First(
			Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByDataAvaliacaoBetween_First(
			dataAvaliacao, dataAvaliacao, orderByComparator);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByDataAvaliacaoBetween_First(
		Date dataAvaliacao, Date dataAvaliacao,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByDataAvaliacaoBetween_First(
			dataAvaliacao, dataAvaliacao, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByDataAvaliacaoBetween_Last(
			Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByDataAvaliacaoBetween_Last(
			dataAvaliacao, dataAvaliacao, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByDataAvaliacaoBetween_Last(
		Date dataAvaliacao, Date dataAvaliacao,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByDataAvaliacaoBetween_Last(
			dataAvaliacao, dataAvaliacao, orderByComparator);
	}

	/**
	 * Returns the descricao desafios before and after the current descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param descricaoDesafioId the primary key of the current descricao desafio
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio[] findByDataAvaliacaoBetween_PrevAndNext(
			long descricaoDesafioId, Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByDataAvaliacaoBetween_PrevAndNext(
			descricaoDesafioId, dataAvaliacao, dataAvaliacao,
			orderByComparator);
	}

	/**
	 * Removes all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63; from the database.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 */
	public static void removeByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao) {

		getPersistence().removeByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao);
	}

	/**
	 * Returns the number of descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @return the number of matching descricao desafios
	 */
	public static int countByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao) {

		return getPersistence().countByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao);
	}

	/**
	 * Returns all the descricao desafios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the descricao desafios where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @return the range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the descricao desafios where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching descricao desafios
	 */
	public static List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByGroupId_First(
			long groupId, OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByGroupId_First(
		long groupId, OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio findByGroupId_Last(
			long groupId, OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public static DescricaoDesafio fetchByGroupId_Last(
		long groupId, OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the descricao desafios before and after the current descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param descricaoDesafioId the primary key of the current descricao desafio
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio[] findByGroupId_PrevAndNext(
			long descricaoDesafioId, long groupId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByGroupId_PrevAndNext(
			descricaoDesafioId, groupId, orderByComparator);
	}

	/**
	 * Removes all the descricao desafios where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of descricao desafios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching descricao desafios
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the descricao desafio in the entity cache if it is enabled.
	 *
	 * @param descricaoDesafio the descricao desafio
	 */
	public static void cacheResult(DescricaoDesafio descricaoDesafio) {
		getPersistence().cacheResult(descricaoDesafio);
	}

	/**
	 * Caches the descricao desafios in the entity cache if it is enabled.
	 *
	 * @param descricaoDesafios the descricao desafios
	 */
	public static void cacheResult(List<DescricaoDesafio> descricaoDesafios) {
		getPersistence().cacheResult(descricaoDesafios);
	}

	/**
	 * Creates a new descricao desafio with the primary key. Does not add the descricao desafio to the database.
	 *
	 * @param descricaoDesafioId the primary key for the new descricao desafio
	 * @return the new descricao desafio
	 */
	public static DescricaoDesafio create(long descricaoDesafioId) {
		return getPersistence().create(descricaoDesafioId);
	}

	/**
	 * Removes the descricao desafio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio that was removed
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio remove(long descricaoDesafioId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().remove(descricaoDesafioId);
	}

	public static DescricaoDesafio updateImpl(
		DescricaoDesafio descricaoDesafio) {

		return getPersistence().updateImpl(descricaoDesafio);
	}

	/**
	 * Returns the descricao desafio with the primary key or throws a <code>NoSuchDescricaoDesafioException</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio findByPrimaryKey(long descricaoDesafioId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchDescricaoDesafioException {

		return getPersistence().findByPrimaryKey(descricaoDesafioId);
	}

	/**
	 * Returns the descricao desafio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio, or <code>null</code> if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio fetchByPrimaryKey(long descricaoDesafioId) {
		return getPersistence().fetchByPrimaryKey(descricaoDesafioId);
	}

	/**
	 * Returns all the descricao desafios.
	 *
	 * @return the descricao desafios
	 */
	public static List<DescricaoDesafio> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the descricao desafios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @return the range of descricao desafios
	 */
	public static List<DescricaoDesafio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the descricao desafios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of descricao desafios
	 */
	public static List<DescricaoDesafio> findAll(
		int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the descricao desafios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of descricao desafios
	 */
	public static List<DescricaoDesafio> findAll(
		int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the descricao desafios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of descricao desafios.
	 *
	 * @return the number of descricao desafios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DescricaoDesafioPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(DescricaoDesafioPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile DescricaoDesafioPersistence _persistence;

}