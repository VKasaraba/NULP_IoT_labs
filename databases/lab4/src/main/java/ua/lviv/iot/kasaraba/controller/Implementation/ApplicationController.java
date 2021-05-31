package ua.lviv.iot.kasaraba.controller.Implementation;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.controller.CommonControllerInterface;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;
import ua.lviv.iot.kasaraba.service.Implementation.ApplicationService;

public class ApplicationController implements CommonControllerInterface<Application> {
    private static final CommonServiceInterface applicationService = new ApplicationService();

    @Override
    public CommonServiceInterface<Application> getService() {
        return applicationService;
    }

    @Override
    public int add(Application entity) throws SQLException {
        return getService().add(entity);
    }

    @Override
    public int update(Application entity) throws SQLException {
        return getService().update(entity);
    }

    @Override
    public int delete(int id) throws SQLException {
        return getService().delete(id);
    }

    @Override
    public List<Application> getAll() throws SQLException {
        return getService().getAll();
    }

    @Override
    public Application getById(int id) throws SQLException {
        return getService().getById(id);
    }
}
