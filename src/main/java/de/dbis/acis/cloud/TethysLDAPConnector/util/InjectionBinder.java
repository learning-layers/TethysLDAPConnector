package de.dbis.acis.cloud.TethysLDAPConnector.util;

import java.util.ResourceBundle;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

/**
 * HK2 Binding class. Which binds classes for Dependency Injection(DI).
 * See "HK2", "JSR-330", "DI" and "CDI" for more Information.
 * 
 * @author Gordon Lawrenz <lawrenz@dbis.rwth-aachen.de>
 */
public class InjectionBinder extends AbstractBinder {
	
	ClientConfig clientConfig;
	ResourceBundle configRB = ResourceBundle.getBundle("config");

	/* (non-Javadoc)
	 * @see org.glassfish.hk2.utilities.binding.AbstractBinder#configure()
	 */
	@Override
	protected void configure() {
		clientConfig = new ClientConfig()
			.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true)
			.property(ClientProperties.MOXY_JSON_FEATURE_DISABLE, true)
			.register(GsonMessageBodyHandler.class); 
	}
}
