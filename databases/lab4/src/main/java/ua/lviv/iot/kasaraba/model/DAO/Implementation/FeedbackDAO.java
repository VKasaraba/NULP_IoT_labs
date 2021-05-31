package ua.lviv.iot.kasaraba.model.DAO.Implementation;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.lviv.iot.kasaraba.persistent.ConnectionManager.getConnection;

public class FeedbackDAO implements CommonDAOInterface<Feedback, Integer> {

    private static final String getAllFeedbacksQuery = "SELECT * FROM kasaraba_db.feedback;";
    private static final String getFeedbackByIdQuery = "SELECT * FROM kasaraba_db.feedback WHERE id=?;";
    private static final String deleteFeedbackByIdQuery = "DELETE FROM kasaraba_db.feedback WHERE id=?;";
    private static final String updateFeedbackByIdQuery = "UPDATE kasaraba_db.feedback SET application_id=?, " +
            "user_id=?, stars_given=?, text_feedback=?, would_recommend=? WHERE id=?;";
    private static final String addFeedbackQuery = "INSERT INTO kasaraba_db.feedback" +
            "(application_id, user_id, stars_given, text_feedback, would_recommend) VALUES (?, ?, ?, ?, ?);";

    private Feedback getFeedbacksFromRS(final ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int applicationId = rs.getInt("application_id");
        int userId = rs.getInt("user_id");
        int starsGiven = rs.getInt("stars_given");
        String textFeedback = rs.getString("text_feedback");
        int wouldRecommend = rs.getInt("would_recommend");


        Feedback feedback = new Feedback();
        feedback.setId(id);
        feedback.setApplicationId(applicationId);
        feedback.setStarsGiven(starsGiven);
        feedback.setTextFeedback(textFeedback);
        feedback.setWouldRecommend(wouldRecommend);
        feedback.setUserId(userId);

        return feedback;
    }

    @Override
    public List<Feedback> getAll() throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getAllFeedbacksQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Feedback feedback = getFeedbacksFromRS(rs);
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }

    @Override
    public Feedback getById(Integer id) throws SQLException {
        Feedback found_feedback = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getFeedbackByIdQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                found_feedback = getFeedbacksFromRS(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found_feedback;
    }

    @Override
    public int add(Feedback entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addFeedbackQuery)) {
            preparedStatement.setInt(1, entity.getApplicationId());
            preparedStatement.setInt(2, entity.getUserId());
            preparedStatement.setInt(3, entity.getStarsGiven());
            preparedStatement.setString(4, entity.getTextFeedback());
            preparedStatement.setInt(5, entity.getWouldRecommend());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public int update(Feedback entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateFeedbackByIdQuery)) {
            preparedStatement.setInt(1, entity.getApplicationId());
            preparedStatement.setInt(2, entity.getUserId());
            preparedStatement.setInt(3, entity.getStarsGiven());
            preparedStatement.setString(4, entity.getTextFeedback());
            preparedStatement.setInt(5, entity.getWouldRecommend());
            preparedStatement.setInt(6, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Integer id) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteFeedbackByIdQuery)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("A value in this row is a foreign key in another table. Please firstly delete the " +
                    "depending row.");
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
