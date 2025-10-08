/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the avaliacao detalhe service. This utility wraps <code>br.com.example.model.avaliacao.service.persistence.impl.AvaliacaoDetalhePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoDetalhePersistence
 * @generated
 */
public class AvaliacaoDetalheUtil {

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
	public static void clearCache(AvaliacaoDetalhe avaliacaoDetalhe) {
		getPersistence().clearCache(avaliacaoDetalhe);
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
	public static Map<Serializable, AvaliacaoDetalhe> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AvaliacaoDetalhe> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AvaliacaoDetalhe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AvaliacaoDetalhe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AvaliacaoDetalhe update(AvaliacaoDetalhe avaliacaoDetalhe) {
		return getPersistence().update(avaliacaoDetalhe);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AvaliacaoDetalhe update(
		AvaliacaoDetalhe avaliacaoDetalhe, ServiceContext serviceContext) {

		return getPersistence().update(avaliacaoDetalhe, serviceContext);
	}

	/**
	 * Returns all the avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @return the matching avaliacao detalhes
	 */
	public static List<AvaliacaoDetalhe> findByAvaliacaoId(long avaliacaoId) {
		return getPersistence().findByAvaliacaoId(avaliacaoId);
	}

	/**
	 * Returns a range of all the avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoDetalheModelImpl</code>.
	 * </p>
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param start the lower bound of the range of avaliacao detalhes
	 * @param end the upper bound of the range of avaliacao detalhes (not inclusive)
	 * @return the range of matching avaliacao detalhes
	 */
	public static List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end) {

		return getPersistence().findByAvaliacaoId(avaliacaoId, start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoDetalheModelImpl</code>.
	 * </p>
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param start the lower bound of the range of avaliacao detalhes
	 * @param end the upper bound of the range of avaliacao detalhes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching avaliacao detalhes
	 */
	public static List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		return getPersistence().findByAvaliacaoId(
			avaliacaoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoDetalheModelImpl</code>.
	 * </p>
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param start the lower bound of the range of avaliacao detalhes
	 * @param end the upper bound of the range of avaliacao detalhes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching avaliacao detalhes
	 */
	public static List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAvaliacaoId(
			avaliacaoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	public static AvaliacaoDetalhe findByAvaliacaoId_First(
			long avaliacaoId,
			OrderByComparator<AvaliacaoDetalhe> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoDetalheException {

		return getPersistence().findByAvaliacaoId_First(
			avaliacaoId, orderByComparator);
	}

	/**
	 * Returns the first avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	public static AvaliacaoDetalhe fetchByAvaliacaoId_First(
		long avaliacaoId,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		return getPersistence().fetchByAvaliacaoId_First(
			avaliacaoId, orderByComparator);
	}

	/**
	 * Returns the last avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	public static AvaliacaoDetalhe findByAvaliacaoId_Last(
			long avaliacaoId,
			OrderByComparator<AvaliacaoDetalhe> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoDetalheException {

		return getPersistence().findByAvaliacaoId_Last(
			avaliacaoId, orderByComparator);
	}

	/**
	 * Returns the last avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	public static AvaliacaoDetalhe fetchByAvaliacaoId_Last(
		long avaliacaoId,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		return getPersistence().fetchByAvaliacaoId_Last(
			avaliacaoId, orderByComparator);
	}

	/**
	 * Returns the avaliacao detalhes before and after the current avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoDetalheId the primary key of the current avaliacao detalhe
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	public static AvaliacaoDetalhe[] findByAvaliacaoId_PrevAndNext(
			long avaliacaoDetalheId, long avaliacaoId,
			OrderByComparator<AvaliacaoDetalhe> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoDetalheException {

		return getPersistence().findByAvaliacaoId_PrevAndNext(
			avaliacaoDetalheId, avaliacaoId, orderByComparator);
	}

	/**
	 * Removes all the avaliacao detalhes where avaliacaoId = &#63; from the database.
	 *
	 * @param avaliacaoId the avaliacao ID
	 */
	public static void removeByAvaliacaoId(long avaliacaoId) {
		getPersistence().removeByAvaliacaoId(avaliacaoId);
	}

	/**
	 * Returns the number of avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @return the number of matching avaliacao detalhes
	 */
	public static int countByAvaliacaoId(long avaliacaoId) {
		return getPersistence().countByAvaliacaoId(avaliacaoId);
	}

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or throws a <code>NoSuchAvaliacaoDetalheException</code> if it could not be found.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	public static AvaliacaoDetalhe findByAvaliacaoIdTipoAvaliador(
			long avaliacaoId, int tipoAvaliador)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoDetalheException {

		return getPersistence().findByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador);
	}

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	public static AvaliacaoDetalhe fetchByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, int tipoAvaliador) {

		return getPersistence().fetchByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador);
	}

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	public static AvaliacaoDetalhe fetchByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, int tipoAvaliador, boolean useFinderCache) {

		return getPersistence().fetchByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador, useFinderCache);
	}

	/**
	 * Removes the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; from the database.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the avaliacao detalhe that was removed
	 */
	public static AvaliacaoDetalhe removeByAvaliacaoIdTipoAvaliador(
			long avaliacaoId, int tipoAvaliador)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoDetalheException {

		return getPersistence().removeByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador);
	}

