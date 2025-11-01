package br.com.example.model.avaliacao.notification;

import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;
import br.com.example.model.avaliacao.service.AvaliacaoDetalheLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.mail.internet.InternetAddress;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Utilitário para envio de notificações por email de avaliações.
 *
 * @author SEA TECNOLOGIA
 */
public class EmailNotificationUtil {

    /**
     * Envia email de notificação quando uma avaliação é criada.
     *
     * @param avaliacao A avaliação que foi criada
     * @throws PortalException Se houver erro no envio
     */
    public static void enviarEmailAvaliacaoCriada(Avaliacao avaliacao) throws PortalException {
        try {
            // Busca dados do funcionário
            User funcionario = UserLocalServiceUtil.getUser(avaliacao.getFuncionarioId());

            // Carrega e processa o template HTML
            String htmlContent = processarTemplate(funcionario, avaliacao);

            // Prepara a mensagem
            MailMessage mailMessage = new MailMessage();
            mailMessage.setHTMLFormat(true);
            mailMessage.setFrom(new InternetAddress("noreply@seatecnologia.com.br", "SEA TECNOLOGIA"));
            mailMessage.setTo(new InternetAddress(funcionario.getEmailAddress()));
            mailMessage.setSubject(" Nova Avaliação de Desafio - " + avaliacao.getPeriodoDesafio() + " dias");
            mailMessage.setBody(htmlContent);

            // Envia o email
            MailServiceUtil.sendEmail(mailMessage);

            _log.info(" Email enviado com sucesso para: " + funcionario.getEmailAddress() +
                    " (Avaliação ID: " + avaliacao.getAvaliacaoId() + ")");

        } catch (Exception e) {
            _log.error(" Erro ao enviar email de avaliação: " + e.getMessage(), e);
            throw new PortalException("Erro ao enviar notificação por email", e);
        }
    }

    /**
     * Carrega o template HTML e substitui as variáveis.
     */
    private static String processarTemplate(User funcionario, Avaliacao avaliacao) throws Exception {
        // Carrega o template do resources
        InputStream inputStream = EmailNotificationUtil.class.getClassLoader()
                .getResourceAsStream("email-template.html");

        if (inputStream == null) {
            throw new Exception("Template de email não encontrado em src/main/resources/email-template.html");
        }

        String template = StringUtil.read(inputStream);

        // Formata as datas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        // Substitui as variáveis no template
        return template
                .replace("{{nomeFuncionario}}", funcionario.getFullName())
                .replace("{{periodoDesafio}}", String.valueOf(avaliacao.getPeriodoDesafio()))
                .replace("{{dataAvaliacao}}", dateFormat.format(avaliacao.getDataAvaliacao()))
                .replace("{{anoAtual}}", yearFormat.format(new java.util.Date()));
    }



    // Para implementação futura de notificações quando avaliadores preenchem suas partes
    /**
     * Envia notificação para RH quando um avaliador preenche sua parte.
     *
     * Este método verifica o status de preenchimento e envia:
     * - Email de "preenchimento parcial" se ainda falta alguém preencher
     * - Email de "avaliação completa" se todos os 3 já preencheram
     *
     * @param avaliacao Avaliação sendo preenchida
     * @param tipoAvaliadorQuePreencheu Tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
     * @param usuariosRH Lista de usuários com role RH para notificar
     */
    public static void enviarNotificacaoPreenchimento(
            Avaliacao avaliacao,
            int tipoAvaliadorQuePreencheu,
            List<User> usuariosRH) {

        try {
            // Verificar status atual de preenchimento
            StatusPreenchimento status = verificarStatusPreenchimento(avaliacao);

            if (status.isCompleta()) {
                // Todos os 3 avaliadores preencheram - email especial
                enviarEmailAvaliacaoCompleta(avaliacao, usuariosRH);
            } else {
                // Apenas alguns preencheram - email de status parcial
                enviarEmailPreenchimentoParcial(
                        avaliacao,
                        tipoAvaliadorQuePreencheu,
                        status,
                        usuariosRH
                );
            }

        } catch (Exception e) {
            // NÃO FALHAR a operação principal se notificação der erro
            _log.error("Erro ao enviar notificação de preenchimento para avaliação " +
                    avaliacao.getAvaliacaoId(), e);
        }
    }

