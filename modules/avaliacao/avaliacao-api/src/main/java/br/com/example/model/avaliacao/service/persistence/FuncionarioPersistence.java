/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence;

import br.com.example.model.avaliacao.exception.NoSuchFuncionarioException;
import br.com.example.model.avaliacao.model.Funcionario;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the funcionario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FuncionarioUtil
 * @generated
 */
@ProviderType
public interface FuncionarioPersistence extends BasePersistence<Funcionario> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FuncionarioUtil} to access the funcionario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the funcionarios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching funcionarios
	 */
	public java.util.List<Funcionario> findByFuncionarioId(long funcionarioId);

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
	public java.util.List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end);

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
	public java.util.List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

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
	public java.util.List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public Funcionario findByFuncionarioId_First(
			long funcionarioId,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the first funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public Funcionario fetchByFuncionarioId_First(
		long funcionarioId,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

	/**
	 * Returns the last funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public Funcionario findByFuncionarioId_Last(
			long funcionarioId,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the last funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public Funcionario fetchByFuncionarioId_Last(
		long funcionarioId,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

	/**
	 * Removes all the funcionarios where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	public void removeByFuncionarioId(long funcionarioId);

	/**
	 * Returns the number of funcionarios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching funcionarios
	 */
	public int countByFuncionarioId(long funcionarioId);

	/**
	 * Returns all the funcionarios where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching funcionarios
	 */
	public java.util.List<Funcionario> findByEmail(String email);

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
	public java.util.List<Funcionario> findByEmail(
		String email, int start, int end);

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
	public java.util.List<Funcionario> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

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
	public java.util.List<Funcionario> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public Funcionario findByEmail_First(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the first funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public Funcionario fetchByEmail_First(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

	/**
	 * Returns the last funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public Funcionario findByEmail_Last(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the last funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public Funcionario fetchByEmail_Last(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where email = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public Funcionario[] findByEmail_PrevAndNext(
			long funcionarioId, String email,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Removes all the funcionarios where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public void removeByEmail(String email);

	/**
	 * Returns the number of funcionarios where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching funcionarios
	 */
	public int countByEmail(String email);

	/**
	 * Returns all the funcionarios where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the matching funcionarios
	 */
	public java.util.List<Funcionario> findByAreaAtuacao(int areaAtuacao);

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
	public java.util.List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end);

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
	public java.util.List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

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
	public java.util.List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public Funcionario findByAreaAtuacao_First(
			int areaAtuacao,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the first funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public Funcionario fetchByAreaAtuacao_First(
		int areaAtuacao,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

	/**
	 * Returns the last funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public Funcionario findByAreaAtuacao_Last(
			int areaAtuacao,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the last funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public Funcionario fetchByAreaAtuacao_Last(
		int areaAtuacao,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public Funcionario[] findByAreaAtuacao_PrevAndNext(
			long funcionarioId, int areaAtuacao,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Removes all the funcionarios where areaAtuacao = &#63; from the database.
	 *
	 * @param areaAtuacao the area atuacao
	 */
	public void removeByAreaAtuacao(int areaAtuacao);

	/**
	 * Returns the number of funcionarios where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the number of matching funcionarios
	 */
	public int countByAreaAtuacao(int areaAtuacao);

	/**
	 * Returns all the funcionarios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching funcionarios
	 */
	public java.util.List<Funcionario> findByGroupId(long groupId);

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
	public java.util.List<Funcionario> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Funcionario> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

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
	public java.util.List<Funcionario> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public Funcionario findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the first funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public Funcionario fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

	/**
	 * Returns the last funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	public Funcionario findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the last funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	public Funcionario fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public Funcionario[] findByGroupId_PrevAndNext(
			long funcionarioId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
				orderByComparator)
		throws NoSuchFuncionarioException;

	/**
	 * Removes all the funcionarios where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of funcionarios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching funcionarios
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the funcionario in the entity cache if it is enabled.
	 *
	 * @param funcionario the funcionario
	 */
	public void cacheResult(Funcionario funcionario);

	/**
	 * Caches the funcionarios in the entity cache if it is enabled.
	 *
	 * @param funcionarios the funcionarios
	 */
	public void cacheResult(java.util.List<Funcionario> funcionarios);

	/**
	 * Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	 *
	 * @param funcionarioId the primary key for the new funcionario
	 * @return the new funcionario
	 */
	public Funcionario create(long funcionarioId);

	/**
	 * Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario that was removed
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public Funcionario remove(long funcionarioId)
		throws NoSuchFuncionarioException;

	public Funcionario updateImpl(Funcionario funcionario);

	/**
	 * Returns the funcionario with the primary key or throws a <code>NoSuchFuncionarioException</code> if it could not be found.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	public Funcionario findByPrimaryKey(long funcionarioId)
		throws NoSuchFuncionarioException;

	/**
	 * Returns the funcionario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario, or <code>null</code> if a funcionario with the primary key could not be found
	 */
	public Funcionario fetchByPrimaryKey(long funcionarioId);

	/**
	 * Returns all the funcionarios.
	 *
	 * @return the funcionarios
	 */
	public java.util.List<Funcionario> findAll();

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
	public java.util.List<Funcionario> findAll(int start, int end);

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
	public java.util.List<Funcionario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator);

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
	public java.util.List<Funcionario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Funcionario>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the funcionarios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of funcionarios.
	 *
	 * @return the number of funcionarios
	 */
	public int countAll();

}