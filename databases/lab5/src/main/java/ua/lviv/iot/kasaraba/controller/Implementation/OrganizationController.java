package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.business.Implementation.OrganizationService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.Organization;

public class OrganizationController implements CommonController<Organization, Integer> {


    @Override
    public CommonService getService() {
        return new OrganizationService();
    }

    @Override
    public void printHeaders() {
        System.out.println(Organization.getHeaders());
    }
}
