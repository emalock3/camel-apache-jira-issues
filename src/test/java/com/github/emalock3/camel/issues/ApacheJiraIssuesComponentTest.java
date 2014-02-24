package com.github.emalock3.camel.issues;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ApacheJiraIssuesComponentTest extends CamelTestSupport {
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;
	
	@Produce(uri = "direct:start")
	protected ProducerTemplate template;

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
