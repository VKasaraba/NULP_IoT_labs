package ua.lviv.iot.kasaraba.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int yearOfRegistration;

    public User(int id, String firstName, String lastName, String email, int yearOfRegistration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearOfRegistration = yearOfRegistration;
    }

    public User(String firstName, String lastName, String email, int yearOfRegistration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearOfRegistration = yearOfRegistration;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "id= " + id +
                "\t firstName= " + firstName +
                "\t lastName= " + lastName +
                "\t email= " + email +
                "\t yearOfRegistration= " + yearOfRegistration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(int yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }
}
