package ua.lviv.iot.kasaraba.DAO.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.queries.QueryManger;
import ua.lviv.iot.kasaraba.model.Feedback;
import ua.lviv.iot.kasaraba.model.Secured;

public class SecuredDAO implements CommonDAO<Secured, Integer> {
    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("Secured");
        }
        return queryManger;
    }
}
