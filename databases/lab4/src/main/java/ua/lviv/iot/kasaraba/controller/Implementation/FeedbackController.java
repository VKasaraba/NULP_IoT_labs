package ua.lviv.iot.kasaraba.controller.Implementation;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.controller.CommonControllerInterface;
import ua.lviv.iot.kasaraba.model.Feedback;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;
import ua.lviv.iot.kasaraba.service.Implementation.FeedbackService;

public class FeedbackController implements CommonControllerInterface<Feedback> {
    private static final CommonServiceInterface feedbackService = new FeedbackService();

    @Override
    public CommonServiceInterface<Feedback> getService() {
        return feedbackService;
    }

    @Override
    public int add(Feedback entity) throws SQLException {
        return getService().add(entity);
    }

    @Override
    public int update(Feedback entity) throws SQLException {
        return getService().update(entity);
    }

    @Override
    public int delete(int id) throws SQLException {
        return getService().delete(id);
    }

    @Override
    public List<Feedback> getAll() throws SQLException {
        return getService().getAll();
    }

    @Override
    public Feedback getById(int id) throws SQLException {
        return getService().getById(id);
    }
}
