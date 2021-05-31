package ua.lviv.iot.kasaraba.service.Implementation;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.DAO.Implementation.VirtualWalletDAO;
import ua.lviv.iot.kasaraba.model.VirtualWallet;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class VirtualWalletService implements CommonServiceInterface<VirtualWallet> {
    private static final CommonDAOInterface virtualWalletDAO = new VirtualWalletDAO();

    @Override
    public CommonDAOInterface<VirtualWallet, Integer> getDAO() {
        return virtualWalletDAO;
    }

    @Override
    public List<VirtualWallet> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public VirtualWallet getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int add(VirtualWallet entity) throws SQLException {
        return getDAO().add(entity);
    }

    @Override
    public int update(VirtualWallet entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }
}
