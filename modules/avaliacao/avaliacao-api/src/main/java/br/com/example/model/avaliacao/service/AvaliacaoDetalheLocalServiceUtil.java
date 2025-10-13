/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AvaliacaoDetalhe. This utility wraps
 * <code>br.com.example.model.avaliacao.service.impl.AvaliacaoDetalheLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoDetalheLocalService
 * @generated
 */
public class AvaliacaoDetalheLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.example.model.avaliacao.service.impl.AvaliacaoDetalheLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AvaliacaoDetalhe addAvaliacaoDetalhe(
			br.com.example.model.avaliacao.model.Avaliacao avaliacao,
			int tipoAvaliador, String nomeAvaliador,
			String observacoesAvaliador, int desempenho,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAvaliacaoDetalhe(
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
	public static AvaliacaoDetalhe addAvaliacaoDetalhe(
		AvaliacaoDetalhe avaliacaoDetalhe) {

		return getService().addAvaliacaoDetalhe(avaliacaoDetalhe);
	}

	/**
	 * Creates a new avaliacao detalhe with the primary key. Does not add the avaliacao detalhe to the database.
	 *
	 * @param avaliacaoDetalheId the primary key for the new avaliacao detalhe
	 * @return the new avaliacao detalhe
	 */
	public static AvaliacaoDetalhe createAvaliacaoDetalhe(
		long avaliacaoDetalheId) {

		return getService().createAvaliacaoDetalhe(avaliacaoDetalheId);
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
	 * Deletes the avaliacao detalhe from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoDetalheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacaoDetalhe the avaliacao detalhe
	 * @return the avaliacao detalhe that was removed
	 */
	public static AvaliacaoDetalhe deleteAvaliacaoDetalhe(
		AvaliacaoDetalhe avaliacaoDetalhe) {

		return getService().deleteAvaliacaoDetalhe(avaliacaoDetalhe);
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
	public static AvaliacaoDetalhe deleteAvaliacaoDetalhe(
			long avaliacaoDetalheId)
		throws PortalException {

		return getService().deleteAvaliacaoDetalhe(avaliacaoDetalheId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoDetalheModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoDetalheModelImpl</code>.
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

	public static AvaliacaoDetalhe fetchAvaliacaoDetalhe(
		long avaliacaoDetalheId) {

		return getService().fetchAvaliacaoDetalhe(avaliacaoDetalheId);
	}

	/**
	 * Busca todos os detalhes de uma avaliação específica.
	 *
	 * @param avaliacaoId ID da avaliação pai
	 * @return lista de detalhes da avaliação
	 */
	public static List<AvaliacaoDetalhe> findByAvaliacaoId(long avaliacaoId) {
		return getService().findByAvaliacaoId(avaliacaoId);
	}

	/**
	 * Busca detalhes por nota de desempenho.
	 *
	 * @param desempenho nota de desempenho (1-5)
	 * @return lista de detalhes com a nota específica
	 */
	public static List<AvaliacaoDetalhe> findByDesempenho(int desempenho) {
		return getService().findByDesempenho(desempenho);
	}

	/**
	 * Busca detalhes por tipo de avaliador.
	 *
	 * @param tipoAvaliador tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @return lista de detalhes do tipo de avaliador
	 */
	public static List<AvaliacaoDetalhe> findByTipoAvaliador(
		int tipoAvaliador) {

		return getService().findByTipoAvaliador(tipoAvaliador);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the avaliacao detalhe with the primary key.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe
	 * @throws PortalException if a avaliacao detalhe with the primary key could not be found
	 */
	public static AvaliacaoDetalhe getAvaliacaoDetalhe(long avaliacaoDetalheId)
		throws PortalException {

		return getService().getAvaliacaoDetalhe(avaliacaoDetalheId);
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
	public static List<AvaliacaoDetalhe> getAvaliacaoDetalhes(
		int start, int end) {

		return getService().getAvaliacaoDetalhes(start, end);
	}

	/**
	 * Returns the number of avaliacao detalhes.
	 *
	 * @return the number of avaliacao detalhes
	 */
	public static int getAvaliacaoDetalhesCount() {
		return getService().getAvaliacaoDetalhesCount();
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
	 * Updates the avaliacao detalhe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoDetalheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacaoDetalhe the avaliacao detalhe
	 * @return the avaliacao detalhe that was updated
	 */
	public static AvaliacaoDetalhe updateAvaliacaoDetalhe(
		AvaliacaoDetalhe avaliacaoDetalhe) {

		return getService().updateAvaliacaoDetalhe(avaliacaoDetalhe);
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
	public static AvaliacaoDetalhe updateAvaliacaoDetalhe(
			long avaliacaoDetalheId, int tipoAvaliador, String nomeAvaliador,
			String observacoesAvaliador, int desempenho,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateAvaliacaoDetalhe(
			avaliacaoDetalheId, tipoAvaliador, nomeAvaliador,
			observacoesAvaliador, desempenho, serviceContext);
	}

	public static AvaliacaoDetalheLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AvaliacaoDetalheLocalService>
		_serviceSnapshot = new Snapshot<>(
			AvaliacaoDetalheLocalServiceUtil.class,
			AvaliacaoDetalheLocalService.class);

}