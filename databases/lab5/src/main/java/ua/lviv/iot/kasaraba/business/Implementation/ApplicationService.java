package ua.lviv.iot.kasaraba.business.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.ApplicationDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.Application;

public class ApplicationService implements CommonService<Application, Integer> {
    private CommonDAO applicationDAO = new ApplicationDAO();

    @Override
    public CommonDAO<Application, Integer> getDAO() {
        return applicationDAO;
    }
}
