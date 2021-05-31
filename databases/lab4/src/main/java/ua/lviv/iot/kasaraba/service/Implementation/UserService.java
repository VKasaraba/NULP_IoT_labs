package ua.lviv.iot.kasaraba.service.Implementation;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.DAO.Implementation.UserDAO;
import ua.lviv.iot.kasaraba.model.User;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class UserService implements CommonServiceInterface<User> {
    private static final CommonDAOInterface userDAO = new UserDAO();

    @Override
    public CommonDAOInterface<User, Integer> getDAO() {
        return userDAO;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public User getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int add(User entity) throws SQLException {
        return getDAO().add(entity);
    }

    @Override
    public int update(User entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }
}