    /**
     * Envia email de avaliação completa usando template HTML.
     */
    private static void enviarEmailAvaliacaoCompleta(
            Avaliacao avaliacao,
            List<User> usuariosRH) throws Exception {

        User funcionario = UserLocalServiceUtil.getUser(avaliacao.getFuncionarioId());

        // Carregar template
        String htmlTemplate = carregarTemplate("email-avaliacao-completa.html");

        // Substituir placeholders
        String htmlContent = htmlTemplate
                .replace("{{FUNCIONARIO_NOME}}", funcionario.getFullName())
                .replace("{{FUNCIONARIO_EMAIL}}", funcionario.getEmailAddress())
                .replace("{{PERIODO_DESAFIO}}", String.valueOf(avaliacao.getPeriodoDesafio()))
                .replace("{{DATA_AVALIACAO}}", DATE_FORMAT.format(avaliacao.getDataAvaliacao()));

        String assunto = "Avaliação Completa - " + funcionario.getFullName();

        enviarEmailParaGrupo(usuariosRH, assunto, htmlContent);

        _log.info("Email de avaliação completa enviado para " + usuariosRH.size() +
                " usuários RH (Avaliação ID: " + avaliacao.getAvaliacaoId() + ")");
    }

    /**
     * Envia email de preenchimento parcial usando template HTML.
     */
    private static void enviarEmailPreenchimentoParcial(
            Avaliacao avaliacao,
            int tipoAvaliadorQuePreencheu,
            StatusPreenchimento status,
            List<User> usuariosRH) throws Exception {

        User funcionario = UserLocalServiceUtil.getUser(avaliacao.getFuncionarioId());
        String nomeAvaliador = getNomeTipoAvaliador(tipoAvaliadorQuePreencheu);

        // Carregar template
        String htmlTemplate = carregarTemplate("email-preenchimento-parcial.html");

        // Substituir placeholders básicos
        String htmlContent = htmlTemplate
                .replace("{{NOME_AVALIADOR}}", nomeAvaliador)
                .replace("{{FUNCIONARIO_NOME}}", funcionario.getFullName());

        // Substituir status de Tech Lead
        htmlContent = htmlContent
                .replace("{{STATUS_TECH_LEAD_ICON}}", status.techLeadPreenchido ? "✅" : "⏳")
                .replace("{{STATUS_TECH_LEAD_TEXTO}}", status.techLeadPreenchido ? "Preenchido" : "Aguardando")
                .replace("{{STATUS_TECH_LEAD_BG}}", status.techLeadPreenchido ? "#ecfdf5" : "#fef3c7");

        // Substituir status de Gerente
        htmlContent = htmlContent
                .replace("{{STATUS_GERENTE_ICON}}", status.gerentePreenchido ? "✅" : "⏳")
                .replace("{{STATUS_GERENTE_TEXTO}}", status.gerentePreenchido ? "Preenchido" : "Aguardando")
                .replace("{{STATUS_GERENTE_BG}}", status.gerentePreenchido ? "#ecfdf5" : "#fef3c7");

        // Substituir status de RH
        htmlContent = htmlContent
                .replace("{{STATUS_RH_ICON}}", status.rhPreenchido ? "✅" : "⏳")
                .replace("{{STATUS_RH_TEXTO}}", status.rhPreenchido ? "Preenchido" : "Aguardando")
                .replace("{{STATUS_RH_BG}}", status.rhPreenchido ? "#ecfdf5" : "#fef3c7");

        // Alerta de pendência (se não completo)
        String alertaPendencia = "";
        if (!status.isCompleta()) {
            alertaPendencia =
                    "<div style=\"background-color: #fef3c7; border-left: 4px solid #f59e0b; " +
                            "padding: 15px; border-radius: 4px; margin-bottom: 25px;\">" +
                            "<p style=\"margin: 0; font-size: 14px; color: #92400e; font-weight: bold;\">" +
                            "⚠️ Aguardando preenchimento dos demais avaliadores." +
                            "</p></div>";
        }
        htmlContent = htmlContent.replace("{{ALERTA_PENDENCIA}}", alertaPendencia);

        String assunto = "📝 " + nomeAvaliador + " preencheu avaliação - " +
                funcionario.getFullName();

        enviarEmailParaGrupo(usuariosRH, assunto, htmlContent);

        _log.info("Email de preenchimento parcial enviado (" + nomeAvaliador +
                ") - Avaliação ID: " + avaliacao.getAvaliacaoId());
    }

