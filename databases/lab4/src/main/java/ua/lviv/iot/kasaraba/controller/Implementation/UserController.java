package ua.lviv.iot.kasaraba.controller.Implementation;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.controller.CommonControllerInterface;
import ua.lviv.iot.kasaraba.model.User;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;
import ua.lviv.iot.kasaraba.service.Implementation.UserService;

public class UserController implements CommonControllerInterface<User> {
    private static final CommonServiceInterface userService = new UserService();

    @Override
    public CommonServiceInterface<User> getService() {
        return userService;
    }

    @Override
    public int add(User entity) throws SQLException {
        return getService().add(entity);
    }

    @Override
    public int update(User entity) throws SQLException {
        return getService().update(entity);
    }

    @Override
    public int delete(int id) throws SQLException {
        return getService().delete(id);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getService().getAll();
    }

    @Override
    public User getById(int id) throws SQLException {
        return getService().getById(id);
    }
}
