package br.com.desafio.avaliacao.headless.internal.resource.v1_0;


import br.com.desafio.avaliacao.headless.dto.v1_0.Avaliacao;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoCompleta;
import br.com.desafio.avaliacao.headless.dto.v1_0.AvaliacaoDetalhe;
import br.com.desafio.avaliacao.headless.internal.converter.ConverterDto;
import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoResource;
import br.com.example.model.avaliacao.permission.AvaliacaoPermissionChecker;
import br.com.example.model.avaliacao.permission.PermissionConstants;
import br.com.example.model.avaliacao.service.AvaliacaoDetalheLocalService;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import br.com.example.model.avaliacao.service.search.AvaliacaoSearchHelper;
import br.com.example.model.avaliacao.service.search.AvaliacaoSearchService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;

import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Resource implementation para gerenciamento de avaliações via REST API.
 *
 * @author sea
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/avaliacao.properties",
		scope = ServiceScope.PROTOTYPE,
		service = AvaliacaoResource.class
)
public class AvaliacaoResourceImpl extends BaseAvaliacaoResourceImpl {



	/**
	 * Busca uma avaliação específica por ID.
	 *
	 * @param avaliacaoId ID da avaliação
	 * @return DTO da avaliação encontrada
	 * @throws PortalException se a avaliação não for encontrada
	 */
	@Override
	public Avaliacao getAvaliacaoById(Long avaliacaoId) throws PortalException {

		// Busca avaliação no banco via LocalService
		br.com.example.model.avaliacao.model.Avaliacao entity =
				_avaliacaoLocalService.getAvaliacao(avaliacaoId);

		return ConverterDto.entityToDto(entity); // Converte entity para DTO
	}


	/**
	 * Busca todas as avaliações de um funcionário específico.
	 *
	 * @param funcionarioId ID do funcionário
	 * @return página contendo lista de avaliações do funcionário
	 * @throws PortalException se houver erro ao acessar o banco de dados
	 */
	@Override
	public Page<Avaliacao> getAvaliacoesByFuncionario(Long funcionarioId)
			throws PortalException {

		// Busca entidades no banco via LocalService
		List<br.com.example.model.avaliacao.model.Avaliacao> entities =
				_avaliacaoLocalService.findByFuncionarioId(funcionarioId);

		// Retorna página vazia se não houver dados
		if (entities == null || entities.isEmpty()) {
			return Page.of(new ArrayList<>());
		}

		List<Avaliacao> dtos = ConverterDto.entityListToDtoList(entities);

		return Page.of(dtos); // Retorna página com DTOs
	}

	/**
	 * Busca a avaliação específica de um funcionário em determinado período.
	 *
	 * @param funcionarioId ID do funcionário
	 * @param periodoDesafio período do desafio (1=30, 2=60, 3=90 dias)
	 * @return DTO da avaliação encontrada
	 * @throws PortalException se a avaliação não for encontrada
	 */
	@Override
	public Avaliacao getAvaliacaoByFuncionarioAndPeriodo(Long funcionarioId, Integer periodoDesafio)
			throws PortalException {

		// Busca avaliação no banco via LocalService
		br.com.example.model.avaliacao.model.Avaliacao entity =
				_avaliacaoLocalService.findByFuncionarioIdAndPeriodoDesafio(funcionarioId, periodoDesafio);

		if (entity == null) {
			throw new PortalException("Avaliação não encontrada para funcionário " + funcionarioId +
					" no período " + periodoDesafio);
		}

		return convertEntityToDTO(entity); // Converte entity para DTO
	}

	/**
	 * Busca avaliação completa com todos os detalhes de avaliadores.
	 *
	 * @param avaliacaoId ID da avaliação
	 * @return AvaliacaoCompleta DTO com avaliação + array de detalhes
	 * @throws PortalException se a avaliação não existir
	 */
	@Override
	public AvaliacaoCompleta getAvaliacaoCompletaById(Long avaliacaoId) throws PortalException {

		// 1. Busca a avaliação principal
		br.com.example.model.avaliacao.model.Avaliacao avaliacaoEntity =
				_avaliacaoLocalService.getAvaliacao(avaliacaoId);

		// 2. Busca TODOS os detalhes relacionados
		List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> detalhesEntities =
				_avaliacaoDetalheLocalService.findByAvaliacaoId(avaliacaoId);

		// 3. NOVO: Usa ConverterDto para montar DTO composto
		return ConverterDto.toAvaliacaoCompleta(avaliacaoEntity, detalhesEntities);
	}

