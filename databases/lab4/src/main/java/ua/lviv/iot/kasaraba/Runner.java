package ua.lviv.iot.kasaraba;

import ua.lviv.iot.kasaraba.persistent.ConnectionManager;
import ua.lviv.iot.kasaraba.view.MyView;

public class Runner {
    public static void main(String[] args) {
        new MyView().show();
        ConnectionManager.closeConnection();
    }
}
