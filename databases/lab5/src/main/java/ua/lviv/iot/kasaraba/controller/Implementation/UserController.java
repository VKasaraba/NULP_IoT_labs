package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.business.Implementation.UserService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.User;

public class UserController implements CommonController<User, Integer> {


    @Override
    public CommonService getService() {
        return new UserService();
    }

    @Override
    public void printHeaders() {
        System.out.println(User.getHeaders());
    }
}
