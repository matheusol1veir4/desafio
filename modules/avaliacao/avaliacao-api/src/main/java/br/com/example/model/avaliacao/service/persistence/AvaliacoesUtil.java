/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.model.Avaliacoes;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the avaliacoes service. This utility wraps <code>br.com.example.model.avaliacao.service.persistence.impl.AvaliacoesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacoesPersistence
 * @generated
 */
public class AvaliacoesUtil {

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
	public static void clearCache(Avaliacoes avaliacoes) {
		getPersistence().clearCache(avaliacoes);
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
	public static Map<Serializable, Avaliacoes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Avaliacoes> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Avaliacoes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Avaliacoes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Avaliacoes update(Avaliacoes avaliacoes) {
		return getPersistence().update(avaliacoes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Avaliacoes update(
		Avaliacoes avaliacoes, ServiceContext serviceContext) {

		return getPersistence().update(avaliacoes, serviceContext);
	}

	/**
	 * Returns all the avaliacoeses where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @return the matching avaliacoeses
	 */
	public static List<Avaliacoes> findByAvaliacoesId(long avaliacoesId) {
		return getPersistence().findByAvaliacoesId(avaliacoesId);
	}

	/**
	 * Returns a range of all the avaliacoeses where avaliacoesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @return the range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end) {

		return getPersistence().findByAvaliacoesId(avaliacoesId, start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacoeses where avaliacoesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().findByAvaliacoesId(
			avaliacoesId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacoeses where avaliacoesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAvaliacoesId(
			avaliacoesId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public static Avaliacoes findByAvaliacoesId_First(
			long avaliacoesId, OrderByComparator<Avaliacoes> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByAvaliacoesId_First(
			avaliacoesId, orderByComparator);
	}

	/**
	 * Returns the first avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public static Avaliacoes fetchByAvaliacoesId_First(
		long avaliacoesId, OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().fetchByAvaliacoesId_First(
			avaliacoesId, orderByComparator);
	}

	/**
	 * Returns the last avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public static Avaliacoes findByAvaliacoesId_Last(
			long avaliacoesId, OrderByComparator<Avaliacoes> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByAvaliacoesId_Last(
			avaliacoesId, orderByComparator);
	}

	/**
	 * Returns the last avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public static Avaliacoes fetchByAvaliacoesId_Last(
		long avaliacoesId, OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().fetchByAvaliacoesId_Last(
			avaliacoesId, orderByComparator);
	}

	/**
	 * Removes all the avaliacoeses where avaliacoesId = &#63; from the database.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 */
	public static void removeByAvaliacoesId(long avaliacoesId) {
		getPersistence().removeByAvaliacoesId(avaliacoesId);
	}

	/**
	 * Returns the number of avaliacoeses where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @return the number of matching avaliacoeses
	 */
	public static int countByAvaliacoesId(long avaliacoesId) {
		return getPersistence().countByAvaliacoesId(avaliacoesId);
	}

	/**
	 * Returns all the avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the matching avaliacoeses
	 */
	public static List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId) {

		return getPersistence().findByDescricaoDesafioId(descricaoDesafioId);
	}

	/**
	 * Returns a range of all the avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @return the range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end) {

		return getPersistence().findByDescricaoDesafioId(
			descricaoDesafioId, start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().findByDescricaoDesafioId(
			descricaoDesafioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDescricaoDesafioId(
			descricaoDesafioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public static Avaliacoes findByDescricaoDesafioId_First(
			long descricaoDesafioId,
			OrderByComparator<Avaliacoes> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByDescricaoDesafioId_First(
			descricaoDesafioId, orderByComparator);
	}

	/**
	 * Returns the first avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public static Avaliacoes fetchByDescricaoDesafioId_First(
		long descricaoDesafioId,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().fetchByDescricaoDesafioId_First(
			descricaoDesafioId, orderByComparator);
	}

	/**
	 * Returns the last avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public static Avaliacoes findByDescricaoDesafioId_Last(
			long descricaoDesafioId,
			OrderByComparator<Avaliacoes> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByDescricaoDesafioId_Last(
			descricaoDesafioId, orderByComparator);
	}

	/**
	 * Returns the last avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public static Avaliacoes fetchByDescricaoDesafioId_Last(
		long descricaoDesafioId,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().fetchByDescricaoDesafioId_Last(
			descricaoDesafioId, orderByComparator);
	}

	/**
	 * Returns the avaliacoeses before and after the current avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param avaliacoesId the primary key of the current avaliacoes
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	public static Avaliacoes[] findByDescricaoDesafioId_PrevAndNext(
			long avaliacoesId, long descricaoDesafioId,
			OrderByComparator<Avaliacoes> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByDescricaoDesafioId_PrevAndNext(
			avaliacoesId, descricaoDesafioId, orderByComparator);
	}

	/**
	 * Removes all the avaliacoeses where descricaoDesafioId = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 */
	public static void removeByDescricaoDesafioId(long descricaoDesafioId) {
		getPersistence().removeByDescricaoDesafioId(descricaoDesafioId);
	}

	/**
	 * Returns the number of avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the number of matching avaliacoeses
	 */
	public static int countByDescricaoDesafioId(long descricaoDesafioId) {
		return getPersistence().countByDescricaoDesafioId(descricaoDesafioId);
	}

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or throws a <code>NoSuchAvaliacoesException</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public static Avaliacoes findByDescricaoDesafioId_TipoAvaliador(
			long descricaoDesafioId, String tipoAvaliador)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador);
	}

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public static Avaliacoes fetchByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador) {

		return getPersistence().fetchByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador);
	}

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public static Avaliacoes fetchByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador, boolean useFinderCache) {

		return getPersistence().fetchByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador, useFinderCache);
	}

	/**
	 * Removes the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the avaliacoes that was removed
	 */
	public static Avaliacoes removeByDescricaoDesafioId_TipoAvaliador(
			long descricaoDesafioId, String tipoAvaliador)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().removeByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador);
	}

	/**
	 * Returns the number of avaliacoeses where descricaoDesafioId = &#63; and tipoAvaliador = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the number of matching avaliacoeses
	 */
	public static int countByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador) {

		return getPersistence().countByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador);
	}

	/**
	 * Returns all the avaliacoeses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching avaliacoeses
	 */
	public static List<Avaliacoes> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the avaliacoeses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @return the range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacoeses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacoeses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching avaliacoeses
	 */
	public static List<Avaliacoes> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public static Avaliacoes findByGroupId_First(
			long groupId, OrderByComparator<Avaliacoes> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public static Avaliacoes fetchByGroupId_First(
		long groupId, OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public static Avaliacoes findByGroupId_Last(
			long groupId, OrderByComparator<Avaliacoes> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public static Avaliacoes fetchByGroupId_Last(
		long groupId, OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the avaliacoeses before and after the current avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param avaliacoesId the primary key of the current avaliacoes
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	public static Avaliacoes[] findByGroupId_PrevAndNext(
			long avaliacoesId, long groupId,
			OrderByComparator<Avaliacoes> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByGroupId_PrevAndNext(
			avaliacoesId, groupId, orderByComparator);
	}

	/**
	 * Removes all the avaliacoeses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of avaliacoeses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching avaliacoeses
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the avaliacoes in the entity cache if it is enabled.
	 *
	 * @param avaliacoes the avaliacoes
	 */
	public static void cacheResult(Avaliacoes avaliacoes) {
		getPersistence().cacheResult(avaliacoes);
	}

	/**
	 * Caches the avaliacoeses in the entity cache if it is enabled.
	 *
	 * @param avaliacoeses the avaliacoeses
	 */
	public static void cacheResult(List<Avaliacoes> avaliacoeses) {
		getPersistence().cacheResult(avaliacoeses);
	}

	/**
	 * Creates a new avaliacoes with the primary key. Does not add the avaliacoes to the database.
	 *
	 * @param avaliacoesId the primary key for the new avaliacoes
	 * @return the new avaliacoes
	 */
	public static Avaliacoes create(long avaliacoesId) {
		return getPersistence().create(avaliacoesId);
	}

	/**
	 * Removes the avaliacoes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes that was removed
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	public static Avaliacoes remove(long avaliacoesId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().remove(avaliacoesId);
	}

	public static Avaliacoes updateImpl(Avaliacoes avaliacoes) {
		return getPersistence().updateImpl(avaliacoes);
	}

	/**
	 * Returns the avaliacoes with the primary key or throws a <code>NoSuchAvaliacoesException</code> if it could not be found.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	public static Avaliacoes findByPrimaryKey(long avaliacoesId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacoesException {

		return getPersistence().findByPrimaryKey(avaliacoesId);
	}

	/**
	 * Returns the avaliacoes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes, or <code>null</code> if a avaliacoes with the primary key could not be found
	 */
	public static Avaliacoes fetchByPrimaryKey(long avaliacoesId) {
		return getPersistence().fetchByPrimaryKey(avaliacoesId);
	}

	/**
	 * Returns all the avaliacoeses.
	 *
	 * @return the avaliacoeses
	 */
	public static List<Avaliacoes> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the avaliacoeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @return the range of avaliacoeses
	 */
	public static List<Avaliacoes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacoeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of avaliacoeses
	 */
	public static List<Avaliacoes> findAll(
		int start, int end, OrderByComparator<Avaliacoes> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacoeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of avaliacoeses
	 */
	public static List<Avaliacoes> findAll(
		int start, int end, OrderByComparator<Avaliacoes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the avaliacoeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of avaliacoeses.
	 *
	 * @return the number of avaliacoeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AvaliacoesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AvaliacoesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AvaliacoesPersistence _persistence;

}