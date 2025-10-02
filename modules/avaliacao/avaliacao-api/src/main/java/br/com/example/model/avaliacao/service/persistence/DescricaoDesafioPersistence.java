/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.exception.NoSuchDescricaoDesafioException;
import br.com.example.model.avaliacao.model.DescricaoDesafio;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the descricao desafio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescricaoDesafioUtil
 * @generated
 */
@ProviderType
public interface DescricaoDesafioPersistence
	extends BasePersistence<DescricaoDesafio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DescricaoDesafioUtil} to access the descricao desafio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the descricao desafios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching descricao desafios
	 */
	public java.util.List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId);

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
	public java.util.List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end);

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
	public java.util.List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

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
	public java.util.List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByFuncionarioId_First(
			long funcionarioId,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the first descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByFuncionarioId_First(
		long funcionarioId,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Returns the last descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByFuncionarioId_Last(
			long funcionarioId,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the last descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByFuncionarioId_Last(
		long funcionarioId,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Returns the descricao desafios before and after the current descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param descricaoDesafioId the primary key of the current descricao desafio
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public DescricaoDesafio[] findByFuncionarioId_PrevAndNext(
			long descricaoDesafioId, long funcionarioId,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Removes all the descricao desafios where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	public void removeByFuncionarioId(long funcionarioId);

	/**
	 * Returns the number of descricao desafios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching descricao desafios
	 */
	public int countByFuncionarioId(long funcionarioId);

	/**
	 * Returns all the descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the matching descricao desafios
	 */
	public java.util.List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId);

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
	public java.util.List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end);

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
	public java.util.List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

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
	public java.util.List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByDescricaoDesafioId_First(
			long descricaoDesafioId,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the first descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByDescricaoDesafioId_First(
		long descricaoDesafioId,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Returns the last descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByDescricaoDesafioId_Last(
			long descricaoDesafioId,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the last descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByDescricaoDesafioId_Last(
		long descricaoDesafioId,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Removes all the descricao desafios where descricaoDesafioId = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 */
	public void removeByDescricaoDesafioId(long descricaoDesafioId);

	/**
	 * Returns the number of descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the number of matching descricao desafios
	 */
	public int countByDescricaoDesafioId(long descricaoDesafioId);

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or throws a <code>NoSuchDescricaoDesafioException</code> if it could not be found.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByFuncionarioId_TipoDesafio(
			long funcionarioId, int tipoDesafio)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio);

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio, boolean useFinderCache);

	/**
	 * Removes the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the descricao desafio that was removed
	 */
	public DescricaoDesafio removeByFuncionarioId_TipoDesafio(
			long funcionarioId, int tipoDesafio)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the number of descricao desafios where funcionarioId = &#63; and tipoDesafio = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the number of matching descricao desafios
	 */
	public int countByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio);

	/**
	 * Returns all the descricao desafios where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafios
	 */
	public java.util.List<DescricaoDesafio> findByTipoDesafio(int tipoDesafio);

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
	public java.util.List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end);

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
	public java.util.List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

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
	public java.util.List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByTipoDesafio_First(
			int tipoDesafio,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the first descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByTipoDesafio_First(
		int tipoDesafio,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Returns the last descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByTipoDesafio_Last(
			int tipoDesafio,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the last descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByTipoDesafio_Last(
		int tipoDesafio,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Returns the descricao desafios before and after the current descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param descricaoDesafioId the primary key of the current descricao desafio
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public DescricaoDesafio[] findByTipoDesafio_PrevAndNext(
			long descricaoDesafioId, int tipoDesafio,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Removes all the descricao desafios where tipoDesafio = &#63; from the database.
	 *
	 * @param tipoDesafio the tipo desafio
	 */
	public void removeByTipoDesafio(int tipoDesafio);

	/**
	 * Returns the number of descricao desafios where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @return the number of matching descricao desafios
	 */
	public int countByTipoDesafio(int tipoDesafio);

	/**
	 * Returns all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @return the matching descricao desafios
	 */
	public java.util.List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao);

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
	public java.util.List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end);

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
	public java.util.List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

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
	public java.util.List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByDataAvaliacaoBetween_First(
			Date dataAvaliacao, Date dataAvaliacao,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the first descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByDataAvaliacaoBetween_First(
		Date dataAvaliacao, Date dataAvaliacao,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Returns the last descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByDataAvaliacaoBetween_Last(
			Date dataAvaliacao, Date dataAvaliacao,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the last descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByDataAvaliacaoBetween_Last(
		Date dataAvaliacao, Date dataAvaliacao,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

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
	public DescricaoDesafio[] findByDataAvaliacaoBetween_PrevAndNext(
			long descricaoDesafioId, Date dataAvaliacao, Date dataAvaliacao,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Removes all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63; from the database.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 */
	public void removeByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao);

	/**
	 * Returns the number of descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @return the number of matching descricao desafios
	 */
	public int countByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao);

	/**
	 * Returns all the descricao desafios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching descricao desafios
	 */
	public java.util.List<DescricaoDesafio> findByGroupId(long groupId);

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
	public java.util.List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

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
	public java.util.List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the first descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Returns the last descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the last descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	public DescricaoDesafio fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

	/**
	 * Returns the descricao desafios before and after the current descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param descricaoDesafioId the primary key of the current descricao desafio
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public DescricaoDesafio[] findByGroupId_PrevAndNext(
			long descricaoDesafioId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
				orderByComparator)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Removes all the descricao desafios where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of descricao desafios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching descricao desafios
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the descricao desafio in the entity cache if it is enabled.
	 *
	 * @param descricaoDesafio the descricao desafio
	 */
	public void cacheResult(DescricaoDesafio descricaoDesafio);

	/**
	 * Caches the descricao desafios in the entity cache if it is enabled.
	 *
	 * @param descricaoDesafios the descricao desafios
	 */
	public void cacheResult(java.util.List<DescricaoDesafio> descricaoDesafios);

	/**
	 * Creates a new descricao desafio with the primary key. Does not add the descricao desafio to the database.
	 *
	 * @param descricaoDesafioId the primary key for the new descricao desafio
	 * @return the new descricao desafio
	 */
	public DescricaoDesafio create(long descricaoDesafioId);

	/**
	 * Removes the descricao desafio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio that was removed
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public DescricaoDesafio remove(long descricaoDesafioId)
		throws NoSuchDescricaoDesafioException;

	public DescricaoDesafio updateImpl(DescricaoDesafio descricaoDesafio);

	/**
	 * Returns the descricao desafio with the primary key or throws a <code>NoSuchDescricaoDesafioException</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	public DescricaoDesafio findByPrimaryKey(long descricaoDesafioId)
		throws NoSuchDescricaoDesafioException;

	/**
	 * Returns the descricao desafio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio, or <code>null</code> if a descricao desafio with the primary key could not be found
	 */
	public DescricaoDesafio fetchByPrimaryKey(long descricaoDesafioId);

	/**
	 * Returns all the descricao desafios.
	 *
	 * @return the descricao desafios
	 */
	public java.util.List<DescricaoDesafio> findAll();

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
	public java.util.List<DescricaoDesafio> findAll(int start, int end);

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
	public java.util.List<DescricaoDesafio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator);

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
	public java.util.List<DescricaoDesafio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DescricaoDesafio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the descricao desafios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of descricao desafios.
	 *
	 * @return the number of descricao desafios
	 */
	public int countAll();

}