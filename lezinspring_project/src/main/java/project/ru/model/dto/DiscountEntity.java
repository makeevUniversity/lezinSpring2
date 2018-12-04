package project.ru.model.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "discount", schema = "public", catalog = "lezin")
public class DiscountEntity implements EntityDTO{

    private UUID id=UUID.randomUUID();
    private Long minQuantity;
    private Long price;
    private Date dateWith;
    private Date dateIn;
    private SellerEntity seller;
    private ProductEntity product;

    public DiscountEntity() {
    }

    public DiscountEntity(UUID id, Long minQuantity, Long price, Date dateWith, Date dateIn, SellerEntity seller, ProductEntity product) {
        this.id = id;
        this.minQuantity = minQuantity;
        this.price = price;
        this.dateWith = dateWith;
        this.dateIn = dateIn;
        this.seller = seller;
        this.product = product;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "min_quantity", nullable = true)
    public Long getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Long minQuantity) {
        this.minQuantity = minQuantity;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "date_with", nullable = true)
    public Date getWith() {
        return dateWith;
    }

    public void setWith(Date dateWith) {
        this.dateWith = dateWith;
    }

    @Basic
    @Column(name = "date_in", nullable = true)
    public Date getIn() {
        return dateIn;
    }

    public void setIn(Date in) {
        this.dateIn = in;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountEntity that = (DiscountEntity) o;

        if (minQuantity != null ? !minQuantity.equals(that.minQuantity) : that.minQuantity != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (dateWith != null ? !dateWith.equals(that.dateWith) : that.dateWith != null) return false;
        if (dateIn != null ? !dateIn.equals(that.dateIn) : that.dateIn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = minQuantity != null ? minQuantity.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (dateWith != null ? dateWith.hashCode() : 0);
        result = 31 * result + (dateIn != null ? dateIn.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_seller", referencedColumnName = "id", nullable = false)
    public SellerEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerEntity seller) {
        this.seller = seller;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
