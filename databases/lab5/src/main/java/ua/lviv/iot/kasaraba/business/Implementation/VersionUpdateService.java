package ua.lviv.iot.kasaraba.business.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.FeedbackDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.VersionUpdateDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.Secured;
import ua.lviv.iot.kasaraba.model.VersionUpdate;

public class VersionUpdateService implements CommonService<VersionUpdate, Integer> {
    private CommonDAO versionUpdateDAO = new VersionUpdateDAO();

    @Override
    public CommonDAO<VersionUpdate, Integer> getDAO() {
        return versionUpdateDAO;
    }
}
