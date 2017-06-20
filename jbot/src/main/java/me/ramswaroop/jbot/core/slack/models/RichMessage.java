package me.ramswaroop.jbot.core.slack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ramswaroop
 * @version 21/06/2016
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichMessage {
    private String token;
    private String username;
    @JsonProperty("icon_emoji")
    private String iconEmoji;
    private String channel;
    private String text;
    private Boolean mrkdwn;
    @JsonProperty("response_type")
    private String responseType;
    private Attachment[] attachments;

    public RichMessage() {
    }

    public RichMessage(String text) {
        this.text = text;
    }
    
    public RichMessage encodedMessage() {
        this.setText(this.getText().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;"));
        return this;
    }

    public Map<String, Object> toValueMap(ObjectMapper mapper) throws JsonProcessingException {
        encodedMessage();

        Map<String, Object> map = new HashMap<>();
        if (token != null) {
            map.put("token", token);
        }
        if (username != null) {
            map.put("username", username);
        }
        if (iconEmoji != null) {
            map.put("iconEmoji", iconEmoji);
        }
        if (channel != null) {
            map.put("channel", channel);
        }
        if (text != null) {
            map.put("text", text);
        }
        if (responseType != null) {
            map.put("responseType", responseType);
        }
        if (attachments != null && attachments.length > 0) {
            map.put("attachments", mapper.writeValueAsString(attachments));
        }
        if (mrkdwn != null) {
            map.put("mrkdwn", mrkdwn);
        }
        return map;
    }
}
