import ua.lviv.iot.kasaraba.persistence.SessionManager;
import ua.lviv.iot.kasaraba.view.MyView;

public class Runner {
    public static void main(final String[] args) throws Exception {
        SessionManager.openSessionFactory();
        new MyView().show();
        SessionManager.closeSessionFactory();
    }
}