	/**
	 * Returns the number of avaliacao detalhes where avaliacaoId = &#63; and tipoAvaliador = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the number of matching avaliacao detalhes
	 */
	public static int countByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, int tipoAvaliador) {

		return getPersistence().countByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador);
	}

	/**
	 * Caches the avaliacao detalhe in the entity cache if it is enabled.
	 *
	 * @param avaliacaoDetalhe the avaliacao detalhe
	 */
	public static void cacheResult(AvaliacaoDetalhe avaliacaoDetalhe) {
		getPersistence().cacheResult(avaliacaoDetalhe);
	}

	/**
	 * Caches the avaliacao detalhes in the entity cache if it is enabled.
	 *
	 * @param avaliacaoDetalhes the avaliacao detalhes
	 */
	public static void cacheResult(List<AvaliacaoDetalhe> avaliacaoDetalhes) {
		getPersistence().cacheResult(avaliacaoDetalhes);
	}

	/**
	 * Creates a new avaliacao detalhe with the primary key. Does not add the avaliacao detalhe to the database.
	 *
	 * @param avaliacaoDetalheId the primary key for the new avaliacao detalhe
	 * @return the new avaliacao detalhe
	 */
	public static AvaliacaoDetalhe create(long avaliacaoDetalheId) {
		return getPersistence().create(avaliacaoDetalheId);
	}

	/**
	 * Removes the avaliacao detalhe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe that was removed
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	public static AvaliacaoDetalhe remove(long avaliacaoDetalheId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoDetalheException {

		return getPersistence().remove(avaliacaoDetalheId);
	}

	public static AvaliacaoDetalhe updateImpl(
		AvaliacaoDetalhe avaliacaoDetalhe) {

		return getPersistence().updateImpl(avaliacaoDetalhe);
	}

	/**
	 * Returns the avaliacao detalhe with the primary key or throws a <code>NoSuchAvaliacaoDetalheException</code> if it could not be found.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	public static AvaliacaoDetalhe findByPrimaryKey(long avaliacaoDetalheId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoDetalheException {

		return getPersistence().findByPrimaryKey(avaliacaoDetalheId);
	}

	/**
	 * Returns the avaliacao detalhe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe, or <code>null</code> if a avaliacao detalhe with the primary key could not be found
	 */
	public static AvaliacaoDetalhe fetchByPrimaryKey(long avaliacaoDetalheId) {
		return getPersistence().fetchByPrimaryKey(avaliacaoDetalheId);
	}

	/**
	 * Returns all the avaliacao detalhes.
	 *
	 * @return the avaliacao detalhes
	 */
	public static List<AvaliacaoDetalhe> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the avaliacao detalhes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoDetalheModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacao detalhes
	 * @param end the upper bound of the range of avaliacao detalhes (not inclusive)
	 * @return the range of avaliacao detalhes
	 */
	public static List<AvaliacaoDetalhe> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacao detalhes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoDetalheModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacao detalhes
	 * @param end the upper bound of the range of avaliacao detalhes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of avaliacao detalhes
	 */
	public static List<AvaliacaoDetalhe> findAll(
		int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacao detalhes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoDetalheModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacao detalhes
	 * @param end the upper bound of the range of avaliacao detalhes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of avaliacao detalhes
	 */
	public static List<AvaliacaoDetalhe> findAll(
		int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the avaliacao detalhes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of avaliacao detalhes.
	 *
	 * @return the number of avaliacao detalhes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AvaliacaoDetalhePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AvaliacaoDetalhePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AvaliacaoDetalhePersistence _persistence;

}