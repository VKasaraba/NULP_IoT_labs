package ua.lviv.iot.kasaraba.model.DAO.Implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.SingleDeveloper;

import static ua.lviv.iot.kasaraba.persistent.ConnectionManager.getConnection;

public class SingleDeveloperDAO implements CommonDAOInterface<SingleDeveloper, Integer> {
    private static final String getAllDevelopersQuery = "SELECT * FROM kasaraba_db.single_developer;";
    private static final String getDeveloperByIdQuery = "SELECT * FROM kasaraba_db.single_developer WHERE author_id=?;";
    private static final String deleteDeveloperByIdQuery = "DELETE FROM kasaraba_db.single_developer WHERE author_id=?;";
    private static final String updateDeveloperByIdQuery = "UPDATE kasaraba_db.single_developer SET first_name=?, " +
            "last_name=? WHERE author_id=?;";
    private static final String addDeveloperQuery = "INSERT INTO kasaraba_db.single_developer" +
            "(first_name, last_name, author_id) VALUES (?, ?, ?);";

    private SingleDeveloper getDeveloperFromRS(final ResultSet rs) throws SQLException {
        int authorId = rs.getInt("author_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        SingleDeveloper developer = new SingleDeveloper();
        developer.setAuthorId(authorId);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);

        return developer;
    }


    @Override
    public List<SingleDeveloper> getAll() throws SQLException {
        List<SingleDeveloper> developers = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getAllDevelopersQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SingleDeveloper developer = getDeveloperFromRS(rs);
                developers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }

    @Override
    public SingleDeveloper getById(Integer author_id) throws SQLException {
        SingleDeveloper found_developer = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getDeveloperByIdQuery)) {
            preparedStatement.setInt(1, author_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                found_developer = getDeveloperFromRS(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found_developer;
    }

    @Override
    public int add(SingleDeveloper entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addDeveloperQuery)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getAuthorId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(SingleDeveloper entity) {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateDeveloperByIdQuery)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getAuthorId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Integer author_id) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteDeveloperByIdQuery)) {
            preparedStatement.setInt(1, author_id);
            result = preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("A value in this row is a foreign key in another table. Please firstly delete the " +
                    "depending row.");
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