	/**
	 * Busca funcionários ativos do Liferay pelo nome.
	 *
	 * GET /o/avaliacao-headless/v1.0/funcionarios
	 */
	@Override
	public Page getFuncionarios(
			String nome,
			Pagination pagination
	) throws Exception {

		long companyId = PortalUtil.getCompanyId(contextHttpServletRequest);

		try {
			// 1. Busca TODOS os usuários ativos da empresa
			List<com.liferay.portal.kernel.model.User> allUsers =
					_userLocalService.getCompanyUsers(companyId, 0, Integer.MAX_VALUE);

			// 2. Filtra apenas usuários ATIVOS
			List<com.liferay.portal.kernel.model.User> activeUsers = allUsers.stream()
					.filter(user -> user.isActive())
					.collect(Collectors.toList());

			// 3. Se foi passado filtro de nome
			if (Validator.isNotNull(nome) && !nome.trim().isEmpty()) {
				String nomeLower = nome.toLowerCase();
				activeUsers = activeUsers.stream()
						.filter(user -> user.getFullName().toLowerCase().contains(nomeLower))
						.collect(Collectors.toList());
			}

			// 4. Ordenar por nome
			activeUsers.sort((u1, u2) -> u1.getFullName().compareTo(u2.getFullName()));

			// 5. Aplicar paginação
			int totalCount = activeUsers.size();
			int start = pagination != null ? pagination.getStartPosition() : 0;
			int end = pagination != null ?
					Math.min(pagination.getEndPosition(), totalCount) : totalCount;

			List<com.liferay.portal.kernel.model.User> paginatedUsers =
					activeUsers.subList(start, end);

			// 6. Converter para Map/JSON - MAS agora retorna a lista completa
			List<Map<String, Object>> funcionarioDtos = paginatedUsers.stream()
					.map(user -> {
						Map<String, Object> dto = new HashMap<>();
						dto.put("funcionarioId", user.getUserId());
						dto.put("nome", user.getFullName());
						dto.put("email", user.getEmailAddress());
						dto.put("screenName", user.getScreenName());
						return dto;
					})
					.collect(Collectors.toList());

			// 7. CORRIGIDO: Retorna a LISTA de Maps, não um Map único
			// A estrutura JSON será montada automaticamente pelo Liferay
			return Page.of(funcionarioDtos, pagination, totalCount);

		} catch (Exception e) {
			_log.error("Erro ao buscar funcionários: " + e.getMessage(), e);
			throw new Exception("Erro ao buscar funcionários: " + e.getMessage(), e);
		}
	}

