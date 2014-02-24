package com.github.emalock3.camel.issues;

import java.util.List;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultProducer;
import org.jsoup.nodes.Document;

/**
 * @author Shinobu Aoki
 */
abstract class AbstractIssuesProducer<T> extends DefaultProducer {

	public AbstractIssuesProducer(Endpoint endpoint) {
		super(endpoint);
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		in.setBody(findIssues(in.getBody(Document.class)));
	}
	
	abstract protected List<T> findIssues(Document doc);

}
