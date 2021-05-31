package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.business.Implementation.VersionUpdateService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.VersionUpdate;

public class VersionUpdateController implements CommonController<VersionUpdate, Integer> {


    @Override
    public CommonService getService() {
        return new VersionUpdateService();
    }

    @Override
    public void printHeaders() {
        System.out.println(VersionUpdate.getHeaders());
    }
}
