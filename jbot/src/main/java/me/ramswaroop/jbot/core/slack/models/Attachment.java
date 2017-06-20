package me.ramswaroop.jbot.core.slack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ramswaroop on 12/06/2016.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {
	private String fallback;
	private String color;
	private String pretext;
	@JsonProperty("author_name")
	private String authorName;
	@JsonProperty("author_link")
	private String authorLink;
	@JsonProperty("author_icon")
	private String authorIcon;
	private String title;
	@JsonProperty("title_link")
	private String titleLink;
	private String text;
	private Field[] fields;
	@JsonProperty("image_url")
	private String imageUrl;
	@JsonProperty("thumb_url")
	private String thumbUrl;
	private String footer;
	@JsonProperty("footer_icon")
	private String footerIcon;
	private String ts;
	private List<Action> actions;
	@JsonProperty("mrkdwn_in")
	private List<String> markdownIn;

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Action implements Serializable {
		private String name;
		private String text;
		private String value;
		private String style; // default, primary, danger
		private String type; // select, button
		@JsonProperty("data_source")
		private String dataSource; // null, users, channels, conversations,
		private Confirm confirm;
		private List<Option> options;
		@JsonProperty("selected_options")
		private List<Option> selectedOptions;
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Option implements Serializable {
		private String text;
		private String value;
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Confirm implements Serializable {
		private String title;
		private String text;
		@JsonProperty("ok_text")
		private String okText;
		@JsonProperty("dismiss_text")
		private String dismissText;
	}
}

