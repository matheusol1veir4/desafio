/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.impl;

import br.com.example.model.avaliacao.exception.NoSuchFuncionarioException;
import br.com.example.model.avaliacao.model.Funcionario;
import br.com.example.model.avaliacao.model.FuncionarioTable;
import br.com.example.model.avaliacao.model.impl.FuncionarioImpl;
import br.com.example.model.avaliacao.model.impl.FuncionarioModelImpl;
import br.com.example.model.avaliacao.service.persistence.FuncionarioPersistence;
import br.com.example.model.avaliacao.service.persistence.FuncionarioUtil;
import br.com.example.model.avaliacao.service.persistence.impl.constants.FOOPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the funcionario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FuncionarioPersistence.class)
public class FuncionarioPersistenceImpl
	extends BasePersistenceImpl<Funcionario> implements FuncionarioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FuncionarioUtil</code> to access the funcionario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FuncionarioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByFuncionarioId;
	private FinderPath _finderPathWithoutPaginationFindByFuncionarioId;
	private FinderPath _finderPathCountByFuncionarioId;

	/**
	 * Returns all the funcionarios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching funcionarios
	 */
	@Override
	public List<Funcionario> findByFuncionarioId(long funcionarioId) {
		return findByFuncionarioId(
			funcionarioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end) {

		return findByFuncionarioId(funcionarioId, start, end, null);
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
	@Override
	public List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return findByFuncionarioId(
			funcionarioId, start, end, orderByComparator, true);
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
	@Override
	public List<Funcionario> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFuncionarioId;
				finderArgs = new Object[] {funcionarioId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFuncionarioId;
			finderArgs = new Object[] {
				funcionarioId, start, end, orderByComparator
			};
		}

		List<Funcionario> list = null;

		if (useFinderCache) {
			list = (List<Funcionario>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Funcionario funcionario : list) {
					if (funcionarioId != funcionario.getFuncionarioId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			sb.append(_FINDER_COLUMN_FUNCIONARIOID_FUNCIONARIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(funcionarioId);

				list = (List<Funcionario>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	@Override
	public Funcionario findByFuncionarioId_First(
			long funcionarioId,
			OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByFuncionarioId_First(
			funcionarioId, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("funcionarioId=");
		sb.append(funcionarioId);

		sb.append("}");

		throw new NoSuchFuncionarioException(sb.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	@Override
	public Funcionario fetchByFuncionarioId_First(
		long funcionarioId, OrderByComparator<Funcionario> orderByComparator) {

		List<Funcionario> list = findByFuncionarioId(
			funcionarioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	@Override
	public Funcionario findByFuncionarioId_Last(
			long funcionarioId,
			OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByFuncionarioId_Last(
			funcionarioId, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("funcionarioId=");
		sb.append(funcionarioId);

		sb.append("}");

		throw new NoSuchFuncionarioException(sb.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	@Override
	public Funcionario fetchByFuncionarioId_Last(
		long funcionarioId, OrderByComparator<Funcionario> orderByComparator) {

		int count = countByFuncionarioId(funcionarioId);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByFuncionarioId(
			funcionarioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the funcionarios where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	@Override
	public void removeByFuncionarioId(long funcionarioId) {
		for (Funcionario funcionario :
				findByFuncionarioId(
					funcionarioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching funcionarios
	 */
	@Override
	public int countByFuncionarioId(long funcionarioId) {
		FinderPath finderPath = _finderPathCountByFuncionarioId;

		Object[] finderArgs = new Object[] {funcionarioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			sb.append(_FINDER_COLUMN_FUNCIONARIOID_FUNCIONARIOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(funcionarioId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FUNCIONARIOID_FUNCIONARIOID_2 =
		"funcionario.funcionarioId = ?";

	private FinderPath _finderPathWithPaginationFindByEmail;
	private FinderPath _finderPathWithoutPaginationFindByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns all the funcionarios where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching funcionarios
	 */
	@Override
	public List<Funcionario> findByEmail(String email) {
		return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Funcionario> findByEmail(String email, int start, int end) {
		return findByEmail(email, start, end, null);
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
	@Override
	public List<Funcionario> findByEmail(
		String email, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return findByEmail(email, start, end, orderByComparator, true);
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
	@Override
	public List<Funcionario> findByEmail(
		String email, int start, int end,
		OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		email = Objects.toString(email, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmail;
				finderArgs = new Object[] {email};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmail;
			finderArgs = new Object[] {email, start, end, orderByComparator};
		}

		List<Funcionario> list = null;

		if (useFinderCache) {
			list = (List<Funcionario>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Funcionario funcionario : list) {
					if (!email.equals(funcionario.getEmail())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				list = (List<Funcionario>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	@Override
	public Funcionario findByEmail_First(
			String email, OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByEmail_First(email, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchFuncionarioException(sb.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	@Override
	public Funcionario fetchByEmail_First(
		String email, OrderByComparator<Funcionario> orderByComparator) {

		List<Funcionario> list = findByEmail(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	@Override
	public Funcionario findByEmail_Last(
			String email, OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByEmail_Last(email, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchFuncionarioException(sb.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	@Override
	public Funcionario fetchByEmail_Last(
		String email, OrderByComparator<Funcionario> orderByComparator) {

		int count = countByEmail(email);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByEmail(
			email, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Funcionario[] findByEmail_PrevAndNext(
			long funcionarioId, String email,
			OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		email = Objects.toString(email, "");

		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByEmail_PrevAndNext(
				session, funcionario, email, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByEmail_PrevAndNext(
				session, funcionario, email, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funcionario getByEmail_PrevAndNext(
		Session session, Funcionario funcionario, String email,
		OrderByComparator<Funcionario> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FUNCIONARIO_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FuncionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmail) {
			queryPos.add(email);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(funcionario)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Funcionario> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByEmail(String email) {
		for (Funcionario funcionario :
				findByEmail(
					email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching funcionarios
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"funcionario.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(funcionario.email IS NULL OR funcionario.email = '')";

	private FinderPath _finderPathWithPaginationFindByAreaAtuacao;
	private FinderPath _finderPathWithoutPaginationFindByAreaAtuacao;
	private FinderPath _finderPathCountByAreaAtuacao;

	/**
	 * Returns all the funcionarios where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the matching funcionarios
	 */
	@Override
	public List<Funcionario> findByAreaAtuacao(int areaAtuacao) {
		return findByAreaAtuacao(
			areaAtuacao, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end) {

		return findByAreaAtuacao(areaAtuacao, start, end, null);
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
	@Override
	public List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return findByAreaAtuacao(
			areaAtuacao, start, end, orderByComparator, true);
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
	@Override
	public List<Funcionario> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAreaAtuacao;
				finderArgs = new Object[] {areaAtuacao};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAreaAtuacao;
			finderArgs = new Object[] {
				areaAtuacao, start, end, orderByComparator
			};
		}

		List<Funcionario> list = null;

		if (useFinderCache) {
			list = (List<Funcionario>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Funcionario funcionario : list) {
					if (areaAtuacao != funcionario.getAreaAtuacao()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			sb.append(_FINDER_COLUMN_AREAATUACAO_AREAATUACAO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(areaAtuacao);

				list = (List<Funcionario>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	@Override
	public Funcionario findByAreaAtuacao_First(
			int areaAtuacao, OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByAreaAtuacao_First(
			areaAtuacao, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("areaAtuacao=");
		sb.append(areaAtuacao);

		sb.append("}");

		throw new NoSuchFuncionarioException(sb.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	@Override
	public Funcionario fetchByAreaAtuacao_First(
		int areaAtuacao, OrderByComparator<Funcionario> orderByComparator) {

		List<Funcionario> list = findByAreaAtuacao(
			areaAtuacao, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	@Override
	public Funcionario findByAreaAtuacao_Last(
			int areaAtuacao, OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByAreaAtuacao_Last(
			areaAtuacao, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("areaAtuacao=");
		sb.append(areaAtuacao);

		sb.append("}");

		throw new NoSuchFuncionarioException(sb.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	@Override
	public Funcionario fetchByAreaAtuacao_Last(
		int areaAtuacao, OrderByComparator<Funcionario> orderByComparator) {

		int count = countByAreaAtuacao(areaAtuacao);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByAreaAtuacao(
			areaAtuacao, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Funcionario[] findByAreaAtuacao_PrevAndNext(
			long funcionarioId, int areaAtuacao,
			OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByAreaAtuacao_PrevAndNext(
				session, funcionario, areaAtuacao, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByAreaAtuacao_PrevAndNext(
				session, funcionario, areaAtuacao, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funcionario getByAreaAtuacao_PrevAndNext(
		Session session, Funcionario funcionario, int areaAtuacao,
		OrderByComparator<Funcionario> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FUNCIONARIO_WHERE);

		sb.append(_FINDER_COLUMN_AREAATUACAO_AREAATUACAO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FuncionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(areaAtuacao);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(funcionario)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Funcionario> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where areaAtuacao = &#63; from the database.
	 *
	 * @param areaAtuacao the area atuacao
	 */
	@Override
	public void removeByAreaAtuacao(int areaAtuacao) {
		for (Funcionario funcionario :
				findByAreaAtuacao(
					areaAtuacao, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the number of matching funcionarios
	 */
	@Override
	public int countByAreaAtuacao(int areaAtuacao) {
		FinderPath finderPath = _finderPathCountByAreaAtuacao;

		Object[] finderArgs = new Object[] {areaAtuacao};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			sb.append(_FINDER_COLUMN_AREAATUACAO_AREAATUACAO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(areaAtuacao);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_AREAATUACAO_AREAATUACAO_2 =
		"funcionario.areaAtuacao = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the funcionarios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching funcionarios
	 */
	@Override
	public List<Funcionario> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Funcionario> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Funcionario> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Funcionario> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Funcionario> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Funcionario> list = null;

		if (useFinderCache) {
			list = (List<Funcionario>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Funcionario funcionario : list) {
					if (groupId != funcionario.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Funcionario>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	@Override
	public Funcionario findByGroupId_First(
			long groupId, OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByGroupId_First(
			groupId, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchFuncionarioException(sb.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	@Override
	public Funcionario fetchByGroupId_First(
		long groupId, OrderByComparator<Funcionario> orderByComparator) {

		List<Funcionario> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws NoSuchFuncionarioException if a matching funcionario could not be found
	 */
	@Override
	public Funcionario findByGroupId_Last(
			long groupId, OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchFuncionarioException(sb.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 */
	@Override
	public Funcionario fetchByGroupId_Last(
		long groupId, OrderByComparator<Funcionario> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Funcionario[] findByGroupId_PrevAndNext(
			long funcionarioId, long groupId,
			OrderByComparator<Funcionario> orderByComparator)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, funcionario, groupId, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByGroupId_PrevAndNext(
				session, funcionario, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funcionario getByGroupId_PrevAndNext(
		Session session, Funcionario funcionario, long groupId,
		OrderByComparator<Funcionario> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FUNCIONARIO_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FuncionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(funcionario)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Funcionario> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Funcionario funcionario :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching funcionarios
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"funcionario.groupId = ?";

	public FuncionarioPersistenceImpl() {
		setModelClass(Funcionario.class);

		setModelImplClass(FuncionarioImpl.class);
		setModelPKClass(long.class);

		setTable(FuncionarioTable.INSTANCE);
	}

	/**
	 * Caches the funcionario in the entity cache if it is enabled.
	 *
	 * @param funcionario the funcionario
	 */
	@Override
	public void cacheResult(Funcionario funcionario) {
		entityCache.putResult(
			FuncionarioImpl.class, funcionario.getPrimaryKey(), funcionario);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the funcionarios in the entity cache if it is enabled.
	 *
	 * @param funcionarios the funcionarios
	 */
	@Override
	public void cacheResult(List<Funcionario> funcionarios) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (funcionarios.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Funcionario funcionario : funcionarios) {
			if (entityCache.getResult(
					FuncionarioImpl.class, funcionario.getPrimaryKey()) ==
						null) {

				cacheResult(funcionario);
			}
		}
	}

	/**
	 * Clears the cache for all funcionarios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FuncionarioImpl.class);

		finderCache.clearCache(FuncionarioImpl.class);
	}

	/**
	 * Clears the cache for the funcionario.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Funcionario funcionario) {
		entityCache.removeResult(FuncionarioImpl.class, funcionario);
	}

	@Override
	public void clearCache(List<Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			entityCache.removeResult(FuncionarioImpl.class, funcionario);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FuncionarioImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FuncionarioImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	 *
	 * @param funcionarioId the primary key for the new funcionario
	 * @return the new funcionario
	 */
	@Override
	public Funcionario create(long funcionarioId) {
		Funcionario funcionario = new FuncionarioImpl();

		funcionario.setNew(true);
		funcionario.setPrimaryKey(funcionarioId);

		funcionario.setCompanyId(CompanyThreadLocal.getCompanyId());

		return funcionario;
	}

	/**
	 * Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario that was removed
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	@Override
	public Funcionario remove(long funcionarioId)
		throws NoSuchFuncionarioException {

		return remove((Serializable)funcionarioId);
	}

	/**
	 * Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the funcionario
	 * @return the funcionario that was removed
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	@Override
	public Funcionario remove(Serializable primaryKey)
		throws NoSuchFuncionarioException {

		Session session = null;

		try {
			session = openSession();

			Funcionario funcionario = (Funcionario)session.get(
				FuncionarioImpl.class, primaryKey);

			if (funcionario == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFuncionarioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(funcionario);
		}
		catch (NoSuchFuncionarioException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Funcionario removeImpl(Funcionario funcionario) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(funcionario)) {
				funcionario = (Funcionario)session.get(
					FuncionarioImpl.class, funcionario.getPrimaryKeyObj());
			}

			if (funcionario != null) {
				session.delete(funcionario);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (funcionario != null) {
			clearCache(funcionario);
		}

		return funcionario;
	}

	@Override
	public Funcionario updateImpl(Funcionario funcionario) {
		boolean isNew = funcionario.isNew();

		if (!(funcionario instanceof FuncionarioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(funcionario.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(funcionario);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in funcionario proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Funcionario implementation " +
					funcionario.getClass());
		}

		FuncionarioModelImpl funcionarioModelImpl =
			(FuncionarioModelImpl)funcionario;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (funcionario.getCreateDate() == null)) {
			if (serviceContext == null) {
				funcionario.setCreateDate(date);
			}
			else {
				funcionario.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!funcionarioModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				funcionario.setModifiedDate(date);
			}
			else {
				funcionario.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(funcionario);
			}
			else {
				funcionario = (Funcionario)session.merge(funcionario);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FuncionarioImpl.class, funcionarioModelImpl, false, true);

		if (isNew) {
			funcionario.setNew(false);
		}

		funcionario.resetOriginalValues();

		return funcionario;
	}

	/**
	 * Returns the funcionario with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the funcionario
	 * @return the funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	@Override
	public Funcionario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFuncionarioException {

		Funcionario funcionario = fetchByPrimaryKey(primaryKey);

		if (funcionario == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFuncionarioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return funcionario;
	}

	/**
	 * Returns the funcionario with the primary key or throws a <code>NoSuchFuncionarioException</code> if it could not be found.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario
	 * @throws NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 */
	@Override
	public Funcionario findByPrimaryKey(long funcionarioId)
		throws NoSuchFuncionarioException {

		return findByPrimaryKey((Serializable)funcionarioId);
	}

	/**
	 * Returns the funcionario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario, or <code>null</code> if a funcionario with the primary key could not be found
	 */
	@Override
	public Funcionario fetchByPrimaryKey(long funcionarioId) {
		return fetchByPrimaryKey((Serializable)funcionarioId);
	}

	/**
	 * Returns all the funcionarios.
	 *
	 * @return the funcionarios
	 */
	@Override
	public List<Funcionario> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Funcionario> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Funcionario> findAll(
		int start, int end, OrderByComparator<Funcionario> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Funcionario> findAll(
		int start, int end, OrderByComparator<Funcionario> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Funcionario> list = null;

		if (useFinderCache) {
			list = (List<Funcionario>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FUNCIONARIO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FUNCIONARIO;

				sql = sql.concat(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Funcionario>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the funcionarios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Funcionario funcionario : findAll()) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios.
	 *
	 * @return the number of funcionarios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FUNCIONARIO);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "funcionarioId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FUNCIONARIO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FuncionarioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the funcionario persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByFuncionarioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFuncionarioId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"funcionarioId"}, true);

		_finderPathWithoutPaginationFindByFuncionarioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFuncionarioId",
			new String[] {Long.class.getName()}, new String[] {"funcionarioId"},
			true);

		_finderPathCountByFuncionarioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFuncionarioId",
			new String[] {Long.class.getName()}, new String[] {"funcionarioId"},
			false);

		_finderPathWithPaginationFindByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"email"}, true);

		_finderPathWithoutPaginationFindByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_finderPathWithPaginationFindByAreaAtuacao = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAreaAtuacao",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"areaAtuacao"}, true);

		_finderPathWithoutPaginationFindByAreaAtuacao = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAreaAtuacao",
			new String[] {Integer.class.getName()},
			new String[] {"areaAtuacao"}, true);

		_finderPathCountByAreaAtuacao = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAreaAtuacao",
			new String[] {Integer.class.getName()},
			new String[] {"areaAtuacao"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		FuncionarioUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		FuncionarioUtil.setPersistence(null);

		entityCache.removeCache(FuncionarioImpl.class.getName());
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FUNCIONARIO =
		"SELECT funcionario FROM Funcionario funcionario";

	private static final String _SQL_SELECT_FUNCIONARIO_WHERE =
		"SELECT funcionario FROM Funcionario funcionario WHERE ";

	private static final String _SQL_COUNT_FUNCIONARIO =
		"SELECT COUNT(funcionario) FROM Funcionario funcionario";

	private static final String _SQL_COUNT_FUNCIONARIO_WHERE =
		"SELECT COUNT(funcionario) FROM Funcionario funcionario WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "funcionario.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Funcionario exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Funcionario exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FuncionarioPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}