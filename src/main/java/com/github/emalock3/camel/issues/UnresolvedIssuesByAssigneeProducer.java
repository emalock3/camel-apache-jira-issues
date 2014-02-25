package com.github.emalock3.camel.issues;

import java.util.List;

import org.apache.camel.Endpoint;
import org.jsoup.nodes.Document;

import com.github.emalock3.camel.issues.model.UnresolvedIssuesByAssignee;

/**
 * @author Shinobu Aoki
 */
class UnresolvedIssuesByAssigneeProducer extends
		AbstractIssuesProducer<UnresolvedIssuesByAssignee> {

	public UnresolvedIssuesByAssigneeProducer(Endpoint endpoint) {
		super(endpoint);
	}

	@Override
	protected List<UnresolvedIssuesByAssignee> findIssues(Document doc) {
		return UnresolvedIssuesByAssignee.from(doc);
	}

}
