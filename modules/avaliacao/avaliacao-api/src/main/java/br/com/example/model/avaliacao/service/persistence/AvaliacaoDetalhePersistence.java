/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacaoDetalheException;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the avaliacao detalhe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoDetalheUtil
 * @generated
 */
@ProviderType
public interface AvaliacaoDetalhePersistence
	extends BasePersistence<AvaliacaoDetalhe> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AvaliacaoDetalheUtil} to access the avaliacao detalhe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @return the matching avaliacao detalhes
	 */
	public java.util.List<AvaliacaoDetalhe> findByAvaliacaoId(long avaliacaoId);

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
	public java.util.List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end);

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
	public java.util.List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
			orderByComparator);

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
	public java.util.List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	public AvaliacaoDetalhe findByAvaliacaoId_First(
			long avaliacaoId,
			com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
				orderByComparator)
		throws NoSuchAvaliacaoDetalheException;

	/**
	 * Returns the first avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	public AvaliacaoDetalhe fetchByAvaliacaoId_First(
		long avaliacaoId,
		com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
			orderByComparator);

	/**
	 * Returns the last avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	public AvaliacaoDetalhe findByAvaliacaoId_Last(
			long avaliacaoId,
			com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
				orderByComparator)
		throws NoSuchAvaliacaoDetalheException;

	/**
	 * Returns the last avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	public AvaliacaoDetalhe fetchByAvaliacaoId_Last(
		long avaliacaoId,
		com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
			orderByComparator);

	/**
	 * Returns the avaliacao detalhes before and after the current avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoDetalheId the primary key of the current avaliacao detalhe
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	public AvaliacaoDetalhe[] findByAvaliacaoId_PrevAndNext(
			long avaliacaoDetalheId, long avaliacaoId,
			com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
				orderByComparator)
		throws NoSuchAvaliacaoDetalheException;

	/**
	 * Removes all the avaliacao detalhes where avaliacaoId = &#63; from the database.
	 *
	 * @param avaliacaoId the avaliacao ID
	 */
	public void removeByAvaliacaoId(long avaliacaoId);

	/**
	 * Returns the number of avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @return the number of matching avaliacao detalhes
	 */
	public int countByAvaliacaoId(long avaliacaoId);

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or throws a <code>NoSuchAvaliacaoDetalheException</code> if it could not be found.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	public AvaliacaoDetalhe findByAvaliacaoIdTipoAvaliador(
			long avaliacaoId, int tipoAvaliador)
		throws NoSuchAvaliacaoDetalheException;

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	public AvaliacaoDetalhe fetchByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, int tipoAvaliador);

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	public AvaliacaoDetalhe fetchByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, int tipoAvaliador, boolean useFinderCache);

	/**
	 * Removes the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; from the database.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the avaliacao detalhe that was removed
	 */
	public AvaliacaoDetalhe removeByAvaliacaoIdTipoAvaliador(
			long avaliacaoId, int tipoAvaliador)
		throws NoSuchAvaliacaoDetalheException;

	/**
	 * Returns the number of avaliacao detalhes where avaliacaoId = &#63; and tipoAvaliador = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the number of matching avaliacao detalhes
	 */
	public int countByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, int tipoAvaliador);

	/**
	 * Caches the avaliacao detalhe in the entity cache if it is enabled.
	 *
	 * @param avaliacaoDetalhe the avaliacao detalhe
	 */
	public void cacheResult(AvaliacaoDetalhe avaliacaoDetalhe);

	/**
	 * Caches the avaliacao detalhes in the entity cache if it is enabled.
	 *
	 * @param avaliacaoDetalhes the avaliacao detalhes
	 */
	public void cacheResult(java.util.List<AvaliacaoDetalhe> avaliacaoDetalhes);

	/**
	 * Creates a new avaliacao detalhe with the primary key. Does not add the avaliacao detalhe to the database.
	 *
	 * @param avaliacaoDetalheId the primary key for the new avaliacao detalhe
	 * @return the new avaliacao detalhe
	 */
	public AvaliacaoDetalhe create(long avaliacaoDetalheId);

	/**
	 * Removes the avaliacao detalhe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe that was removed
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	public AvaliacaoDetalhe remove(long avaliacaoDetalheId)
		throws NoSuchAvaliacaoDetalheException;

	public AvaliacaoDetalhe updateImpl(AvaliacaoDetalhe avaliacaoDetalhe);

	/**
	 * Returns the avaliacao detalhe with the primary key or throws a <code>NoSuchAvaliacaoDetalheException</code> if it could not be found.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	public AvaliacaoDetalhe findByPrimaryKey(long avaliacaoDetalheId)
		throws NoSuchAvaliacaoDetalheException;

	/**
	 * Returns the avaliacao detalhe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe, or <code>null</code> if a avaliacao detalhe with the primary key could not be found
	 */
	public AvaliacaoDetalhe fetchByPrimaryKey(long avaliacaoDetalheId);

	/**
	 * Returns all the avaliacao detalhes.
	 *
	 * @return the avaliacao detalhes
	 */
	public java.util.List<AvaliacaoDetalhe> findAll();

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
	public java.util.List<AvaliacaoDetalhe> findAll(int start, int end);

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
	public java.util.List<AvaliacaoDetalhe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
			orderByComparator);

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
	public java.util.List<AvaliacaoDetalhe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AvaliacaoDetalhe>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the avaliacao detalhes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of avaliacao detalhes.
	 *
	 * @return the number of avaliacao detalhes
	 */
	public int countAll();

}