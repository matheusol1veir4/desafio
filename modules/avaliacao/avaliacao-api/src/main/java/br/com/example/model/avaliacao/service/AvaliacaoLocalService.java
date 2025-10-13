/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service;

import br.com.example.model.avaliacao.model.Avaliacao;

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

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Avaliacao. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AvaliacaoLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>br.com.example.model.avaliacao.service.impl.AvaliacaoLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the avaliacao local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AvaliacaoLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public Avaliacao addAvaliacao(Avaliacao avaliacao);

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
	@Indexable(type = IndexableType.REINDEX)
	public Avaliacao addAvaliacao(
			long funcionarioId, Date dataAvaliacao, int periodoDesafio,
			String observacoesGerais, int areaAtuacao,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new avaliacao with the primary key. Does not add the avaliacao to the database.
	 *
	 * @param avaliacaoId the primary key for the new avaliacao
	 * @return the new avaliacao
	 */
	@Transactional(enabled = false)
	public Avaliacao createAvaliacao(long avaliacaoId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Avaliacao deleteAvaliacao(Avaliacao avaliacao);

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
	@Indexable(type = IndexableType.REINDEX)
	public Avaliacao deleteAvaliacao(long avaliacaoId) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.example.model.avaliacao.model.impl.AvaliacaoModelImpl</code>.
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
	public Avaliacao fetchAvaliacao(long avaliacaoId);

	/**
	 * Busca avaliações por área de atuação.
	 *
	 * @param areaAtuacao área de atuação (1=Analista, 2=Tester, 3=UI, etc.)
	 * @return lista de avaliações da área
	 */
	public List<Avaliacao> findByAreaAtuacao(int areaAtuacao);

	public List<Avaliacao> findByFuncionarioId(long funcionarioId);

	/**
	 * Busca avaliação específica de um funcionário em determinado período.
	 * Deve ser único por regra de negócio (um funcionário só pode ter uma avaliação por período).
	 *
	 * @param funcionarioId ID do funcionário
	 * @param periodoDesafio período do desafio (30, 60 ou 90 dias)
	 * @return avaliação encontrada ou null se não existir
	 */
	public Avaliacao findByFuncionarioIdAndPeriodoDesafio(
		long funcionarioId, int periodoDesafio);

	/**
	 * Busca todas as avaliações de um período específico.
	 *
	 * @param periodoDesafio período do desafio (1=30, 2=60, 3=90 dias)
	 * @return lista de avaliações do período
	 */
	public List<Avaliacao> findByPeriodoDesafio(int periodoDesafio);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the avaliacao with the primary key.
	 *
	 * @param avaliacaoId the primary key of the avaliacao
	 * @return the avaliacao
	 * @throws PortalException if a avaliacao with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Avaliacao getAvaliacao(long avaliacaoId) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Avaliacao> getAvaliacaos(int start, int end);

	/**
	 * Returns the number of avaliacaos.
	 *
	 * @return the number of avaliacaos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAvaliacaosCount();

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
	 * Updates the avaliacao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AvaliacaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param avaliacao the avaliacao
	 * @return the avaliacao that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Avaliacao updateAvaliacao(Avaliacao avaliacao);

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
	@Indexable(type = IndexableType.REINDEX)
	public Avaliacao updateAvaliacao(
			long avaliacaoId, Date dataAvaliacao, int periodoDesafio,
			String observacoesGerais, int areaAtuacao,
			ServiceContext serviceContext)
		throws PortalException;

}