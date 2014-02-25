package com.github.emalock3.camel.issues;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import org.apache.camel.Component;
import org.apache.camel.Endpoint;
import org.apache.camel.Producer;
import org.apache.camel.impl.ProcessorEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriPath;

/**
 * @author Shinobu Aoki
 */
@UriEndpoint(scheme = "apache-jira-issues")
@Data
@EqualsAndHashCode(callSuper=false)
public class ApacheJiraIssuesEndpoint extends ProcessorEndpoint {

	/**
	 * project name in jira
	 */
	@UriPath private String project;
	
	/**
	 * process type
	 */
	@UriPath @NonNull private Types type = Types.RoadMapVersions;
	
	public static enum Types {
		RoadMapVersions {
			Producer create(Endpoint endpoint) {
				return new RoadMapVersionsProducer(endpoint);
			}
		},
		IssuesStatusSummary {
			Producer create(Endpoint endpoint) {
				return new IssuesStatusSummaryProducer(endpoint);
			}
		},
		UnresolvedIssuesByAssignee {
			Producer create(Endpoint endpoint) {
				return new UnresolvedIssuesByAssigneeProducer(endpoint);
			}
		},
		UnresolvedIssuesByComponent {
			Producer create(Endpoint endpoint) {
				return new UnresolvedIssuesByComponentProducer(endpoint);
			}
		},
		UnresolvedIssuesByPriority {
			Producer create(Endpoint endpoint) {
				return new UnresolvedIssuesByPriorityProducer(endpoint);
			}
		};
		
		abstract Producer create(Endpoint endpoint);
	}
	
	public ApacheJiraIssuesEndpoint(String endpointUri, Component component) {
		super(endpointUri, component);
	}

	@Override
	public Producer createProducer() throws Exception {
		return type.create(this);
	}
}
