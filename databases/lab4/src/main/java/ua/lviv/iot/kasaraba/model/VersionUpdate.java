package ua.lviv.iot.kasaraba.model;

public class VersionUpdate {
    private int id;
    private int applicationId;
    private String thingsUpdated;

    public VersionUpdate(int id, int applicationId, String thingsUpdated) {
        this.id = id;
        this.applicationId = applicationId;
        this.thingsUpdated = thingsUpdated;
    }

    public VersionUpdate(int applicationId, String thingsUpdated) {
        this.applicationId = applicationId;
        this.thingsUpdated = thingsUpdated;
    }

    public VersionUpdate() {
    }

    @Override
    public String toString() {
        return "id= " + id +
                "\t application_id= " + applicationId +
                "\t things_updated= " + thingsUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getThingsUpdated() {
        return thingsUpdated;
    }

    public void setThingsUpdated(String thingsUpdated) {
        this.thingsUpdated = thingsUpdated;
    }
}
