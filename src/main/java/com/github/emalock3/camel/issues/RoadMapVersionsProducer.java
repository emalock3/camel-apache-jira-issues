package com.github.emalock3.camel.issues;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;

import com.github.emalock3.camel.issues.model.DocumentCreator;
import com.github.emalock3.camel.issues.model.RoadMapVersion;

/**
 * @author Shinobu Aoki
 */
class RoadMapVersionsProducer extends DefaultProducer {
	
	public RoadMapVersionsProducer(Endpoint endpoint) {
		super(endpoint);
	}

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		String project = getEndpoint().getProject();
		exchange.getIn().setBody(RoadMapVersion.find(project, DocumentCreator.INSTANCE));
	}

	@Override
	public ApacheJiraIssuesEndpoint getEndpoint() {
		return ApacheJiraIssuesEndpoint.class.cast(super.getEndpoint());
	}

}
