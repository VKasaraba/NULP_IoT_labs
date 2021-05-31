package ua.lviv.iot.kasaraba.model;

import ua.lviv.iot.kasaraba.DAO.Implementation.AuthorDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.UserDAO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

@Entity
@Table(name = "application", schema = "kasaraba_lab5")
public class Application implements Serializable {
    private final AuthorDAO authorDAO = new AuthorDAO();
    private final UserDAO userDAO = new UserDAO();
    private Integer id;
    private String name;
    private Integer priceInDol;
    private Integer releaseYear;
    private Author authorByAuthorId;
    private Set<User> users;

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
    @Column(name = "price_in_dol")
    public Integer getPriceInDol() {
        return priceInDol;
    }

    public void setPriceInDol(Integer priceInDol) {
        this.priceInDol = priceInDol;
    }

    @Basic
    @Column(name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Application(Integer id, String name, Integer priceInDol, Integer releaseYear, Integer authorId) throws SQLException {
        this.id = id;
        this.name = name;
        this.priceInDol = priceInDol;
        this.releaseYear = releaseYear;
        this.authorByAuthorId = authorDAO.findById(authorId);
    }

    public Application(String name, Integer priceInDol, Integer releaseYear, Integer authorId) throws SQLException {
        this.name = name;
        this.priceInDol = priceInDol;
        this.releaseYear = releaseYear;
        this.authorByAuthorId = authorDAO.findById(authorId);
    }

    public Application() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Application that = (Application) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(priceInDol, that.priceInDol)) return false;
        if (!Objects.equals(releaseYear, that.releaseYear)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (priceInDol != null ? priceInDol.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @ManyToMany(mappedBy = "applications", fetch = FetchType.EAGER)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Integer> showUsersIds(){
        List<Integer> usersIds = new ArrayList<>();
        for (User user : getUsers()) {
            usersIds.add(user.getId());
        }
        return usersIds;
    }

    public static String getHeaders() {
        return String.format("%-3s  %-30s %-14s %-14s %-12s %-20s",
                "id", "name", "priceInDol", "releaseYear", "authorId", "userIds");
    }

    @Override
    public String toString() {
        return String.format("%-3s  %-30s %-14s %-14s %-12s %-20s",
                id, name, priceInDol, releaseYear, authorByAuthorId.getId(), showUsersIds().toString());
    }
}