	/**
	 * Retorna avaliações pendentes para o usuário logado baseado no seu papel.
	 *
	 * Endpoint: GET /o/avaliacao-headless/v1.0/avaliacoes/pendentes-para-mim
	 *
	 * Busca avaliações onde o usuário tem um detalhe pendente (desempenho = 0).
	 *
	 * @return Page com lista de AvaliacaoCompleta onde o usuário tem detalhe pendente
	 * @throws PortalException se usuário não autenticado ou sem papel de avaliador
	 */
	@Override
	public Page<AvaliacaoCompleta> getAvaliacoesPendentesParaMim() throws PortalException {
		// ==========================================
		// 1. OBTER USUÁRIO LOGADO
		// ==========================================
		User currentUser = getLoginUser();
		if (currentUser == null) {
			_log.error("❌ ERRO: Usuário não autenticado!");
			throw new PortalException("Usuário não autenticado");
		}

		_log.info("========== INÍCIO: getAvaliacoesPendentesParaMim ==========");
		_log.info("✅ USUÁRIO LOGADO: " + currentUser.getFullName() + " (ID: " + currentUser.getUserId() + ")");
		_log.info("✅ E-MAIL: " + currentUser.getEmailAddress());

		// ==========================================
		// 2. DESCOBRIR TIPO DO AVALIADOR
		// ==========================================
		int tipoAvaliador = obterTipoAvaliadorDoUsuario(currentUser);

		_log.info("📋 TIPO DE AVALIADOR: " + tipoAvaliador);
		_log.info("   1 = Tech Lead | 2 = Gerente | 3 = RH");

		if (tipoAvaliador == 0) {
			_log.error("❌ ERRO: Usuário não possui papel de avaliador!");
			throw new PortalException("Usuário não possui papel de avaliador (Tech Lead, Gerente ou RH)");
		}

		// ==========================================
		// 3. BUSCAR DETALHES PENDENTES
		// ==========================================
		_log.info("🔍 BUSCANDO DETALHES PENDENTES...");
		_log.info("   Filtro: tipoAvaliador = " + tipoAvaliador + " AND desempenho = 0");

		List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> detalhesPendentes =
				_avaliacaoDetalheLocalService.findByTipoAvaliadorAndDesempenho(tipoAvaliador, 0);

		_log.info("📊 RESULTADO DA BUSCA:");
		if (detalhesPendentes == null) {
			_log.warn("⚠️  Lista de detalhes retornou NULL!");
			return Page.of(new ArrayList<>());
		}

		_log.info("   ✅ TOTAL DE DETALHES PENDENTES: " + detalhesPendentes.size());

		if (detalhesPendentes.isEmpty()) {
			_log.warn("⚠️  NENHUM DETALHE PENDENTE ENCONTRADO para tipoAvaliador = " + tipoAvaliador);
			_log.warn("   Isso significa que não existem avaliações aguardando preenchimento deste tipo de avaliador.");
			return Page.of(new ArrayList<>());
		}

		// ==========================================
		// 4. LOG DOS DETALHES ENCONTRADOS
		// ==========================================
		_log.info("📝 DETALHES PENDENTES ENCONTRADOS:");
		for (br.com.example.model.avaliacao.model.AvaliacaoDetalhe detalhe : detalhesPendentes) {
			_log.info("   - Detalhe ID: " + detalhe.getAvaliacaoDetalheId() +
					" | Avaliação ID: " + detalhe.getAvaliacaoId() +
					" | Tipo: " + detalhe.getTipoAvaliador() +
					" | Desempenho: " + detalhe.getDesempenho());
		}

		// ==========================================
		// 5. MONTAR AVALIAÇÕES COMPLETAS
		// ==========================================
		List<AvaliacaoCompleta> avaliacoesCompletas = new ArrayList<>();
		Set<Long> avaliacoesJaProcessadas = new HashSet<>();

		_log.info("🔄 MONTANDO AVALIAÇÕES COMPLETAS...");

		for (br.com.example.model.avaliacao.model.AvaliacaoDetalhe detalhe : detalhesPendentes) {
			try {
				// Evita processar a mesma avaliação várias vezes
				if (avaliacoesJaProcessadas.contains(detalhe.getAvaliacaoId())) {
					_log.info("   ⏭️  Avaliação " + detalhe.getAvaliacaoId() + " já processada. Pulando...");
					continue;
				}

				// Buscar avaliação principal
				_log.info("   📥 Buscando Avaliação ID: " + detalhe.getAvaliacaoId());
				br.com.example.model.avaliacao.model.Avaliacao avaliacaoEntity =
						_avaliacaoLocalService.getAvaliacao(detalhe.getAvaliacaoId());

				// Buscar TODOS os detalhes desta avaliação
				List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> todosDetalhes =
						_avaliacaoDetalheLocalService.findByAvaliacaoId(detalhe.getAvaliacaoId());

				_log.info("   ✅ Avaliação encontrada! Funcionário: " + avaliacaoEntity.getUserName());
				_log.info("   ✅ Total de detalhes: " + (todosDetalhes != null ? todosDetalhes.size() : 0));

				// Converter para DTO composto
				AvaliacaoCompleta avaliacaoCompleta =
						ConverterDto.toAvaliacaoCompleta(avaliacaoEntity, todosDetalhes);

				avaliacoesCompletas.add(avaliacaoCompleta);
				avaliacoesJaProcessadas.add(detalhe.getAvaliacaoId());

			} catch (Exception e) {
				_log.error("❌ ERRO ao processar Avaliação ID " + detalhe.getAvaliacaoId() + ": " + e.getMessage(), e);
				// Continua para próxima
			}
		}

		// ==========================================
		// 6. RETORNAR RESULTADO
		// ==========================================
		_log.info("📤 RESULTADO FINAL:");
		_log.info("   ✅ TOTAL DE AVALIAÇÕES PENDENTES: " + avaliacoesCompletas.size());
		_log.info("========== FIM: getAvaliacoesPendentesParaMim ==========\n");

		return Page.of(avaliacoesCompletas);
	}




