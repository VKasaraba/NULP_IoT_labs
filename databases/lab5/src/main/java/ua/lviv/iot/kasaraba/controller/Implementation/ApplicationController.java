package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;

public class ApplicationController implements CommonController<Application, Integer> {


    @Override
    public CommonService getService() {
        return new ApplicationService();
    }

    @Override
    public void printHeaders() {
        System.out.println(Application.getHeaders());
    }
}
