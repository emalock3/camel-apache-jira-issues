package com.github.emalock3.camel.issues.model;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.Value;

@Value
public class IssuesStatusSummary {
	/**
	 * status名称
	 */
	String status;
	/**
	 * issueの数
	 */
	int issuesNum;
	/**
	 * パーセント
	 */
	double percentage;
	
	/**
	 * IssueサマリのページからIssuesStatusSummaryのListを作成します。
	 * 
	 * @param doc IssuesStatusSummaryの存在するページのDocument
	 * @return IssuesStatusSummaryのList
	 */
	public static List<IssuesStatusSummary> from(Document doc) {
		List<IssuesStatusSummary> result = new ArrayList<>();
		for (Element elem : doc.select("#fragstatussummary table.aui > tbody > tr")) {
			String status = elem.select("> td:nth-of-type(1) > a").text();
			int issuesNum = Integer.parseInt(elem.select("> td:nth-of-type(2)").text());
			String percentageStr = elem.select("> td:nth-of-type(3) tr > td:nth-of-type(2)")
				.text().replace("\u00a0", "").replace("%", "").trim();
			double percentage = percentageStr.isEmpty() ? 0.0 : Double.parseDouble(percentageStr);
			result.add(new IssuesStatusSummary(status, issuesNum, percentage));
		}
		return result;
	}
}
