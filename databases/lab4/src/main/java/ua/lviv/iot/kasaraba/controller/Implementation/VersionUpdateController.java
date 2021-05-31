package ua.lviv.iot.kasaraba.controller.Implementation;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.controller.CommonControllerInterface;
import ua.lviv.iot.kasaraba.model.VersionUpdate;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;
import ua.lviv.iot.kasaraba.service.Implementation.VersionUpdateService;

public class VersionUpdateController implements CommonControllerInterface<VersionUpdate> {
    private static final CommonServiceInterface versionUpdateService = new VersionUpdateService();

    @Override
    public CommonServiceInterface<VersionUpdate> getService() {
        return versionUpdateService;
    }

    @Override
    public int add(VersionUpdate entity) throws SQLException {
        return getService().add(entity);
    }

    @Override
    public int update(VersionUpdate entity) throws SQLException {
        return getService().update(entity);
    }

    @Override
    public int delete(int id) throws SQLException {
        return getService().delete(id);
    }

    @Override
    public List<VersionUpdate> getAll() throws SQLException {
        return getService().getAll();
    }

    @Override
    public VersionUpdate getById(int id) throws SQLException {
        return getService().getById(id);
    }
}