	/**
	 * Busca avaliações com filtros opcionais.
	 *
	 * Endpoint: GET /o/desafio-avaliacao/v1.0/avaliacoes/search
	 */
	@Override
	public Page<Avaliacao> searchAvaliacoes(
			String nome,
			String email,
			String data,
			Integer area,
			Integer periodo,
			Pagination pagination
	) throws Exception {

		long companyId = PortalUtil.getCompanyId(contextHttpServletRequest);

		// Validações
		if (!_searchHelper.isValidDateFormat(data)) {
			throw new IllegalArgumentException("Formato de data inválido. Use: yyyy-MM-dd");
		}

		if (!_searchHelper.isValidArea(area)) {
			throw new IllegalArgumentException("Área inválida. Valores permitidos: 1-5");
		}

		if (!_searchHelper.isValidPeriodo(periodo)) {
			throw new IllegalArgumentException("Período inválido. Valores permitidos: 1-3");
		}

		// Normalizar email
		email = _searchHelper.normalizeEmail(email);

		// Executar busca
		AvaliacaoSearchService.SearchResult searchResult = _searchService.searchAvaliacoes(
				nome,
				email,
				data,
				area,
				periodo,
				companyId,
				pagination.getStartPosition(),
				pagination.getEndPosition()
		);

		// Converter entidades para DTOs
		List<br.com.example.model.avaliacao.model.Avaliacao> entities = searchResult.getItems();
		List<Avaliacao> dtos = ConverterDto.entityListToDtoList(entities);

		// Retornar página com DTOs
		return Page.of(dtos, pagination, searchResult.getTotalCount());
	}



	/**
	 * Cria uma nova avaliação de desafio para um funcionário.
	 *
	 * @param avaliacao DTO contendo dados da nova avaliação
	 * @return DTO da avaliação criada com ID gerado
	 * @throws PortalException se os dados forem inválidos
	 */
	@Override
	public Avaliacao createAvaliacao(Avaliacao avaliacao) throws PortalException {

		// Chama LocalService para persistir nova avaliação
		br.com.example.model.avaliacao.model.Avaliacao entity =
				_avaliacaoLocalService.addAvaliacao(
						avaliacao.getFuncionarioId(),        // ID do funcionário
						avaliacao.getDataAvaliacao(),        // Date direto do DTO
						avaliacao.getPeriodoDesafio(),       // Período (30/60/90 dias)
						avaliacao.getObservacoesGerais(),    // Observações gerais
						avaliacao.getAreaAtuacao(),          // Área de atuação
						createServiceContext()               // Contexto da requisição
				);

		return ConverterDto.entityToDto(entity);  // Converte entity salva para DTO
	}

