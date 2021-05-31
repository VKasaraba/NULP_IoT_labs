package ua.lviv.iot.kasaraba.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user", schema = "kasaraba_lab5")
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String nationality;
    private String email;
    private Integer yearOfRegistration;
    private Set<Application> applications;

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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "year_of_registration")
    public Integer getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(Integer yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }

    public User(Integer id, String firstName, String lastName, String middleName, String nationality, String email, Integer yearOfRegistration, Set<Application> applications) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nationality = nationality;
        this.email = email;
        this.yearOfRegistration = yearOfRegistration;
        this.applications = applications;
    }

    public User(Integer id, String firstName, String lastName, String middleName, String nationality, String email, Integer yearOfRegistration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nationality = nationality;
        this.email = email;
        this.yearOfRegistration = yearOfRegistration;
    }

    public User(String firstName, String lastName, String middleName, String nationality, String email, Integer yearOfRegistration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nationality = nationality;
        this.email = email;
        this.yearOfRegistration = yearOfRegistration;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (yearOfRegistration != null ? !yearOfRegistration.equals(that.yearOfRegistration) : that.yearOfRegistration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (yearOfRegistration != null ? yearOfRegistration.hashCode() : 0);
        return result;
    }

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "user_application", schema = "kasaraba_lab5", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false))
    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }


    public List<Integer> showApplicationIds(){
        List<Integer> applicationIds = new ArrayList<>();
        for (Application application : this.getApplications()) {
            applicationIds.add(application.getId());
        }
        return applicationIds;
    }

    public static String getHeaders() {
        return String.format("%-3s  %-10s %-10s %-14s %-14s %-25s %-20s %-12s",
                "id", "firstName", "lastName", "middleName", "nationality", "email", "yearOfRegistration", "applicationIds");
    }

    @Override
    public String toString() {
        return String.format("%-3s  %-10s %-10s %-14s %-14s %-25s %-20s %-12s",
                id, firstName, lastName, middleName, nationality, email, yearOfRegistration, showApplicationIds());
    }
}
