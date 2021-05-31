package ua.lviv.iot.kasaraba.business.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.FeedbackDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.OrganizationDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.Feedback;
import ua.lviv.iot.kasaraba.model.Organization;

public class OrganizationService implements CommonService<Organization, Integer> {
    private CommonDAO organizationDAO = new OrganizationDAO();

    @Override
    public CommonDAO<Organization, Integer> getDAO() {
        return organizationDAO;
    }
}
