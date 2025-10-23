package br.com.example.model.avaliacao.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Helper para verificação de permissões do portlet Avaliacao.
 */
@Component(
        property = {"resource.name=" + PermissionConstants.PORTLET_RESOURCE_NAME},
        immediate = true)
public class AvaliacaoPortletPermission {

    /**
     * Verifica permissão do portlet. Lança exceção se negado.
     */
    public static void check(
            PermissionChecker permissionChecker,
            long groupId,
            String actionId) throws PortalException {

        if (!contains(permissionChecker, groupId, actionId)) {
            throw new PrincipalException(
                    String.format("User %d doesn't have permission to %s on group %d",
                            permissionChecker.getUserId(), actionId, groupId));
        }
    }

    /**
     * Verifica se tem permissão do portlet (não lança exceção).
     */
    public static boolean contains(
            PermissionChecker permissionChecker,
            long groupId,
            String actionId) {

        return _portletResourcePermission.contains(
                permissionChecker, groupId, actionId);
    }

    @Reference(
            target = "(resource.name=" + PermissionConstants.PORTLET_RESOURCE_NAME + ")",
            unbind = "-")
    protected void setPortletResourcePermission(
            PortletResourcePermission portletResourcePermission) {

        _portletResourcePermission = portletResourcePermission;
    }

    private static PortletResourcePermission _portletResourcePermission;
}
