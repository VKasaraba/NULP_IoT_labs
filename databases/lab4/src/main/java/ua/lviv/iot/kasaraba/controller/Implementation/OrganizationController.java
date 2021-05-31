package ua.lviv.iot.kasaraba.controller.Implementation;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.controller.CommonControllerInterface;
import ua.lviv.iot.kasaraba.model.Organization;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;
import ua.lviv.iot.kasaraba.service.Implementation.OrganizationService;

public class OrganizationController implements CommonControllerInterface<Organization> {
    private static final CommonServiceInterface organizationService = new OrganizationService();

    @Override
    public CommonServiceInterface<Organization> getService() {
        return organizationService;
    }

    @Override
    public int add(Organization entity) throws SQLException {
        return getService().add(entity);
    }

    @Override
    public int update(Organization entity) throws SQLException {
        return getService().update(entity);
    }

    @Override
    public int delete(int id) throws SQLException {
        return getService().delete(id);
    }

    @Override
    public List<Organization> getAll() throws SQLException {
        return getService().getAll();
    }

    @Override
    public Organization getById(int id) throws SQLException {
        return getService().getById(id);
    }
}
