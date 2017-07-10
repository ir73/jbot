package me.ramswaroop.jbot.core.slack.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Team {
	private String id;
	private String name;
	private String domain;
	@JsonProperty("enterprise_id")
	private String enterpriseId;
	@JsonProperty("enterprise_name")
	private String enterpriseName;
}
