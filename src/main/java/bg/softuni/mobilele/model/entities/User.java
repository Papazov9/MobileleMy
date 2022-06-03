package bg.softuni.mobilele.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(nullable = false, name = "user_roles")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> userRoles;

    @Column(name = "image_url")
    private String imageUrl;

//    @Column(nullable = false)
//    private LocalDate created;
//
//    @Column(nullable = false)
//    private LocalDate modified;

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public User setActive(boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public User setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public User setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


//    public LocalDate getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDate created) {
//        this.created = created;
//    }
//
//    public LocalDate getModified() {
//        return modified;
//    }
//
//    public void setModified(LocalDate modified) {
//        this.modified = modified;
//    }
}
