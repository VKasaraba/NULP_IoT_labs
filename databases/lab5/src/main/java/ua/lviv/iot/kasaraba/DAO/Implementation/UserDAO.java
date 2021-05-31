package ua.lviv.iot.kasaraba.DAO.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.queries.QueryManger;
import ua.lviv.iot.kasaraba.model.Feedback;
import ua.lviv.iot.kasaraba.model.User;

public class UserDAO implements CommonDAO<User, Integer> {
    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("User");
        }
        return queryManger;
    }
}
