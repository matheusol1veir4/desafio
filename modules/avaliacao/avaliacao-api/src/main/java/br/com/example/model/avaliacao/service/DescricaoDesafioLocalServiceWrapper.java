/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DescricaoDesafioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DescricaoDesafioLocalService
 * @generated
 */
public class DescricaoDesafioLocalServiceWrapper
	implements DescricaoDesafioLocalService,
			   ServiceWrapper<DescricaoDesafioLocalService> {

	public DescricaoDesafioLocalServiceWrapper() {
		this(null);
	}

	public DescricaoDesafioLocalServiceWrapper(
		DescricaoDesafioLocalService descricaoDesafioLocalService) {

		_descricaoDesafioLocalService = descricaoDesafioLocalService;
	}

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
	@Override
	public br.com.example.model.avaliacao.model.DescricaoDesafio
		addDescricaoDesafio(
			br.com.example.model.avaliacao.model.DescricaoDesafio
				descricaoDesafio) {

		return _descricaoDesafioLocalService.addDescricaoDesafio(
			descricaoDesafio);
	}

	/**
	 * Creates a new descricao desafio with the primary key. Does not add the descricao desafio to the database.
	 *
	 * @param descricaoDesafioId the primary key for the new descricao desafio
	 * @return the new descricao desafio
	 */
	@Override
	public br.com.example.model.avaliacao.model.DescricaoDesafio
		createDescricaoDesafio(long descricaoDesafioId) {

		return _descricaoDesafioLocalService.createDescricaoDesafio(
			descricaoDesafioId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descricaoDesafioLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public br.com.example.model.avaliacao.model.DescricaoDesafio
		deleteDescricaoDesafio(
			br.com.example.model.avaliacao.model.DescricaoDesafio
				descricaoDesafio) {

		return _descricaoDesafioLocalService.deleteDescricaoDesafio(
			descricaoDesafio);
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
	@Override
	public br.com.example.model.avaliacao.model.DescricaoDesafio
			deleteDescricaoDesafio(long descricaoDesafioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descricaoDesafioLocalService.deleteDescricaoDesafio(
			descricaoDesafioId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descricaoDesafioLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _descricaoDesafioLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _descricaoDesafioLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _descricaoDesafioLocalService.dynamicQuery();
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

		return _descricaoDesafioLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _descricaoDesafioLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _descricaoDesafioLocalService.dynamicQuery(
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

		return _descricaoDesafioLocalService.dynamicQueryCount(dynamicQuery);
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

		return _descricaoDesafioLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.example.model.avaliacao.model.DescricaoDesafio
		fetchDescricaoDesafio(long descricaoDesafioId) {

		return _descricaoDesafioLocalService.fetchDescricaoDesafio(
			descricaoDesafioId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _descricaoDesafioLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the descricao desafio with the primary key.
	 *
	 * @param descricaoDesafioId the primary key of the descricao desafio
	 * @return the descricao desafio
	 * @throws PortalException if a descricao desafio with the primary key could not be found
	 */
	@Override
	public br.com.example.model.avaliacao.model.DescricaoDesafio
			getDescricaoDesafio(long descricaoDesafioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descricaoDesafioLocalService.getDescricaoDesafio(
			descricaoDesafioId);
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
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.DescricaoDesafio>
		getDescricaoDesafios(int start, int end) {

		return _descricaoDesafioLocalService.getDescricaoDesafios(start, end);
	}

	/**
	 * Returns the number of descricao desafios.
	 *
	 * @return the number of descricao desafios
	 */
	@Override
	public int getDescricaoDesafiosCount() {
		return _descricaoDesafioLocalService.getDescricaoDesafiosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _descricaoDesafioLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _descricaoDesafioLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descricaoDesafioLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public br.com.example.model.avaliacao.model.DescricaoDesafio
		updateDescricaoDesafio(
			br.com.example.model.avaliacao.model.DescricaoDesafio
				descricaoDesafio) {

		return _descricaoDesafioLocalService.updateDescricaoDesafio(
			descricaoDesafio);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _descricaoDesafioLocalService.getBasePersistence();
	}

	@Override
	public DescricaoDesafioLocalService getWrappedService() {
		return _descricaoDesafioLocalService;
	}

	@Override
	public void setWrappedService(
		DescricaoDesafioLocalService descricaoDesafioLocalService) {

		_descricaoDesafioLocalService = descricaoDesafioLocalService;
	}

	private DescricaoDesafioLocalService _descricaoDesafioLocalService;

}