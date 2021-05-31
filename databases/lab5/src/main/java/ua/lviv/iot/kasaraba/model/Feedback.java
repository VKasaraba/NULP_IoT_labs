package ua.lviv.iot.kasaraba.model;

import ua.lviv.iot.kasaraba.DAO.Implementation.ApplicationDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.AuthorDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.UserDAO;
import ua.lviv.iot.kasaraba.controller.Implementation.ApplicationController;

import javax.persistence.*;
import java.sql.SQLException;

@Entity
@Table(name = "feedback", schema = "kasaraba_lab5")
public class Feedback {
    private final ApplicationDAO applicationDAO = new ApplicationDAO();
    private final UserDAO userDAO = new UserDAO();
    private Integer id;
    private Integer starsGiven;
    private String textFeedback;
    private Byte wouldRecommend;
    private Application applicationByApplicationId;
    private User userByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stars_given")
    public Integer getStarsGiven() {
        return starsGiven;
    }

    public void setStarsGiven(Integer starsGiven) {
        this.starsGiven = starsGiven;
    }

    @Basic
    @Column(name = "text_feedback")
    public String getTextFeedback() {
        return textFeedback;
    }

    public void setTextFeedback(String textFeedback) {
        this.textFeedback = textFeedback;
    }

    @Basic
    @Column(name = "would_recommend")
    public Byte getWouldRecommend() {
        return wouldRecommend;
    }

    public void setWouldRecommend(Byte wouldRecommend) {
        this.wouldRecommend = wouldRecommend;
    }

    public Feedback(Integer id, Integer starsGiven, String textFeedback, Byte wouldRecommend, Integer applicationId, Integer userId) throws SQLException {
        this.id = id;
        this.starsGiven = starsGiven;
        this.textFeedback = textFeedback;
        this.wouldRecommend = wouldRecommend;
        this.applicationByApplicationId = applicationDAO.findById(applicationId);
        this.userByUserId = userDAO.findById(userId);
    }

    public Feedback(Integer starsGiven, String textFeedback, Byte wouldRecommend, Integer applicationId, Integer userId) throws SQLException {
        this.starsGiven = starsGiven;
        this.textFeedback = textFeedback;
        this.wouldRecommend = wouldRecommend;
        this.applicationByApplicationId = applicationDAO.findById(applicationId);
        this.userByUserId = userDAO.findById(userId);
    }

    public Feedback() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback that = (Feedback) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (starsGiven != null ? !starsGiven.equals(that.starsGiven) : that.starsGiven != null) return false;
        if (textFeedback != null ? !textFeedback.equals(that.textFeedback) : that.textFeedback != null) return false;
        if (wouldRecommend != null ? !wouldRecommend.equals(that.wouldRecommend) : that.wouldRecommend != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (starsGiven != null ? starsGiven.hashCode() : 0);
        result = 31 * result + (textFeedback != null ? textFeedback.hashCode() : 0);
        result = 31 * result + (wouldRecommend != null ? wouldRecommend.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    public Application getApplicationByApplicationId() {
        return applicationByApplicationId;
    }

    public void setApplicationByApplicationId(Application applicationByApplicationId) {
        this.applicationByApplicationId = applicationByApplicationId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public static String getHeaders() {
        return String.format("%-3s  %-12s %-50s %-14s %-13s %-13s",
                "id", "starsGiven", "textFeedback", "wouldRecommend", "applicationId", "userId");
    }

    @Override
    public String toString() {
        return String.format("%-3s  %-12s %-50s %-14s %-13s %-13s",
                id, starsGiven, textFeedback, wouldRecommend, applicationByApplicationId.getId(), userByUserId.getId());
    }
}
