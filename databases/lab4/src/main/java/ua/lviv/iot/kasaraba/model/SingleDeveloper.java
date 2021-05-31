package ua.lviv.iot.kasaraba.model;

public class SingleDeveloper {
    private String firstName;
    private String lastName;
    private int authorId;

    public SingleDeveloper(String firstName, String lastName, int authorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorId = authorId;
    }

    public SingleDeveloper() {
    }

    @Override
    public String toString() {
        return "first_name= " + firstName + "\t last_name= " + lastName +
                "\t author_id= " + authorId;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
