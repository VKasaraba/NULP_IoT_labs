package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.business.Implementation.SingleDeveloperService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.SingleDeveloper;

public class SingleDeveloperController implements CommonController<SingleDeveloper, Integer> {


    @Override
    public CommonService getService() {
        return new SingleDeveloperService();
    }

    @Override
    public void printHeaders() {
        System.out.println(SingleDeveloper.getHeaders());
    }
}
