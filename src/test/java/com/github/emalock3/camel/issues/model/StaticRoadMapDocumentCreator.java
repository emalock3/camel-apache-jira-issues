package com.github.emalock3.camel.issues.model;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

class StaticRoadMapDocumentCreator extends DocumentCreator {
	private static final Charset UTF8 = Charset.forName("UTF-8");
	private final String resourceName;
	StaticRoadMapDocumentCreator(String resourceName) {
		this.resourceName = resourceName;
	}
	@Override
	public Document from(String url) throws IOException {
		try {
			URI htmlURI = RoadMapVersionTest.class.getResource(resourceName).toURI();
			String html = new String(Files.readAllBytes(new File(htmlURI).toPath()), UTF8);
			return Parser.parse(html, url);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
