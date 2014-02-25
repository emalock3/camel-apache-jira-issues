package com.github.emalock3.camel.issues.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Test;

public class IssuesStatusSummaryTest {

	@Test
	public void testFrom() throws IOException {
		Document doc = new StaticRoadMapDocumentCreator("issuesSummary.html")
			.from("https://issues.apache.org/jira/browse/CAMEL/fixforversion/12324786");
		List<IssuesStatusSummary> issues = IssuesStatusSummary.from(doc);
		assertThat(issues.size(), is(3));
		assertThat(issues.get(0), is(new IssuesStatusSummary("Open", 1, 0.0)));
		assertThat(issues.get(1), is(new IssuesStatusSummary("Resolved", 420, 99.0)));
		assertThat(issues.get(2), is(new IssuesStatusSummary("Closed", 4, 1.0)));
	}

}
