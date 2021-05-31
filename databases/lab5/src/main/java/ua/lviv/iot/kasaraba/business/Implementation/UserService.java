package ua.lviv.iot.kasaraba.business.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.FeedbackDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.UserDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.Secured;
import ua.lviv.iot.kasaraba.model.User;

public class UserService implements CommonService<User, Integer> {
    private CommonDAO userDAO = new UserDAO();

    @Override
    public CommonDAO<User, Integer> getDAO() {
        return userDAO;
    }
}
