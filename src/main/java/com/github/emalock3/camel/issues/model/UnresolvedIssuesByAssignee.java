package com.github.emalock3.camel.issues.model;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.Value;

@Value
public class UnresolvedIssuesByAssignee {
	String assignee;
	int issuesNum;
	double percentage;
	
	public static List<UnresolvedIssuesByAssignee> from(Document doc) {
		List<UnresolvedIssuesByAssignee> result = new ArrayList<>();
		for (Element elem : doc.select(
				"#fragunresolvedissuesbyassignee table.aui > tbody > tr")) {
			String assignee = elem.select("> td.name > a").text();
			int issuesNum = Integer.parseInt(elem.select(">td.count").text());
			String ps = elem.select("> td.graph tr > td:nth-of-type(2)")
					.text().replace("\u00a0", "").replace("%", "").trim();
			double percentage = ps.isEmpty() ? 0.0 : Double.parseDouble(ps);
			result.add(new UnresolvedIssuesByAssignee(assignee, issuesNum, percentage));
		}
		return result;
	}
}
