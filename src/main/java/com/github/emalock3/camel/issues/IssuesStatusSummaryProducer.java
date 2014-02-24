package com.github.emalock3.camel.issues;

import java.util.List;

import org.apache.camel.Endpoint;
import org.jsoup.nodes.Document;

import com.github.emalock3.camel.issues.model.IssuesStatusSummary;

/**
 * @author Shinobu Aoki
 */
class IssuesStatusSummaryProducer extends AbstractIssuesProducer<IssuesStatusSummary> {

	public IssuesStatusSummaryProducer(Endpoint endpoint) {
		super(endpoint);
	}

	@Override
	protected List<IssuesStatusSummary> findIssues(Document doc) {
		return IssuesStatusSummary.from(doc);
	}

}
