/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import br.com.example.model.avaliacao.model.Avaliacao;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Avaliacao. This utility wraps
 * <code>br.com.example.model.avaliacao.service.impl.AvaliacaoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoLocalService
 * @generated
 */
public class AvaliacaoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.example.model.avaliacao.service.impl.AvaliacaoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the avaliacao to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacao the avaliacao
	 * @return the avaliacao that was added
	 */
	public static Avaliacao addAvaliacao(Avaliacao avaliacao) {
		return getService().addAvaliacao(avaliacao);
	}

	/**
	 * @param funcionarioId O ID do funcionário.
	 * @param dataAvaliacao A data da avaliação.
	 * @param periodoDesafio O tipo da avaliação.
	 * @param observacoesGerais Observações gerais da avaliação.
	 * @param areaAtuacao A área de atuação do funcionário.
	 * @throws PortalException
	 */
	public static Avaliacao addAvaliacao(
			long funcionarioId, java.util.Date dataAvaliacao,
			int periodoDesafio, String observacoesGerais, int areaAtuacao,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAvaliacao(
			funcionarioId, dataAvaliacao, periodoDesafio, observacoesGerais,
			areaAtuacao, serviceContext);
	}

	/**
	 * Creates a new avaliacao with the primary key. Does not add the avaliacao to the database.
	 *
	 * @param avaliacaoId the primary key for the new avaliacao
	 * @return the new avaliacao
	 */
	public static Avaliacao createAvaliacao(long avaliacaoId) {
		return getService().createAvaliacao(avaliacaoId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the avaliacao from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacao the avaliacao
	 * @return the avaliacao that was removed
	 */
	public static Avaliacao deleteAvaliacao(Avaliacao avaliacao) {
		return getService().deleteAvaliacao(avaliacao);
	}

	/**
	 * Deletes the avaliacao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao that was removed
	 * @throws PortalException if a avaliacao with the primary key could not be found
	 */
	public static Avaliacao deleteAvaliacao(long avaliacaoId)
		throws PortalException {

		return getService().deleteAvaliacao(avaliacaoId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Avaliacao fetchAvaliacao(long avaliacaoId) {
		return getService().fetchAvaliacao(avaliacaoId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the avaliacao with the primary key.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao
	 * @throws PortalException if a avaliacao with the primary key could not be found
	 */
	public static Avaliacao getAvaliacao(long avaliacaoId)
		throws PortalException {

		return getService().getAvaliacao(avaliacaoId);
	}

	/**
	 * Returns a range of all the avaliacaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacaos
	 * @param end the upper bound of the range of avaliacaos (not inclusive)
	 * @return the range of avaliacaos
	 */
	public static List<Avaliacao> getAvaliacaos(int start, int end) {
		return getService().getAvaliacaos(start, end);
	}

	/**
	 * Returns the number of avaliacaos.
	 *
	 * @return the number of avaliacaos
	 */
	public static int getAvaliacaosCount() {
		return getService().getAvaliacaosCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the avaliacao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacao the avaliacao
	 * @return the avaliacao that was updated
	 */
	public static Avaliacao updateAvaliacao(Avaliacao avaliacao) {
		return getService().updateAvaliacao(avaliacao);
	}

	public static AvaliacaoLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AvaliacaoLocalService> _serviceSnapshot =
		new Snapshot<>(
			AvaliacaoLocalServiceUtil.class, AvaliacaoLocalService.class);

}