package project.ru.model.vo;

import project.ru.model.dto.BuyerEntity;
import project.ru.model.dto.SaleEntity;

import java.sql.Date;
import java.util.Collection;
import java.util.UUID;

public class BuyerVO {
    private UUID id;
    private String name;
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String address;

    public BuyerVO() {
    }

    public BuyerVO(BuyerEntity entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.birthday=entity.getBirthday();
        this.email=entity.getEmail();
        this.phoneNumber=entity.getPhoneNumber();
        this.address=entity.getAddress();
    }

    public BuyerVO(UUID id, String name, Date birthday, String email, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public BuyerEntity getEntity(){
        return new BuyerEntity(id,name,birthday,email,phoneNumber,address);
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

        BuyerVO vo = (BuyerVO) o;

        if (id != null ? !id.equals(vo.id) : vo.id != null) return false;
        if (name != null ? !name.equals(vo.name) : vo.name != null) return false;
        if (birthday != null ? !birthday.equals(vo.birthday) : vo.birthday != null) return false;
        if (email != null ? !email.equals(vo.email) : vo.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(vo.phoneNumber) : vo.phoneNumber != null) return false;
        return address != null ? address.equals(vo.address) : vo.address == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BuyerVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
