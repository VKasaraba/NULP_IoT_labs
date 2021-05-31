package ua.lviv.iot.kasaraba.DAO.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.queries.QueryManger;
import ua.lviv.iot.kasaraba.model.User;
import ua.lviv.iot.kasaraba.model.VirtualWallet;

public class VirtualWalletDAO implements CommonDAO<VirtualWallet, Integer> {
    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("VirtualWallet");
        }
        return queryManger;
    }
}

