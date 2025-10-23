package br.com.example.model.avaliacao.permission;

import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.HashMapDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

@Component(immediate = true)
public class AvaliacaoModelResourcePermissionRegistrar {

    @Activate
    protected void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();
        properties.put("model.class.name", Avaliacao.class.getName());

        _serviceRegistration = bundleContext.registerService(
                (Class) ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        Avaliacao.class,
                        Avaliacao::getAvaliacaoId,
                        _avaliacaoLocalService::getAvaliacao,
                        _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {

                        }
                ),
                properties
        );
    }

    @Deactivate
    protected void deactivate() {
        if (_serviceRegistration != null) {
            _serviceRegistration.unregister();
        }
    }

    @Reference
    private AvaliacaoLocalService _avaliacaoLocalService;

    @Reference(target = "(resource.name=" + PermissionConstants.PORTLET_RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    private ServiceRegistration<ModelResourcePermission<Avaliacao>> _serviceRegistration;
}
