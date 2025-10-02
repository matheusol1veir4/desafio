/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import br.com.example.model.avaliacao.model.DescricaoDesafio;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DescricaoDesafio. This utility wraps
 * <code>br.com.example.model.avaliacao.service.impl.DescricaoDesafioLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DescricaoDesafioLocalService
 * @generated
 */
public class DescricaoDesafioLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.example.model.avaliacao.service.impl.DescricaoDesafioLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the descricao desafio to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescricaoDesafioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descricaoDesafio the descricao desafio
	 * @return the descricao desafio that was added
	 */
	public static DescricaoDesafio addDescricaoDesafio(
		DescricaoDesafio descricaoDesafio) {

		return getService().addDescricaoDesafio(descricaoDesafio);
	}

	/**
	 * Creates a new descricao desafio with the primary key. Does not add the descricao desafio to the database.
	 *
	 * @param descricaoDesafioId the primary key for the new descricao desafio
	 * @return the new descricao desafio
	 */
	public static DescricaoDesafio createDescricaoDesafio(
		long descricaoDesafioId) {

		return getService().createDescricaoDesafio(descricaoDesafioId);
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
	 * Deletes the descricao desafio from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescricaoDesafioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descricaoDesafio the descricao desafio
	 * @return the descricao desafio that was removed
	 */
	public static DescricaoDesafio deleteDescricaoDesafio(
		DescricaoDesafio descricaoDesafio) {

		return getService().deleteDescricaoDesafio(descricaoDesafio);
	}

	/**
	 * Deletes the descricao desafio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescricaoDesafioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio that was removed
	 * @throws PortalException if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio deleteDescricaoDesafio(
			long descricaoDesafioId)
		throws PortalException {

		return getService().deleteDescricaoDesafio(descricaoDesafioId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.DescricaoDesafioModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.DescricaoDesafioModelImpl</code>.
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

	public static DescricaoDesafio fetchDescricaoDesafio(
		long descricaoDesafioId) {

		return getService().fetchDescricaoDesafio(descricaoDesafioId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the descricao desafio with the primary key.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio
	 * @throws PortalException if a descricao desafio with the primary key could not be found
	 */
	public static DescricaoDesafio getDescricaoDesafio(long descricaoDesafioId)
		throws PortalException {

		return getService().getDescricaoDesafio(descricaoDesafioId);
	}

	/**
	 * Returns a range of all the descricao desafios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.DescricaoDesafioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descricao desafios
	 * @param end the upper bound of the range of descricao desafios (not inclusive)
	 * @return the range of descricao desafios
	 */
	public static List<DescricaoDesafio> getDescricaoDesafios(
		int start, int end) {

		return getService().getDescricaoDesafios(start, end);
	}

	/**
	 * Returns the number of descricao desafios.
	 *
	 * @return the number of descricao desafios
	 */
	public static int getDescricaoDesafiosCount() {
		return getService().getDescricaoDesafiosCount();
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
	 * Updates the descricao desafio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescricaoDesafioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descricaoDesafio the descricao desafio
	 * @return the descricao desafio that was updated
	 */
	public static DescricaoDesafio updateDescricaoDesafio(
		DescricaoDesafio descricaoDesafio) {

		return getService().updateDescricaoDesafio(descricaoDesafio);
	}

	public static DescricaoDesafioLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<DescricaoDesafioLocalService>
		_serviceSnapshot = new Snapshot<>(
			DescricaoDesafioLocalServiceUtil.class,
			DescricaoDesafioLocalService.class);

}