package com.github.emalock3.camel.issues;

import java.util.List;

import org.apache.camel.Endpoint;
import org.jsoup.nodes.Document;

import com.github.emalock3.camel.issues.model.UnresolvedIssuesByComponent;

/**
 * @author Shinobu Aoki
 */
class UnresolvedIssuesByComponentProducer extends
		AbstractIssuesProducer<UnresolvedIssuesByComponent> {

	public UnresolvedIssuesByComponentProducer(Endpoint endpoint) {
		super(endpoint);
	}

	@Override
	protected List<UnresolvedIssuesByComponent> findIssues(Document doc) {
		return UnresolvedIssuesByComponent.from(doc);
	}

}
