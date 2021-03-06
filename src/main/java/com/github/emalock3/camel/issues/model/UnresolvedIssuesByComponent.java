package com.github.emalock3.camel.issues.model;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.Value;

@Value
public class UnresolvedIssuesByComponent {
	String component;
	int issuesNum;
	
	public static List<UnresolvedIssuesByComponent> from(Document doc) {
		List<UnresolvedIssuesByComponent> result = new ArrayList<>();
		for (Element elem : doc.select(
				"#fragunresolvedissuesbycomponent table.aui > tbody > tr")) {
			String component = elem.select("> td:nth-of-type(1) > a").text().trim();
			int issuesNum = Integer.parseInt(elem.select("> td:nth-of-type(2)").text());
			result.add(new UnresolvedIssuesByComponent(component, issuesNum));
		}
		return result;
	}
}
