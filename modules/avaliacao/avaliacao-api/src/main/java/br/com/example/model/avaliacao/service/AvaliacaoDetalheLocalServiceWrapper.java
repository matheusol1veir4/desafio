/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AvaliacaoDetalheLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoDetalheLocalService
 * @generated
 */
public class AvaliacaoDetalheLocalServiceWrapper
	implements AvaliacaoDetalheLocalService,
			   ServiceWrapper<AvaliacaoDetalheLocalService> {

	public AvaliacaoDetalheLocalServiceWrapper() {
		this(null);
	}

	public AvaliacaoDetalheLocalServiceWrapper(
		AvaliacaoDetalheLocalService avaliacaoDetalheLocalService) {

		_avaliacaoDetalheLocalService = avaliacaoDetalheLocalService;
	}

	/**
	 * Adiciona um detalhe de avaliação vinculado a uma avaliação existente.
	 *
	 * @param avaliacao           Avaliação pai à qual o detalhe será vinculado
	 * @param tipoAvaliador       Tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @param nomeAvaliador       Nome completo do avaliador
	 * @param observacoesAvaliador Comentários específicos do avaliador
	 * @param desempenho          Nota de desempenho (1-5 conforme DesempenhoEnum)
	 * @param serviceContext      Contexto de serviço com informações de auditoria
	 * @return O detalhe de avaliação criado
	 * @throws PortalException    se os dados fornecidos forem inválidos
	 */
	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
			addAvaliacaoDetalhe(
				br.com.example.model.avaliacao.model.Avaliacao avaliacao,
				int tipoAvaliador, String nomeAvaliador,
				String observacoesAvaliador, int desempenho,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoDetalheLocalService.addAvaliacaoDetalhe(
			avaliacao, tipoAvaliador, nomeAvaliador, observacoesAvaliador,
			desempenho, serviceContext);
	}

	/**
	 * Adds the avaliacao detalhe to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoDetalheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacaoDetalhe the avaliacao detalhe
	 * @return the avaliacao detalhe that was added
	 */
	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
		addAvaliacaoDetalhe(
			br.com.example.model.avaliacao.model.AvaliacaoDetalhe
				avaliacaoDetalhe) {

		return _avaliacaoDetalheLocalService.addAvaliacaoDetalhe(
			avaliacaoDetalhe);
	}

	/**
	 * Creates a new avaliacao detalhe with the primary key. Does not add the avaliacao detalhe to the database.
	 *
	 * @param avaliacaoDetalheId the primary key for the new avaliacao detalhe
	 * @return the new avaliacao detalhe
	 */
	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
		createAvaliacaoDetalhe(long avaliacaoDetalheId) {

		return _avaliacaoDetalheLocalService.createAvaliacaoDetalhe(
			avaliacaoDetalheId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoDetalheLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the avaliacao detalhe from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoDetalheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacaoDetalhe the avaliacao detalhe
	 * @return the avaliacao detalhe that was removed
	 */
	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
		deleteAvaliacaoDetalhe(
			br.com.example.model.avaliacao.model.AvaliacaoDetalhe
				avaliacaoDetalhe) {

		return _avaliacaoDetalheLocalService.deleteAvaliacaoDetalhe(
			avaliacaoDetalhe);
	}

	/**
	 * Deletes the avaliacao detalhe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoDetalheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe that was removed
	 * @throws PortalException if a avaliacao detalhe with the primary key could not be found
	 */
	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
			deleteAvaliacaoDetalhe(long avaliacaoDetalheId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoDetalheLocalService.deleteAvaliacaoDetalhe(
			avaliacaoDetalheId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoDetalheLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _avaliacaoDetalheLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _avaliacaoDetalheLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _avaliacaoDetalheLocalService.dynamicQuery();
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

		return _avaliacaoDetalheLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoDetalheModelImpl</code>.
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

		return _avaliacaoDetalheLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoDetalheModelImpl</code>.
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

		return _avaliacaoDetalheLocalService.dynamicQuery(
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

		return _avaliacaoDetalheLocalService.dynamicQueryCount(dynamicQuery);
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

		return _avaliacaoDetalheLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
		fetchAvaliacaoDetalhe(long avaliacaoDetalheId) {

		return _avaliacaoDetalheLocalService.fetchAvaliacaoDetalhe(
			avaliacaoDetalheId);
	}

	/**
	 * Busca todos os detalhes de uma avaliação específica.
	 * MÉTODO CRÍTICO - usado pela API REST.
	 *
	 * @param avaliacaoId ID da avaliação pai
	 * @return lista de detalhes da avaliação
	 */
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe>
		findByAvaliacaoId(long avaliacaoId) {

		return _avaliacaoDetalheLocalService.findByAvaliacaoId(avaliacaoId);
	}

	/**
	 * Busca detalhes por nota de desempenho.
	 *
	 * @param desempenho nota de desempenho (1-5)
	 * @return lista de detalhes com a nota específica
	 */
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe>
		findByDesempenho(int desempenho) {

		return _avaliacaoDetalheLocalService.findByDesempenho(desempenho);
	}

	/**
	 * Busca detalhes por tipo de avaliador.
	 *
	 * @param tipoAvaliador tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @return lista de detalhes do tipo de avaliador
	 */
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe>
		findByTipoAvaliador(int tipoAvaliador) {

		return _avaliacaoDetalheLocalService.findByTipoAvaliador(tipoAvaliador);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _avaliacaoDetalheLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the avaliacao detalhe with the primary key.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe
	 * @throws PortalException if a avaliacao detalhe with the primary key could not be found
	 */
	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
			getAvaliacaoDetalhe(long avaliacaoDetalheId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoDetalheLocalService.getAvaliacaoDetalhe(
			avaliacaoDetalheId);
	}

	/**
	 * Returns a range of all the avaliacao detalhes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoDetalheModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of avaliacao detalhes
	 * @param end the upper bound of the range of avaliacao detalhes (not inclusive)
	 * @return the range of avaliacao detalhes
	 */
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe>
		getAvaliacaoDetalhes(int start, int end) {

		return _avaliacaoDetalheLocalService.getAvaliacaoDetalhes(start, end);
	}

	/**
	 * Returns the number of avaliacao detalhes.
	 *
	 * @return the number of avaliacao detalhes
	 */
	@Override
	public int getAvaliacaoDetalhesCount() {
		return _avaliacaoDetalheLocalService.getAvaliacaoDetalhesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _avaliacaoDetalheLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _avaliacaoDetalheLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoDetalheLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the avaliacao detalhe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoDetalheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacaoDetalhe the avaliacao detalhe
	 * @return the avaliacao detalhe that was updated
	 */
	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
		updateAvaliacaoDetalhe(
			br.com.example.model.avaliacao.model.AvaliacaoDetalhe
				avaliacaoDetalhe) {

		return _avaliacaoDetalheLocalService.updateAvaliacaoDetalhe(
			avaliacaoDetalhe);
	}

	/**
	 * Atualiza um detalhe de avaliação existente.
	 *
	 * @param avaliacaoDetalheId   ID do detalhe a ser atualizado
	 * @param tipoAvaliador        Tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @param nomeAvaliador        Nome completo do avaliador
	 * @param observacoesAvaliador Comentários específicos do avaliador
	 * @param desempenho           Nota de desempenho (1-5 conforme DesempenhoEnum)
	 * @param serviceContext       Contexto de serviço com informações de auditoria
	 * @return O detalhe de avaliação atualizado
	 * @throws PortalException     se os dados fornecidos forem inválidos
	 */
	@Override
	public br.com.example.model.avaliacao.model.AvaliacaoDetalhe
			updateAvaliacaoDetalhe(
				long avaliacaoDetalheId, int tipoAvaliador,
				String nomeAvaliador, String observacoesAvaliador,
				int desempenho,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoDetalheLocalService.updateAvaliacaoDetalhe(
			avaliacaoDetalheId, tipoAvaliador, nomeAvaliador,
			observacoesAvaliador, desempenho, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _avaliacaoDetalheLocalService.getBasePersistence();
	}

	@Override
	public AvaliacaoDetalheLocalService getWrappedService() {
		return _avaliacaoDetalheLocalService;
	}

	@Override
	public void setWrappedService(
		AvaliacaoDetalheLocalService avaliacaoDetalheLocalService) {

		_avaliacaoDetalheLocalService = avaliacaoDetalheLocalService;
	}

	private AvaliacaoDetalheLocalService _avaliacaoDetalheLocalService;

}