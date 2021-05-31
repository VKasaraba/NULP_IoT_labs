package ua.lviv.iot.kasaraba.model.DAO.Implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.VersionUpdate;

import static ua.lviv.iot.kasaraba.persistent.ConnectionManager.getConnection;

public class VersionUpdateDAO implements CommonDAOInterface<VersionUpdate, Integer> {
    private static final String getAllVersionUpdatesQuery = "SELECT id, application_id, things_updated " +
            "FROM kasaraba_db.version_update;";
    private static final String getVersionUpdateByIdQuery = "SELECT id, application_id, things_updated " +
            "FROM kasaraba_db.version_update WHERE id=?;";
    private static final String deleteVersionUpdateByIdQuery = "DELETE FROM kasaraba_db.version_update WHERE id=?;";
    private static final String updateVersionUpdateByIdQuery = "UPDATE kasaraba_db.version_update SET application_id=?, " +
            "things_updated=? WHERE id=?;";
    private static final String addVersionUpdateQuery = "INSERT INTO kasaraba_db.version_update" +
            "(application_id, things_updated) VALUES (?, ?);";

    private VersionUpdate getVersionUpdateFromRS(final ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int applicationId = rs.getInt("application_id");
        String thingsUpdated = rs.getString("things_updated");


        VersionUpdate versionUpdate = new VersionUpdate();
        versionUpdate.setId(id);
        versionUpdate.setApplicationId(applicationId);
        versionUpdate.setThingsUpdated(thingsUpdated);

        return versionUpdate;
    }

    @Override
    public List<VersionUpdate> getAll() throws SQLException {
        List<VersionUpdate> versionUpdates = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getAllVersionUpdatesQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                VersionUpdate versionUpdate = getVersionUpdateFromRS(rs);
                versionUpdates.add(versionUpdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return versionUpdates;
    }

    @Override
    public VersionUpdate getById(Integer id) throws SQLException {
        VersionUpdate found_versionUpdate = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getVersionUpdateByIdQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                found_versionUpdate = getVersionUpdateFromRS(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found_versionUpdate;
    }

    @Override
    public int add(VersionUpdate entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addVersionUpdateQuery)) {
            preparedStatement.setInt(1, entity.getApplicationId());
            preparedStatement.setString(2, entity.getThingsUpdated());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(VersionUpdate entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateVersionUpdateByIdQuery)) {
            preparedStatement.setInt(1, entity.getApplicationId());
            preparedStatement.setString(2, entity.getThingsUpdated());
            preparedStatement.setInt(3, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Integer id) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteVersionUpdateByIdQuery)) {
            preparedStatement.setInt(1, id);
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
