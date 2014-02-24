package com.github.emalock3.camel.issues;

import java.util.List;

import org.apache.camel.Endpoint;
import org.jsoup.nodes.Document;

import com.github.emalock3.camel.issues.model.UnresolvedByPriorityIssues;

/**
 * @author Shinobu Aoki
 */
class UnresolvedByPriorityIssuesProducer extends AbstractIssuesProducer<UnresolvedByPriorityIssues> {

	public UnresolvedByPriorityIssuesProducer(Endpoint endpoint) {
		super(endpoint);
	}

	@Override
	protected List<UnresolvedByPriorityIssues> findIssues(Document doc) {
		return UnresolvedByPriorityIssues.from(doc);
	}

}
