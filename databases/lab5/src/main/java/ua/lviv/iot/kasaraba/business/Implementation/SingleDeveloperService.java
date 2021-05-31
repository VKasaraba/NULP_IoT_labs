package ua.lviv.iot.kasaraba.business.Implementation;

import com.thoughtworks.qdox.model.expression.Or;
import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.FeedbackDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.SingleDeveloperDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.Secured;
import ua.lviv.iot.kasaraba.model.SingleDeveloper;

public class SingleDeveloperService implements CommonService<SingleDeveloper, Integer> {
    private CommonDAO singleDeveloperDAO = new SingleDeveloperDAO();

    @Override
    public CommonDAO<SingleDeveloper, Integer> getDAO() {
        return singleDeveloperDAO;
    }
}
