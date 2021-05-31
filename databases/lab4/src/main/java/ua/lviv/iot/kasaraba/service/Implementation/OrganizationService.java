package ua.lviv.iot.kasaraba.service.Implementation;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.DAO.Implementation.OrganizationDAO;
import ua.lviv.iot.kasaraba.model.Organization;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class OrganizationService implements CommonServiceInterface<Organization> {
    private static final CommonDAOInterface organizationDAO = new OrganizationDAO();

    @Override
    public CommonDAOInterface<Organization, Integer> getDAO() {
        return organizationDAO;
    }

    @Override
    public List<Organization> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public Organization getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int add(Organization entity) throws SQLException {
        return getDAO().add(entity);
    }

    @Override
    public int update(Organization entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }
}
