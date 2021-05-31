package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.business.Implementation.AuthorService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.Author;

public class AuthorController implements CommonController<Author, Integer> {


    @Override
    public CommonService getService() {
        return new AuthorService();
    }

    @Override
    public void printHeaders() {
        System.out.println(Author.getHeaders());
    }
}
