package ua.lviv.iot.kasaraba.controller.Implementation;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.business.Implementation.ApplicationService;
import ua.lviv.iot.kasaraba.business.Implementation.VirtualWalletService;
import ua.lviv.iot.kasaraba.controller.CommonController;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.VirtualWallet;

public class VirtualWalletController implements CommonController<VirtualWallet, Integer> {


    @Override
    public CommonService getService() {
        return new VirtualWalletService();
    }

    @Override
    public void printHeaders() {
        System.out.println(VirtualWallet.getHeaders());
    }
}
