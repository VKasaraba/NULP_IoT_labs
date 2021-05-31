package ua.lviv.iot.kasaraba.business.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.FeedbackDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.SecuredDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.Organization;
import ua.lviv.iot.kasaraba.model.Secured;

public class SecuredService implements CommonService<Secured, Integer> {
    private CommonDAO securedDAO = new SecuredDAO();

    @Override
    public CommonDAO<Secured, Integer> getDAO() {
        return securedDAO;
    }
}
