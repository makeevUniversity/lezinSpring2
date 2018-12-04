package project.ru.model.vo;

import project.ru.model.dto.DiscountEntity;
import project.ru.model.dto.ProductEntity;
import project.ru.model.dto.SellerEntity;

import java.sql.Date;
import java.util.UUID;

public class DiscountVO {

    private UUID id;
    private Long minQuantity;
    private Long price;
    private Date dateWith;
    private Date dateIn;
    private SellerVO seller;
    private ProductVO product;

    public DiscountVO() {
    }

    public DiscountVO(DiscountEntity entity){
        this.id=entity.getId();
        this.minQuantity=entity.getMinQuantity();
        this.price=entity.getPrice();
        this.dateWith=entity.getWith();
        this.dateIn=entity.getIn();
        this.seller=new SellerVO(entity.getSeller());
        this.product=new ProductVO(entity.getProduct());
    }

    public DiscountVO(UUID id, Long minQuantity, Long price, Date dateWith, Date dateIn, SellerEntity seller, ProductEntity product) {
        this.id = id;
        this.minQuantity = minQuantity;
        this.price = price;
        this.dateWith = dateWith;
        this.dateIn = dateIn;
        this.seller=new SellerVO(seller);
        this.product=new ProductVO(product);
    }

    public DiscountEntity getEntity(){
        return new DiscountEntity(id,minQuantity,price,dateWith,dateIn,seller.getEntity(),product.getEntity());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Long minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getDateWith() {
        return dateWith;
    }

    public void setDateWith(Date dateWith) {
        this.dateWith = dateWith;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public SellerVO getSeller() {
        return seller;
    }

    public void setSeller(SellerVO seller) {
        this.seller = seller;
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

        DiscountVO that = (DiscountVO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (minQuantity != null ? !minQuantity.equals(that.minQuantity) : that.minQuantity != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (dateWith != null ? !dateWith.equals(that.dateWith) : that.dateWith != null) return false;
        if (dateIn != null ? !dateIn.equals(that.dateIn) : that.dateIn != null) return false;
        if (seller != null ? !seller.equals(that.seller) : that.seller != null)
            return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (minQuantity != null ? minQuantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (dateWith != null ? dateWith.hashCode() : 0);
        result = 31 * result + (dateIn != null ? dateIn.hashCode() : 0);
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DiscountVO{" +
                "id=" + id +
                ", minQuantity=" + minQuantity +
                ", price=" + price +
                ", dateWith=" + dateWith +
                ", dateIn=" + dateIn +
                ", sellerByIdSeller=" + seller +
                ", productByIdProduct=" + product +
                '}';
    }
}
