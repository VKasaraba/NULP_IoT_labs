package ua.lviv.iot.kasaraba.service.Implementation;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.DAO.Implementation.SingleDeveloperDAO;
import ua.lviv.iot.kasaraba.model.SingleDeveloper;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class SingleDeveloperService implements CommonServiceInterface<SingleDeveloper> {
    private static final CommonDAOInterface developerDAO = new SingleDeveloperDAO();

    @Override
    public CommonDAOInterface<SingleDeveloper, Integer> getDAO() {
        return developerDAO;
    }

    @Override
    public List<SingleDeveloper> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public SingleDeveloper getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int add(SingleDeveloper entity) throws SQLException {
        return getDAO().add(entity);
    }

    @Override
    public int update(SingleDeveloper entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }
}
