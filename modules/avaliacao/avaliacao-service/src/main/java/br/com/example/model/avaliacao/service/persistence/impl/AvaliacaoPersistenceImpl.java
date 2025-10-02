/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.impl;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacaoException;
import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.model.AvaliacaoTable;
import br.com.example.model.avaliacao.model.impl.AvaliacaoImpl;
import br.com.example.model.avaliacao.model.impl.AvaliacaoModelImpl;
import br.com.example.model.avaliacao.service.persistence.AvaliacaoPersistence;
import br.com.example.model.avaliacao.service.persistence.AvaliacaoUtil;
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
 * The persistence implementation for the avaliacao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AvaliacaoPersistence.class)
public class AvaliacaoPersistenceImpl
	extends BasePersistenceImpl<Avaliacao> implements AvaliacaoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AvaliacaoUtil</code> to access the avaliacao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AvaliacaoImpl.class.getName();

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
	 * Returns all the avaliacaos where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the matching avaliacaos
	 */
	@Override
	public List<Avaliacao> findByFuncionarioId(long funcionarioId) {
		return findByFuncionarioId(
			funcionarioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end) {

		return findByFuncionarioId(funcionarioId, start, end, null);
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
	@Override
	public List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator) {

		return findByFuncionarioId(
			funcionarioId, start, end, orderByComparator, true);
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
	@Override
	public List<Avaliacao> findByFuncionarioId(
		long funcionarioId, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator,
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

		List<Avaliacao> list = null;

		if (useFinderCache) {
			list = (List<Avaliacao>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Avaliacao avaliacao : list) {
					if (funcionarioId != avaliacao.getFuncionarioId()) {
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

			sb.append(_SQL_SELECT_AVALIACAO_WHERE);

			sb.append(_FINDER_COLUMN_FUNCIONARIOID_FUNCIONARIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AvaliacaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(funcionarioId);

				list = (List<Avaliacao>)QueryUtil.list(
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
	 * Returns the first avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByFuncionarioId_First(
			long funcionarioId, OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByFuncionarioId_First(
			funcionarioId, orderByComparator);

		if (avaliacao != null) {
			return avaliacao;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("funcionarioId=");
		sb.append(funcionarioId);

		sb.append("}");

		throw new NoSuchAvaliacaoException(sb.toString());
	}

	/**
	 * Returns the first avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByFuncionarioId_First(
		long funcionarioId, OrderByComparator<Avaliacao> orderByComparator) {

		List<Avaliacao> list = findByFuncionarioId(
			funcionarioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByFuncionarioId_Last(
			long funcionarioId, OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByFuncionarioId_Last(
			funcionarioId, orderByComparator);

		if (avaliacao != null) {
			return avaliacao;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("funcionarioId=");
		sb.append(funcionarioId);

		sb.append("}");

		throw new NoSuchAvaliacaoException(sb.toString());
	}

	/**
	 * Returns the last avaliacao in the ordered set where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByFuncionarioId_Last(
		long funcionarioId, OrderByComparator<Avaliacao> orderByComparator) {

		int count = countByFuncionarioId(funcionarioId);

		if (count == 0) {
			return null;
		}

		List<Avaliacao> list = findByFuncionarioId(
			funcionarioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Avaliacao[] findByFuncionarioId_PrevAndNext(
			long avaliacaoId, long funcionarioId,
			OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = findByPrimaryKey(avaliacaoId);

		Session session = null;

		try {
			session = openSession();

			Avaliacao[] array = new AvaliacaoImpl[3];

			array[0] = getByFuncionarioId_PrevAndNext(
				session, avaliacao, funcionarioId, orderByComparator, true);

			array[1] = avaliacao;

			array[2] = getByFuncionarioId_PrevAndNext(
				session, avaliacao, funcionarioId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Avaliacao getByFuncionarioId_PrevAndNext(
		Session session, Avaliacao avaliacao, long funcionarioId,
		OrderByComparator<Avaliacao> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AVALIACAO_WHERE);

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
			sb.append(AvaliacaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(funcionarioId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(avaliacao)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Avaliacao> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the avaliacaos where funcionarioId = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 */
	@Override
	public void removeByFuncionarioId(long funcionarioId) {
		for (Avaliacao avaliacao :
				findByFuncionarioId(
					funcionarioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(avaliacao);
		}
	}

	/**
	 * Returns the number of avaliacaos where funcionarioId = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @return the number of matching avaliacaos
	 */
	@Override
	public int countByFuncionarioId(long funcionarioId) {
		FinderPath finderPath = _finderPathCountByFuncionarioId;

		Object[] finderArgs = new Object[] {funcionarioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AVALIACAO_WHERE);

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
		"avaliacao.funcionarioId = ?";

	private FinderPath _finderPathFetchByFuncionarioIdPeriodoDesafio;

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or throws a <code>NoSuchAvaliacaoException</code> if it could not be found.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByFuncionarioIdPeriodoDesafio(
			long funcionarioId, int periodoDesafio)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio);

		if (avaliacao == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("funcionarioId=");
			sb.append(funcionarioId);

			sb.append(", periodoDesafio=");
			sb.append(periodoDesafio);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAvaliacaoException(sb.toString());
		}

		return avaliacao;
	}

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio) {

		return fetchByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio, true);
	}

	/**
	 * Returns the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {funcionarioId, periodoDesafio};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFuncionarioIdPeriodoDesafio, finderArgs,
				this);
		}

		if (result instanceof Avaliacao) {
			Avaliacao avaliacao = (Avaliacao)result;

			if ((funcionarioId != avaliacao.getFuncionarioId()) ||
				(periodoDesafio != avaliacao.getPeriodoDesafio())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AVALIACAO_WHERE);

			sb.append(
				_FINDER_COLUMN_FUNCIONARIOIDPERIODODESAFIO_FUNCIONARIOID_2);

			sb.append(
				_FINDER_COLUMN_FUNCIONARIOIDPERIODODESAFIO_PERIODODESAFIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(funcionarioId);

				queryPos.add(periodoDesafio);

				List<Avaliacao> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFuncionarioIdPeriodoDesafio,
							finderArgs, list);
					}
				}
				else {
					Avaliacao avaliacao = list.get(0);

					result = avaliacao;

					cacheResult(avaliacao);
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
			return (Avaliacao)result;
		}
	}

	/**
	 * Removes the avaliacao where funcionarioId = &#63; and periodoDesafio = &#63; from the database.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the avaliacao that was removed
	 */
	@Override
	public Avaliacao removeByFuncionarioIdPeriodoDesafio(
			long funcionarioId, int periodoDesafio)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = findByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio);

		return remove(avaliacao);
	}

	/**
	 * Returns the number of avaliacaos where funcionarioId = &#63; and periodoDesafio = &#63;.
	 *
	 * @param funcionarioId the funcionario ID
	 * @param periodoDesafio the periodo desafio
	 * @return the number of matching avaliacaos
	 */
	@Override
	public int countByFuncionarioIdPeriodoDesafio(
		long funcionarioId, int periodoDesafio) {

		Avaliacao avaliacao = fetchByFuncionarioIdPeriodoDesafio(
			funcionarioId, periodoDesafio);

		if (avaliacao == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_FUNCIONARIOIDPERIODODESAFIO_FUNCIONARIOID_2 =
			"avaliacao.funcionarioId = ? AND ";

	private static final String
		_FINDER_COLUMN_FUNCIONARIOIDPERIODODESAFIO_PERIODODESAFIO_2 =
			"avaliacao.periodoDesafio = ?";

	private FinderPath _finderPathWithPaginationFindByPeriodoDesafio;
	private FinderPath _finderPathWithoutPaginationFindByPeriodoDesafio;
	private FinderPath _finderPathCountByPeriodoDesafio;

	/**
	 * Returns all the avaliacaos where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @return the matching avaliacaos
	 */
	@Override
	public List<Avaliacao> findByPeriodoDesafio(int periodoDesafio) {
		return findByPeriodoDesafio(
			periodoDesafio, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end) {

		return findByPeriodoDesafio(periodoDesafio, start, end, null);
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
	@Override
	public List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator) {

		return findByPeriodoDesafio(
			periodoDesafio, start, end, orderByComparator, true);
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
	@Override
	public List<Avaliacao> findByPeriodoDesafio(
		int periodoDesafio, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPeriodoDesafio;
				finderArgs = new Object[] {periodoDesafio};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPeriodoDesafio;
			finderArgs = new Object[] {
				periodoDesafio, start, end, orderByComparator
			};
		}

		List<Avaliacao> list = null;

		if (useFinderCache) {
			list = (List<Avaliacao>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Avaliacao avaliacao : list) {
					if (periodoDesafio != avaliacao.getPeriodoDesafio()) {
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

			sb.append(_SQL_SELECT_AVALIACAO_WHERE);

			sb.append(_FINDER_COLUMN_PERIODODESAFIO_PERIODODESAFIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AvaliacaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(periodoDesafio);

				list = (List<Avaliacao>)QueryUtil.list(
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
	 * Returns the first avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByPeriodoDesafio_First(
			int periodoDesafio, OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByPeriodoDesafio_First(
			periodoDesafio, orderByComparator);

		if (avaliacao != null) {
			return avaliacao;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("periodoDesafio=");
		sb.append(periodoDesafio);

		sb.append("}");

		throw new NoSuchAvaliacaoException(sb.toString());
	}

	/**
	 * Returns the first avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByPeriodoDesafio_First(
		int periodoDesafio, OrderByComparator<Avaliacao> orderByComparator) {

		List<Avaliacao> list = findByPeriodoDesafio(
			periodoDesafio, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByPeriodoDesafio_Last(
			int periodoDesafio, OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByPeriodoDesafio_Last(
			periodoDesafio, orderByComparator);

		if (avaliacao != null) {
			return avaliacao;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("periodoDesafio=");
		sb.append(periodoDesafio);

		sb.append("}");

		throw new NoSuchAvaliacaoException(sb.toString());
	}

	/**
	 * Returns the last avaliacao in the ordered set where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByPeriodoDesafio_Last(
		int periodoDesafio, OrderByComparator<Avaliacao> orderByComparator) {

		int count = countByPeriodoDesafio(periodoDesafio);

		if (count == 0) {
			return null;
		}

		List<Avaliacao> list = findByPeriodoDesafio(
			periodoDesafio, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Avaliacao[] findByPeriodoDesafio_PrevAndNext(
			long avaliacaoId, int periodoDesafio,
			OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = findByPrimaryKey(avaliacaoId);

		Session session = null;

		try {
			session = openSession();

			Avaliacao[] array = new AvaliacaoImpl[3];

			array[0] = getByPeriodoDesafio_PrevAndNext(
				session, avaliacao, periodoDesafio, orderByComparator, true);

			array[1] = avaliacao;

			array[2] = getByPeriodoDesafio_PrevAndNext(
				session, avaliacao, periodoDesafio, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Avaliacao getByPeriodoDesafio_PrevAndNext(
		Session session, Avaliacao avaliacao, int periodoDesafio,
		OrderByComparator<Avaliacao> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AVALIACAO_WHERE);

		sb.append(_FINDER_COLUMN_PERIODODESAFIO_PERIODODESAFIO_2);

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
			sb.append(AvaliacaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(periodoDesafio);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(avaliacao)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Avaliacao> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the avaliacaos where periodoDesafio = &#63; from the database.
	 *
	 * @param periodoDesafio the periodo desafio
	 */
	@Override
	public void removeByPeriodoDesafio(int periodoDesafio) {
		for (Avaliacao avaliacao :
				findByPeriodoDesafio(
					periodoDesafio, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(avaliacao);
		}
	}

	/**
	 * Returns the number of avaliacaos where periodoDesafio = &#63;.
	 *
	 * @param periodoDesafio the periodo desafio
	 * @return the number of matching avaliacaos
	 */
	@Override
	public int countByPeriodoDesafio(int periodoDesafio) {
		FinderPath finderPath = _finderPathCountByPeriodoDesafio;

		Object[] finderArgs = new Object[] {periodoDesafio};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AVALIACAO_WHERE);

			sb.append(_FINDER_COLUMN_PERIODODESAFIO_PERIODODESAFIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(periodoDesafio);

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

	private static final String _FINDER_COLUMN_PERIODODESAFIO_PERIODODESAFIO_2 =
		"avaliacao.periodoDesafio = ?";

	private FinderPath _finderPathWithPaginationFindByDataAvaliacaoBetween;
	private FinderPath _finderPathWithPaginationCountByDataAvaliacaoBetween;

	/**
	 * Returns all the avaliacaos where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @return the matching avaliacaos
	 */
	@Override
	public List<Avaliacao> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao) {

		return findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the avaliacaos where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @return the range of matching avaliacaos
	 */
	@Override
	public List<Avaliacao> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end) {

		return findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, start, end, null);
	}

	/**
	 * Returns an ordered range of all the avaliacaos where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching avaliacaos
	 */
	@Override
	public List<Avaliacao> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator) {

		return findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the avaliacaos where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching avaliacaos
	 */
	@Override
	public List<Avaliacao> findByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByDataAvaliacaoBetween;
		finderArgs = new Object[] {
			_getTime(dataAvaliacao), _getTime(dataAvaliacao), start, end,
			orderByComparator
		};

		List<Avaliacao> list = null;

		if (useFinderCache) {
			list = (List<Avaliacao>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Avaliacao avaliacao : list) {
					if ((dataAvaliacao.getTime() > avaliacao.getDataAvaliacao(
						).getTime()) ||
						(dataAvaliacao.getTime() < avaliacao.getDataAvaliacao(
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

			sb.append(_SQL_SELECT_AVALIACAO_WHERE);

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
				sb.append(AvaliacaoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Avaliacao>)QueryUtil.list(
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
	 * Returns the first avaliacao in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByDataAvaliacaoBetween_First(
			Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByDataAvaliacaoBetween_First(
			dataAvaliacao, dataAvaliacao, orderByComparator);

		if (avaliacao != null) {
			return avaliacao;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataAvaliacao>=");
		sb.append(dataAvaliacao);

		sb.append(", dataAvaliacao<=");
		sb.append(dataAvaliacao);

		sb.append("}");

		throw new NoSuchAvaliacaoException(sb.toString());
	}

	/**
	 * Returns the first avaliacao in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByDataAvaliacaoBetween_First(
		Date dataAvaliacao, Date dataAvaliacao,
		OrderByComparator<Avaliacao> orderByComparator) {

		List<Avaliacao> list = findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last avaliacao in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByDataAvaliacaoBetween_Last(
			Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByDataAvaliacaoBetween_Last(
			dataAvaliacao, dataAvaliacao, orderByComparator);

		if (avaliacao != null) {
			return avaliacao;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataAvaliacao>=");
		sb.append(dataAvaliacao);

		sb.append(", dataAvaliacao<=");
		sb.append(dataAvaliacao);

		sb.append("}");

		throw new NoSuchAvaliacaoException(sb.toString());
	}

	/**
	 * Returns the last avaliacao in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByDataAvaliacaoBetween_Last(
		Date dataAvaliacao, Date dataAvaliacao,
		OrderByComparator<Avaliacao> orderByComparator) {

		int count = countByDataAvaliacaoBetween(dataAvaliacao, dataAvaliacao);

		if (count == 0) {
			return null;
		}

		List<Avaliacao> list = findByDataAvaliacaoBetween(
			dataAvaliacao, dataAvaliacao, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the avaliacaos before and after the current avaliacao in the ordered set where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param avaliacaoId the primary key of the current avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	@Override
	public Avaliacao[] findByDataAvaliacaoBetween_PrevAndNext(
			long avaliacaoId, Date dataAvaliacao, Date dataAvaliacao,
			OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = findByPrimaryKey(avaliacaoId);

		Session session = null;

		try {
			session = openSession();

			Avaliacao[] array = new AvaliacaoImpl[3];

			array[0] = getByDataAvaliacaoBetween_PrevAndNext(
				session, avaliacao, dataAvaliacao, dataAvaliacao,
				orderByComparator, true);

			array[1] = avaliacao;

			array[2] = getByDataAvaliacaoBetween_PrevAndNext(
				session, avaliacao, dataAvaliacao, dataAvaliacao,
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

	protected Avaliacao getByDataAvaliacaoBetween_PrevAndNext(
		Session session, Avaliacao avaliacao, Date dataAvaliacao,
		Date dataAvaliacao, OrderByComparator<Avaliacao> orderByComparator,
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

		sb.append(_SQL_SELECT_AVALIACAO_WHERE);

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
			sb.append(AvaliacaoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(avaliacao)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Avaliacao> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the avaliacaos where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63; from the database.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 */
	@Override
	public void removeByDataAvaliacaoBetween(
		Date dataAvaliacao, Date dataAvaliacao) {

		for (Avaliacao avaliacao :
				findByDataAvaliacaoBetween(
					dataAvaliacao, dataAvaliacao, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(avaliacao);
		}
	}

	/**
	 * Returns the number of avaliacaos where dataAvaliacao &ge; &#63; and dataAvaliacao &le; &#63;.
	 *
	 * @param dataAvaliacao the data avaliacao
	 * @param dataAvaliacao the data avaliacao
	 * @return the number of matching avaliacaos
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

			sb.append(_SQL_COUNT_AVALIACAO_WHERE);

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
			"avaliacao.dataAvaliacao IS NULL AND ";

	private static final String
		_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2 =
			"avaliacao.dataAvaliacao >= ? AND ";

	private static final String
		_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_1 =
			"avaliacao.dataAvaliacao IS NULL";

	private static final String
		_FINDER_COLUMN_DATAAVALIACAOBETWEEN_DATAAVALIACAO_2 =
			"avaliacao.dataAvaliacao <= ?";

	private FinderPath _finderPathWithPaginationFindByAreaAtuacao;
	private FinderPath _finderPathWithoutPaginationFindByAreaAtuacao;
	private FinderPath _finderPathCountByAreaAtuacao;

	/**
	 * Returns all the avaliacaos where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the matching avaliacaos
	 */
	@Override
	public List<Avaliacao> findByAreaAtuacao(int areaAtuacao) {
		return findByAreaAtuacao(
			areaAtuacao, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end) {

		return findByAreaAtuacao(areaAtuacao, start, end, null);
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
	@Override
	public List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator) {

		return findByAreaAtuacao(
			areaAtuacao, start, end, orderByComparator, true);
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
	@Override
	public List<Avaliacao> findByAreaAtuacao(
		int areaAtuacao, int start, int end,
		OrderByComparator<Avaliacao> orderByComparator,
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

		List<Avaliacao> list = null;

		if (useFinderCache) {
			list = (List<Avaliacao>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Avaliacao avaliacao : list) {
					if (areaAtuacao != avaliacao.getAreaAtuacao()) {
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

			sb.append(_SQL_SELECT_AVALIACAO_WHERE);

			sb.append(_FINDER_COLUMN_AREAATUACAO_AREAATUACAO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AvaliacaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(areaAtuacao);

				list = (List<Avaliacao>)QueryUtil.list(
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
	 * Returns the first avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByAreaAtuacao_First(
			int areaAtuacao, OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByAreaAtuacao_First(
			areaAtuacao, orderByComparator);

		if (avaliacao != null) {
			return avaliacao;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("areaAtuacao=");
		sb.append(areaAtuacao);

		sb.append("}");

		throw new NoSuchAvaliacaoException(sb.toString());
	}

	/**
	 * Returns the first avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByAreaAtuacao_First(
		int areaAtuacao, OrderByComparator<Avaliacao> orderByComparator) {

		List<Avaliacao> list = findByAreaAtuacao(
			areaAtuacao, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao
	 * @throws NoSuchAvaliacaoException if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao findByAreaAtuacao_Last(
			int areaAtuacao, OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByAreaAtuacao_Last(
			areaAtuacao, orderByComparator);

		if (avaliacao != null) {
			return avaliacao;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("areaAtuacao=");
		sb.append(areaAtuacao);

		sb.append("}");

		throw new NoSuchAvaliacaoException(sb.toString());
	}

	/**
	 * Returns the last avaliacao in the ordered set where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacao, or <code>null</code> if a matching avaliacao could not be found
	 */
	@Override
	public Avaliacao fetchByAreaAtuacao_Last(
		int areaAtuacao, OrderByComparator<Avaliacao> orderByComparator) {

		int count = countByAreaAtuacao(areaAtuacao);

		if (count == 0) {
			return null;
		}

		List<Avaliacao> list = findByAreaAtuacao(
			areaAtuacao, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Avaliacao[] findByAreaAtuacao_PrevAndNext(
			long avaliacaoId, int areaAtuacao,
			OrderByComparator<Avaliacao> orderByComparator)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = findByPrimaryKey(avaliacaoId);

		Session session = null;

		try {
			session = openSession();

			Avaliacao[] array = new AvaliacaoImpl[3];

			array[0] = getByAreaAtuacao_PrevAndNext(
				session, avaliacao, areaAtuacao, orderByComparator, true);

			array[1] = avaliacao;

			array[2] = getByAreaAtuacao_PrevAndNext(
				session, avaliacao, areaAtuacao, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Avaliacao getByAreaAtuacao_PrevAndNext(
		Session session, Avaliacao avaliacao, int areaAtuacao,
		OrderByComparator<Avaliacao> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AVALIACAO_WHERE);

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
			sb.append(AvaliacaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(areaAtuacao);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(avaliacao)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Avaliacao> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the avaliacaos where areaAtuacao = &#63; from the database.
	 *
	 * @param areaAtuacao the area atuacao
	 */
	@Override
	public void removeByAreaAtuacao(int areaAtuacao) {
		for (Avaliacao avaliacao :
				findByAreaAtuacao(
					areaAtuacao, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(avaliacao);
		}
	}

	/**
	 * Returns the number of avaliacaos where areaAtuacao = &#63;.
	 *
	 * @param areaAtuacao the area atuacao
	 * @return the number of matching avaliacaos
	 */
	@Override
	public int countByAreaAtuacao(int areaAtuacao) {
		FinderPath finderPath = _finderPathCountByAreaAtuacao;

		Object[] finderArgs = new Object[] {areaAtuacao};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AVALIACAO_WHERE);

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
		"avaliacao.areaAtuacao = ?";

	public AvaliacaoPersistenceImpl() {
		setModelClass(Avaliacao.class);

		setModelImplClass(AvaliacaoImpl.class);
		setModelPKClass(long.class);

		setTable(AvaliacaoTable.INSTANCE);
	}

	/**
	 * Caches the avaliacao in the entity cache if it is enabled.
	 *
	 * @param avaliacao the avaliacao
	 */
	@Override
	public void cacheResult(Avaliacao avaliacao) {
		entityCache.putResult(
			AvaliacaoImpl.class, avaliacao.getPrimaryKey(), avaliacao);

		finderCache.putResult(
			_finderPathFetchByFuncionarioIdPeriodoDesafio,
			new Object[] {
				avaliacao.getFuncionarioId(), avaliacao.getPeriodoDesafio()
			},
			avaliacao);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the avaliacaos in the entity cache if it is enabled.
	 *
	 * @param avaliacaos the avaliacaos
	 */
	@Override
	public void cacheResult(List<Avaliacao> avaliacaos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (avaliacaos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Avaliacao avaliacao : avaliacaos) {
			if (entityCache.getResult(
					AvaliacaoImpl.class, avaliacao.getPrimaryKey()) == null) {

				cacheResult(avaliacao);
			}
		}
	}

	/**
	 * Clears the cache for all avaliacaos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AvaliacaoImpl.class);

		finderCache.clearCache(AvaliacaoImpl.class);
	}

	/**
	 * Clears the cache for the avaliacao.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Avaliacao avaliacao) {
		entityCache.removeResult(AvaliacaoImpl.class, avaliacao);
	}

	@Override
	public void clearCache(List<Avaliacao> avaliacaos) {
		for (Avaliacao avaliacao : avaliacaos) {
			entityCache.removeResult(AvaliacaoImpl.class, avaliacao);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AvaliacaoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AvaliacaoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AvaliacaoModelImpl avaliacaoModelImpl) {

		Object[] args = new Object[] {
			avaliacaoModelImpl.getFuncionarioId(),
			avaliacaoModelImpl.getPeriodoDesafio()
		};

		finderCache.putResult(
			_finderPathFetchByFuncionarioIdPeriodoDesafio, args,
			avaliacaoModelImpl);
	}

	/**
	 * Creates a new avaliacao with the primary key. Does not add the avaliacao to the database.
	 *
	 * @param avaliacaoId the primary key for the new avaliacao
	 * @return the new avaliacao
	 */
	@Override
	public Avaliacao create(long avaliacaoId) {
		Avaliacao avaliacao = new AvaliacaoImpl();

		avaliacao.setNew(true);
		avaliacao.setPrimaryKey(avaliacaoId);

		avaliacao.setCompanyId(CompanyThreadLocal.getCompanyId());

		return avaliacao;
	}

	/**
	 * Removes the avaliacao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao that was removed
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	@Override
	public Avaliacao remove(long avaliacaoId) throws NoSuchAvaliacaoException {
		return remove((Serializable)avaliacaoId);
	}

	/**
	 * Removes the avaliacao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the avaliacao
	 * @return the avaliacao that was removed
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	@Override
	public Avaliacao remove(Serializable primaryKey)
		throws NoSuchAvaliacaoException {

		Session session = null;

		try {
			session = openSession();

			Avaliacao avaliacao = (Avaliacao)session.get(
				AvaliacaoImpl.class, primaryKey);

			if (avaliacao == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAvaliacaoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(avaliacao);
		}
		catch (NoSuchAvaliacaoException noSuchEntityException) {
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
	protected Avaliacao removeImpl(Avaliacao avaliacao) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(avaliacao)) {
				avaliacao = (Avaliacao)session.get(
					AvaliacaoImpl.class, avaliacao.getPrimaryKeyObj());
			}

			if (avaliacao != null) {
				session.delete(avaliacao);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (avaliacao != null) {
			clearCache(avaliacao);
		}

		return avaliacao;
	}

	@Override
	public Avaliacao updateImpl(Avaliacao avaliacao) {
		boolean isNew = avaliacao.isNew();

		if (!(avaliacao instanceof AvaliacaoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(avaliacao.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(avaliacao);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in avaliacao proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Avaliacao implementation " +
					avaliacao.getClass());
		}

		AvaliacaoModelImpl avaliacaoModelImpl = (AvaliacaoModelImpl)avaliacao;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (avaliacao.getCreateDate() == null)) {
			if (serviceContext == null) {
				avaliacao.setCreateDate(date);
			}
			else {
				avaliacao.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!avaliacaoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				avaliacao.setModifiedDate(date);
			}
			else {
				avaliacao.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(avaliacao);
			}
			else {
				avaliacao = (Avaliacao)session.merge(avaliacao);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AvaliacaoImpl.class, avaliacaoModelImpl, false, true);

		cacheUniqueFindersCache(avaliacaoModelImpl);

		if (isNew) {
			avaliacao.setNew(false);
		}

		avaliacao.resetOriginalValues();

		return avaliacao;
	}

	/**
	 * Returns the avaliacao with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the avaliacao
	 * @return the avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	@Override
	public Avaliacao findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAvaliacaoException {

		Avaliacao avaliacao = fetchByPrimaryKey(primaryKey);

		if (avaliacao == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAvaliacaoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return avaliacao;
	}

	/**
	 * Returns the avaliacao with the primary key or throws a <code>NoSuchAvaliacaoException</code> if it could not be found.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao
	 * @throws NoSuchAvaliacaoException if a avaliacao with the primary key could not be found
	 */
	@Override
	public Avaliacao findByPrimaryKey(long avaliacaoId)
		throws NoSuchAvaliacaoException {

		return findByPrimaryKey((Serializable)avaliacaoId);
	}

	/**
	 * Returns the avaliacao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao, or <code>null</code> if a avaliacao with the primary key could not be found
	 */
	@Override
	public Avaliacao fetchByPrimaryKey(long avaliacaoId) {
		return fetchByPrimaryKey((Serializable)avaliacaoId);
	}

	/**
	 * Returns all the avaliacaos.
	 *
	 * @return the avaliacaos
	 */
	@Override
	public List<Avaliacao> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Avaliacao> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Avaliacao> findAll(
		int start, int end, OrderByComparator<Avaliacao> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Avaliacao> findAll(
		int start, int end, OrderByComparator<Avaliacao> orderByComparator,
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

		List<Avaliacao> list = null;

		if (useFinderCache) {
			list = (List<Avaliacao>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AVALIACAO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AVALIACAO;

				sql = sql.concat(AvaliacaoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Avaliacao>)QueryUtil.list(
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
	 * Removes all the avaliacaos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Avaliacao avaliacao : findAll()) {
			remove(avaliacao);
		}
	}

	/**
	 * Returns the number of avaliacaos.
	 *
	 * @return the number of avaliacaos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AVALIACAO);

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
		return "avaliacaoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AVALIACAO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AvaliacaoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the avaliacao persistence.
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

		_finderPathFetchByFuncionarioIdPeriodoDesafio = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFuncionarioIdPeriodoDesafio",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"funcionarioId", "periodoDesafio"}, true);

		_finderPathWithPaginationFindByPeriodoDesafio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPeriodoDesafio",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"periodoDesafio"}, true);

		_finderPathWithoutPaginationFindByPeriodoDesafio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPeriodoDesafio",
			new String[] {Integer.class.getName()},
			new String[] {"periodoDesafio"}, true);

		_finderPathCountByPeriodoDesafio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPeriodoDesafio",
			new String[] {Integer.class.getName()},
			new String[] {"periodoDesafio"}, false);

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

		AvaliacaoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AvaliacaoUtil.setPersistence(null);

		entityCache.removeCache(AvaliacaoImpl.class.getName());
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_AVALIACAO =
		"SELECT avaliacao FROM Avaliacao avaliacao";

	private static final String _SQL_SELECT_AVALIACAO_WHERE =
		"SELECT avaliacao FROM Avaliacao avaliacao WHERE ";

	private static final String _SQL_COUNT_AVALIACAO =
		"SELECT COUNT(avaliacao) FROM Avaliacao avaliacao";

	private static final String _SQL_COUNT_AVALIACAO_WHERE =
		"SELECT COUNT(avaliacao) FROM Avaliacao avaliacao WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "avaliacao.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Avaliacao exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Avaliacao exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AvaliacaoPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}