    /**
     * Carrega template HTML da pasta resources.
     *
     * @param nomeArquivo Nome do arquivo (ex: "email-avaliacao-completa.html")
     * @return Conteúdo HTML do template
     */
    private static String carregarTemplate(String nomeArquivo) throws Exception {
        try (InputStream inputStream = EmailNotificationUtil.class.getClassLoader()
                .getResourceAsStream(nomeArquivo)) {

            if (inputStream == null) {
                throw new Exception("Template não encontrado em resources: " + nomeArquivo);
            }

            return StringUtil.read(inputStream);

        } catch (Exception e) {
            _log.error("Erro ao carregar template: " + nomeArquivo, e);
            throw e;
        }
    }

    /**
     * Verifica o status de preenchimento da avaliação.
     * Retorna quais avaliadores já preencheram suas partes.
     */
    private static StatusPreenchimento verificarStatusPreenchimento(Avaliacao avaliacao) {
        try {
            List<AvaliacaoDetalhe> detalhes =
                    AvaliacaoDetalheLocalServiceUtil.findByAvaliacaoId(avaliacao.getAvaliacaoId());

            boolean techLeadOk = false;
            boolean gerenteOk = false;
            boolean rhOk = false;

            for (AvaliacaoDetalhe detalhe : detalhes) {
                boolean preenchido = isDetalhePreenchido(detalhe);

                if (preenchido) {
                    switch (detalhe.getTipoAvaliador()) {
                        case 1:
                            techLeadOk = true;
                            break;
                        case 2:
                            gerenteOk = true;
                            break;
                        case 3:
                            rhOk = true;
                            break;
                    }
                }
            }

            return new StatusPreenchimento(techLeadOk, gerenteOk, rhOk);

        } catch (Exception e) {
            _log.error("Erro ao verificar status de preenchimento", e);
            return new StatusPreenchimento(false, false, false);
        }
    }

    /**
     * Verifica se um detalhe foi preenchido.
     * Considera preenchido se tem observações e desempenho > 0.
     */
    private static boolean isDetalhePreenchido(AvaliacaoDetalhe detalhe) {
        return detalhe.getObservacoesAvaliador() != null &&
                !detalhe.getObservacoesAvaliador().trim().isEmpty() &&
                detalhe.getDesempenho() > 0;
    }

    /**
     * Envia email para um grupo de usuários.
     */
    private static void enviarEmailParaGrupo(List<User> usuarios, String assunto, String corpo) {
        for (User usuario : usuarios) {
            try {
                InternetAddress from = new InternetAddress(
                        "noreply@seatecnologia.com.br",
                        "Sistema de Avaliação - SEA"
                );
                InternetAddress to = new InternetAddress(
                        usuario.getEmailAddress(),
                        usuario.getFullName()
                );

                MailMessage mailMessage = new MailMessage();
                mailMessage.setHTMLFormat(true);
                mailMessage.setFrom(from);
                mailMessage.setTo(to);
                mailMessage.setSubject(assunto);
                mailMessage.setBody(corpo);

                MailServiceUtil.sendEmail(mailMessage);

                _log.info("Email enviado com sucesso para: " + usuario.getEmailAddress());

            } catch (Exception e) {
                _log.error("Erro ao enviar email para " + usuario.getEmailAddress(), e);
            }
        }
    }

    /**
     * Retorna nome amigável do tipo de avaliador.
     */
    private static String getNomeTipoAvaliador(int tipo) {
        switch (tipo) {
            case 1: return "Tech Lead";
            case 2: return "Gerente";
            case 3: return "RH";
            default: return "Avaliador";
        }
    }

    /**
     * Classe que encapsula o status de preenchimento da avaliação.
     * Indica quais avaliadores já preencheram suas respectivas partes.
     */
    private static class StatusPreenchimento {
        boolean techLeadPreenchido;
        boolean gerentePreenchido;
        boolean rhPreenchido;

