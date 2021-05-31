package ua.lviv.iot.kasaraba.service.Implementation;

import ua.lviv.iot.kasaraba.model.Author;
import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.DAO.Implementation.AuthorDAO;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class AuthorService implements CommonServiceInterface<Author> {
    private static final CommonDAOInterface authorDAO = new AuthorDAO();


    @Override
    public CommonDAOInterface<Author, Integer> getDAO() {
        return authorDAO;
    }

    @Override
    public List<Author> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public Author getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int add(Author entity) throws SQLException {
        return getDAO().add(entity);
    }

    @Override
    public int update(Author entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }


}

