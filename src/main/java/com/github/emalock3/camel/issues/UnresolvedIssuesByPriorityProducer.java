package com.github.emalock3.camel.issues;

import java.util.List;

import org.apache.camel.Endpoint;
import org.jsoup.nodes.Document;

import com.github.emalock3.camel.issues.model.UnresolvedIssuesByPriority;

/**
 * @author Shinobu Aoki
 */
class UnresolvedIssuesByPriorityProducer extends AbstractIssuesProducer<UnresolvedIssuesByPriority> {

	public UnresolvedIssuesByPriorityProducer(Endpoint endpoint) {
		super(endpoint);
	}

	@Override
	protected List<UnresolvedIssuesByPriority> findIssues(Document doc) {
		return UnresolvedIssuesByPriority.from(doc);
	}

}
