package ua.lviv.iot.kasaraba.controller.Implementation;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.controller.CommonControllerInterface;
import ua.lviv.iot.kasaraba.model.SingleDeveloper;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;
import ua.lviv.iot.kasaraba.service.Implementation.SingleDeveloperService;

public class SingleDeveloperController implements CommonControllerInterface<SingleDeveloper> {
    private static final CommonServiceInterface developerService = new SingleDeveloperService();

    @Override
    public CommonServiceInterface<SingleDeveloper> getService() {
        return developerService;
    }

    @Override
    public int add(SingleDeveloper entity) throws SQLException {
        return getService().add(entity);
    }

    @Override
    public int update(SingleDeveloper entity) throws SQLException {
        return getService().update(entity);
    }

    @Override
    public int delete(int id) throws SQLException {
        return getService().delete(id);
    }

    @Override
    public List<SingleDeveloper> getAll() throws SQLException {
        return getService().getAll();
    }

    @Override
    public SingleDeveloper getById(int id) throws SQLException {
        return getService().getById(id);
    }
}
