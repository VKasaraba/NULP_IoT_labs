package ua.lviv.iot.kasaraba.model;

public class Feedback {
    private int id;
    private int applicationId;
    private int userId;
    private int starsGiven;
    private String textFeedback;
    private int wouldRecommend;


    public Feedback(int id, int applicationId, int userId, int starsGiven, String textFeedback, int wouldRecommend) {
        this.id = id;
        this.applicationId = applicationId;
        this.userId = userId;
        this.starsGiven = starsGiven;
        this.textFeedback = textFeedback;
        this.wouldRecommend = wouldRecommend;
    }

    public Feedback(int applicationId, int userId, int starsGiven, String textFeedback, int wouldRecommend) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.starsGiven = starsGiven;
        this.textFeedback = textFeedback;
        this.wouldRecommend = wouldRecommend;
    }

    public Feedback() {
    }

    @Override
    public String toString() {
        return "id= " + id + "\t application id= " + applicationId + "\t user id= " + userId + "\t stars given= "
                + starsGiven + "\t text_feedback= " + textFeedback + "\t would recommend=" + wouldRecommend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStarsGiven() {
        return starsGiven;
    }

    public void setStarsGiven(int starsGiven) {
        this.starsGiven = starsGiven;
    }

    public String getTextFeedback() {
        return textFeedback;
    }

    public void setTextFeedback(String textFeedback) {
        this.textFeedback = textFeedback;
    }

    public int getWouldRecommend() {
        return wouldRecommend;
    }

    public void setWouldRecommend(int wouldRecommend) {
        this.wouldRecommend = wouldRecommend;
    }
}
