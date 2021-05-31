package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.business.Implementation.SecuredService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.Secured;

public class SecuredController implements CommonController<Secured, Integer> {


    @Override
    public CommonService getService() {
        return new SecuredService();
    }

    @Override
    public void printHeaders() {
        System.out.println(Secured.getHeaders());
    }
}
