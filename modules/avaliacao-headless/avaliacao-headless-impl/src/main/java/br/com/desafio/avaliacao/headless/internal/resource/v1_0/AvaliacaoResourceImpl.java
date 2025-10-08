package br.com.desafio.avaliacao.headless.internal.resource.v1_0;

import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author sea
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/avaliacao.properties",
	scope = ServiceScope.PROTOTYPE, service = AvaliacaoResource.class
)
public class AvaliacaoResourceImpl extends BaseAvaliacaoResourceImpl {



}