package ua.lviv.iot.kasaraba.service.Implementation;

import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.DAO.Implementation.ApplicationDAO;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class ApplicationService implements CommonServiceInterface<Application> {
    private static final CommonDAOInterface applicationDAO = new ApplicationDAO();


    @Override
    public CommonDAOInterface<Application, Integer> getDAO() {
        return applicationDAO;
    }

    @Override
    public List<Application> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public Application getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int add(Application entity) throws SQLException {
        return getDAO().add(entity);
    }

    @Override
    public int update(Application entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }
}
