package serialization;

public class ChannelsConnectionBody {
    private final String faceBookAccessToken = "EAAIBCTVUjZA0BAEWLHDr2FvUGUtpHuPA4Moa9mhiLTCDIUtZAv3POFHSaPHUms" +
            "Lr98x6lmt7IqNZCaPKgG0nkB647vR9po8FZCYKasDe7JLn3IcJYChzPQWtgrN3qkA58ZCPgQSd" +
            "QZCRLlhFvXaPWVkCB8u2OSnYmzh1eSaVgZB4YZCZBAqGy0SBB";
    private final String facebookPageId = "3544113719190886";
    private String channelId;
    private String categoryId;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getFaceBookAccessToken() {
        return faceBookAccessToken;
    }

    public String getFacebookPageId() {
        return facebookPageId;
    }

}
