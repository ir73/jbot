package me.ramswaroop.jbot.core.slack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;

/**
 * @author ramswaroop
 * @version 21/06/2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichMessage {
    private String token;
    private String username;
    @JsonProperty("icon_emoji")
    private String iconEmoji;
    private String channel;
    private String text;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIconEmoji() {
        return iconEmoji;
    }

    public void setIconEmoji(String iconEmoji) {
        this.iconEmoji = iconEmoji;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Attachment[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachment[] attachments) {
        this.attachments = attachments;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MultiValueMap<String, String> toValueMap(ObjectMapper mapper) throws JsonProcessingException {
        encodedMessage();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("token", Arrays.asList(token));
        map.put("username", Arrays.asList(username));
        map.put("iconEmoji", Arrays.asList(iconEmoji));
        map.put("channel", Arrays.asList(channel));
        map.put("text", Arrays.asList(text));
        map.put("responseType", Arrays.asList(responseType));
        map.put("attachments", Arrays.asList(mapper.writeValueAsString(attachments)));
        return map;
    }
}
