package com.github.emalock3.camel.issues.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Test;

public class UnresolvedIssuesByAssigneeTest {

	@Test
	public void testFrom() throws IOException {
		Document doc = new StaticRoadMapDocumentCreator("issuesSummary.html")
			.from("https://issues.apache.org/jira/browse/CAMEL/fixforversion/12324786");
		List<UnresolvedIssuesByAssignee> issues = UnresolvedIssuesByAssignee.from(doc);
		assertThat(issues.size(), is(1));
		assertThat(issues.get(0), is(new UnresolvedIssuesByAssignee("Charles Moulliard", 1, 100.0)));
	}

}
