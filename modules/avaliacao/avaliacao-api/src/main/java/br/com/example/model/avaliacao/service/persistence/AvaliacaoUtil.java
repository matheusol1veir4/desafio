/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.model.Avaliacao;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the avaliacao service. This utility wraps <code>br.com.example.model.avaliacao.service.persistence.impl.AvaliacaoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoPersistence
 * @generated
 */
public class AvaliacaoUtil {

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
	public static void clearCache(Avaliacao avaliacao) {
		getPersistence().clearCache(avaliacao);
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
	public static Map<Serializable, Avaliacao> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Avaliacao> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Avaliacao> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Avaliacao> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Avaliacao update(Avaliacao avaliacao) {
		return getPersistence().update(avaliacao);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Avaliacao update(
		Avaliacao avaliacao, ServiceContext serviceContext) {

		return getPersistence().update(avaliacao, serviceContext);
	}

	/**
	 * Returns all the avaliacaos where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching avaliacaos
	 */
	public static List<Avaliacao> findByFuncionarioId(long funcionarioId) {
		return getPersistence().findByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns a range of all the avaliacaos where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @return the range of matching avaliacaos
	 */
	public static List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end) {

		return getPersistence().findByFuncionarioId(funcionarioId, start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacaos where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching avaliacaos
	 */
	public static List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().findByFuncionarioId(
			funcionarioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacaos where funcionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param funcionarioId the funcionario ID
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching avaliacaos
	 */
	public static List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFuncionarioId(
			funcionarioId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public static Avaliacao findByFuncionarioId_First(
			long funcionarioId, OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByFuncionarioId_First(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the first avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public static Avaliacao fetchByFuncionarioId_First(
		long funcionarioId, OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().fetchByFuncionarioId_First(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the last avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public static Avaliacao findByFuncionarioId_Last(
			long funcionarioId, OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByFuncionarioId_Last(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the last avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public static Avaliacao fetchByFuncionarioId_Last(
		long funcionarioId, OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().fetchByFuncionarioId_Last(
			funcionarioId, orderByComparator);
	}

	/**
	 * Returns the avaliacaos before and after the current avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param avaliacaoId the primary key of the current avaliacao
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public static Avaliacao[] findByFuncionarioId_PrevAndNext(
			long avaliacaoId, long funcionarioId,
			OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByFuncionarioId_PrevAndNext(
			avaliacaoId, funcionarioId, orderByComparator);
	}

	/**
	 * Removes all the avaliacaos where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	public static void removeByFuncionarioId(long funcionarioId) {
		getPersistence().removeByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns the number of avaliacaos where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching avaliacaos
	 */
	public static int countByFuncionarioId(long funcionarioId) {
		return getPersistence().countByFuncionarioId(funcionarioId);
	}

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or throws a <code>NoSuchAvaliacaoException</code> if it could not be found.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public static Avaliacao findByFuncionarioIdPeriodoDesafio(
			long funcionarioId, int periodoDesafio)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio);
	}

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public static Avaliacao fetchByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio) {

		return getPersistence().fetchByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio);
	}

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public static Avaliacao fetchByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio, boolean useFinderCache) {

		return getPersistence().fetchByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio, useFinderCache);
	}

	/**
	 * Removes the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the avaliacao that was removed
	 */
	public static Avaliacao removeByFuncionarioIdPeriodoDesafio(
			long funcionarioId, int periodoDesafio)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().removeByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio);
	}

	/**
	 * Returns the number of avaliacaos where funcionarioId = &#63; and periodoDesafio = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the number of matching avaliacaos
	 */
	public static int countByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio) {

		return getPersistence().countByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio);
	}

	/**
	 * Returns all the avaliacaos where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacaos
	 */
	public static List<Avaliacao> findByPeriodoDesafio(int periodoDesafio) {
		return getPersistence().findByPeriodoDesafio(periodoDesafio);
	}

	/**
	 * Returns a range of all the avaliacaos where periodoDesafio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @return the range of matching avaliacaos
	 */
	public static List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end) {

		return getPersistence().findByPeriodoDesafio(
			periodoDesafio, start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacaos where periodoDesafio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching avaliacaos
	 */
	public static List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().findByPeriodoDesafio(
			periodoDesafio, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacaos where periodoDesafio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching avaliacaos
	 */
	public static List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPeriodoDesafio(
			periodoDesafio, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public static Avaliacao findByPeriodoDesafio_First(
			int periodoDesafio, OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByPeriodoDesafio_First(
			periodoDesafio, orderByComparator);
	}

	/**
	 * Returns the first avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public static Avaliacao fetchByPeriodoDesafio_First(
		int periodoDesafio, OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().fetchByPeriodoDesafio_First(
			periodoDesafio, orderByComparator);
	}

	/**
	 * Returns the last avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public static Avaliacao findByPeriodoDesafio_Last(
			int periodoDesafio, OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByPeriodoDesafio_Last(
			periodoDesafio, orderByComparator);
	}

	/**
	 * Returns the last avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public static Avaliacao fetchByPeriodoDesafio_Last(
		int periodoDesafio, OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().fetchByPeriodoDesafio_Last(
			periodoDesafio, orderByComparator);
	}

	/**
	 * Returns the avaliacaos before and after the current avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param avaliacaoId the primary key of the current avaliacao
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public static Avaliacao[] findByPeriodoDesafio_PrevAndNext(
			long avaliacaoId, int periodoDesafio,
			OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByPeriodoDesafio_PrevAndNext(
			avaliacaoId, periodoDesafio, orderByComparator);
	}

	/**
	 * Removes all the avaliacaos where periodoDesafio = &#63; from the database.
	 *
	 * @param periodoDesafio the periodo desafio
	 */
	public static void removeByPeriodoDesafio(int periodoDesafio) {
		getPersistence().removeByPeriodoDesafio(periodoDesafio);
	}

	/**
	 * Returns the number of avaliacaos where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @return the number of matching avaliacaos
	 */
	public static int countByPeriodoDesafio(int periodoDesafio) {
		return getPersistence().countByPeriodoDesafio(periodoDesafio);
	}

	/**
	 * Returns all the avaliacaos where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the matching avaliacaos
	 */
	public static List<Avaliacao> findByAreaAtuacao(int areaAtuacao) {
		return getPersistence().findByAreaAtuacao(areaAtuacao);
	}

	/**
	 * Returns a range of all the avaliacaos where areaAtuacao = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param areaAtuacao the area atuacao
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @return the range of matching avaliacaos
	 */
	public static List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end) {

		return getPersistence().findByAreaAtuacao(areaAtuacao, start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacaos where areaAtuacao = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param areaAtuacao the area atuacao
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching avaliacaos
	 */
	public static List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().findByAreaAtuacao(
			areaAtuacao, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacaos where areaAtuacao = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param areaAtuacao the area atuacao
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching avaliacaos
	 */
	public static List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAreaAtuacao(
			areaAtuacao, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public static Avaliacao findByAreaAtuacao_First(
			int areaAtuacao, OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByAreaAtuacao_First(
			areaAtuacao, orderByComparator);
	}

	/**
	 * Returns the first avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public static Avaliacao fetchByAreaAtuacao_First(
		int areaAtuacao, OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().fetchByAreaAtuacao_First(
			areaAtuacao, orderByComparator);
	}

	/**
	 * Returns the last avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public static Avaliacao findByAreaAtuacao_Last(
			int areaAtuacao, OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByAreaAtuacao_Last(
			areaAtuacao, orderByComparator);
	}

	/**
	 * Returns the last avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public static Avaliacao fetchByAreaAtuacao_Last(
		int areaAtuacao, OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().fetchByAreaAtuacao_Last(
			areaAtuacao, orderByComparator);
	}

	/**
	 * Returns the avaliacaos before and after the current avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param avaliacaoId the primary key of the current avaliacao
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public static Avaliacao[] findByAreaAtuacao_PrevAndNext(
			long avaliacaoId, int areaAtuacao,
			OrderByComparator<Avaliacao> orderByComparator)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByAreaAtuacao_PrevAndNext(
			avaliacaoId, areaAtuacao, orderByComparator);
	}

	/**
	 * Removes all the avaliacaos where areaAtuacao = &#63; from the database.
	 *
	 * @param areaAtuacao the area atuacao
	 */
	public static void removeByAreaAtuacao(int areaAtuacao) {
		getPersistence().removeByAreaAtuacao(areaAtuacao);
	}

	/**
	 * Returns the number of avaliacaos where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the number of matching avaliacaos
	 */
	public static int countByAreaAtuacao(int areaAtuacao) {
		return getPersistence().countByAreaAtuacao(areaAtuacao);
	}

	/**
	 * Caches the avaliacao in the entity cache if it is enabled.
	 *
	 * @param avaliacao the avaliacao
	 */
	public static void cacheResult(Avaliacao avaliacao) {
		getPersistence().cacheResult(avaliacao);
	}

	/**
	 * Caches the avaliacaos in the entity cache if it is enabled.
	 *
	 * @param avaliacaos the avaliacaos
	 */
	public static void cacheResult(List<Avaliacao> avaliacaos) {
		getPersistence().cacheResult(avaliacaos);
	}

	/**
	 * Creates a new avaliacao with the primary key. Does not add the avaliacao to the database.
	 *
	 * @param avaliacaoId the primary key for the new avaliacao
	 * @return the new avaliacao
	 */
	public static Avaliacao create(long avaliacaoId) {
		return getPersistence().create(avaliacaoId);
	}

	/**
	 * Removes the avaliacao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao that was removed
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public static Avaliacao remove(long avaliacaoId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().remove(avaliacaoId);
	}

	public static Avaliacao updateImpl(Avaliacao avaliacao) {
		return getPersistence().updateImpl(avaliacao);
	}

	/**
	 * Returns the avaliacao with the primary key or throws a <code>NoSuchAvaliacaoException</code> if it could not be found.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public static Avaliacao findByPrimaryKey(long avaliacaoId)
		throws br.com.example.model.avaliacao.exception.
			NoSuchAvaliacaoException {

		return getPersistence().findByPrimaryKey(avaliacaoId);
	}

	/**
	 * Returns the avaliacao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao, or <code>null</code> if a avaliacao with the primary key could not be found
	 */
	public static Avaliacao fetchByPrimaryKey(long avaliacaoId) {
		return getPersistence().fetchByPrimaryKey(avaliacaoId);
	}

	/**
	 * Returns all the avaliacaos.
	 *
	 * @return the avaliacaos
	 */
	public static List<Avaliacao> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the avaliacaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @return the range of avaliacaos
	 */
	public static List<Avaliacao> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the avaliacaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of avaliacaos
	 */
	public static List<Avaliacao> findAll(
		int start, int end, OrderByComparator<Avaliacao> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the avaliacaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of avaliacaos
	 */
	public static List<Avaliacao> findAll(
		int start, int end, OrderByComparator<Avaliacao> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the avaliacaos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of avaliacaos.
	 *
	 * @return the number of avaliacaos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AvaliacaoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AvaliacaoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AvaliacaoPersistence _persistence;

}