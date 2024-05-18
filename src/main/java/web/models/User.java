package web.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;

    @Column(name = "married")
    private boolean married;

    public User() {

    }

    public User(String name, String city, boolean married) {
        this.name = name;
        this.city = city;
        this.married = married;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public boolean isMarried() {
        return married;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", married=" + married +
                ", id=" + id +
                '}';
    }
}
