package ua.lviv.iot.kasaraba.controller.Implementation;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.controller.CommonControllerInterface;
import ua.lviv.iot.kasaraba.model.VirtualWallet;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;
import ua.lviv.iot.kasaraba.service.Implementation.VirtualWalletService;

public class VirtualWalletController implements CommonControllerInterface<VirtualWallet> {
    private static final CommonServiceInterface virtualWalletService = new VirtualWalletService();

    @Override
    public CommonServiceInterface<VirtualWallet> getService() {
        return virtualWalletService;
    }

    @Override
    public int add(VirtualWallet entity) throws SQLException {
        return getService().add(entity);
    }

    @Override
    public int update(VirtualWallet entity) throws SQLException {
        return getService().update(entity);
    }

    @Override
    public int delete(int id) throws SQLException {
        return getService().delete(id);
    }

    @Override
    public List<VirtualWallet> getAll() throws SQLException {
        return getService().getAll();
    }

    @Override
    public VirtualWallet getById(int id) throws SQLException {
        return getService().getById(id);
    }
}
