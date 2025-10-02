/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link FuncionarioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FuncionarioLocalService
 * @generated
 */
public class FuncionarioLocalServiceWrapper
	implements FuncionarioLocalService,
			   ServiceWrapper<FuncionarioLocalService> {

	public FuncionarioLocalServiceWrapper() {
		this(null);
	}

	public FuncionarioLocalServiceWrapper(
		FuncionarioLocalService funcionarioLocalService) {

		_funcionarioLocalService = funcionarioLocalService;
	}

	/**
	 * Adds the funcionario to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FuncionarioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param funcionario the funcionario
	 * @return the funcionario that was added
	 */
	@Override
	public br.com.example.model.avaliacao.model.Funcionario addFuncionario(
		br.com.example.model.avaliacao.model.Funcionario funcionario) {

		return _funcionarioLocalService.addFuncionario(funcionario);
	}

	/**
	 * Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	 *
	 * @param funcionarioId the primary key for the new funcionario
	 * @return the new funcionario
	 */
	@Override
	public br.com.example.model.avaliacao.model.Funcionario createFuncionario(
		long funcionarioId) {

		return _funcionarioLocalService.createFuncionario(funcionarioId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _funcionarioLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the funcionario from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FuncionarioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param funcionario the funcionario
	 * @return the funcionario that was removed
	 */
	@Override
	public br.com.example.model.avaliacao.model.Funcionario deleteFuncionario(
		br.com.example.model.avaliacao.model.Funcionario funcionario) {

		return _funcionarioLocalService.deleteFuncionario(funcionario);
	}

	/**
	 * Deletes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FuncionarioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario that was removed
	 * @throws PortalException if a funcionario with the primary key could not be found
	 */
	@Override
	public br.com.example.model.avaliacao.model.Funcionario deleteFuncionario(
			long funcionarioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _funcionarioLocalService.deleteFuncionario(funcionarioId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _funcionarioLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _funcionarioLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _funcionarioLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _funcionarioLocalService.dynamicQuery();
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

		return _funcionarioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.FuncionarioModelImpl</code>.
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

		return _funcionarioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.FuncionarioModelImpl</code>.
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

		return _funcionarioLocalService.dynamicQuery(
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

		return _funcionarioLocalService.dynamicQueryCount(dynamicQuery);
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

		return _funcionarioLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.example.model.avaliacao.model.Funcionario fetchFuncionario(
		long funcionarioId) {

		return _funcionarioLocalService.fetchFuncionario(funcionarioId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _funcionarioLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the funcionario with the primary key.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario
	 * @throws PortalException if a funcionario with the primary key could not be found
	 */
	@Override
	public br.com.example.model.avaliacao.model.Funcionario getFuncionario(
			long funcionarioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _funcionarioLocalService.getFuncionario(funcionarioId);
	}

	/**
	 * Returns a range of all the funcionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.FuncionarioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of funcionarios
	 */
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.Funcionario>
		getFuncionarios(int start, int end) {

		return _funcionarioLocalService.getFuncionarios(start, end);
	}

	/**
	 * Returns the number of funcionarios.
	 *
	 * @return the number of funcionarios
	 */
	@Override
	public int getFuncionariosCount() {
		return _funcionarioLocalService.getFuncionariosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _funcionarioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _funcionarioLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _funcionarioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the funcionario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FuncionarioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param funcionario the funcionario
	 * @return the funcionario that was updated
	 */
	@Override
	public br.com.example.model.avaliacao.model.Funcionario updateFuncionario(
		br.com.example.model.avaliacao.model.Funcionario funcionario) {

		return _funcionarioLocalService.updateFuncionario(funcionario);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _funcionarioLocalService.getBasePersistence();
	}

	@Override
	public FuncionarioLocalService getWrappedService() {
		return _funcionarioLocalService;
	}

	@Override
	public void setWrappedService(
		FuncionarioLocalService funcionarioLocalService) {

		_funcionarioLocalService = funcionarioLocalService;
	}

	private FuncionarioLocalService _funcionarioLocalService;

}