package br.com.example.model.avaliacao.notification;

import br.com.example.model.avaliacao.model.Avaliacao;
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

    private static final Log _log = LogFactoryUtil.getLog(EmailNotificationUtil.class);
}
