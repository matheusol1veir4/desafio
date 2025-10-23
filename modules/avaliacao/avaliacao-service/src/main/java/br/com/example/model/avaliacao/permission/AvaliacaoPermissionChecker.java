package br.com.example.model.avaliacao.permission;

import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Checker de permissões customizadas para regras de negócio de avaliações.
 * Tech Lead → tipo 1 | Gerente → tipo 2 | RH → tudo
 */
@Component(immediate = true, service = AvaliacaoPermissionChecker.class)
public class AvaliacaoPermissionChecker {

    private static final Log _log = LogFactoryUtil.getLog(AvaliacaoPermissionChecker.class);


    /**
     * Verifica se usuário pode editar um detalhe específico.
     */
    public boolean podeEditarDetalhe(long userId, AvaliacaoDetalhe avaliacaoDetalhe)
            throws PortalException {

        User user = _userLocalService.getUser(userId);
        int tipoAvaliador = avaliacaoDetalhe.getTipoAvaliador();

        // Administrator pode editar tudo
        if (possuiRole(user, PermissionConstants.ROLE_ADMINISTRATOR)) return true;

        // Tech Lead só edita tipo 1
        if (possuiRole(user, PermissionConstants.ROLE_TECH_LEAD)
                && tipoAvaliador == PermissionConstants.TIPO_TECH_LEAD) return true;

        // Gerente só edita tipo 2
        if (possuiRole(user, PermissionConstants.ROLE_GERENTE)
                && tipoAvaliador == PermissionConstants.TIPO_GERENTE) return true;

        // RH só edita tipo 3
        if (possuiRole(user, PermissionConstants.ROLE_RH)
                && tipoAvaliador == PermissionConstants.TIPO_RH) return true;

        return false;
    }

    /**
     * Verifica se usuário possui uma role específica.
     */
    private boolean possuiRole(User user, String nomeRole) throws PortalException {
        try {
            return _roleLocalService.hasUserRole(
                    user.getUserId(),
                    user.getCompanyId(),
                    nomeRole,
                    true);
        } catch (PortalException e) {
            _log.error("Erro ao verificar role " + nomeRole, e);
            return false;
        }
    }

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private RoleLocalService _roleLocalService;
}
