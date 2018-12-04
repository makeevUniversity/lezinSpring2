package project.ru.model.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "sale", schema = "public", catalog = "lezin")
public class SaleEntity implements EntityDTO {
    private UUID id=UUID.randomUUID();
    private Date orderDate;
    private Date dateOfDelivery;
    private Long quantity;
    private Long price;
    private String comment;
    private String address;
    private SellerEntity seller;
    private BuyerEntity buyer;
    private ProductEntity product;

    public SaleEntity() {
    }

    public SaleEntity(UUID id, Date orderDate, Date dateOfDelivery, Long quantity, Long price, String comment, String address, SellerEntity seller, BuyerEntity buyer, ProductEntity product) {
        this.id = id;
        this.orderDate = orderDate;
        this.dateOfDelivery = dateOfDelivery;
        this.quantity = quantity;
        this.price = price;
        this.comment = comment;
        this.address = address;
        this.seller = seller;
        this.buyer = buyer;
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
    @Column(name = "order_date", nullable = true)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "date_of_delivery", nullable = true)
    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "address", nullable = true, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleEntity that = (SaleEntity) o;

        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (dateOfDelivery != null ? !dateOfDelivery.equals(that.dateOfDelivery) : that.dateOfDelivery != null)
            return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderDate != null ? orderDate.hashCode() : 0;
        result = 31 * result + (dateOfDelivery != null ? dateOfDelivery.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_seller", referencedColumnName = "id", nullable = false)
    public SellerEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerEntity sellerByIdSeller) {
        this.seller = sellerByIdSeller;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_buyer", referencedColumnName = "id", nullable = false)
    public BuyerEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerEntity buyerByIdBuyer) {
        this.buyer = buyerByIdBuyer;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity productByIdProduct) {
        this.product = productByIdProduct;
    }
}
