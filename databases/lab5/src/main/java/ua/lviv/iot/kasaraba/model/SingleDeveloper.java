package ua.lviv.iot.kasaraba.model;

import ua.lviv.iot.kasaraba.DAO.Implementation.AuthorDAO;

import javax.persistence.*;
import java.sql.SQLException;

@Entity
@Table(name = "single_developer", schema = "kasaraba_lab5")
public class SingleDeveloper {
    private final AuthorDAO authorDAO = new AuthorDAO();
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer authorId;
    private Author authorByAuthorId;

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
    @Column(name = "author_id")
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public SingleDeveloper(Integer id, String firstName, String lastName, Integer authorId) throws SQLException {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorId = authorId;
        this.authorByAuthorId = authorDAO.findById(authorId);
    }

    public SingleDeveloper(String firstName, String lastName, Integer authorId) throws SQLException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorId = authorId;
        this.authorByAuthorId = authorDAO.findById(authorId);
    }

    public SingleDeveloper() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleDeveloper that = (SingleDeveloper) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    public static String getHeaders() {
        return String.format("%-3s %-30s %-30s %-8s",
                "id", "firstName", "lastName", "authorId");
    }

    @Override
    public String toString() {
        return String.format("%-3s %-30s %-30s %-8s",
                id, firstName, lastName, authorId);
    }
}
