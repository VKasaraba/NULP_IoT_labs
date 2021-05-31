package ua.lviv.iot.kasaraba.DAO.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.queries.QueryManger;
import ua.lviv.iot.kasaraba.model.Author;
import ua.lviv.iot.kasaraba.model.Feedback;

public class FeedbackDAO implements CommonDAO<Feedback, Integer> {
    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("Feedback");
        }
        return queryManger;
    }
}
