/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.impl;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacaoDetalheException;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;
import br.com.example.model.avaliacao.model.AvaliacaoDetalheTable;
import br.com.example.model.avaliacao.model.impl.AvaliacaoDetalheImpl;
import br.com.example.model.avaliacao.model.impl.AvaliacaoDetalheModelImpl;
import br.com.example.model.avaliacao.service.persistence.AvaliacaoDetalhePersistence;
import br.com.example.model.avaliacao.service.persistence.AvaliacaoDetalheUtil;
import br.com.example.model.avaliacao.service.persistence.impl.constants.DESAFIOPersistenceConstants;

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
 * The persistence implementation for the avaliacao detalhe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AvaliacaoDetalhePersistence.class)
public class AvaliacaoDetalhePersistenceImpl
	extends BasePersistenceImpl<AvaliacaoDetalhe>
	implements AvaliacaoDetalhePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AvaliacaoDetalheUtil</code> to access the avaliacao detalhe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AvaliacaoDetalheImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAvaliacaoId;
	private FinderPath _finderPathWithoutPaginationFindByAvaliacaoId;
	private FinderPath _finderPathCountByAvaliacaoId;

	/**
	 * Returns all the avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @return the matching avaliacao detalhes
	 */
	@Override
	public List<AvaliacaoDetalhe> findByAvaliacaoId(long avaliacaoId) {
		return findByAvaliacaoId(
			avaliacaoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end) {

		return findByAvaliacaoId(avaliacaoId, start, end, null);
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
	@Override
	public List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		return findByAvaliacaoId(
			avaliacaoId, start, end, orderByComparator, true);
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
	@Override
	public List<AvaliacaoDetalhe> findByAvaliacaoId(
		long avaliacaoId, int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAvaliacaoId;
				finderArgs = new Object[] {avaliacaoId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAvaliacaoId;
			finderArgs = new Object[] {
				avaliacaoId, start, end, orderByComparator
			};
		}

		List<AvaliacaoDetalhe> list = null;

		if (useFinderCache) {
			list = (List<AvaliacaoDetalhe>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AvaliacaoDetalhe avaliacaoDetalhe : list) {
					if (avaliacaoId != avaliacaoDetalhe.getAvaliacaoId()) {
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

			sb.append(_SQL_SELECT_AVALIACAODETALHE_WHERE);

			sb.append(_FINDER_COLUMN_AVALIACAOID_AVALIACAOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AvaliacaoDetalheModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(avaliacaoId);

				list = (List<AvaliacaoDetalhe>)QueryUtil.list(
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
	 * Returns the first avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	@Override
	public AvaliacaoDetalhe findByAvaliacaoId_First(
			long avaliacaoId,
			OrderByComparator<AvaliacaoDetalhe> orderByComparator)
		throws NoSuchAvaliacaoDetalheException {

		AvaliacaoDetalhe avaliacaoDetalhe = fetchByAvaliacaoId_First(
			avaliacaoId, orderByComparator);

		if (avaliacaoDetalhe != null) {
			return avaliacaoDetalhe;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("avaliacaoId=");
		sb.append(avaliacaoId);

		sb.append("}");

		throw new NoSuchAvaliacaoDetalheException(sb.toString());
	}

	/**
	 * Returns the first avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	@Override
	public AvaliacaoDetalhe fetchByAvaliacaoId_First(
		long avaliacaoId,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		List<AvaliacaoDetalhe> list = findByAvaliacaoId(
			avaliacaoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	@Override
	public AvaliacaoDetalhe findByAvaliacaoId_Last(
			long avaliacaoId,
			OrderByComparator<AvaliacaoDetalhe> orderByComparator)
		throws NoSuchAvaliacaoDetalheException {

		AvaliacaoDetalhe avaliacaoDetalhe = fetchByAvaliacaoId_Last(
			avaliacaoId, orderByComparator);

		if (avaliacaoDetalhe != null) {
			return avaliacaoDetalhe;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("avaliacaoId=");
		sb.append(avaliacaoId);

		sb.append("}");

		throw new NoSuchAvaliacaoDetalheException(sb.toString());
	}

	/**
	 * Returns the last avaliacao detalhe in the ordered set where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	@Override
	public AvaliacaoDetalhe fetchByAvaliacaoId_Last(
		long avaliacaoId,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		int count = countByAvaliacaoId(avaliacaoId);

		if (count == 0) {
			return null;
		}

		List<AvaliacaoDetalhe> list = findByAvaliacaoId(
			avaliacaoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AvaliacaoDetalhe[] findByAvaliacaoId_PrevAndNext(
			long avaliacaoDetalheId, long avaliacaoId,
			OrderByComparator<AvaliacaoDetalhe> orderByComparator)
		throws NoSuchAvaliacaoDetalheException {

		AvaliacaoDetalhe avaliacaoDetalhe = findByPrimaryKey(
			avaliacaoDetalheId);

		Session session = null;

		try {
			session = openSession();

			AvaliacaoDetalhe[] array = new AvaliacaoDetalheImpl[3];

			array[0] = getByAvaliacaoId_PrevAndNext(
				session, avaliacaoDetalhe, avaliacaoId, orderByComparator,
				true);

			array[1] = avaliacaoDetalhe;

			array[2] = getByAvaliacaoId_PrevAndNext(
				session, avaliacaoDetalhe, avaliacaoId, orderByComparator,
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

	protected AvaliacaoDetalhe getByAvaliacaoId_PrevAndNext(
		Session session, AvaliacaoDetalhe avaliacaoDetalhe, long avaliacaoId,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator,
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

		sb.append(_SQL_SELECT_AVALIACAODETALHE_WHERE);

		sb.append(_FINDER_COLUMN_AVALIACAOID_AVALIACAOID_2);

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
			sb.append(AvaliacaoDetalheModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(avaliacaoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						avaliacaoDetalhe)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AvaliacaoDetalhe> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the avaliacao detalhes where avaliacaoId = &#63; from the database.
	 *
	 * @param avaliacaoId the avaliacao ID
	 */
	@Override
	public void removeByAvaliacaoId(long avaliacaoId) {
		for (AvaliacaoDetalhe avaliacaoDetalhe :
				findByAvaliacaoId(
					avaliacaoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(avaliacaoDetalhe);
		}
	}

	/**
	 * Returns the number of avaliacao detalhes where avaliacaoId = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @return the number of matching avaliacao detalhes
	 */
	@Override
	public int countByAvaliacaoId(long avaliacaoId) {
		FinderPath finderPath = _finderPathCountByAvaliacaoId;

		Object[] finderArgs = new Object[] {avaliacaoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AVALIACAODETALHE_WHERE);

			sb.append(_FINDER_COLUMN_AVALIACAOID_AVALIACAOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(avaliacaoId);

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

	private static final String _FINDER_COLUMN_AVALIACAOID_AVALIACAOID_2 =
		"avaliacaoDetalhe.avaliacaoId = ?";

	private FinderPath _finderPathFetchByAvaliacaoIdTipoAvaliador;

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or throws a <code>NoSuchAvaliacaoDetalheException</code> if it could not be found.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a matching avaliacao detalhe could not be found
	 */
	@Override
	public AvaliacaoDetalhe findByAvaliacaoIdTipoAvaliador(
			long avaliacaoId, String tipoAvaliador)
		throws NoSuchAvaliacaoDetalheException {

		AvaliacaoDetalhe avaliacaoDetalhe = fetchByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador);

		if (avaliacaoDetalhe == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("avaliacaoId=");
			sb.append(avaliacaoId);

			sb.append(", tipoAvaliador=");
			sb.append(tipoAvaliador);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAvaliacaoDetalheException(sb.toString());
		}

		return avaliacaoDetalhe;
	}

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	@Override
	public AvaliacaoDetalhe fetchByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, String tipoAvaliador) {

		return fetchByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador, true);
	}

	/**
	 * Returns the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacao detalhe, or <code>null</code> if a matching avaliacao detalhe could not be found
	 */
	@Override
	public AvaliacaoDetalhe fetchByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, String tipoAvaliador, boolean useFinderCache) {

		tipoAvaliador = Objects.toString(tipoAvaliador, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {avaliacaoId, tipoAvaliador};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByAvaliacaoIdTipoAvaliador, finderArgs, this);
		}

		if (result instanceof AvaliacaoDetalhe) {
			AvaliacaoDetalhe avaliacaoDetalhe = (AvaliacaoDetalhe)result;

			if ((avaliacaoId != avaliacaoDetalhe.getAvaliacaoId()) ||
				!Objects.equals(
					tipoAvaliador, avaliacaoDetalhe.getTipoAvaliador())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AVALIACAODETALHE_WHERE);

			sb.append(_FINDER_COLUMN_AVALIACAOIDTIPOAVALIADOR_AVALIACAOID_2);

			boolean bindTipoAvaliador = false;

			if (tipoAvaliador.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_AVALIACAOIDTIPOAVALIADOR_TIPOAVALIADOR_3);
			}
			else {
				bindTipoAvaliador = true;

				sb.append(
					_FINDER_COLUMN_AVALIACAOIDTIPOAVALIADOR_TIPOAVALIADOR_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(avaliacaoId);

				if (bindTipoAvaliador) {
					queryPos.add(tipoAvaliador);
				}

				List<AvaliacaoDetalhe> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByAvaliacaoIdTipoAvaliador,
							finderArgs, list);
					}
				}
				else {
					AvaliacaoDetalhe avaliacaoDetalhe = list.get(0);

					result = avaliacaoDetalhe;

					cacheResult(avaliacaoDetalhe);
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
			return (AvaliacaoDetalhe)result;
		}
	}

	/**
	 * Removes the avaliacao detalhe where avaliacaoId = &#63; and tipoAvaliador = &#63; from the database.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the avaliacao detalhe that was removed
	 */
	@Override
	public AvaliacaoDetalhe removeByAvaliacaoIdTipoAvaliador(
			long avaliacaoId, String tipoAvaliador)
		throws NoSuchAvaliacaoDetalheException {

		AvaliacaoDetalhe avaliacaoDetalhe = findByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador);

		return remove(avaliacaoDetalhe);
	}

	/**
	 * Returns the number of avaliacao detalhes where avaliacaoId = &#63; and tipoAvaliador = &#63;.
	 *
	 * @param avaliacaoId the avaliacao ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the number of matching avaliacao detalhes
	 */
	@Override
	public int countByAvaliacaoIdTipoAvaliador(
		long avaliacaoId, String tipoAvaliador) {

		AvaliacaoDetalhe avaliacaoDetalhe = fetchByAvaliacaoIdTipoAvaliador(
			avaliacaoId, tipoAvaliador);

		if (avaliacaoDetalhe == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_AVALIACAOIDTIPOAVALIADOR_AVALIACAOID_2 =
			"avaliacaoDetalhe.avaliacaoId = ? AND ";

	private static final String
		_FINDER_COLUMN_AVALIACAOIDTIPOAVALIADOR_TIPOAVALIADOR_2 =
			"avaliacaoDetalhe.tipoAvaliador = ?";

	private static final String
		_FINDER_COLUMN_AVALIACAOIDTIPOAVALIADOR_TIPOAVALIADOR_3 =
			"(avaliacaoDetalhe.tipoAvaliador IS NULL OR avaliacaoDetalhe.tipoAvaliador = '')";

	public AvaliacaoDetalhePersistenceImpl() {
		setModelClass(AvaliacaoDetalhe.class);

		setModelImplClass(AvaliacaoDetalheImpl.class);
		setModelPKClass(long.class);

		setTable(AvaliacaoDetalheTable.INSTANCE);
	}

	/**
	 * Caches the avaliacao detalhe in the entity cache if it is enabled.
	 *
	 * @param avaliacaoDetalhe the avaliacao detalhe
	 */
	@Override
	public void cacheResult(AvaliacaoDetalhe avaliacaoDetalhe) {
		entityCache.putResult(
			AvaliacaoDetalheImpl.class, avaliacaoDetalhe.getPrimaryKey(),
			avaliacaoDetalhe);

		finderCache.putResult(
			_finderPathFetchByAvaliacaoIdTipoAvaliador,
			new Object[] {
				avaliacaoDetalhe.getAvaliacaoId(),
				avaliacaoDetalhe.getTipoAvaliador()
			},
			avaliacaoDetalhe);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the avaliacao detalhes in the entity cache if it is enabled.
	 *
	 * @param avaliacaoDetalhes the avaliacao detalhes
	 */
	@Override
	public void cacheResult(List<AvaliacaoDetalhe> avaliacaoDetalhes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (avaliacaoDetalhes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AvaliacaoDetalhe avaliacaoDetalhe : avaliacaoDetalhes) {
			if (entityCache.getResult(
					AvaliacaoDetalheImpl.class,
					avaliacaoDetalhe.getPrimaryKey()) == null) {

				cacheResult(avaliacaoDetalhe);
			}
		}
	}

	/**
	 * Clears the cache for all avaliacao detalhes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AvaliacaoDetalheImpl.class);

		finderCache.clearCache(AvaliacaoDetalheImpl.class);
	}

	/**
	 * Clears the cache for the avaliacao detalhe.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AvaliacaoDetalhe avaliacaoDetalhe) {
		entityCache.removeResult(AvaliacaoDetalheImpl.class, avaliacaoDetalhe);
	}

	@Override
	public void clearCache(List<AvaliacaoDetalhe> avaliacaoDetalhes) {
		for (AvaliacaoDetalhe avaliacaoDetalhe : avaliacaoDetalhes) {
			entityCache.removeResult(
				AvaliacaoDetalheImpl.class, avaliacaoDetalhe);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AvaliacaoDetalheImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AvaliacaoDetalheImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AvaliacaoDetalheModelImpl avaliacaoDetalheModelImpl) {

		Object[] args = new Object[] {
			avaliacaoDetalheModelImpl.getAvaliacaoId(),
			avaliacaoDetalheModelImpl.getTipoAvaliador()
		};

		finderCache.putResult(
			_finderPathFetchByAvaliacaoIdTipoAvaliador, args,
			avaliacaoDetalheModelImpl);
	}

	/**
	 * Creates a new avaliacao detalhe with the primary key. Does not add the avaliacao detalhe to the database.
	 *
	 * @param avaliacaoDetalheId the primary key for the new avaliacao detalhe
	 * @return the new avaliacao detalhe
	 */
	@Override
	public AvaliacaoDetalhe create(long avaliacaoDetalheId) {
		AvaliacaoDetalhe avaliacaoDetalhe = new AvaliacaoDetalheImpl();

		avaliacaoDetalhe.setNew(true);
		avaliacaoDetalhe.setPrimaryKey(avaliacaoDetalheId);

		avaliacaoDetalhe.setCompanyId(CompanyThreadLocal.getCompanyId());

		return avaliacaoDetalhe;
	}

	/**
	 * Removes the avaliacao detalhe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe that was removed
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	@Override
	public AvaliacaoDetalhe remove(long avaliacaoDetalheId)
		throws NoSuchAvaliacaoDetalheException {

		return remove((Serializable)avaliacaoDetalheId);
	}

	/**
	 * Removes the avaliacao detalhe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe that was removed
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	@Override
	public AvaliacaoDetalhe remove(Serializable primaryKey)
		throws NoSuchAvaliacaoDetalheException {

		Session session = null;

		try {
			session = openSession();

			AvaliacaoDetalhe avaliacaoDetalhe = (AvaliacaoDetalhe)session.get(
				AvaliacaoDetalheImpl.class, primaryKey);

			if (avaliacaoDetalhe == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAvaliacaoDetalheException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(avaliacaoDetalhe);
		}
		catch (NoSuchAvaliacaoDetalheException noSuchEntityException) {
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
	protected AvaliacaoDetalhe removeImpl(AvaliacaoDetalhe avaliacaoDetalhe) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(avaliacaoDetalhe)) {
				avaliacaoDetalhe = (AvaliacaoDetalhe)session.get(
					AvaliacaoDetalheImpl.class,
					avaliacaoDetalhe.getPrimaryKeyObj());
			}

			if (avaliacaoDetalhe != null) {
				session.delete(avaliacaoDetalhe);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (avaliacaoDetalhe != null) {
			clearCache(avaliacaoDetalhe);
		}

		return avaliacaoDetalhe;
	}

	@Override
	public AvaliacaoDetalhe updateImpl(AvaliacaoDetalhe avaliacaoDetalhe) {
		boolean isNew = avaliacaoDetalhe.isNew();

		if (!(avaliacaoDetalhe instanceof AvaliacaoDetalheModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(avaliacaoDetalhe.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					avaliacaoDetalhe);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in avaliacaoDetalhe proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AvaliacaoDetalhe implementation " +
					avaliacaoDetalhe.getClass());
		}

		AvaliacaoDetalheModelImpl avaliacaoDetalheModelImpl =
			(AvaliacaoDetalheModelImpl)avaliacaoDetalhe;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (avaliacaoDetalhe.getCreateDate() == null)) {
			if (serviceContext == null) {
				avaliacaoDetalhe.setCreateDate(date);
			}
			else {
				avaliacaoDetalhe.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!avaliacaoDetalheModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				avaliacaoDetalhe.setModifiedDate(date);
			}
			else {
				avaliacaoDetalhe.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(avaliacaoDetalhe);
			}
			else {
				avaliacaoDetalhe = (AvaliacaoDetalhe)session.merge(
					avaliacaoDetalhe);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AvaliacaoDetalheImpl.class, avaliacaoDetalheModelImpl, false, true);

		cacheUniqueFindersCache(avaliacaoDetalheModelImpl);

		if (isNew) {
			avaliacaoDetalhe.setNew(false);
		}

		avaliacaoDetalhe.resetOriginalValues();

		return avaliacaoDetalhe;
	}

	/**
	 * Returns the avaliacao detalhe with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	@Override
	public AvaliacaoDetalhe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAvaliacaoDetalheException {

		AvaliacaoDetalhe avaliacaoDetalhe = fetchByPrimaryKey(primaryKey);

		if (avaliacaoDetalhe == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAvaliacaoDetalheException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return avaliacaoDetalhe;
	}

	/**
	 * Returns the avaliacao detalhe with the primary key or throws a <code>NoSuchAvaliacaoDetalheException</code> if it could not be found.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe
	 * @throws NoSuchAvaliacaoDetalheException if a avaliacao detalhe with the primary key could not be found
	 */
	@Override
	public AvaliacaoDetalhe findByPrimaryKey(long avaliacaoDetalheId)
		throws NoSuchAvaliacaoDetalheException {

		return findByPrimaryKey((Serializable)avaliacaoDetalheId);
	}

	/**
	 * Returns the avaliacao detalhe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe, or <code>null</code> if a avaliacao detalhe with the primary key could not be found
	 */
	@Override
	public AvaliacaoDetalhe fetchByPrimaryKey(long avaliacaoDetalheId) {
		return fetchByPrimaryKey((Serializable)avaliacaoDetalheId);
	}

	/**
	 * Returns all the avaliacao detalhes.
	 *
	 * @return the avaliacao detalhes
	 */
	@Override
	public List<AvaliacaoDetalhe> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AvaliacaoDetalhe> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AvaliacaoDetalhe> findAll(
		int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AvaliacaoDetalhe> findAll(
		int start, int end,
		OrderByComparator<AvaliacaoDetalhe> orderByComparator,
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

		List<AvaliacaoDetalhe> list = null;

		if (useFinderCache) {
			list = (List<AvaliacaoDetalhe>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AVALIACAODETALHE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AVALIACAODETALHE;

				sql = sql.concat(AvaliacaoDetalheModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AvaliacaoDetalhe>)QueryUtil.list(
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
	 * Removes all the avaliacao detalhes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AvaliacaoDetalhe avaliacaoDetalhe : findAll()) {
			remove(avaliacaoDetalhe);
		}
	}

	/**
	 * Returns the number of avaliacao detalhes.
	 *
	 * @return the number of avaliacao detalhes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AVALIACAODETALHE);

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
		return "avaliacaoDetalheId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AVALIACAODETALHE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AvaliacaoDetalheModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the avaliacao detalhe persistence.
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

		_finderPathWithPaginationFindByAvaliacaoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAvaliacaoId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"avaliacaoId"}, true);

		_finderPathWithoutPaginationFindByAvaliacaoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAvaliacaoId",
			new String[] {Long.class.getName()}, new String[] {"avaliacaoId"},
			true);

		_finderPathCountByAvaliacaoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAvaliacaoId",
			new String[] {Long.class.getName()}, new String[] {"avaliacaoId"},
			false);

		_finderPathFetchByAvaliacaoIdTipoAvaliador = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAvaliacaoIdTipoAvaliador",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"avaliacaoId", "tipoAvaliador"}, true);

		AvaliacaoDetalheUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AvaliacaoDetalheUtil.setPersistence(null);

		entityCache.removeCache(AvaliacaoDetalheImpl.class.getName());
	}

	@Override
	@Reference(
		target = DESAFIOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DESAFIOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DESAFIOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AVALIACAODETALHE =
		"SELECT avaliacaoDetalhe FROM AvaliacaoDetalhe avaliacaoDetalhe";

	private static final String _SQL_SELECT_AVALIACAODETALHE_WHERE =
		"SELECT avaliacaoDetalhe FROM AvaliacaoDetalhe avaliacaoDetalhe WHERE ";

	private static final String _SQL_COUNT_AVALIACAODETALHE =
		"SELECT COUNT(avaliacaoDetalhe) FROM AvaliacaoDetalhe avaliacaoDetalhe";

	private static final String _SQL_COUNT_AVALIACAODETALHE_WHERE =
		"SELECT COUNT(avaliacaoDetalhe) FROM AvaliacaoDetalhe avaliacaoDetalhe WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "avaliacaoDetalhe.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AvaliacaoDetalhe exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AvaliacaoDetalhe exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AvaliacaoDetalhePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}