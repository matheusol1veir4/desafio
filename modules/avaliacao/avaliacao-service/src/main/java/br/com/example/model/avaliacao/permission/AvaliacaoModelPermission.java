package br.com.example.model.avaliacao.permission;

import br.com.example.model.avaliacao.model.Avaliacao;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Helper para verificação de permissões do modelo Avaliacao.
 */
@Component(immediate = true)
public class AvaliacaoModelPermission {

    /**
     * Verifica permissão sobre uma entidade. Lança exceção se negado.
     */
    public static void check(
            PermissionChecker permissionChecker,
            Avaliacao avaliacao,
            String actionId) throws PortalException {

        check(permissionChecker, avaliacao.getAvaliacaoId(), actionId);
    }

    /**
     * Verifica permissão pelo ID. Lança exceção se negado.
     */
    public static void check(
            PermissionChecker permissionChecker,
            long avaliacaoId,
            String actionId) throws PortalException {

        if (!contains(permissionChecker, avaliacaoId, actionId)) {
            throw new PrincipalException(
                    String.format("User %d doesn't have permission to %s on Avaliacao %d",
                            permissionChecker.getUserId(), actionId, avaliacaoId));
        }
    }

    /**
     * Verifica se tem permissão (não lança exceção).
     */
    public static boolean contains(
            PermissionChecker permissionChecker,
            Avaliacao avaliacao,
            String actionId) throws PortalException {

        return contains(permissionChecker, avaliacao.getAvaliacaoId(), actionId);
    }

    /**
     * Verifica se tem permissão pelo ID (não lança exceção).
     */
    public static boolean contains(
            PermissionChecker permissionChecker,
            long avaliacaoId,
            String actionId) throws PortalException {

        return _avaliacaoModelResourcePermission.contains(
                permissionChecker, avaliacaoId, actionId);
    }

    @Reference(
            target = "(model.class.name=" + PermissionConstants.MODEL_NAME + ")",
            unbind = "-")
    protected void setModelResourcePermission(
            ModelResourcePermission<Avaliacao> modelResourcePermission) {

        _avaliacaoModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Avaliacao> _avaliacaoModelResourcePermission;
}
