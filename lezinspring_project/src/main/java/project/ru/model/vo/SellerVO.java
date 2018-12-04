package project.ru.model.vo;

import project.ru.model.dto.DiscountEntity;
import project.ru.model.dto.SaleEntity;
import project.ru.model.dto.SellerEntity;

import java.sql.Date;
import java.util.Collection;
import java.util.UUID;

public class SellerVO {
    private UUID id;
    private String name;
    private Date birthday;
    private Date dateOfEmployment;
    private String email;
    private String phoneNumber;
    private String address;

    public SellerVO() {
    }

    public SellerVO(SellerEntity entity) {
        id = entity.getId();
        name = entity.getName();
        birthday = entity.getBirthday();
        dateOfEmployment = entity.getDateOfEmployment();
        email = entity.getEmail();
        phoneNumber = entity.getPhoneNumber();
        address = entity.getAddress();
    }

    public SellerVO(UUID id, String name, Date birthday, Date dateOfEmployment, String email, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.dateOfEmployment = dateOfEmployment;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public SellerEntity getEntity() {
        return new SellerEntity(id, name, birthday, dateOfEmployment, email, phoneNumber, address);
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

        SellerVO sellerVO = (SellerVO) o;

        if (id != null ? !id.equals(sellerVO.id) : sellerVO.id != null) return false;
        if (name != null ? !name.equals(sellerVO.name) : sellerVO.name != null) return false;
        if (birthday != null ? !birthday.equals(sellerVO.birthday) : sellerVO.birthday != null) return false;
        if (dateOfEmployment != null ? !dateOfEmployment.equals(sellerVO.dateOfEmployment) : sellerVO.dateOfEmployment != null)
            return false;
        if (email != null ? !email.equals(sellerVO.email) : sellerVO.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(sellerVO.phoneNumber) : sellerVO.phoneNumber != null)
            return false;
        return address != null ? address.equals(sellerVO.address) : sellerVO.address == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (dateOfEmployment != null ? dateOfEmployment.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SellerVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", dateOfEmployment=" + dateOfEmployment +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
