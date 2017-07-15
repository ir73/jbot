package me.ramswaroop.jbot.core.slack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ramswaroop
 * @version 21/06/2016
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichMessage implements Serializable {
    private String token;
    private String username;
    @JsonProperty("icon_emoji")
    private String iconEmoji;
    private String channel;
    private String text;
    private String ts;
    private Boolean mrkdwn;
    @JsonProperty("link_names")
    private Boolean linkNames;
    @JsonProperty("as_user")
    private Boolean asUser;
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
        if (attachments != null) {
            map.put("attachments", mapper.writeValueAsString(attachments));
        }
        if (mrkdwn != null) {
            map.put("mrkdwn", mrkdwn);
        }
        if (asUser != null) {
            map.put("as_user", asUser);
        }
        if (ts != null) {
            map.put("ts", ts);
        }
        if (linkNames != null) {
            map.put("link_names", linkNames);
        }
        return map;
    }
}
