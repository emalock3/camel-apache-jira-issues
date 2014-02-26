package com.github.emalock3.camel.issues;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ApacheJiraIssuesComponentTest extends CamelTestSupport {

	@Test
	public void test() {
		template.sendBody("direct:start", "hoge1");
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("direct:start")
					.to("apache-jira-issues:CAMEL")
					.split(body())
						.to("log:camelIssues")
					.end()
					.log("end");
			}
		};
	}

}
