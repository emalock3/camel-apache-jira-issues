package com.github.emalock3.camel.issues;

import java.util.List;

import org.apache.camel.Endpoint;
import org.jsoup.nodes.Document;

import com.github.emalock3.camel.issues.model.UnresolvedByComponentIssues;

/**
 * @author Shinobu Aoki
 */
class UnresolvedByComponentIssuesProducer extends
		AbstractIssuesProducer<UnresolvedByComponentIssues> {

	public UnresolvedByComponentIssuesProducer(Endpoint endpoint) {
		super(endpoint);
	}

	@Override
	protected List<UnresolvedByComponentIssues> findIssues(Document doc) {
		return UnresolvedByComponentIssues.from(doc);
	}

}
