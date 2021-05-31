package ua.lviv.iot.kasaraba.model.DAO.Implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;

import static ua.lviv.iot.kasaraba.persistent.ConnectionManager.getConnection;

public class ApplicationDAO implements CommonDAOInterface<Application, Integer> {
    private static final String getAllApplicationsQuery = "SELECT id, name, author_id, release_year, price_in_dol" +
            " FROM kasaraba_db.application;";
    private static final String getApplicationByIdQuery = "SELECT id, name, author_id, release_year, price_in_dol" +
            " FROM kasaraba_db.application WHERE id=?;";
    private static final String deleteApplicationByIdQuery = "DELETE FROM kasaraba_db.application WHERE id=?;";
    private static final String updateApplicationByIdQuery = "UPDATE kasaraba_db.application SET name=?, author_id=?, " +
            "release_year=?, price_in_dol=? WHERE id=?;";
    private static final String addApplicationQuery = "INSERT INTO kasaraba_db.application" +
            "(name, author_id, release_year, price_in_dol) VALUES (?, ?, ?, ?);";

    private Application getApplicationFromRS(final ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int authorId = rs.getInt("author_id");
        int releaseYear = rs.getInt("release_year");
        int priseInDol = rs.getInt("price_in_dol");

        Application application = new Application();
        application.setId(id);
        application.setName(name);
        application.setAuthorId(authorId);
        application.setReleaseYear(releaseYear);
        application.setPriceInDol(priseInDol);

        return application;
    }

    @Override
    public final List<Application> getAll() {
        List<Application> applications = new ArrayList<>();
        try (
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getAllApplicationsQuery)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Application application = getApplicationFromRS(rs);
                applications.add(application);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    @Override
    public final Application getById(final Integer id) {
        Application found_application = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getApplicationByIdQuery)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                found_application = getApplicationFromRS(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found_application;
    }

    @Override
    public final int delete(final Integer id) {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteApplicationByIdQuery)){
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException ex) {
            System.out.println("A value in this row is a foreign key in another table. Please firstly delete the " +
                    "depending row.");
            ex.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public final int update(Application entity) {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateApplicationByIdQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAuthorId());
            preparedStatement.setInt(3, entity.getReleaseYear());
            preparedStatement.setInt(4, entity.getPriceInDol());
            preparedStatement.setInt(5, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public final int add(Application entity) {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addApplicationQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAuthorId());
            preparedStatement.setInt(3, entity.getReleaseYear());
            preparedStatement.setInt(4, entity.getPriceInDol());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

}
