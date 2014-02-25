package com.github.emalock3.camel.issues.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class RoadMapVersionTest {
	
	@Test
	public void testFrom() throws Exception {
		List<RoadMapVersion> roadMapVersions = 
				RoadMapVersion.find("TEST", new StaticRoadMapDocumentCreator("roadMapIssues.html"));
		assertThat(roadMapVersions.size(), is(2));
		assertThat(roadMapVersions.get(0).getVersion(), is("2.11.4"));
		assertThat(roadMapVersions.get(1).getVersion(), is("2.12.3"));
	}

}
