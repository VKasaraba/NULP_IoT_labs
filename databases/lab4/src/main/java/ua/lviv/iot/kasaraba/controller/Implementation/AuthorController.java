package ua.lviv.iot.kasaraba.controller.Implementation;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.controller.CommonControllerInterface;
import ua.lviv.iot.kasaraba.model.Author;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;
import ua.lviv.iot.kasaraba.service.Implementation.AuthorService;

public class AuthorController implements CommonControllerInterface<Author> {
    private static final CommonServiceInterface authorService = new AuthorService();

    @Override
    public CommonServiceInterface<Author> getService() {
        return authorService;
    }

    public List<Author> getAll() throws SQLException {
        return getService().getAll();
    }

    public Author getById(final int id) throws SQLException {
        return getService().getById(id);
    }

    public int delete(final int id) throws SQLException {
        return getService().delete(id);
    }

    public int update(Author entity) throws SQLException {
        return getService().update(entity);
    }

    public int add(Author entity) throws SQLException {
        return getService().add(entity);
    }
}