        StatusPreenchimento(boolean techLead, boolean gerente, boolean rh) {
            this.techLeadPreenchido = techLead;
            this.gerentePreenchido = gerente;
            this.rhPreenchido = rh;
        }

        /**
         * Verifica se a avaliação está completa (todos os 3 preencheram).
         */
        boolean isCompleta() {
            return techLeadPreenchido && gerentePreenchido && rhPreenchido;
        }
    }

    /**
     * Envia email inicial para todos os avaliadores quando RH cria a avaliação.
     * Notifica TechLead, Gerente e RH que uma nova avaliação foi criada e aguarda preenchimento.
     *
     * Este método é chamado imediatamente após a criação dos 3 detalhes vazios pelo RH.
     * Envia um único email para cada avaliador informando que há uma avaliação pendente.
     *
     * ➕ MÉTODO NOVO - implementa nova regra de negócio de notificação inicial
     *
     * @param avaliacao Avaliação recém-criada
     * @param companyId ID da company para buscar usuários
     * @param permissionChecker Helper para buscar usuários por role
     */
    public static void enviarEmailInicialParaAvaliadores(
            Avaliacao avaliacao,
            long companyId,
            br.com.example.model.avaliacao.permission.AvaliacaoPermissionChecker permissionChecker) {

        try {
            User funcionario = UserLocalServiceUtil.getUser(avaliacao.getFuncionarioId());

            // Busca TODOS os avaliadores (TechLead + Gerente + RH)
            List<User> todosAvaliadores = new ArrayList<>();

            // Adiciona Tech Leads
            try {
                List<User> techLeads = permissionChecker.getUsersComRole(
                        "Avaliador_TechLead", companyId
                );
                todosAvaliadores.addAll(techLeads);
                _log.info("Encontrados " + techLeads.size() + " Tech Leads para notificar");
            } catch (Exception e) {
                _log.warn("Nenhum Tech Lead encontrado", e);
            }

            // Adiciona Gerentes
            try {
                List<User> gerentes = permissionChecker.getUsersComRole(
                        "Avaliador_Gerente", companyId
                );
                todosAvaliadores.addAll(gerentes);
                _log.info("Encontrados " + gerentes.size() + " Gerentes para notificar");
            } catch (Exception e) {
                _log.warn("Nenhum Gerente encontrado", e);
            }

            // Adiciona RH
            try {
                List<User> rhs = permissionChecker.getUsersComRole(
                        "Avaliador_RH", companyId
                );
                todosAvaliadores.addAll(rhs);
                _log.info("Encontrados " + rhs.size() + " RHs para notificar");
            } catch (Exception e) {
                _log.warn("Nenhum RH encontrado", e);
            }

            if (todosAvaliadores.isEmpty()) {
                _log.warn("Nenhum avaliador encontrado para enviar notificação inicial!");
                return;
            }

            // Carrega template de nova avaliação criada
            String htmlTemplate = carregarTemplate("email-template.html");

            // Substitui placeholders
            String htmlContent = htmlTemplate
                    .replace("{{nomeFuncionario}}", funcionario.getFullName())
                    .replace("{{periodoDesafio}}", String.valueOf(avaliacao.getPeriodoDesafio()))
                    .replace("{{dataAvaliacao}}", DATE_FORMAT.format(avaliacao.getDataAvaliacao()))
                    .replace("{{anoAtual}}", YEAR_FORMAT.format(new Date()));

            String assunto = "🆕 Nova Avaliação Criada - " + funcionario.getFullName() +
                    " (" + avaliacao.getPeriodoDesafio() + " dias)";

            // Envia para todos os avaliadores
            enviarEmailParaGrupo(todosAvaliadores, assunto, htmlContent);

            _log.info("Email inicial enviado para " + todosAvaliadores.size() +
                    " avaliadores (Avaliação ID: " + avaliacao.getAvaliacaoId() + ")");

        } catch (Exception e) {
            // NÃO FALHAR a operação principal se notificação der erro
            _log.error("Erro ao enviar email inicial para avaliadores " +
                    "(Avaliação ID: " + avaliacao.getAvaliacaoId() + ")", e);
        }
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");
    private static final Log _log = LogFactoryUtil.getLog(EmailNotificationUtil.class);
}
