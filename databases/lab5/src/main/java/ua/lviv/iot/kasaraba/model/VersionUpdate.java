package ua.lviv.iot.kasaraba.model;

import ua.lviv.iot.kasaraba.DAO.Implementation.ApplicationDAO;

import javax.persistence.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

@Entity
@Table(name = "version_update", schema = "kasaraba_lab5")
public class VersionUpdate {
    private final ApplicationDAO applicationDAO = new ApplicationDAO();
    private Integer id;
    private Date updateDay;
    private String thingsUpdated;
    private Application applicationByApplicationId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "update_day")
    public Date getUpdateDay() {
        return updateDay;
    }

    public void setUpdateDay(Date updateDay) {
        this.updateDay = updateDay;
    }

    @Basic
    @Column(name = "things_updated")
    public String getThingsUpdated() {
        return thingsUpdated;
    }

    public void setThingsUpdated(String thingsUpdated) {
        this.thingsUpdated = thingsUpdated;
    }

    public VersionUpdate(Integer id, Date updateDay, String thingsUpdated, Integer applicationId) throws SQLException {
        this.id = id;
        this.updateDay = updateDay;
        this.thingsUpdated = thingsUpdated;
        this.applicationByApplicationId = applicationDAO.findById(applicationId);
    }

    public VersionUpdate(Date updateDay, String thingsUpdated, Integer applicationId) throws SQLException {
        this.updateDay = updateDay;
        this.thingsUpdated = thingsUpdated;
        this.applicationByApplicationId = applicationDAO.findById(applicationId);
    }

    public VersionUpdate() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VersionUpdate that = (VersionUpdate) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(updateDay, that.updateDay)) return false;
        if (!Objects.equals(thingsUpdated, that.thingsUpdated))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (updateDay != null ? updateDay.hashCode() : 0);
        result = 31 * result + (thingsUpdated != null ? thingsUpdated.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    public Application getApplicationByApplicationId() {
        return applicationByApplicationId;
    }

    public void setApplicationByApplicationId(Application applicationByApplicationId) {
        this.applicationByApplicationId = applicationByApplicationId;
    }

    public static String getHeaders() {
        return String.format("%-3s  %-20s %-50s %-18s",
                "id", "updateDay", "thingsUpdated", "applicationId");
    }

    @Override
    public String toString() {
        return String.format("%-3s  %-20s %-50s %-18s",
                id, updateDay, thingsUpdated, applicationByApplicationId.getId());
    }
}
