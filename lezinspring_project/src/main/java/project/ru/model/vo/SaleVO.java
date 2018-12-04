package project.ru.model.vo;

import project.ru.model.dto.BuyerEntity;
import project.ru.model.dto.ProductEntity;
import project.ru.model.dto.SaleEntity;
import project.ru.model.dto.SellerEntity;

import java.sql.Date;
import java.util.UUID;

public class SaleVO {

    private UUID id;
    private Date orderDate;
    private Date dateOfDelivery;
    private Long quantity;
    private Long price;
    private String comment;
    private String address;
    private SellerVO seller;
    private BuyerVO buyer;
    private ProductVO product;


    public SaleVO() {
    }

    public SaleVO(SaleEntity entity) {
        this.id = entity.getId();
        this.orderDate = entity.getOrderDate();
        this.dateOfDelivery = entity.getDateOfDelivery();
        this.quantity = entity.getQuantity();
        this.price = entity.getPrice();
        this.comment = entity.getComment();
        this.address = entity.getAddress();
        this.seller = new SellerVO(entity.getSeller());
        this.buyer = new BuyerVO(entity.getBuyer());
        this.product = new ProductVO(entity.getProduct());
    }

    public SaleVO(UUID id, Date orderDate, Date dateOfDelivery, Long quantity, Long price, String comment, String address, SellerEntity seller, BuyerEntity buyer, ProductEntity product) {
        this.id = id;
        this.orderDate = orderDate;
        this.dateOfDelivery = dateOfDelivery;
        this.quantity = quantity;
        this.price = price;
        this.comment = comment;
        this.address = address;
        this.seller = new SellerVO(seller);
        this.buyer = new BuyerVO(buyer);
        this.product = new ProductVO(product);
    }

    public SaleEntity getEntity() {
        return new SaleEntity(id, orderDate, dateOfDelivery, quantity, price, comment, address, seller.getEntity(), buyer.getEntity(), product.getEntity());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SellerVO getSeller() {
        return seller;
    }

    public void setSeller(SellerVO seller) {
        this.seller = seller;
    }

    public BuyerVO getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerVO buyer) {
        this.buyer = buyer;
    }

    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleVO saleVO = (SaleVO) o;

        if (id != null ? !id.equals(saleVO.id) : saleVO.id != null) return false;
        if (orderDate != null ? !orderDate.equals(saleVO.orderDate) : saleVO.orderDate != null) return false;
        if (dateOfDelivery != null ? !dateOfDelivery.equals(saleVO.dateOfDelivery) : saleVO.dateOfDelivery != null)
            return false;
        if (quantity != null ? !quantity.equals(saleVO.quantity) : saleVO.quantity != null) return false;
        if (price != null ? !price.equals(saleVO.price) : saleVO.price != null) return false;
        if (comment != null ? !comment.equals(saleVO.comment) : saleVO.comment != null) return false;
        if (address != null ? !address.equals(saleVO.address) : saleVO.address != null) return false;
        if (seller != null ? !seller.equals(saleVO.seller) : saleVO.seller != null)
            return false;
        if (buyer != null ? !buyer.equals(saleVO.buyer) : saleVO.buyer != null)
            return false;
        return product != null ? product.equals(saleVO.product) : saleVO.product == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (dateOfDelivery != null ? dateOfDelivery.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SaleVO{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", dateOfDelivery=" + dateOfDelivery +
                ", quantity=" + quantity +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", address='" + address + '\'' +
                ", sellerByIdSeller=" + seller +
                ", buyerByIdBuyer=" + buyer +
                ", productByIdProduct=" + product +
                '}';
    }
}
