package com.github.emalock3.camel.issues.model;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;
import lombok.Value;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Value
public class UnresolvedIssuesByPriority {
	String priority;
	int issuesNum;
	double percentage;
	
	public static List<UnresolvedIssuesByPriority> from(@NonNull Document doc) {
		List<UnresolvedIssuesByPriority> result = new ArrayList<>();
		for (Element elem : doc.select(
				"#fragunresolvedissuesbypriority table.aui > tbody > tr")) {
			String priority = elem.select("> td.name > a").text();
			int issuesNum = Integer.parseInt(elem.select("> td.count").text());
			String ps = elem.select("> td.graph tr > td:nth-of-type(2)")
					.text().replace("\u00a0", "").replace("%", "").trim();
			double percentage = ps.isEmpty() ? 0.0 : Double.parseDouble(ps);
			result.add(new UnresolvedIssuesByPriority(priority, issuesNum, percentage));
		}
		return result;
	}
}
