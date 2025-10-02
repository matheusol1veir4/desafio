/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.impl;

import br.com.example.model.avaliacao.exception.NoSuchDescricaoDesafioException;
import br.com.example.model.avaliacao.model.DescricaoDesafio;
import br.com.example.model.avaliacao.model.DescricaoDesafioTable;
import br.com.example.model.avaliacao.model.impl.DescricaoDesafioImpl;
import br.com.example.model.avaliacao.model.impl.DescricaoDesafioModelImpl;
import br.com.example.model.avaliacao.service.persistence.DescricaoDesafioPersistence;
import br.com.example.model.avaliacao.service.persistence.DescricaoDesafioUtil;
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

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the descricao desafio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DescricaoDesafioPersistence.class)
public class DescricaoDesafioPersistenceImpl
	extends BasePersistenceImpl<DescricaoDesafio>
	implements DescricaoDesafioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DescricaoDesafioUtil</code> to access the descricao desafio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DescricaoDesafioImpl.class.getName();

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
	 * Returns all the descricao desafios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching descricao desafios
	 */
	@Override
	public List<DescricaoDesafio> findByFuncionarioId(long funcionarioId) {
		return findByFuncionarioId(
			funcionarioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end) {

		return findByFuncionarioId(funcionarioId, start, end, null);
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
	@Override
	public List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return findByFuncionarioId(
			funcionarioId, start, end, orderByComparator, true);
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
	@Override
	public List<DescricaoDesafio> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
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

		List<DescricaoDesafio> list = null;

		if (useFinderCache) {
			list = (List<DescricaoDesafio>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DescricaoDesafio descricaoDesafio : list) {
					if (funcionarioId != descricaoDesafio.getFuncionarioId()) {
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

			sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

			sb.append(_FINDER_COLUMN_FUNCIONARIOID_FUNCIONARIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(funcionarioId);

				list = (List<DescricaoDesafio>)QueryUtil.list(
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
	 * Returns the first descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByFuncionarioId_First(
			long funcionarioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByFuncionarioId_First(
			funcionarioId, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("funcionarioId=");
		sb.append(funcionarioId);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the first descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByFuncionarioId_First(
		long funcionarioId,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		List<DescricaoDesafio> list = findByFuncionarioId(
			funcionarioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByFuncionarioId_Last(
			long funcionarioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByFuncionarioId_Last(
			funcionarioId, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("funcionarioId=");
		sb.append(funcionarioId);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the last descricao desafio in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByFuncionarioId_Last(
		long funcionarioId,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		int count = countByFuncionarioId(funcionarioId);

		if (count == 0) {
			return null;
		}

		List<DescricaoDesafio> list = findByFuncionarioId(
			funcionarioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DescricaoDesafio[] findByFuncionarioId_PrevAndNext(
			long descricaoDesafioId, long funcionarioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = findByPrimaryKey(
			descricaoDesafioId);

		Session session = null;

		try {
			session = openSession();

			DescricaoDesafio[] array = new DescricaoDesafioImpl[3];

			array[0] = getByFuncionarioId_PrevAndNext(
				session, descricaoDesafio, funcionarioId, orderByComparator,
				true);

			array[1] = descricaoDesafio;

			array[2] = getByFuncionarioId_PrevAndNext(
				session, descricaoDesafio, funcionarioId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DescricaoDesafio getByFuncionarioId_PrevAndNext(
		Session session, DescricaoDesafio descricaoDesafio, long funcionarioId,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

		sb.append(_FINDER_COLUMN_FUNCIONARIOID_FUNCIONARIOID_2);

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
			sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(funcionarioId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						descricaoDesafio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DescricaoDesafio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the descricao desafios where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	@Override
	public void removeByFuncionarioId(long funcionarioId) {
		for (DescricaoDesafio descricaoDesafio :
				findByFuncionarioId(
					funcionarioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(descricaoDesafio);
		}
	}

	/**
	 * Returns the number of descricao desafios where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching descricao desafios
	 */
	@Override
	public int countByFuncionarioId(long funcionarioId) {
		FinderPath finderPath = _finderPathCountByFuncionarioId;

		Object[] finderArgs = new Object[] {funcionarioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESCRICAODESAFIO_WHERE);

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
		"descricaoDesafio.funcionarioId = ?";

	private FinderPath _finderPathWithPaginationFindByDescricaoDesafioId;
	private FinderPath _finderPathWithoutPaginationFindByDescricaoDesafioId;
	private FinderPath _finderPathCountByDescricaoDesafioId;

	/**
	 * Returns all the descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the matching descricao desafios
	 */
	@Override
	public List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId) {

		return findByDescricaoDesafioId(
			descricaoDesafioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end) {

		return findByDescricaoDesafioId(descricaoDesafioId, start, end, null);
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
	@Override
	public List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return findByDescricaoDesafioId(
			descricaoDesafioId, start, end, orderByComparator, true);
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
	@Override
	public List<DescricaoDesafio> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDescricaoDesafioId;
				finderArgs = new Object[] {descricaoDesafioId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDescricaoDesafioId;
			finderArgs = new Object[] {
				descricaoDesafioId, start, end, orderByComparator
			};
		}

		List<DescricaoDesafio> list = null;

		if (useFinderCache) {
			list = (List<DescricaoDesafio>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DescricaoDesafio descricaoDesafio : list) {
					if (descricaoDesafioId !=
							descricaoDesafio.getDescricaoDesafioId()) {

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

			sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

			sb.append(_FINDER_COLUMN_DESCRICAODESAFIOID_DESCRICAODESAFIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(descricaoDesafioId);

				list = (List<DescricaoDesafio>)QueryUtil.list(
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
	 * Returns the first descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByDescricaoDesafioId_First(
			long descricaoDesafioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByDescricaoDesafioId_First(
			descricaoDesafioId, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("descricaoDesafioId=");
		sb.append(descricaoDesafioId);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the first descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByDescricaoDesafioId_First(
		long descricaoDesafioId,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		List<DescricaoDesafio> list = findByDescricaoDesafioId(
			descricaoDesafioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByDescricaoDesafioId_Last(
			long descricaoDesafioId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByDescricaoDesafioId_Last(
			descricaoDesafioId, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("descricaoDesafioId=");
		sb.append(descricaoDesafioId);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the last descricao desafio in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByDescricaoDesafioId_Last(
		long descricaoDesafioId,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		int count = countByDescricaoDesafioId(descricaoDesafioId);

		if (count == 0) {
			return null;
		}

		List<DescricaoDesafio> list = findByDescricaoDesafioId(
			descricaoDesafioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the descricao desafios where descricaoDesafioId = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 */
	@Override
	public void removeByDescricaoDesafioId(long descricaoDesafioId) {
		for (DescricaoDesafio descricaoDesafio :
				findByDescricaoDesafioId(
					descricaoDesafioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(descricaoDesafio);
		}
	}

	/**
	 * Returns the number of descricao desafios where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the number of matching descricao desafios
	 */
	@Override
	public int countByDescricaoDesafioId(long descricaoDesafioId) {
		FinderPath finderPath = _finderPathCountByDescricaoDesafioId;

		Object[] finderArgs = new Object[] {descricaoDesafioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESCRICAODESAFIO_WHERE);

			sb.append(_FINDER_COLUMN_DESCRICAODESAFIOID_DESCRICAODESAFIOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(descricaoDesafioId);

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

	private static final String
		_FINDER_COLUMN_DESCRICAODESAFIOID_DESCRICAODESAFIOID_2 =
			"descricaoDesafio.descricaoDesafioId = ?";

	private FinderPath _finderPathFetchByFuncionarioId_TipoDesafio;

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or throws a <code>NoSuchDescricaoDesafioException</code> if it could not be found.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByFuncionarioId_TipoDesafio(
			long funcionarioId, int tipoDesafio)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio);

		if (descricaoDesafio == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("funcionarioId=");
			sb.append(funcionarioId);

			sb.append(", tipoDesafio=");
			sb.append(tipoDesafio);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDescricaoDesafioException(sb.toString());
		}

		return descricaoDesafio;
	}

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio) {

		return fetchByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio, true);
	}

	/**
	 * Returns the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {funcionarioId, tipoDesafio};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFuncionarioId_TipoDesafio, finderArgs, this);
		}

		if (result instanceof DescricaoDesafio) {
			DescricaoDesafio descricaoDesafio = (DescricaoDesafio)result;

			if ((funcionarioId != descricaoDesafio.getFuncionarioId()) ||
				(tipoDesafio != descricaoDesafio.getTipoDesafio())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

			sb.append(_FINDER_COLUMN_FUNCIONARIOID_TIPODESAFIO_FUNCIONARIOID_2);

			sb.append(_FINDER_COLUMN_FUNCIONARIOID_TIPODESAFIO_TIPODESAFIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(funcionarioId);

				queryPos.add(tipoDesafio);

				List<DescricaoDesafio> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFuncionarioId_TipoDesafio,
							finderArgs, list);
					}
				}
				else {
					DescricaoDesafio descricaoDesafio = list.get(0);

					result = descricaoDesafio;

					cacheResult(descricaoDesafio);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DescricaoDesafio)result;
		}
	}

	/**
	 * Removes the descricao desafio where funcionarioId = &#63; and tipoDesafio = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the descricao desafio that was removed
	 */
	@Override
	public DescricaoDesafio removeByFuncionarioId_TipoDesafio(
			long funcionarioId, int tipoDesafio)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = findByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio);

		return remove(descricaoDesafio);
	}

	/**
	 * Returns the number of descricao desafios where funcionarioId = &#63; and tipoDesafio = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param tipoDesafio the tipo desafio
	 * @return the number of matching descricao desafios
	 */
	@Override
	public int countByFuncionarioId_TipoDesafio(
		long funcionarioId, int tipoDesafio) {

		DescricaoDesafio descricaoDesafio = fetchByFuncionarioId_TipoDesafio(
			funcionarioId, tipoDesafio);

		if (descricaoDesafio == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_FUNCIONARIOID_TIPODESAFIO_FUNCIONARIOID_2 =
			"descricaoDesafio.funcionarioId = ? AND ";

	private static final String
		_FINDER_COLUMN_FUNCIONARIOID_TIPODESAFIO_TIPODESAFIO_2 =
			"descricaoDesafio.tipoDesafio = ?";

	private FinderPath _finderPathWithPaginationFindByTipoDesafio;
	private FinderPath _finderPathWithoutPaginationFindByTipoDesafio;
	private FinderPath _finderPathCountByTipoDesafio;

	/**
	 * Returns all the descricao desafios where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @return the matching descricao desafios
	 */
	@Override
	public List<DescricaoDesafio> findByTipoDesafio(int tipoDesafio) {
		return findByTipoDesafio(
			tipoDesafio, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end) {

		return findByTipoDesafio(tipoDesafio, start, end, null);
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
	@Override
	public List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return findByTipoDesafio(
			tipoDesafio, start, end, orderByComparator, true);
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
	@Override
	public List<DescricaoDesafio> findByTipoDesafio(
		int tipoDesafio, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTipoDesafio;
				finderArgs = new Object[] {tipoDesafio};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTipoDesafio;
			finderArgs = new Object[] {
				tipoDesafio, start, end, orderByComparator
			};
		}

		List<DescricaoDesafio> list = null;

		if (useFinderCache) {
			list = (List<DescricaoDesafio>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DescricaoDesafio descricaoDesafio : list) {
					if (tipoDesafio != descricaoDesafio.getTipoDesafio()) {
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

			sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

			sb.append(_FINDER_COLUMN_TIPODESAFIO_TIPODESAFIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tipoDesafio);

				list = (List<DescricaoDesafio>)QueryUtil.list(
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
	 * Returns the first descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByTipoDesafio_First(
			int tipoDesafio,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByTipoDesafio_First(
			tipoDesafio, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipoDesafio=");
		sb.append(tipoDesafio);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the first descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByTipoDesafio_First(
		int tipoDesafio,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		List<DescricaoDesafio> list = findByTipoDesafio(
			tipoDesafio, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByTipoDesafio_Last(
			int tipoDesafio,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByTipoDesafio_Last(
			tipoDesafio, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipoDesafio=");
		sb.append(tipoDesafio);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the last descricao desafio in the ordered set where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByTipoDesafio_Last(
		int tipoDesafio,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		int count = countByTipoDesafio(tipoDesafio);

		if (count == 0) {
			return null;
		}

		List<DescricaoDesafio> list = findByTipoDesafio(
			tipoDesafio, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DescricaoDesafio[] findByTipoDesafio_PrevAndNext(
			long descricaoDesafioId, int tipoDesafio,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = findByPrimaryKey(
			descricaoDesafioId);

		Session session = null;

		try {
			session = openSession();

			DescricaoDesafio[] array = new DescricaoDesafioImpl[3];

			array[0] = getByTipoDesafio_PrevAndNext(
				session, descricaoDesafio, tipoDesafio, orderByComparator,
				true);

			array[1] = descricaoDesafio;

			array[2] = getByTipoDesafio_PrevAndNext(
				session, descricaoDesafio, tipoDesafio, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DescricaoDesafio getByTipoDesafio_PrevAndNext(
		Session session, DescricaoDesafio descricaoDesafio, int tipoDesafio,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

		sb.append(_FINDER_COLUMN_TIPODESAFIO_TIPODESAFIO_2);

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
			sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tipoDesafio);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						descricaoDesafio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DescricaoDesafio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the descricao desafios where tipoDesafio = &#63; from the database.
	 *
	 * @param tipoDesafio the tipo desafio
	 */
	@Override
	public void removeByTipoDesafio(int tipoDesafio) {
		for (DescricaoDesafio descricaoDesafio :
				findByTipoDesafio(
					tipoDesafio, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(descricaoDesafio);
		}
	}

	/**
	 * Returns the number of descricao desafios where tipoDesafio = &#63;.
	 *
	 * @param tipoDesafio the tipo desafio
	 * @return the number of matching descricao desafios
	 */
	@Override
	public int countByTipoDesafio(int tipoDesafio) {
		FinderPath finderPath = _finderPathCountByTipoDesafio;

		Object[] finderArgs = new Object[] {tipoDesafio};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESCRICAODESAFIO_WHERE);

			sb.append(_FINDER_COLUMN_TIPODESAFIO_TIPODESAFIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tipoDesafio);

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

	private static final String _FINDER_COLUMN_TIPODESAFIO_TIPODESAFIO_2 =
		"descricaoDesafio.tipoDesafio = ?";

	private FinderPath _finderPathWithPaginationFindByDataAvaliacaoBetween;
	private FinderPath _finderPathWithPaginationCountByDataAvaliacaoBetween;

	/**
	 * Returns all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @return the matching descricao desafios
	 */
	@Override
	public List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao) {

		return findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end) {

		return findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, start, end, null);
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
	@Override
	public List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, start, end, orderByComparator, true);
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
	@Override
	public List<DescricaoDesafio> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByDataAvaliacaoBetween;
		finderArgs = new Object[] {
			_getTime(dataAvaliacao), _getTime(dataAvaliacao), start, end,
			orderByComparator
		};

		List<DescricaoDesafio> list = null;

		if (useFinderCache) {
			list = (List<DescricaoDesafio>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DescricaoDesafio descricaoDesafio : list) {
					if ((dataAvaliacao.getTime() >
							descricaoDesafio.getDataAvaliacao(
							).getTime()) ||
						(dataAvaliacao.getTime() <
							descricaoDesafio.getDataAvaliacao(
							).getTime())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

			boolean bindDataAvaliacao = false;

			if (dataAvaliacao == null) {
				sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1);
			}
			else {
				bindDataAvaliacao = true;

				sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2);
			}

			boolean bindDataAvaliacao = false;

			if (dataAvaliacao == null) {
				sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1);
			}
			else {
				bindDataAvaliacao = true;

				sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataAvaliacao) {
					queryPos.add(new Timestamp(dataAvaliacao.getTime()));
				}

				if (bindDataAvaliacao) {
					queryPos.add(new Timestamp(dataAvaliacao.getTime()));
				}

				list = (List<DescricaoDesafio>)QueryUtil.list(
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
	 * Returns the first descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByDataAvaliacaoBetween_First(
			Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByDataAvaliacaoBetween_First(
			dataAvaliacao, dataAvaliacao, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataAvaliacao>=");
		sb.append(dataAvaliacao);

		sb.append(", dataAvaliacao<=");
		sb.append(dataAvaliacao);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the first descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByDataAvaliacaoBetween_First(
		Date dataAvaliacao, Date dataAvaliacao,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		List<DescricaoDesafio> list = findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DescricaoDesafio findByDataAvaliacaoBetween_Last(
			Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByDataAvaliacaoBetween_Last(
			dataAvaliacao, dataAvaliacao, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataAvaliacao>=");
		sb.append(dataAvaliacao);

		sb.append(", dataAvaliacao<=");
		sb.append(dataAvaliacao);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the last descricao desafio in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByDataAvaliacaoBetween_Last(
		Date dataAvaliacao, Date dataAvaliacao,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		int count = countByDataAvaliacaoBetween(dataAvaliacao, dataAvaliacao);

		if (count == 0) {
			return null;
		}

		List<DescricaoDesafio> list = findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DescricaoDesafio[] findByDataAvaliacaoBetween_PrevAndNext(
			long descricaoDesafioId, Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = findByPrimaryKey(
			descricaoDesafioId);

		Session session = null;

		try {
			session = openSession();

			DescricaoDesafio[] array = new DescricaoDesafioImpl[3];

			array[0] = getByDataAvaliacaoBetween_PrevAndNext(
				session, descricaoDesafio, dataAvaliacao, dataAvaliacao,
				orderByComparator, true);

			array[1] = descricaoDesafio;

			array[2] = getByDataAvaliacaoBetween_PrevAndNext(
				session, descricaoDesafio, dataAvaliacao, dataAvaliacao,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DescricaoDesafio getByDataAvaliacaoBetween_PrevAndNext(
		Session session, DescricaoDesafio descricaoDesafio, Date dataAvaliacao,
		Date dataAvaliacao,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

		boolean bindDataAvaliacao = false;

		if (dataAvaliacao == null) {
			sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1);
		}
		else {
			bindDataAvaliacao = true;

			sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2);
		}

		boolean bindDataAvaliacao = false;

		if (dataAvaliacao == null) {
			sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1);
		}
		else {
			bindDataAvaliacao = true;

			sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2);
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
			sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDataAvaliacao) {
			queryPos.add(new Timestamp(dataAvaliacao.getTime()));
		}

		if (bindDataAvaliacao) {
			queryPos.add(new Timestamp(dataAvaliacao.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						descricaoDesafio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DescricaoDesafio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63; from the database.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 */
	@Override
	public void removeByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao) {

		for (DescricaoDesafio descricaoDesafio :
				findByDataAvaliacaoBetween(
					dataAvaliacao, dataAvaliacao, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(descricaoDesafio);
		}
	}

	/**
	 * Returns the number of descricao desafios where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @return the number of matching descricao desafios
	 */
	@Override
	public int countByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao) {

		FinderPath finderPath =
			_finderPathWithPaginationCountByDataAvaliacaoBetween;

		Object[] finderArgs = new Object[] {
			_getTime(dataAvaliacao), _getTime(dataAvaliacao)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESCRICAODESAFIO_WHERE);

			boolean bindDataAvaliacao = false;

			if (dataAvaliacao == null) {
				sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1);
			}
			else {
				bindDataAvaliacao = true;

				sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2);
			}

			boolean bindDataAvaliacao = false;

			if (dataAvaliacao == null) {
				sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1);
			}
			else {
				bindDataAvaliacao = true;

				sb.append(_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataAvaliacao) {
					queryPos.add(new Timestamp(dataAvaliacao.getTime()));
				}

				if (bindDataAvaliacao) {
					queryPos.add(new Timestamp(dataAvaliacao.getTime()));
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

	private static final String
		_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1 =
			"descricaoDesafio.dataAvaliacao IS NULL AND ";

	private static final String
		_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2 =
			"descricaoDesafio.dataAvaliacao >= ? AND ";

	private static final String
		_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1 =
			"descricaoDesafio.dataAvaliacao IS NULL";

	private static final String
		_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2 =
			"descricaoDesafio.dataAvaliacao <= ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the descricao desafios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching descricao desafios
	 */
	@Override
	public List<DescricaoDesafio> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<DescricaoDesafio> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
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

		List<DescricaoDesafio> list = null;

		if (useFinderCache) {
			list = (List<DescricaoDesafio>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DescricaoDesafio descricaoDesafio : list) {
					if (groupId != descricaoDesafio.getGroupId()) {
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

			sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<DescricaoDesafio>)QueryUtil.list(
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
	 * Returns the first descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByGroupId_First(
			long groupId, OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByGroupId_First(
			groupId, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the first descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByGroupId_First(
		long groupId, OrderByComparator<DescricaoDesafio> orderByComparator) {

		List<DescricaoDesafio> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio findByGroupId_Last(
			long groupId, OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (descricaoDesafio != null) {
			return descricaoDesafio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDescricaoDesafioException(sb.toString());
	}

	/**
	 * Returns the last descricao desafio in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descricao desafio, or <code>null</code> if a matching descricao desafio could not be found
	 */
	@Override
	public DescricaoDesafio fetchByGroupId_Last(
		long groupId, OrderByComparator<DescricaoDesafio> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DescricaoDesafio> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DescricaoDesafio[] findByGroupId_PrevAndNext(
			long descricaoDesafioId, long groupId,
			OrderByComparator<DescricaoDesafio> orderByComparator)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = findByPrimaryKey(
			descricaoDesafioId);

		Session session = null;

		try {
			session = openSession();

			DescricaoDesafio[] array = new DescricaoDesafioImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, descricaoDesafio, groupId, orderByComparator, true);

			array[1] = descricaoDesafio;

			array[2] = getByGroupId_PrevAndNext(
				session, descricaoDesafio, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DescricaoDesafio getByGroupId_PrevAndNext(
		Session session, DescricaoDesafio descricaoDesafio, long groupId,
		OrderByComparator<DescricaoDesafio> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESCRICAODESAFIO_WHERE);

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
			sb.append(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						descricaoDesafio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DescricaoDesafio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the descricao desafios where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (DescricaoDesafio descricaoDesafio :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(descricaoDesafio);
		}
	}

	/**
	 * Returns the number of descricao desafios where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching descricao desafios
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESCRICAODESAFIO_WHERE);

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
		"descricaoDesafio.groupId = ?";

	public DescricaoDesafioPersistenceImpl() {
		setModelClass(DescricaoDesafio.class);

		setModelImplClass(DescricaoDesafioImpl.class);
		setModelPKClass(long.class);

		setTable(DescricaoDesafioTable.INSTANCE);
	}

	/**
	 * Caches the descricao desafio in the entity cache if it is enabled.
	 *
	 * @param descricaoDesafio the descricao desafio
	 */
	@Override
	public void cacheResult(DescricaoDesafio descricaoDesafio) {
		entityCache.putResult(
			DescricaoDesafioImpl.class, descricaoDesafio.getPrimaryKey(),
			descricaoDesafio);

		finderCache.putResult(
			_finderPathFetchByFuncionarioId_TipoDesafio,
			new Object[] {
				descricaoDesafio.getFuncionarioId(),
				descricaoDesafio.getTipoDesafio()
			},
			descricaoDesafio);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the descricao desafios in the entity cache if it is enabled.
	 *
	 * @param descricaoDesafios the descricao desafios
	 */
	@Override
	public void cacheResult(List<DescricaoDesafio> descricaoDesafios) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (descricaoDesafios.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DescricaoDesafio descricaoDesafio : descricaoDesafios) {
			if (entityCache.getResult(
					DescricaoDesafioImpl.class,
					descricaoDesafio.getPrimaryKey()) == null) {

				cacheResult(descricaoDesafio);
			}
		}
	}

	/**
	 * Clears the cache for all descricao desafios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DescricaoDesafioImpl.class);

		finderCache.clearCache(DescricaoDesafioImpl.class);
	}

	/**
	 * Clears the cache for the descricao desafio.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DescricaoDesafio descricaoDesafio) {
		entityCache.removeResult(DescricaoDesafioImpl.class, descricaoDesafio);
	}

	@Override
	public void clearCache(List<DescricaoDesafio> descricaoDesafios) {
		for (DescricaoDesafio descricaoDesafio : descricaoDesafios) {
			entityCache.removeResult(
				DescricaoDesafioImpl.class, descricaoDesafio);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DescricaoDesafioImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DescricaoDesafioImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DescricaoDesafioModelImpl descricaoDesafioModelImpl) {

		Object[] args = new Object[] {
			descricaoDesafioModelImpl.getFuncionarioId(),
			descricaoDesafioModelImpl.getTipoDesafio()
		};

		finderCache.putResult(
			_finderPathFetchByFuncionarioId_TipoDesafio, args,
			descricaoDesafioModelImpl);
	}

	/**
	 * Creates a new descricao desafio with the primary key. Does not add the descricao desafio to the database.
	 *
	 * @param descricaoDesafioId the primary key for the new descricao desafio
	 * @return the new descricao desafio
	 */
	@Override
	public DescricaoDesafio create(long descricaoDesafioId) {
		DescricaoDesafio descricaoDesafio = new DescricaoDesafioImpl();

		descricaoDesafio.setNew(true);
		descricaoDesafio.setPrimaryKey(descricaoDesafioId);

		descricaoDesafio.setCompanyId(CompanyThreadLocal.getCompanyId());

		return descricaoDesafio;
	}

	/**
	 * Removes the descricao desafio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio that was removed
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	@Override
	public DescricaoDesafio remove(long descricaoDesafioId)
		throws NoSuchDescricaoDesafioException {

		return remove((Serializable)descricaoDesafioId);
	}

	/**
	 * Removes the descricao desafio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the descricao desafio
	 * @return the descricao desafio that was removed
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	@Override
	public DescricaoDesafio remove(Serializable primaryKey)
		throws NoSuchDescricaoDesafioException {

		Session session = null;

		try {
			session = openSession();

			DescricaoDesafio descricaoDesafio = (DescricaoDesafio)session.get(
				DescricaoDesafioImpl.class, primaryKey);

			if (descricaoDesafio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDescricaoDesafioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(descricaoDesafio);
		}
		catch (NoSuchDescricaoDesafioException noSuchEntityException) {
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
	protected DescricaoDesafio removeImpl(DescricaoDesafio descricaoDesafio) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(descricaoDesafio)) {
				descricaoDesafio = (DescricaoDesafio)session.get(
					DescricaoDesafioImpl.class,
					descricaoDesafio.getPrimaryKeyObj());
			}

			if (descricaoDesafio != null) {
				session.delete(descricaoDesafio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (descricaoDesafio != null) {
			clearCache(descricaoDesafio);
		}

		return descricaoDesafio;
	}

	@Override
	public DescricaoDesafio updateImpl(DescricaoDesafio descricaoDesafio) {
		boolean isNew = descricaoDesafio.isNew();

		if (!(descricaoDesafio instanceof DescricaoDesafioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(descricaoDesafio.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					descricaoDesafio);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in descricaoDesafio proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DescricaoDesafio implementation " +
					descricaoDesafio.getClass());
		}

		DescricaoDesafioModelImpl descricaoDesafioModelImpl =
			(DescricaoDesafioModelImpl)descricaoDesafio;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (descricaoDesafio.getCreateDate() == null)) {
			if (serviceContext == null) {
				descricaoDesafio.setCreateDate(date);
			}
			else {
				descricaoDesafio.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!descricaoDesafioModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				descricaoDesafio.setModifiedDate(date);
			}
			else {
				descricaoDesafio.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(descricaoDesafio);
			}
			else {
				descricaoDesafio = (DescricaoDesafio)session.merge(
					descricaoDesafio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DescricaoDesafioImpl.class, descricaoDesafioModelImpl, false, true);

		cacheUniqueFindersCache(descricaoDesafioModelImpl);

		if (isNew) {
			descricaoDesafio.setNew(false);
		}

		descricaoDesafio.resetOriginalValues();

		return descricaoDesafio;
	}

	/**
	 * Returns the descricao desafio with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the descricao desafio
	 * @return the descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	@Override
	public DescricaoDesafio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDescricaoDesafioException {

		DescricaoDesafio descricaoDesafio = fetchByPrimaryKey(primaryKey);

		if (descricaoDesafio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDescricaoDesafioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return descricaoDesafio;
	}

	/**
	 * Returns the descricao desafio with the primary key or throws a <code>NoSuchDescricaoDesafioException</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio
	 * @throws NoSuchDescricaoDesafioException if a descricao desafio with the primary key could not be found
	 */
	@Override
	public DescricaoDesafio findByPrimaryKey(long descricaoDesafioId)
		throws NoSuchDescricaoDesafioException {

		return findByPrimaryKey((Serializable)descricaoDesafioId);
	}

	/**
	 * Returns the descricao desafio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio, or <code>null</code> if a descricao desafio with the primary key could not be found
	 */
	@Override
	public DescricaoDesafio fetchByPrimaryKey(long descricaoDesafioId) {
		return fetchByPrimaryKey((Serializable)descricaoDesafioId);
	}

	/**
	 * Returns all the descricao desafios.
	 *
	 * @return the descricao desafios
	 */
	@Override
	public List<DescricaoDesafio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DescricaoDesafio> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DescricaoDesafio> findAll(
		int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DescricaoDesafio> findAll(
		int start, int end,
		OrderByComparator<DescricaoDesafio> orderByComparator,
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

		List<DescricaoDesafio> list = null;

		if (useFinderCache) {
			list = (List<DescricaoDesafio>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESCRICAODESAFIO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESCRICAODESAFIO;

				sql = sql.concat(DescricaoDesafioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DescricaoDesafio>)QueryUtil.list(
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
	 * Removes all the descricao desafios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DescricaoDesafio descricaoDesafio : findAll()) {
			remove(descricaoDesafio);
		}
	}

	/**
	 * Returns the number of descricao desafios.
	 *
	 * @return the number of descricao desafios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESCRICAODESAFIO);

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
		return "descricaoDesafioId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESCRICAODESAFIO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DescricaoDesafioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the descricao desafio persistence.
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

		_finderPathWithPaginationFindByDescricaoDesafioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDescricaoDesafioId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"descricaoDesafioId"}, true);

		_finderPathWithoutPaginationFindByDescricaoDesafioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDescricaoDesafioId", new String[] {Long.class.getName()},
			new String[] {"descricaoDesafioId"}, true);

		_finderPathCountByDescricaoDesafioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDescricaoDesafioId", new String[] {Long.class.getName()},
			new String[] {"descricaoDesafioId"}, false);

		_finderPathFetchByFuncionarioId_TipoDesafio = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFuncionarioId_TipoDesafio",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"funcionarioId", "tipoDesafio"}, true);

		_finderPathWithPaginationFindByTipoDesafio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoDesafio",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tipoDesafio"}, true);

		_finderPathWithoutPaginationFindByTipoDesafio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoDesafio",
			new String[] {Integer.class.getName()},
			new String[] {"tipoDesafio"}, true);

		_finderPathCountByTipoDesafio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoDesafio",
			new String[] {Integer.class.getName()},
			new String[] {"tipoDesafio"}, false);

		_finderPathWithPaginationFindByDataAvaliacaoBetween = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDataAvaliacaoBetween",
			new String[] {
				Date.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"dataAvaliacao", "dataAvaliacao"}, true);

		_finderPathWithPaginationCountByDataAvaliacaoBetween = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByDataAvaliacaoBetween",
			new String[] {Date.class.getName(), Date.class.getName()},
			new String[] {"dataAvaliacao", "dataAvaliacao"}, false);

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

		DescricaoDesafioUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DescricaoDesafioUtil.setPersistence(null);

		entityCache.removeCache(DescricaoDesafioImpl.class.getName());
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_DESCRICAODESAFIO =
		"SELECT descricaoDesafio FROM DescricaoDesafio descricaoDesafio";

	private static final String _SQL_SELECT_DESCRICAODESAFIO_WHERE =
		"SELECT descricaoDesafio FROM DescricaoDesafio descricaoDesafio WHERE ";

	private static final String _SQL_COUNT_DESCRICAODESAFIO =
		"SELECT COUNT(descricaoDesafio) FROM DescricaoDesafio descricaoDesafio";

	private static final String _SQL_COUNT_DESCRICAODESAFIO_WHERE =
		"SELECT COUNT(descricaoDesafio) FROM DescricaoDesafio descricaoDesafio WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "descricaoDesafio.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DescricaoDesafio exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DescricaoDesafio exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DescricaoDesafioPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}