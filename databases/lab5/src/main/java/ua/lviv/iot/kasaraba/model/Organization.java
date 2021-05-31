package ua.lviv.iot.kasaraba.model;

import ua.lviv.iot.kasaraba.DAO.Implementation.ApplicationDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.AuthorDAO;

import javax.persistence.*;
import java.sql.SQLException;

@Entity
@Table(name = "organization", schema = "kasaraba_lab5")
public class Organization {
    private final AuthorDAO authorDAO = new AuthorDAO();
    private Integer id;
    private String name;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author_id")
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Organization(Integer id, String name, Integer authorId) throws SQLException {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
        this.authorByAuthorId = authorDAO.findById(authorId);
    }

    public Organization(String name, Integer authorId) throws SQLException {
        this.name = name;
        this.authorId = authorId;
        this.authorByAuthorId = authorDAO.findById(authorId);
    }

    public Organization() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
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
        return String.format("%-3s %-30s %-8s",
                "id", "name", "authorId");
    }

    @Override
    public String toString() {
        return String.format("%-3s %-30s %-8s",
                id, name, authorId);
    }
}
