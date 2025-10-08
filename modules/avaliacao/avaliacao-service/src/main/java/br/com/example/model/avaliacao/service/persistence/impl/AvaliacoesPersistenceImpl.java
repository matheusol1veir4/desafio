/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.impl;

import br.com.example.model.avaliacao.exception.NoSuchAvaliacoesException;
import br.com.example.model.avaliacao.model.Avaliacoes;
import br.com.example.model.avaliacao.model.AvaliacoesTable;
import br.com.example.model.avaliacao.model.impl.AvaliacoesImpl;
import br.com.example.model.avaliacao.model.impl.AvaliacoesModelImpl;
import br.com.example.model.avaliacao.service.persistence.AvaliacoesPersistence;
import br.com.example.model.avaliacao.service.persistence.AvaliacoesUtil;

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
 * The persistence implementation for the avaliacoes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AvaliacoesPersistence.class)
public class AvaliacoesPersistenceImpl
	extends BasePersistenceImpl<Avaliacoes> implements AvaliacoesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AvaliacoesUtil</code> to access the avaliacoes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AvaliacoesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAvaliacoesId;
	private FinderPath _finderPathWithoutPaginationFindByAvaliacoesId;
	private FinderPath _finderPathCountByAvaliacoesId;

	/**
	 * Returns all the avaliacoeses where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @return the matching avaliacoeses
	 */
	@Override
	public List<Avaliacoes> findByAvaliacoesId(long avaliacoesId) {
		return findByAvaliacoesId(
			avaliacoesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end) {

		return findByAvaliacoesId(avaliacoesId, start, end, null);
	}

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
	@Override
	public List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return findByAvaliacoesId(
			avaliacoesId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Avaliacoes> findByAvaliacoesId(
		long avaliacoesId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAvaliacoesId;
				finderArgs = new Object[] {avaliacoesId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAvaliacoesId;
			finderArgs = new Object[] {
				avaliacoesId, start, end, orderByComparator
			};
		}

		List<Avaliacoes> list = null;

		if (useFinderCache) {
			list = (List<Avaliacoes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Avaliacoes avaliacoes : list) {
					if (avaliacoesId != avaliacoes.getAvaliacoesId()) {
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

			sb.append(_SQL_SELECT_AVALIACOES_WHERE);

			sb.append(_FINDER_COLUMN_AVALIACOESID_AVALIACOESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AvaliacoesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(avaliacoesId);

				list = (List<Avaliacoes>)QueryUtil.list(
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
	 * Returns the first avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes findByAvaliacoesId_First(
			long avaliacoesId, OrderByComparator<Avaliacoes> orderByComparator)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = fetchByAvaliacoesId_First(
			avaliacoesId, orderByComparator);

		if (avaliacoes != null) {
			return avaliacoes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("avaliacoesId=");
		sb.append(avaliacoesId);

		sb.append("}");

		throw new NoSuchAvaliacoesException(sb.toString());
	}

	/**
	 * Returns the first avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes fetchByAvaliacoesId_First(
		long avaliacoesId, OrderByComparator<Avaliacoes> orderByComparator) {

		List<Avaliacoes> list = findByAvaliacoesId(
			avaliacoesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes findByAvaliacoesId_Last(
			long avaliacoesId, OrderByComparator<Avaliacoes> orderByComparator)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = fetchByAvaliacoesId_Last(
			avaliacoesId, orderByComparator);

		if (avaliacoes != null) {
			return avaliacoes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("avaliacoesId=");
		sb.append(avaliacoesId);

		sb.append("}");

		throw new NoSuchAvaliacoesException(sb.toString());
	}

	/**
	 * Returns the last avaliacoes in the ordered set where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes fetchByAvaliacoesId_Last(
		long avaliacoesId, OrderByComparator<Avaliacoes> orderByComparator) {

		int count = countByAvaliacoesId(avaliacoesId);

		if (count == 0) {
			return null;
		}

		List<Avaliacoes> list = findByAvaliacoesId(
			avaliacoesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the avaliacoeses where avaliacoesId = &#63; from the database.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 */
	@Override
	public void removeByAvaliacoesId(long avaliacoesId) {
		for (Avaliacoes avaliacoes :
				findByAvaliacoesId(
					avaliacoesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(avaliacoes);
		}
	}

	/**
	 * Returns the number of avaliacoeses where avaliacoesId = &#63;.
	 *
	 * @param avaliacoesId the avaliacoes ID
	 * @return the number of matching avaliacoeses
	 */
	@Override
	public int countByAvaliacoesId(long avaliacoesId) {
		FinderPath finderPath = _finderPathCountByAvaliacoesId;

		Object[] finderArgs = new Object[] {avaliacoesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AVALIACOES_WHERE);

			sb.append(_FINDER_COLUMN_AVALIACOESID_AVALIACOESID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(avaliacoesId);

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

	private static final String _FINDER_COLUMN_AVALIACOESID_AVALIACOESID_2 =
		"avaliacoes.avaliacoesId = ?";

	private FinderPath _finderPathWithPaginationFindByDescricaoDesafioId;
	private FinderPath _finderPathWithoutPaginationFindByDescricaoDesafioId;
	private FinderPath _finderPathCountByDescricaoDesafioId;

	/**
	 * Returns all the avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the matching avaliacoeses
	 */
	@Override
	public List<Avaliacoes> findByDescricaoDesafioId(long descricaoDesafioId) {
		return findByDescricaoDesafioId(
			descricaoDesafioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end) {

		return findByDescricaoDesafioId(descricaoDesafioId, start, end, null);
	}

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
	@Override
	public List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return findByDescricaoDesafioId(
			descricaoDesafioId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Avaliacoes> findByDescricaoDesafioId(
		long descricaoDesafioId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator,
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

		List<Avaliacoes> list = null;

		if (useFinderCache) {
			list = (List<Avaliacoes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Avaliacoes avaliacoes : list) {
					if (descricaoDesafioId !=
							avaliacoes.getDescricaoDesafioId()) {

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

			sb.append(_SQL_SELECT_AVALIACOES_WHERE);

			sb.append(_FINDER_COLUMN_DESCRICAODESAFIOID_DESCRICAODESAFIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AvaliacoesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(descricaoDesafioId);

				list = (List<Avaliacoes>)QueryUtil.list(
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
	 * Returns the first avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes findByDescricaoDesafioId_First(
			long descricaoDesafioId,
			OrderByComparator<Avaliacoes> orderByComparator)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = fetchByDescricaoDesafioId_First(
			descricaoDesafioId, orderByComparator);

		if (avaliacoes != null) {
			return avaliacoes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("descricaoDesafioId=");
		sb.append(descricaoDesafioId);

		sb.append("}");

		throw new NoSuchAvaliacoesException(sb.toString());
	}

	/**
	 * Returns the first avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes fetchByDescricaoDesafioId_First(
		long descricaoDesafioId,
		OrderByComparator<Avaliacoes> orderByComparator) {

		List<Avaliacoes> list = findByDescricaoDesafioId(
			descricaoDesafioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes findByDescricaoDesafioId_Last(
			long descricaoDesafioId,
			OrderByComparator<Avaliacoes> orderByComparator)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = fetchByDescricaoDesafioId_Last(
			descricaoDesafioId, orderByComparator);

		if (avaliacoes != null) {
			return avaliacoes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("descricaoDesafioId=");
		sb.append(descricaoDesafioId);

		sb.append("}");

		throw new NoSuchAvaliacoesException(sb.toString());
	}

	/**
	 * Returns the last avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes fetchByDescricaoDesafioId_Last(
		long descricaoDesafioId,
		OrderByComparator<Avaliacoes> orderByComparator) {

		int count = countByDescricaoDesafioId(descricaoDesafioId);

		if (count == 0) {
			return null;
		}

		List<Avaliacoes> list = findByDescricaoDesafioId(
			descricaoDesafioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the avaliacoeses before and after the current avaliacoes in the ordered set where descricaoDesafioId = &#63;.
	 *
	 * @param avaliacoesId the primary key of the current avaliacoes
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	@Override
	public Avaliacoes[] findByDescricaoDesafioId_PrevAndNext(
			long avaliacoesId, long descricaoDesafioId,
			OrderByComparator<Avaliacoes> orderByComparator)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = findByPrimaryKey(avaliacoesId);

		Session session = null;

		try {
			session = openSession();

			Avaliacoes[] array = new AvaliacoesImpl[3];

			array[0] = getByDescricaoDesafioId_PrevAndNext(
				session, avaliacoes, descricaoDesafioId, orderByComparator,
				true);

			array[1] = avaliacoes;

			array[2] = getByDescricaoDesafioId_PrevAndNext(
				session, avaliacoes, descricaoDesafioId, orderByComparator,
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

	protected Avaliacoes getByDescricaoDesafioId_PrevAndNext(
		Session session, Avaliacoes avaliacoes, long descricaoDesafioId,
		OrderByComparator<Avaliacoes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AVALIACOES_WHERE);

		sb.append(_FINDER_COLUMN_DESCRICAODESAFIOID_DESCRICAODESAFIOID_2);

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
			sb.append(AvaliacoesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(descricaoDesafioId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(avaliacoes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Avaliacoes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the avaliacoeses where descricaoDesafioId = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 */
	@Override
	public void removeByDescricaoDesafioId(long descricaoDesafioId) {
		for (Avaliacoes avaliacoes :
				findByDescricaoDesafioId(
					descricaoDesafioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(avaliacoes);
		}
	}

	/**
	 * Returns the number of avaliacoeses where descricaoDesafioId = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @return the number of matching avaliacoeses
	 */
	@Override
	public int countByDescricaoDesafioId(long descricaoDesafioId) {
		FinderPath finderPath = _finderPathCountByDescricaoDesafioId;

		Object[] finderArgs = new Object[] {descricaoDesafioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AVALIACOES_WHERE);

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
			"avaliacoes.descricaoDesafioId = ?";

	private FinderPath _finderPathFetchByDescricaoDesafioId_TipoAvaliador;

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or throws a <code>NoSuchAvaliacoesException</code> if it could not be found.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes findByDescricaoDesafioId_TipoAvaliador(
			long descricaoDesafioId, String tipoAvaliador)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = fetchByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador);

		if (avaliacoes == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("descricaoDesafioId=");
			sb.append(descricaoDesafioId);

			sb.append(", tipoAvaliador=");
			sb.append(tipoAvaliador);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAvaliacoesException(sb.toString());
		}

		return avaliacoes;
	}

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes fetchByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador) {

		return fetchByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador, true);
	}

	/**
	 * Returns the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes fetchByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador, boolean useFinderCache) {

		tipoAvaliador = Objects.toString(tipoAvaliador, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {descricaoDesafioId, tipoAvaliador};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDescricaoDesafioId_TipoAvaliador, finderArgs,
				this);
		}

		if (result instanceof Avaliacoes) {
			Avaliacoes avaliacoes = (Avaliacoes)result;

			if ((descricaoDesafioId != avaliacoes.getDescricaoDesafioId()) ||
				!Objects.equals(tipoAvaliador, avaliacoes.getTipoAvaliador())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AVALIACOES_WHERE);

			sb.append(
				_FINDER_COLUMN_DESCRICAODESAFIOID_TIPOAVALIADOR_DESCRICAODESAFIOID_2);

			boolean bindTipoAvaliador = false;

			if (tipoAvaliador.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DESCRICAODESAFIOID_TIPOAVALIADOR_TIPOAVALIADOR_3);
			}
			else {
				bindTipoAvaliador = true;

				sb.append(
					_FINDER_COLUMN_DESCRICAODESAFIOID_TIPOAVALIADOR_TIPOAVALIADOR_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(descricaoDesafioId);

				if (bindTipoAvaliador) {
					queryPos.add(tipoAvaliador);
				}

				List<Avaliacoes> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDescricaoDesafioId_TipoAvaliador,
							finderArgs, list);
					}
				}
				else {
					Avaliacoes avaliacoes = list.get(0);

					result = avaliacoes;

					cacheResult(avaliacoes);
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
			return (Avaliacoes)result;
		}
	}

	/**
	 * Removes the avaliacoes where descricaoDesafioId = &#63; and tipoAvaliador = &#63; from the database.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the avaliacoes that was removed
	 */
	@Override
	public Avaliacoes removeByDescricaoDesafioId_TipoAvaliador(
			long descricaoDesafioId, String tipoAvaliador)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = findByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador);

		return remove(avaliacoes);
	}

	/**
	 * Returns the number of avaliacoeses where descricaoDesafioId = &#63; and tipoAvaliador = &#63;.
	 *
	 * @param descricaoDesafioId the descricao desafio ID
	 * @param tipoAvaliador the tipo avaliador
	 * @return the number of matching avaliacoeses
	 */
	@Override
	public int countByDescricaoDesafioId_TipoAvaliador(
		long descricaoDesafioId, String tipoAvaliador) {

		Avaliacoes avaliacoes = fetchByDescricaoDesafioId_TipoAvaliador(
			descricaoDesafioId, tipoAvaliador);

		if (avaliacoes == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_DESCRICAODESAFIOID_TIPOAVALIADOR_DESCRICAODESAFIOID_2 =
			"avaliacoes.descricaoDesafioId = ? AND ";

	private static final String
		_FINDER_COLUMN_DESCRICAODESAFIOID_TIPOAVALIADOR_TIPOAVALIADOR_2 =
			"avaliacoes.tipoAvaliador = ?";

	private static final String
		_FINDER_COLUMN_DESCRICAODESAFIOID_TIPOAVALIADOR_TIPOAVALIADOR_3 =
			"(avaliacoes.tipoAvaliador IS NULL OR avaliacoes.tipoAvaliador = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the avaliacoeses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching avaliacoeses
	 */
	@Override
	public List<Avaliacoes> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Avaliacoes> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<Avaliacoes> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Avaliacoes> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Avaliacoes> orderByComparator,
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

		List<Avaliacoes> list = null;

		if (useFinderCache) {
			list = (List<Avaliacoes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Avaliacoes avaliacoes : list) {
					if (groupId != avaliacoes.getGroupId()) {
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

			sb.append(_SQL_SELECT_AVALIACOES_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AvaliacoesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Avaliacoes>)QueryUtil.list(
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
	 * Returns the first avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes findByGroupId_First(
			long groupId, OrderByComparator<Avaliacoes> orderByComparator)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = fetchByGroupId_First(
			groupId, orderByComparator);

		if (avaliacoes != null) {
			return avaliacoes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAvaliacoesException(sb.toString());
	}

	/**
	 * Returns the first avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes fetchByGroupId_First(
		long groupId, OrderByComparator<Avaliacoes> orderByComparator) {

		List<Avaliacoes> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes
	 * @throws NoSuchAvaliacoesException if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes findByGroupId_Last(
			long groupId, OrderByComparator<Avaliacoes> orderByComparator)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = fetchByGroupId_Last(groupId, orderByComparator);

		if (avaliacoes != null) {
			return avaliacoes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAvaliacoesException(sb.toString());
	}

	/**
	 * Returns the last avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching avaliacoes, or <code>null</code> if a matching avaliacoes could not be found
	 */
	@Override
	public Avaliacoes fetchByGroupId_Last(
		long groupId, OrderByComparator<Avaliacoes> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Avaliacoes> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the avaliacoeses before and after the current avaliacoes in the ordered set where groupId = &#63;.
	 *
	 * @param avaliacoesId the primary key of the current avaliacoes
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	@Override
	public Avaliacoes[] findByGroupId_PrevAndNext(
			long avaliacoesId, long groupId,
			OrderByComparator<Avaliacoes> orderByComparator)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = findByPrimaryKey(avaliacoesId);

		Session session = null;

		try {
			session = openSession();

			Avaliacoes[] array = new AvaliacoesImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, avaliacoes, groupId, orderByComparator, true);

			array[1] = avaliacoes;

			array[2] = getByGroupId_PrevAndNext(
				session, avaliacoes, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Avaliacoes getByGroupId_PrevAndNext(
		Session session, Avaliacoes avaliacoes, long groupId,
		OrderByComparator<Avaliacoes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AVALIACOES_WHERE);

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
			sb.append(AvaliacoesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(avaliacoes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Avaliacoes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the avaliacoeses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Avaliacoes avaliacoes :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(avaliacoes);
		}
	}

	/**
	 * Returns the number of avaliacoeses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching avaliacoeses
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AVALIACOES_WHERE);

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
		"avaliacoes.groupId = ?";

	public AvaliacoesPersistenceImpl() {
		setModelClass(Avaliacoes.class);

		setModelImplClass(AvaliacoesImpl.class);
		setModelPKClass(long.class);

		setTable(AvaliacoesTable.INSTANCE);
	}

	/**
	 * Caches the avaliacoes in the entity cache if it is enabled.
	 *
	 * @param avaliacoes the avaliacoes
	 */
	@Override
	public void cacheResult(Avaliacoes avaliacoes) {
		entityCache.putResult(
			AvaliacoesImpl.class, avaliacoes.getPrimaryKey(), avaliacoes);

		finderCache.putResult(
			_finderPathFetchByDescricaoDesafioId_TipoAvaliador,
			new Object[] {
				avaliacoes.getDescricaoDesafioId(),
				avaliacoes.getTipoAvaliador()
			},
			avaliacoes);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the avaliacoeses in the entity cache if it is enabled.
	 *
	 * @param avaliacoeses the avaliacoeses
	 */
	@Override
	public void cacheResult(List<Avaliacoes> avaliacoeses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (avaliacoeses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Avaliacoes avaliacoes : avaliacoeses) {
			if (entityCache.getResult(
					AvaliacoesImpl.class, avaliacoes.getPrimaryKey()) == null) {

				cacheResult(avaliacoes);
			}
		}
	}

	/**
	 * Clears the cache for all avaliacoeses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AvaliacoesImpl.class);

		finderCache.clearCache(AvaliacoesImpl.class);
	}

	/**
	 * Clears the cache for the avaliacoes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Avaliacoes avaliacoes) {
		entityCache.removeResult(AvaliacoesImpl.class, avaliacoes);
	}

	@Override
	public void clearCache(List<Avaliacoes> avaliacoeses) {
		for (Avaliacoes avaliacoes : avaliacoeses) {
			entityCache.removeResult(AvaliacoesImpl.class, avaliacoes);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AvaliacoesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AvaliacoesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AvaliacoesModelImpl avaliacoesModelImpl) {

		Object[] args = new Object[] {
			avaliacoesModelImpl.getDescricaoDesafioId(),
			avaliacoesModelImpl.getTipoAvaliador()
		};

		finderCache.putResult(
			_finderPathFetchByDescricaoDesafioId_TipoAvaliador, args,
			avaliacoesModelImpl);
	}

	/**
	 * Creates a new avaliacoes with the primary key. Does not add the avaliacoes to the database.
	 *
	 * @param avaliacoesId the primary key for the new avaliacoes
	 * @return the new avaliacoes
	 */
	@Override
	public Avaliacoes create(long avaliacoesId) {
		Avaliacoes avaliacoes = new AvaliacoesImpl();

		avaliacoes.setNew(true);
		avaliacoes.setPrimaryKey(avaliacoesId);

		avaliacoes.setCompanyId(CompanyThreadLocal.getCompanyId());

		return avaliacoes;
	}

	/**
	 * Removes the avaliacoes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes that was removed
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	@Override
	public Avaliacoes remove(long avaliacoesId)
		throws NoSuchAvaliacoesException {

		return remove((Serializable)avaliacoesId);
	}

	/**
	 * Removes the avaliacoes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the avaliacoes
	 * @return the avaliacoes that was removed
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	@Override
	public Avaliacoes remove(Serializable primaryKey)
		throws NoSuchAvaliacoesException {

		Session session = null;

		try {
			session = openSession();

			Avaliacoes avaliacoes = (Avaliacoes)session.get(
				AvaliacoesImpl.class, primaryKey);

			if (avaliacoes == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAvaliacoesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(avaliacoes);
		}
		catch (NoSuchAvaliacoesException noSuchEntityException) {
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
	protected Avaliacoes removeImpl(Avaliacoes avaliacoes) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(avaliacoes)) {
				avaliacoes = (Avaliacoes)session.get(
					AvaliacoesImpl.class, avaliacoes.getPrimaryKeyObj());
			}

			if (avaliacoes != null) {
				session.delete(avaliacoes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (avaliacoes != null) {
			clearCache(avaliacoes);
		}

		return avaliacoes;
	}

	@Override
	public Avaliacoes updateImpl(Avaliacoes avaliacoes) {
		boolean isNew = avaliacoes.isNew();

		if (!(avaliacoes instanceof AvaliacoesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(avaliacoes.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(avaliacoes);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in avaliacoes proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Avaliacoes implementation " +
					avaliacoes.getClass());
		}

		AvaliacoesModelImpl avaliacoesModelImpl =
			(AvaliacoesModelImpl)avaliacoes;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (avaliacoes.getCreateDate() == null)) {
			if (serviceContext == null) {
				avaliacoes.setCreateDate(date);
			}
			else {
				avaliacoes.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!avaliacoesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				avaliacoes.setModifiedDate(date);
			}
			else {
				avaliacoes.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(avaliacoes);
			}
			else {
				avaliacoes = (Avaliacoes)session.merge(avaliacoes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AvaliacoesImpl.class, avaliacoesModelImpl, false, true);

		cacheUniqueFindersCache(avaliacoesModelImpl);

		if (isNew) {
			avaliacoes.setNew(false);
		}

		avaliacoes.resetOriginalValues();

		return avaliacoes;
	}

	/**
	 * Returns the avaliacoes with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the avaliacoes
	 * @return the avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	@Override
	public Avaliacoes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAvaliacoesException {

		Avaliacoes avaliacoes = fetchByPrimaryKey(primaryKey);

		if (avaliacoes == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAvaliacoesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return avaliacoes;
	}

	/**
	 * Returns the avaliacoes with the primary key or throws a <code>NoSuchAvaliacoesException</code> if it could not be found.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes
	 * @throws NoSuchAvaliacoesException if a avaliacoes with the primary key could not be found
	 */
	@Override
	public Avaliacoes findByPrimaryKey(long avaliacoesId)
		throws NoSuchAvaliacoesException {

		return findByPrimaryKey((Serializable)avaliacoesId);
	}

	/**
	 * Returns the avaliacoes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes, or <code>null</code> if a avaliacoes with the primary key could not be found
	 */
	@Override
	public Avaliacoes fetchByPrimaryKey(long avaliacoesId) {
		return fetchByPrimaryKey((Serializable)avaliacoesId);
	}

	/**
	 * Returns all the avaliacoeses.
	 *
	 * @return the avaliacoeses
	 */
	@Override
	public List<Avaliacoes> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Avaliacoes> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Avaliacoes> findAll(
		int start, int end, OrderByComparator<Avaliacoes> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Avaliacoes> findAll(
		int start, int end, OrderByComparator<Avaliacoes> orderByComparator,
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

		List<Avaliacoes> list = null;

		if (useFinderCache) {
			list = (List<Avaliacoes>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AVALIACOES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AVALIACOES;

				sql = sql.concat(AvaliacoesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Avaliacoes>)QueryUtil.list(
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
	 * Removes all the avaliacoeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Avaliacoes avaliacoes : findAll()) {
			remove(avaliacoes);
		}
	}

	/**
	 * Returns the number of avaliacoeses.
	 *
	 * @return the number of avaliacoeses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AVALIACOES);

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
		return "avaliacoesId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AVALIACOES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AvaliacoesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the avaliacoes persistence.
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

		_finderPathWithPaginationFindByAvaliacoesId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAvaliacoesId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"avaliacoesId"}, true);

		_finderPathWithoutPaginationFindByAvaliacoesId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAvaliacoesId",
			new String[] {Long.class.getName()}, new String[] {"avaliacoesId"},
			true);

		_finderPathCountByAvaliacoesId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAvaliacoesId",
			new String[] {Long.class.getName()}, new String[] {"avaliacoesId"},
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

		_finderPathFetchByDescricaoDesafioId_TipoAvaliador = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDescricaoDesafioId_TipoAvaliador",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"descricaoDesafioId", "tipoAvaliador"}, true);

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

		AvaliacoesUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AvaliacoesUtil.setPersistence(null);

		entityCache.removeCache(AvaliacoesImpl.class.getName());
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AVALIACOES =
		"SELECT avaliacoes FROM Avaliacoes avaliacoes";

	private static final String _SQL_SELECT_AVALIACOES_WHERE =
		"SELECT avaliacoes FROM Avaliacoes avaliacoes WHERE ";

	private static final String _SQL_COUNT_AVALIACOES =
		"SELECT COUNT(avaliacoes) FROM Avaliacoes avaliacoes";

	private static final String _SQL_COUNT_AVALIACOES_WHERE =
		"SELECT COUNT(avaliacoes) FROM Avaliacoes avaliacoes WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "avaliacoes.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Avaliacoes exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Avaliacoes exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AvaliacoesPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}