	/**
	 * Cria uma avaliação completa (avaliação + todos os detalhes) em uma única requisição.
	 * Endpoint: POST /o/desafio-avaliacao/v1.0/avaliacoes/completa
	 *
	 * @param avaliacaoCompleta DTO com avaliação + array de detalhes (TechLead, Gerente, RH)
	 * @return AvaliacaoCompleta DTO com IDs gerados
	 * @throws PortalException se dados inválidos ou erro ao salvar
	 */
	@Override
	public AvaliacaoCompleta createAvaliacaoCompleta(AvaliacaoCompleta avaliacaoCompleta)
			throws PortalException {

		ServiceContext serviceContext = createServiceContext();

		// 1. Cria a AVALIAÇÃO principal
		br.com.example.model.avaliacao.model.Avaliacao avaliacaoEntity =
				_avaliacaoLocalService.addAvaliacao(
						avaliacaoCompleta.getFuncionarioId(),
						avaliacaoCompleta.getDataAvaliacao(),
						avaliacaoCompleta.getPeriodoDesafio(),
						avaliacaoCompleta.getObservacoesGerais(),
						avaliacaoCompleta.getAreaAtuacao(),
						serviceContext
				);
		// aplicar no futuro
//		// 2. Cria 3 detalhes VAZIOS obrigatórios
//		List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> detalhesEntities =
//				new ArrayList<>();
//		// Detalhe vazio para Tech Lead (tipo 1)
//		br.com.example.model.avaliacao.model.AvaliacaoDetalhe detalheTechLead =
//				_avaliacaoDetalheLocalService.addAvaliacaoDetalhe(
//						avaliacaoEntity,
//						1,      // TechLead
//						null,   // Nome vazio
//						null,   // Observações vazias
//						0,      // Desempenho vazio
//						serviceContext
//				);
//		detalhesEntities.add(detalheTechLead);
//
//		// Detalhe vazio para Gerente (tipo 2)
//		br.com.example.model.avaliacao.model.AvaliacaoDetalhe detalheGerente =
//				_avaliacaoDetalheLocalService.addAvaliacaoDetalhe(
//						avaliacaoEntity,
//						2,      // Gerente
//						null,   // Nome vazio
//						null,   // Observações vazias
//						0,      // Desempenho vazio
//						serviceContext
//				);
//		detalhesEntities.add(detalheGerente);
//
//		// Detalhe vazio para RH (tipo 3)
//		br.com.example.model.avaliacao.model.AvaliacaoDetalhe detalheRH =
//				_avaliacaoDetalheLocalService.addAvaliacaoDetalhe(
//						avaliacaoEntity,
//						3,      // RH
//						null,   // Nome vazio
//						null,   // Observações vazias
//						0,      // Desempenho vazio
//						serviceContext
//				);
//		detalhesEntities.add(detalheRH);

		// 2. Busca detalhes existentes (se houver)
		List<br.com.example.model.avaliacao.model.AvaliacaoDetalhe> detalhesEntities =
				_avaliacaoDetalheLocalService.findByAvaliacaoId(avaliacaoEntity.getAvaliacaoId());

		// Se não houver detalhes, retorna lista vazia
		if (detalhesEntities == null) {
			detalhesEntities = new ArrayList<>();
		}

		// 3. Converte tudo de volta para DTO composto
		return ConverterDto.toAvaliacaoCompleta(avaliacaoEntity, detalhesEntities);
	}


	/**
	 * Atualiza uma avaliação existente.
	 * Não permite alterar o funcionário após criação.
	 *
	 * @param avaliacaoId ID da avaliação a ser atualizada
	 * @param avaliacao DTO contendo novos dados da avaliação
	 * @return DTO da avaliação atualizada
	 * @throws PortalException se a avaliação não existir ou dados forem inválidos
	 */
	@Override
	public Avaliacao updateAvaliacao(Long avaliacaoId, Avaliacao avaliacao)
			throws PortalException {

		// Chama LocalService para atualizar avaliação existente
		br.com.example.model.avaliacao.model.Avaliacao entity =
				_avaliacaoLocalService.updateAvaliacao(
						avaliacaoId,                         // ID da avaliação a atualizar
						avaliacao.getDataAvaliacao(),        // Nova data
						avaliacao.getPeriodoDesafio(),       // Novo período
						avaliacao.getObservacoesGerais(),    // Novas observações
						avaliacao.getAreaAtuacao(),          // Nova área
						createServiceContext()               // Contexto da requisição
				);

		return convertEntityToDTO(entity);  // Retorna DTO atualizado
	}

	/**
	 * Remove uma avaliação e todos os seus detalhes relacionados (cascade delete).
	 *
	 * @param avaliacaoId ID da avaliação a ser removida
	 * @return Response HTTP 204 (No Content)
	 * @throws PortalException se a avaliação não for encontrada
	 */
	@Override
	public Response deleteAvaliacao(Long avaliacaoId) throws PortalException {

		// LocalService faz deleção em cascata (avaliacao + detalhes)
		_avaliacaoLocalService.deleteAvaliacao(avaliacaoId);

		return Response.noContent().build();  // HTTP 204 No Content
	}

	/**
	 * Converte entidade de domínio para DTO REST.
	 *
	 * @param entity entidade de domínio Avaliacao do banco
	 * @return DTO Avaliacao pronto para serialização JSON/XML
	 */
	private Avaliacao convertEntityToDTO(
			br.com.example.model.avaliacao.model.Avaliacao entity) {

		Avaliacao dto = new Avaliacao();  // Cria novo DTO

		dto.setAvaliacaoId(entity.getAvaliacaoId());        // Mapeia ID
		dto.setFuncionarioId(entity.getFuncionarioId());    // Mapeia funcionário
		dto.setDataAvaliacao(entity.getDataAvaliacao());    // Date direto, sem conversão
		dto.setPeriodoDesafio(entity.getPeriodoDesafio());  // Mapeia período
		dto.setObservacoesGerais(entity.getObservacoesGerais()); // Mapeia observações
		dto.setAreaAtuacao(entity.getAreaAtuacao());        // Mapeia área

		return dto;  // Retorna DTO preenchido
	}

