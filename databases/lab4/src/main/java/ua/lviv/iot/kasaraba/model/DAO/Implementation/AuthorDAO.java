package ua.lviv.iot.kasaraba.model.DAO.Implementation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.kasaraba.model.Author;
import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;

import static ua.lviv.iot.kasaraba.persistent.ConnectionManager.getConnection;

public class AuthorDAO implements CommonDAOInterface<Author, Integer> {
    private static final String getAllAuthorsQuery = "SELECT * FROM kasaraba_db.author;";
    private static final String getAuthorByIdQuery = "SELECT id FROM kasaraba_db.author WHERE id=?;";
    private static final String deleteAuthorByIdQuery = "DELETE FROM kasaraba_db.author WHERE id=?;";
    private static final String addAuthorQuery = "INSERT INTO kasaraba_db.author VALUES ()";

    private Author getAuthorsFromRS(final ResultSet rs) throws SQLException {
        int id = rs.getInt("id");

        Author author = new Author();
        author.setId(id);

        return author;
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getAllAuthorsQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Author author = getAuthorsFromRS(rs);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public Author getById(Integer id) throws SQLException {
        Author found_author = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getAuthorByIdQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                found_author = getAuthorsFromRS(rs);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return found_author;
    }

    @Override
    public int add(Author entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addAuthorQuery)) {
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Author entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Integer id) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteAuthorByIdQuery)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
            System.out.println("result=" + result);
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("A value in this row is a foreign key in another table. Please firstly delete the " +
                    "depending row.");
            ex.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
