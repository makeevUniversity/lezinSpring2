package project.ru.model.vo;

import project.ru.model.dto.ProductEntity;

import java.util.UUID;

public class ProductVO {

    private UUID id;
    private String name;
    private String unit;
    private int price;

    public ProductVO() {
    }

    public ProductVO(ProductEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.unit = entity.getUnit();
        this.price = entity.getPrice();
    }

    public ProductVO(UUID id, String name, String unit, int price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public ProductEntity getEntity() {
        return new ProductEntity(id, name, unit, price);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

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

        ProductVO productVO = (ProductVO) o;

        if (price != productVO.price) return false;
        if (id != null ? !id.equals(productVO.id) : productVO.id != null) return false;
        if (name != null ? !name.equals(productVO.name) : productVO.name != null) return false;
        return unit != null ? unit.equals(productVO.unit) : productVO.unit == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
