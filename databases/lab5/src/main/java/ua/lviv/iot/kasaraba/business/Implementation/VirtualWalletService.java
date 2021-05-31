package ua.lviv.iot.kasaraba.business.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.VersionUpdateDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.VirtualWalletDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.VersionUpdate;
import ua.lviv.iot.kasaraba.model.VirtualWallet;

public class VirtualWalletService implements CommonService<VirtualWallet, Integer> {
    private CommonDAO virtualWalletDAO = new VirtualWalletDAO();

    @Override
    public CommonDAO<VirtualWallet, Integer> getDAO() {
        return virtualWalletDAO;
    }
}
