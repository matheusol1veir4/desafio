/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacaoException;
import br.com.example.model.avaliacao.model.Avaliacao;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the avaliacao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoUtil
 * @generated
 */
@ProviderType
public interface AvaliacaoPersistence extends BasePersistence<Avaliacao> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AvaliacaoUtil} to access the avaliacao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the avaliacaos where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching avaliacaos
	 */
	public java.util.List<Avaliacao> findByFuncionarioId(long funcionarioId);

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
	public java.util.List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end);

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
	public java.util.List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

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
	public java.util.List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public Avaliacao findByFuncionarioId_First(
			long funcionarioId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the first avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public Avaliacao fetchByFuncionarioId_First(
		long funcionarioId,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

	/**
	 * Returns the last avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public Avaliacao findByFuncionarioId_Last(
			long funcionarioId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the last avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public Avaliacao fetchByFuncionarioId_Last(
		long funcionarioId,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

	/**
	 * Returns the avaliacaos before and after the current avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param avaliacaoId the primary key of the current avaliacao
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public Avaliacao[] findByFuncionarioId_PrevAndNext(
			long avaliacaoId, long funcionarioId,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Removes all the avaliacaos where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	public void removeByFuncionarioId(long funcionarioId);

	/**
	 * Returns the number of avaliacaos where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching avaliacaos
	 */
	public int countByFuncionarioId(long funcionarioId);

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or throws a <code>NoSuchAvaliacaoException</code> if it could not be found.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public Avaliacao findByFuncionarioIdPeriodoDesafio(
			long funcionarioId, int periodoDesafio)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public Avaliacao fetchByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio);

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public Avaliacao fetchByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio, boolean useFinderCache);

	/**
	 * Removes the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the avaliacao that was removed
	 */
	public Avaliacao removeByFuncionarioIdPeriodoDesafio(
			long funcionarioId, int periodoDesafio)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the number of avaliacaos where funcionarioId = &#63; and periodoDesafio = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the number of matching avaliacaos
	 */
	public int countByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio);

	/**
	 * Returns all the avaliacaos where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacaos
	 */
	public java.util.List<Avaliacao> findByPeriodoDesafio(int periodoDesafio);

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
	public java.util.List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end);

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
	public java.util.List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

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
	public java.util.List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public Avaliacao findByPeriodoDesafio_First(
			int periodoDesafio,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the first avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public Avaliacao fetchByPeriodoDesafio_First(
		int periodoDesafio,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

	/**
	 * Returns the last avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public Avaliacao findByPeriodoDesafio_Last(
			int periodoDesafio,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the last avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public Avaliacao fetchByPeriodoDesafio_Last(
		int periodoDesafio,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

	/**
	 * Returns the avaliacaos before and after the current avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param avaliacaoId the primary key of the current avaliacao
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public Avaliacao[] findByPeriodoDesafio_PrevAndNext(
			long avaliacaoId, int periodoDesafio,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Removes all the avaliacaos where periodoDesafio = &#63; from the database.
	 *
	 * @param periodoDesafio the periodo desafio
	 */
	public void removeByPeriodoDesafio(int periodoDesafio);

	/**
	 * Returns the number of avaliacaos where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @return the number of matching avaliacaos
	 */
	public int countByPeriodoDesafio(int periodoDesafio);

	/**
	 * Returns all the avaliacaos where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the matching avaliacaos
	 */
	public java.util.List<Avaliacao> findByAreaAtuacao(int areaAtuacao);

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
	public java.util.List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end);

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
	public java.util.List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

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
	public java.util.List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public Avaliacao findByAreaAtuacao_First(
			int areaAtuacao,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the first avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public Avaliacao fetchByAreaAtuacao_First(
		int areaAtuacao,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

	/**
	 * Returns the last avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	public Avaliacao findByAreaAtuacao_Last(
			int areaAtuacao,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the last avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	public Avaliacao fetchByAreaAtuacao_Last(
		int areaAtuacao,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

	/**
	 * Returns the avaliacaos before and after the current avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param avaliacaoId the primary key of the current avaliacao
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public Avaliacao[] findByAreaAtuacao_PrevAndNext(
			long avaliacaoId, int areaAtuacao,
			com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
				orderByComparator)
		throws NoSuchAvaliacaoException;

	/**
	 * Removes all the avaliacaos where areaAtuacao = &#63; from the database.
	 *
	 * @param areaAtuacao the area atuacao
	 */
	public void removeByAreaAtuacao(int areaAtuacao);

	/**
	 * Returns the number of avaliacaos where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the number of matching avaliacaos
	 */
	public int countByAreaAtuacao(int areaAtuacao);

	/**
	 * Caches the avaliacao in the entity cache if it is enabled.
	 *
	 * @param avaliacao the avaliacao
	 */
	public void cacheResult(Avaliacao avaliacao);

	/**
	 * Caches the avaliacaos in the entity cache if it is enabled.
	 *
	 * @param avaliacaos the avaliacaos
	 */
	public void cacheResult(java.util.List<Avaliacao> avaliacaos);

	/**
	 * Creates a new avaliacao with the primary key. Does not add the avaliacao to the database.
	 *
	 * @param avaliacaoId the primary key for the new avaliacao
	 * @return the new avaliacao
	 */
	public Avaliacao create(long avaliacaoId);

	/**
	 * Removes the avaliacao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao that was removed
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public Avaliacao remove(long avaliacaoId) throws NoSuchAvaliacaoException;

	public Avaliacao updateImpl(Avaliacao avaliacao);

	/**
	 * Returns the avaliacao with the primary key or throws a <code>NoSuchAvaliacaoException</code> if it could not be found.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	public Avaliacao findByPrimaryKey(long avaliacaoId)
		throws NoSuchAvaliacaoException;

	/**
	 * Returns the avaliacao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao, or <code>null</code> if a avaliacao with the primary key could not be found
	 */
	public Avaliacao fetchByPrimaryKey(long avaliacaoId);

	/**
	 * Returns all the avaliacaos.
	 *
	 * @return the avaliacaos
	 */
	public java.util.List<Avaliacao> findAll();

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
	public java.util.List<Avaliacao> findAll(int start, int end);

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
	public java.util.List<Avaliacao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator);

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
	public java.util.List<Avaliacao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Avaliacao>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the avaliacaos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of avaliacaos.
	 *
	 * @return the number of avaliacaos
	 */
	public int countAll();

}