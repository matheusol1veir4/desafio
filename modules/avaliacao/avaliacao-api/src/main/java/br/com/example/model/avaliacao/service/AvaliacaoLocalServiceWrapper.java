/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AvaliacaoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoLocalService
 * @generated
 */
public class AvaliacaoLocalServiceWrapper
	implements AvaliacaoLocalService, ServiceWrapper<AvaliacaoLocalService> {

	public AvaliacaoLocalServiceWrapper() {
		this(null);
	}

	public AvaliacaoLocalServiceWrapper(
		AvaliacaoLocalService avaliacaoLocalService) {

		_avaliacaoLocalService = avaliacaoLocalService;
	}

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
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao addAvaliacao(
		br.com.example.model.avaliacao.model.Avaliacao avaliacao) {

		return _avaliacaoLocalService.addAvaliacao(avaliacao);
	}

	/**
	 * Cria uma nova avaliação de desafio para um funcionário.
	 *
	 * @param funcionarioId     ID do usuário que está sendo avaliado
	 * @param dataAvaliacao     Data em que a avaliação está sendo criada
	 * @param periodoDesafio    Período do ciclo (30, 60 ou 90 dias)
	 * @param observacoesGerais Comentários gerais sobre a avaliação
	 * @param areaAtuacao       Área de atuação do funcionário
	 * @param serviceContext    Contexto de serviço com informações de auditoria
	 * @return A avaliação criada
	 * @throws PortalException  se os dados fornecidos forem inválidos
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao addAvaliacao(
			long funcionarioId, java.util.Date dataAvaliacao,
			int periodoDesafio, String observacoesGerais, int areaAtuacao,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoLocalService.addAvaliacao(
			funcionarioId, dataAvaliacao, periodoDesafio, observacoesGerais,
			areaAtuacao, serviceContext);
	}

	/**
	 * Creates a new avaliacao with the primary key. Does not add the avaliacao to the database.
	 *
	 * @param avaliacaoId the primary key for the new avaliacao
	 * @return the new avaliacao
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao createAvaliacao(
		long avaliacaoId) {

		return _avaliacaoLocalService.createAvaliacao(avaliacaoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao deleteAvaliacao(
		br.com.example.model.avaliacao.model.Avaliacao avaliacao) {

		return _avaliacaoLocalService.deleteAvaliacao(avaliacao);
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
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao deleteAvaliacao(
			long avaliacaoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoLocalService.deleteAvaliacao(avaliacaoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _avaliacaoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _avaliacaoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _avaliacaoLocalService.dynamicQuery();
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

		return _avaliacaoLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _avaliacaoLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _avaliacaoLocalService.dynamicQuery(
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

		return _avaliacaoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _avaliacaoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.example.model.avaliacao.model.Avaliacao fetchAvaliacao(
		long avaliacaoId) {

		return _avaliacaoLocalService.fetchAvaliacao(avaliacaoId);
	}

	/**
	 * Busca avaliações por área de atuação.
	 *
	 * @param areaAtuacao área de atuação (1=Analista, 2=Tester, 3=UI, etc.)
	 * @return lista de avaliações da área
	 */
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.Avaliacao>
		findByAreaAtuacao(int areaAtuacao) {

		return _avaliacaoLocalService.findByAreaAtuacao(areaAtuacao);
	}

	@Override
	public java.util.List<br.com.example.model.avaliacao.model.Avaliacao>
		findByFuncionarioId(long funcionarioId) {

		return _avaliacaoLocalService.findByFuncionarioId(funcionarioId);
	}

	/**
	 * Busca avaliação específica de um funcionário em determinado período.
	 * Deve ser único por regra de negócio (um funcionário só pode ter uma avaliação por período).
	 *
	 * @param funcionarioId ID do funcionário
	 * @param periodoDesafio período do desafio (30, 60 ou 90 dias)
	 * @return avaliação encontrada ou null se não existir
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao
		findByFuncionarioIdAndPeriodoDesafio(
			long funcionarioId, int periodoDesafio) {

		return _avaliacaoLocalService.findByFuncionarioIdAndPeriodoDesafio(
			funcionarioId, periodoDesafio);
	}

	/**
	 * Busca todas as avaliações de um período específico.
	 *
	 * @param periodoDesafio período do desafio (1=30, 2=60, 3=90 dias)
	 * @return lista de avaliações do período
	 */
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.Avaliacao>
		findByPeriodoDesafio(int periodoDesafio) {

		return _avaliacaoLocalService.findByPeriodoDesafio(periodoDesafio);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _avaliacaoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the avaliacao with the primary key.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao
	 * @throws PortalException if a avaliacao with the primary key could not be found
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao getAvaliacao(
			long avaliacaoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoLocalService.getAvaliacao(avaliacaoId);
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
	@Override
	public java.util.List<br.com.example.model.avaliacao.model.Avaliacao>
		getAvaliacaos(int start, int end) {

		return _avaliacaoLocalService.getAvaliacaos(start, end);
	}

	/**
	 * Returns the number of avaliacaos.
	 *
	 * @return the number of avaliacaos
	 */
	@Override
	public int getAvaliacaosCount() {
		return _avaliacaoLocalService.getAvaliacaosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _avaliacaoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _avaliacaoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao updateAvaliacao(
		br.com.example.model.avaliacao.model.Avaliacao avaliacao) {

		return _avaliacaoLocalService.updateAvaliacao(avaliacao);
	}

	/**
	 * Atualiza uma avaliação existente.
	 * Não permite alterar o funcionário após criação.
	 *
	 * @param avaliacaoId       ID da avaliação a ser atualizada
	 * @param dataAvaliacao     Nova data da avaliação
	 * @param periodoDesafio    Novo período do desafio
	 * @param observacoesGerais Novas observações gerais
	 * @param areaAtuacao       Nova área de atuação
	 * @param serviceContext    Contexto de serviço
	 * @return A avaliação atualizada
	 * @throws PortalException  se os dados forem inválidos ou funcionário for alterado
	 */
	@Override
	public br.com.example.model.avaliacao.model.Avaliacao updateAvaliacao(
			long avaliacaoId, java.util.Date dataAvaliacao, int periodoDesafio,
			String observacoesGerais, int areaAtuacao,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _avaliacaoLocalService.updateAvaliacao(
			avaliacaoId, dataAvaliacao, periodoDesafio, observacoesGerais,
			areaAtuacao, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _avaliacaoLocalService.getBasePersistence();
	}

	@Override
	public AvaliacaoLocalService getWrappedService() {
		return _avaliacaoLocalService;
	}

	@Override
	public void setWrappedService(AvaliacaoLocalService avaliacaoLocalService) {
		_avaliacaoLocalService = avaliacaoLocalService;
	}

	private AvaliacaoLocalService _avaliacaoLocalService;

}