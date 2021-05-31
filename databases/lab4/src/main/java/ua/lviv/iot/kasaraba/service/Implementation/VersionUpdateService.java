package ua.lviv.iot.kasaraba.service.Implementation;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.DAO.Implementation.VersionUpdateDAO;
import ua.lviv.iot.kasaraba.model.VersionUpdate;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class VersionUpdateService implements CommonServiceInterface<VersionUpdate> {
    private static final CommonDAOInterface versionUpdateDAO = new VersionUpdateDAO();

    @Override
    public CommonDAOInterface<VersionUpdate, Integer> getDAO() {
        return versionUpdateDAO;
    }

    @Override
    public List<VersionUpdate> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public VersionUpdate getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int add(VersionUpdate entity) throws SQLException {
        return getDAO().add(entity);
    }

    @Override
    public int update(VersionUpdate entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }
}
