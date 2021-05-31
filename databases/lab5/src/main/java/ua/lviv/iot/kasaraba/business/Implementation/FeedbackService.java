package ua.lviv.iot.kasaraba.business.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.AuthorDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.FeedbackDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.Author;
import ua.lviv.iot.kasaraba.model.Feedback;

public class FeedbackService implements CommonService<Feedback, Integer> {
    private CommonDAO feedbackDAO = new FeedbackDAO();

    @Override
    public CommonDAO<Feedback, Integer> getDAO() {
        return feedbackDAO;
    }
}
