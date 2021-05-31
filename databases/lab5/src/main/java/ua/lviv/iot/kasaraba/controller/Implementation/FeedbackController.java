package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.business.Implementation.FeedbackService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.Feedback;

public class FeedbackController implements CommonController<Feedback, Integer> {


    @Override
    public CommonService getService() {
        return new FeedbackService();
    }

    @Override
    public void printHeaders() {
        System.out.println(Feedback.getHeaders());
    }
}
