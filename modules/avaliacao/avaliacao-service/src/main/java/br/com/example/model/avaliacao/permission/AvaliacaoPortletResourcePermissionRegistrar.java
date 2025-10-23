package br.com.example.model.avaliacao.permission;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

/**
 * Registrador de permissões de portlet para o módulo Avaliacao.
 */
@Component(immediate = true)
public class AvaliacaoPortletResourcePermissionRegistrar {

    /**
     * Ativa o componente e registra permissões de portlet no Liferay.
     */
    @Activate
    protected void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();
        properties.put("resource.name", PermissionConstants.PORTLET_RESOURCE_NAME);

        _serviceRegistration = bundleContext.registerService(
                PortletResourcePermission.class,
                PortletResourcePermissionFactory.create(
                        PermissionConstants.PORTLET_RESOURCE_NAME,
                        new StagedPortletPermissionLogic(
                                _stagingPermission,
                                PermissionConstants.PORTLET_NAME)),
                properties);
    }

    /**
     * Desativa o componente e remove o registro de permissões de portlet.
     */
    @Deactivate
    protected void deactivate() {
        if (_serviceRegistration != null) {
            _serviceRegistration.unregister();
        }
    }

    @Reference
    private StagingPermission _stagingPermission;

    private ServiceRegistration<PortletResourcePermission> _serviceRegistration;
}
