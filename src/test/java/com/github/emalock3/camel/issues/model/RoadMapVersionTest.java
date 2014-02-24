package com.github.emalock3.camel.issues.model;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.junit.Test;

import com.github.emalock3.camel.issues.model.DocumentCreator;
import com.github.emalock3.camel.issues.model.RoadMapVersion;

public class RoadMapVersionTest {

	private static final Charset UTF8 = Charset.forName("UTF-8");
	
	private static final DocumentCreator DC = new DocumentCreator() {
		@Override
		public Document from(String url) throws IOException {
			try {
				URI htmlURI = RoadMapVersionTest.class.getResource("roadMapIssues.html").toURI();
				String html = new String(Files.readAllBytes(new File(htmlURI).toPath()), UTF8);
				return Parser.parse(html, url);
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
	};
	
	@Test
	public void test() throws Exception {
		List<RoadMapVersion> roadMapVersions = RoadMapVersion.find("TEST", DC);
		assertThat(roadMapVersions.size(), is(2));
		assertThat(roadMapVersions.get(0).getVersion(), is("2.11.4"));
		assertThat(roadMapVersions.get(1).getVersion(), is("2.12.3"));
	}

}
