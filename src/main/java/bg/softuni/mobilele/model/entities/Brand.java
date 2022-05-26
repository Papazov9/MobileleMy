package bg.softuni.mobilele.model.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate created;

    @Column(nullable = false)
    private LocalDate modified;

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
