package ua.lviv.iot.kasaraba.controller;

import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.view.Printable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CommonController<T, Id> {
    CommonService getService();

    void printHeaders();

    default void getAllEntities() throws SQLException {
        List<T> entities = getService().findAll();
        printHeaders();
        for (T entity : entities) {
            System.out.println(entity);
        }
    }

    default Printable getEntity(Integer id) throws SQLException {
        T entity = (T) getService().findById(id);
        printHeaders();
        System.out.println(entity);
        return null;
    }

    default int createEntity(T entity) throws SQLException {
        return getService().create(entity);
    }

    default void updateEntity(T entity) throws SQLException, IOException {
        getService().update(entity);
    }

    default int removeEntity(Integer id) throws SQLException {
        return getService().delete(id);
    }
}
