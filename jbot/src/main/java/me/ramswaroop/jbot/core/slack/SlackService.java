package me.ramswaroop.jbot.core.slack;

import me.ramswaroop.jbot.core.slack.models.RTM;
import me.ramswaroop.jbot.core.slack.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ramswaroop
 * @version 14/08/2016
 */
public class SlackService {

    private SlackDao slackDao;
    private User currentUser;
    private List<String> dmChannels;
    private String webSocketUrl;

    public SlackService(String rtmUrl) {
        this.slackDao = new SlackDao(rtmUrl);
    }

    /**
     * Start a RTM connection. Fetch the web socket url to connect to, current user details
     * and list of channel ids where the current user has had conversation.
     *
     * @param slackToken
     */
    public void startRTM(String slackToken) {
        RTM rtm = slackDao.startRTM(slackToken);
        currentUser = rtm.getUser();
        dmChannels = rtm.getDmChannels();
        webSocketUrl = rtm.getWebSocketUrl();
    }

    /**
     * @return user representing the bot.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @return list of channel ids where the current user has had conversation.
     */
    public List<String> getDmChannels() {
        return dmChannels;
    }

    public void setDmChannels(List<String> dmChannels) {
        this.dmChannels = dmChannels;
    }

    public boolean addDmChannel(String channelId) {
        if (dmChannels == null) dmChannels = new ArrayList<>();
        return dmChannels.add(channelId);
    }

    /**
     * @return web socket url to connect to.
     */
    public String getWebSocketUrl() {
        return webSocketUrl;
    }

    public void setWebSocketUrl(String webSocketUrl) {
        this.webSocketUrl = webSocketUrl;
    }
}
