package project.ru.model.dto;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "product", schema = "public", catalog = "lezin")
public class ProductEntity implements EntityDTO {
    private UUID id=UUID.randomUUID();
    private String name;
    private int price;
    private String unit;

    public ProductEntity() {
    }

    public ProductEntity(UUID id, String name, String unit, int price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price=price;
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "unit", nullable = false, length = 256)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "price", nullable = false, length = 256)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (price != that.price) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return unit != null ? unit.equals(that.unit) : that.unit == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
