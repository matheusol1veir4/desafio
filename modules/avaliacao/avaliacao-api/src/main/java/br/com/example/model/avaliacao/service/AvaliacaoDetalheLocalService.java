/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AvaliacaoDetalhe. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoDetalheLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AvaliacaoDetalheLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>br.com.example.model.avaliacao.service.impl.AvaliacaoDetalheLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the avaliacao detalhe local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AvaliacaoDetalheLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public AvaliacaoDetalhe addAvaliacaoDetalhe(
			Avaliacao avaliacao, int tipoAvaliador, String nomeAvaliador,
			String observacoesAvaliador, int desempenho,
			ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public AvaliacaoDetalhe addAvaliacaoDetalhe(
		AvaliacaoDetalhe avaliacaoDetalhe);

	/**
	 * Creates a new avaliacao detalhe with the primary key. Does not add the avaliacao detalhe to the database.
	 *
	 * @param avaliacaoDetalheId the primary key for the new avaliacao detalhe
	 * @return the new avaliacao detalhe
	 */
	@Transactional(enabled = false)
	public AvaliacaoDetalhe createAvaliacaoDetalhe(long avaliacaoDetalheId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public AvaliacaoDetalhe deleteAvaliacaoDetalhe(
		AvaliacaoDetalhe avaliacaoDetalhe);

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
	@Indexable(type = IndexableType.REINDEX)
	public AvaliacaoDetalhe deleteAvaliacaoDetalhe(long avaliacaoDetalheId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AvaliacaoDetalhe fetchAvaliacaoDetalhe(long avaliacaoDetalheId);

	/**
	 * Busca todos os detalhes de uma avaliação específica.
	 *
	 * @param avaliacaoId ID da avaliação pai
	 * @return lista de detalhes da avaliação
	 */
	public List<AvaliacaoDetalhe> findByAvaliacaoId(long avaliacaoId);

	/**
	 * Busca detalhes por nota de desempenho.
	 *
	 * @param desempenho nota de desempenho (1-5)
	 * @return lista de detalhes com a nota específica
	 */
	public List<AvaliacaoDetalhe> findByDesempenho(int desempenho);

	/**
	 * Busca detalhes por tipo de avaliador.
	 *
	 * @param tipoAvaliador tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @return lista de detalhes do tipo de avaliador
	 */
	public List<AvaliacaoDetalhe> findByTipoAvaliador(int tipoAvaliador);

	/**
	 * Busca detalhes por tipo de avaliador E desempenho.
	 *
	 * Usado para encontrar detalhes pendentes (desempenho = 0) de um tipo de avaliador específico.
	 *
	 * @param tipoAvaliador tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @param desempenho nota de desempenho (geralmente 0 para pendentes, ou 1-5 para preenchidos)
	 * @return lista de detalhes que atendem ambos os critérios
	 */
	public List<AvaliacaoDetalhe> findByTipoAvaliadorAndDesempenho(
		int tipoAvaliador, int desempenho);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the avaliacao detalhe with the primary key.
	 *
	 * @param avaliacaoDetalheId the primary key of the avaliacao detalhe
	 * @return the avaliacao detalhe
	 * @throws PortalException if a avaliacao detalhe with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AvaliacaoDetalhe getAvaliacaoDetalhe(long avaliacaoDetalheId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AvaliacaoDetalhe> getAvaliacaoDetalhes(int start, int end);

	/**
	 * Returns the number of avaliacao detalhes.
	 *
	 * @return the number of avaliacao detalhes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAvaliacaoDetalhesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public AvaliacaoDetalhe updateAvaliacaoDetalhe(
		AvaliacaoDetalhe avaliacaoDetalhe);

	/**
	 * Atualiza um detalhe de avaliação existente.
	 * O tipo de avaliador NÃO pode ser alterado após a criação (imutável).
	 *
	 * @param avaliacaoDetalheId   ID do detalhe a ser atualizado
	 * @param tipoAvaliador        Tipo do avaliador (deve ser igual ao original, não pode mudar)
	 * @param nomeAvaliador        Nome completo do avaliador
	 * @param observacoesAvaliador Comentários específicos do avaliador
	 * @param desempenho           Nota de desempenho (1-5 conforme DesempenhoEnum)
	 * @param serviceContext       Contexto de serviço com informações de auditoria
	 * @return O detalhe de avaliação atualizado
	 * @throws PortalException     se os dados forem inválidos ou tipo de avaliador for diferente do original
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AvaliacaoDetalhe updateAvaliacaoDetalhe(
			long avaliacaoDetalheId, int tipoAvaliador, String nomeAvaliador,
			String observacoesAvaliador, int desempenho,
			ServiceContext serviceContext)
		throws PortalException;

}