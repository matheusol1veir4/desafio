/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacoesException;
import br.com.example.model.avaliacao.model.Avaliacoes;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the avaliacoes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacoesUtil
 * @generated
 */
@ProviderType
public interface AvaliacoesPersistence extends BasePersistence<Avaliacoes> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AvaliacoesUtil} to access the avaliacoes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the avaliacoeses where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @return the matching avaliacoeses
	 */
	public java.util.List<Avaliacoes> findByAvaliacoesId(long avaliacoesId);

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
	public java.util.List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end);

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
	public java.util.List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

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
	public java.util.List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public Avaliacoes findByAvaliacoesId_First(
			long avaliacoesId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
				orderByComparator)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the first avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public Avaliacoes fetchByAvaliacoesId_First(
		long avaliacoesId,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

	/**
	 * Returns the last avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public Avaliacoes findByAvaliacoesId_Last(
			long avaliacoesId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
				orderByComparator)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the last avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public Avaliacoes fetchByAvaliacoesId_Last(
		long avaliacoesId,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

	/**
	 * Removes all the avaliacoeses where avaliacoesId = &#63; from the database.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 */
	public void removeByAvaliacoesId(long avaliacoesId);

	/**
	 * Returns the number of avaliacoeses where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @return the number of matching avaliacoeses
	 */
	public int countByAvaliacoesId(long avaliacoesId);

	/**
	 * Returns all the avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the matching avaliacoeses
	 */
	public java.util.List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId);

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
	public java.util.List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end);

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
	public java.util.List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

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
	public java.util.List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public Avaliacoes findByDescricaoDesafioId_First(
			long descricaoDesafioId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
				orderByComparator)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the first avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public Avaliacoes fetchByDescricaoDesafioId_First(
		long descricaoDesafioId,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

	/**
	 * Returns the last avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public Avaliacoes findByDescricaoDesafioId_Last(
			long descricaoDesafioId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
				orderByComparator)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the last avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public Avaliacoes fetchByDescricaoDesafioId_Last(
		long descricaoDesafioId,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

	/**
	 * Returns the avaliacoeses before and after the current avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param avaliacoesId the primary key of the current avaliacoes
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	public Avaliacoes[] findByDescricaoDesafioId_PrevAndNext(
			long avaliacoesId, long descricaoDesafioId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
				orderByComparator)
		throws NoSuchAvaliacoesException;

	/**
	 * Removes all the avaliacoeses where descricaoDesafioId = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 */
	public void removeByDescricaoDesafioId(long descricaoDesafioId);

	/**
	 * Returns the number of avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the number of matching avaliacoeses
	 */
	public int countByDescricaoDesafioId(long descricaoDesafioId);

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or throws a <code>NoSuchAvaliacoesException</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public Avaliacoes findByDescricaoDesafioId_TipoAvaliador(
			long descricaoDesafioId, String tipoAvaliador)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public Avaliacoes fetchByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador);

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public Avaliacoes fetchByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador, boolean useFinderCache);

	/**
	 * Removes the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the avaliacoes that was removed
	 */
	public Avaliacoes removeByDescricaoDesafioId_TipoAvaliador(
			long descricaoDesafioId, String tipoAvaliador)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the number of avaliacoeses where descricaoDesafioId = &#63; and tipoAvaliador = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the number of matching avaliacoeses
	 */
	public int countByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador);

	/**
	 * Returns all the avaliacoeses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching avaliacoeses
	 */
	public java.util.List<Avaliacoes> findByGroupId(long groupId);

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
	public java.util.List<Avaliacoes> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Avaliacoes> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

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
	public java.util.List<Avaliacoes> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public Avaliacoes findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
				orderByComparator)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the first avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public Avaliacoes fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

	/**
	 * Returns the last avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	public Avaliacoes findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
				orderByComparator)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the last avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	public Avaliacoes fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

	/**
	 * Returns the avaliacoeses before and after the current avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param avaliacoesId the primary key of the current avaliacoes
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	public Avaliacoes[] findByGroupId_PrevAndNext(
			long avaliacoesId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
				orderByComparator)
		throws NoSuchAvaliacoesException;

	/**
	 * Removes all the avaliacoeses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of avaliacoeses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching avaliacoeses
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the avaliacoes in the entity cache if it is enabled.
	 *
	 * @param avaliacoes the avaliacoes
	 */
	public void cacheResult(Avaliacoes avaliacoes);

	/**
	 * Caches the avaliacoeses in the entity cache if it is enabled.
	 *
	 * @param avaliacoeses the avaliacoeses
	 */
	public void cacheResult(java.util.List<Avaliacoes> avaliacoeses);

	/**
	 * Creates a new avaliacoes with the primary key. Does not add the avaliacoes to the database.
	 *
	 * @param avaliacoesId the primary key for the new avaliacoes
	 * @return the new avaliacoes
	 */
	public Avaliacoes create(long avaliacoesId);

	/**
	 * Removes the avaliacoes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes that was removed
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	public Avaliacoes remove(long avaliacoesId)
		throws NoSuchAvaliacoesException;

	public Avaliacoes updateImpl(Avaliacoes avaliacoes);

	/**
	 * Returns the avaliacoes with the primary key or throws a <code>NoSuchAvaliacoesException</code> if it could not be found.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	public Avaliacoes findByPrimaryKey(long avaliacoesId)
		throws NoSuchAvaliacoesException;

	/**
	 * Returns the avaliacoes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes, or <code>null</code> if a avaliacoes with the primary key could not be found
	 */
	public Avaliacoes fetchByPrimaryKey(long avaliacoesId);

	/**
	 * Returns all the avaliacoeses.
	 *
	 * @return the avaliacoeses
	 */
	public java.util.List<Avaliacoes> findAll();

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
	public java.util.List<Avaliacoes> findAll(int start, int end);

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
	public java.util.List<Avaliacoes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator);

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
	public java.util.List<Avaliacoes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacoes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the avaliacoeses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of avaliacoeses.
	 *
	 * @return the number of avaliacoeses
	 */
	public int countAll();

}