	/**
	 * Cria ServiceContext a partir do contexto HTTP da requisição REST.
	 *
	 * @return ServiceContext configurado para a requisição atual
	 * @throws PortalException se não conseguir obter informações do contexto
	 */
	private ServiceContext createServiceContext() throws PortalException {
		ServiceContext serviceContext = new ServiceContext();  // Cria contexto

		if (contextHttpServletRequest != null) {  // Se há requisição HTTP
			// Extrai companyId da requisição
			serviceContext.setCompanyId(
					PortalUtil.getCompanyId(contextHttpServletRequest)
			);

			// Extrai groupId (escopo) da requisição
			serviceContext.setScopeGroupId(
					PortalUtil.getScopeGroupId(contextHttpServletRequest)
			);

			try {
				// Tenta extrair userId do usuário autenticado
				serviceContext.setUserId(
						PortalUtil.getUserId(contextHttpServletRequest)
				);
			} catch (Exception e) {
				serviceContext.setUserId(0L);  // Usuário guest se não autenticado
			}
		}

		return serviceContext;  // Retorna contexto configurado
	}


	/**
	 * Obtém o tipo de avaliador do usuário baseado nos seus papéis (roles).
	 * @param user usuário logado
	 * @return TIPO_TECH_LEAD, TIPO_GERENTE, TIPO_RH ou TIPO_DESCONHECIDO
	 */
	private int obterTipoAvaliadorDoUsuario(User user) {
		try {
			List<Role> roles = user.getRoles();

			// ========== ADICIONAR ESTES LOGS ==========
			_log.info("========== DEBUG DE ROLES ==========");
			_log.info("Total de roles do usuário: " + roles.size());

			for (Role role : roles) {
				String roleName = role.getName();
				_log.info("   → Role encontrada: [" + roleName + "]");
				_log.info("   → Length: " + roleName.length());
				_log.info("   → Bytes: " + java.util.Arrays.toString(roleName.getBytes()));
			}

			_log.info("========== COMPARAÇÕES ==========");
			_log.info("ROLE_RH esperado: [" + PermissionConstants.ROLE_RH + "]");
			_log.info("ROLE_TECH_LEAD esperado: [" + PermissionConstants.ROLE_TECH_LEAD + "]");
			_log.info("ROLE_GERENTE esperado: [" + PermissionConstants.ROLE_GERENTE + "]");
			// ==========================================

			for (Role role : roles) {
				String roleName = role.getName();

				if (roleName.equals(PermissionConstants.ROLE_TECH_LEAD)) {
					return PermissionConstants.TIPO_TECH_LEAD;
				}

				if (roleName.equals(PermissionConstants.ROLE_GERENTE)) {
					return PermissionConstants.TIPO_GERENTE;
				}

				if (roleName.equals(PermissionConstants.ROLE_RH)) {
					return PermissionConstants.TIPO_RH;
				}
			}

			return PermissionConstants.TIPO_DESCONHECIDO;

		} catch (Exception e) {
			_log.error("Erro ao obter tipo de avaliador do usuário", e);
			return PermissionConstants.TIPO_DESCONHECIDO;
		}
	}


	/**
	 * Obtém o usuário logado da requisição atual.
	 *
	 * @return User logado
	 * @throws PortalException se não conseguir obter usuário
	 */
	private User getLoginUser() throws PortalException {
		try {
			long userId = PortalUtil.getUserId(contextHttpServletRequest);
			return _userLocalService.getUser(userId);
		} catch (Exception e) {
			throw new PortalException("Não foi possível obter usuário logado", e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(AvaliacaoResourceImpl.class);

	@Reference
	private AvaliacaoLocalService _avaliacaoLocalService;

	@Reference
	private AvaliacaoDetalheLocalService _avaliacaoDetalheLocalService;

	@Reference
	private AvaliacaoSearchService _searchService;

	@Reference
	private AvaliacaoSearchHelper _searchHelper;

	@Reference
	private AvaliacaoPermissionChecker _avaliacaoPermissionChecker;

	@Reference
	private UserLocalService _userLocalService;

	@Reference
	private com.liferay.portal.kernel.service.RoleLocalService roleLocalService;



}
