package ua.lviv.iot.kasaraba.service.Implementation;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.DAO.Implementation.FeedbackDAO;
import ua.lviv.iot.kasaraba.model.Feedback;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class FeedbackService implements CommonServiceInterface<Feedback> {
    private static final CommonDAOInterface feedbackDAO = new FeedbackDAO();

    @Override
    public CommonDAOInterface<Feedback, Integer> getDAO() {
        return feedbackDAO;
    }

    @Override
    public List<Feedback> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public Feedback getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int add(Feedback entity) throws SQLException {
        return getDAO().add(entity);
    }

    @Override
    public int update(Feedback entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }
}
