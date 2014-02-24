package com.github.emalock3.camel.issues.model;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.github.emalock3.camel.issues.ApacheJiraIssuesComponent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoadMapVersion {
	private String version;
	private String url;
	
	public static List<RoadMapVersion> find(String projectName, DocumentCreator docCreator)
			throws URISyntaxException, IOException {
		String roadMapURL = MessageFormat.format(
				ApacheJiraIssuesComponent.CONFIG.getString("roadMapURL"),
				projectName);
		Document doc = docCreator.from(roadMapURL);
		List<RoadMapVersion> versions = new ArrayList<>();
		URI baseURI = new URI(doc.baseUri());
		for (Element elem : doc
				.select("section#project-tab > div.module > div.mod-content > ul.versions-list > li.version-block-container")) {
			Element titleElem = elem.select("h3.version-title > a").first();
			if (titleElem != null) {
				String url = baseURI
						.resolve(titleElem.select("a").attr("href")).toURL()
						.toString();
				String version = titleElem.text().trim();
				versions.add(new RoadMapVersion(version, url));
			}
		}
		return versions;
	}
}
