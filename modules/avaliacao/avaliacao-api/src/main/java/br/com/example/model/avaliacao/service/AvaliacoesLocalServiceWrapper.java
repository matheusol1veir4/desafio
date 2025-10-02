/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AvaliacoesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacoesLocalService
 * @generated
 */
public class AvaliacoesLocalServiceWrapper
	implements AvaliacoesLocalService, ServiceWrapper<AvaliacoesLocalService> {

	public AvaliacoesLocalServiceWrapper() {
		this(null);
	}

	public AvaliacoesLocalServiceWrapper(
		AvaliacoesLocalService avaliacoesLocalService) {

		_avaliacoesLocalService = avaliacoesLocalService;
	}

	/**
	 * Adds the avaliacoes to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacoesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacoes the avaliacoes
	 * @return the avaliacoes that was added
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacoes addAvaliacoes(
		br.com.example.model.avaliacao.model.Avaliacoes avaliacoes) {

		return _avaliacoesLocalService.addAvaliacoes(avaliacoes);
	}

	/**
	 * Creates a new avaliacoes with the primary key. Does not add the avaliacoes to the database.
	 *
	 * @param avaliacoesId the primary key for the new avaliacoes
	 * @return the new avaliacoes
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacoes createAvaliacoes(
		long avaliacoesId) {

		return _avaliacoesLocalService.createAvaliacoes(avaliacoesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacoesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the avaliacoes from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacoesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacoes the avaliacoes
	 * @return the avaliacoes that was removed
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacoes deleteAvaliacoes(
		br.com.example.model.avaliacao.model.Avaliacoes avaliacoes) {

		return _avaliacoesLocalService.deleteAvaliacoes(avaliacoes);
	}

	/**
	 * Deletes the avaliacoes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacoesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes that was removed
	 * @throws PortalException if a avaliacoes with the primary key could not be found
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacoes deleteAvaliacoes(
			long avaliacoesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacoesLocalService.deleteAvaliacoes(avaliacoesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacoesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _avaliacoesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _avaliacoesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _avaliacoesLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _avaliacoesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _avaliacoesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _avaliacoesLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _avaliacoesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _avaliacoesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.example.model.avaliacao.model.Avaliacoes fetchAvaliacoes(
		long avaliacoesId) {

		return _avaliacoesLocalService.fetchAvaliacoes(avaliacoesId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _avaliacoesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the avaliacoes with the primary key.
	 *
	 * @param avaliacoesId the primary key of the avaliacoes
	 * @return the avaliacoes
	 * @throws PortalException if a avaliacoes with the primary key could not be found
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacoes getAvaliacoes(
			long avaliacoesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacoesLocalService.getAvaliacoes(avaliacoesId);
	}

	/**
	 * Returns a range of all the avaliacoeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacoesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacoeses
	 * @param end the upper bound of the range of avaliacoeses (not inclusive)
	 * @return the range of avaliacoeses
	 */
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.Avaliacoes>
		getAvaliacoeses(int start, int end) {

		return _avaliacoesLocalService.getAvaliacoeses(start, end);
	}

	/**
	 * Returns the number of avaliacoeses.
	 *
	 * @return the number of avaliacoeses
	 */
	@Override
	public int getAvaliacoesesCount() {
		return _avaliacoesLocalService.getAvaliacoesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _avaliacoesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _avaliacoesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacoesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the avaliacoes in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacoesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacoes the avaliacoes
	 * @return the avaliacoes that was updated
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacoes updateAvaliacoes(
		br.com.example.model.avaliacao.model.Avaliacoes avaliacoes) {

		return _avaliacoesLocalService.updateAvaliacoes(avaliacoes);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _avaliacoesLocalService.getBasePersistence();
	}

	@Override
	public AvaliacoesLocalService getWrappedService() {
		return _avaliacoesLocalService;
	}

	@Override
	public void setWrappedService(
		AvaliacoesLocalService avaliacoesLocalService) {

		_avaliacoesLocalService = avaliacoesLocalService;
	}

	private AvaliacoesLocalService _avaliacoesLocalService;

}