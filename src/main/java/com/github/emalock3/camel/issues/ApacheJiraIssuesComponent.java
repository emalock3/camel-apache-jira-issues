package com.github.emalock3.camel.issues;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @author Shinobu.Aoki
 */
public class ApacheJiraIssuesComponent extends DefaultComponent {
	
	public static final Config CONFIG;
	static {
		Config conf = ConfigFactory.load();
		CONFIG = conf.getConfig("camelApacheJira");
	}

	/* (non-Javadoc)
	 * @see org.apache.camel.impl.DefaultComponent#createEndpoint(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	protected Endpoint createEndpoint(String uri, String remaining,
			Map<String, Object> parameters) throws Exception {
		ApacheJiraIssuesEndpoint endpoint = new ApacheJiraIssuesEndpoint(uri, this);
		endpoint.setProject(remaining);
		setProperties(endpoint, parameters);
		return endpoint;
	}

}
