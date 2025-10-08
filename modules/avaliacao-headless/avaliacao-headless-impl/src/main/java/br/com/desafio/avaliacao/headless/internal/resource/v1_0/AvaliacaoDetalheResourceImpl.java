package br.com.desafio.avaliacao.headless.internal.resource.v1_0;

import br.com.desafio.avaliacao.headless.resource.v1_0.AvaliacaoDetalheResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author sea
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/avaliacao-detalhe.properties",
	scope = ServiceScope.PROTOTYPE, service = AvaliacaoDetalheResource.class
)
public class AvaliacaoDetalheResourceImpl
	extends BaseAvaliacaoDetalheResourceImpl {



}