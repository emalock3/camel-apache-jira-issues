package com.github.emalock3.camel.issues;

import java.util.List;

import org.apache.camel.Endpoint;
import org.jsoup.nodes.Document;

import com.github.emalock3.camel.issues.model.UnresolvedByAssigneeIssues;

/**
 * @author Shinobu Aoki
 */
class UnresolvedByAssigneeIssuesProducer extends
		AbstractIssuesProducer<UnresolvedByAssigneeIssues> {

	public UnresolvedByAssigneeIssuesProducer(Endpoint endpoint) {
		super(endpoint);
	}

	@Override
	protected List<UnresolvedByAssigneeIssues> findIssues(Document doc) {
		return UnresolvedByAssigneeIssues.from(doc);
	}

}
