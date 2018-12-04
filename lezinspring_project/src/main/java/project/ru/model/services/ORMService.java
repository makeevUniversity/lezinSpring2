package project.ru.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ru.model.dao.*;
import project.ru.model.dto.*;
import project.ru.model.vo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ORMService implements Services {

    @Autowired
    private DAOBuyerImpl daoBuyer;

    @Autowired
    private DAODiscountImpl daoDiscount;

    @Autowired
    private DAOProductImpl daoProduct;

    @Autowired
    private DAOSaleImpl daoSale;

    @Autowired
    private DAOSellerImpl daoSeller;

    @Autowired
    private DAODiscount daoDiscountFindById;

    @Override
    public List<BuyerVO> findAllBuyers() {
        List<BuyerEntity> buyerEntities = daoBuyer.findAll();
        List<BuyerVO> buyerVOS = new ArrayList<>();
        if (buyerEntities == null) {
            return buyerVOS;
        }
        buyerEntities.forEach(vo -> buyerVOS.add(new BuyerVO(vo)));

        return buyerVOS;
    }

    @Override
    public BuyerVO findBuyerById(UUID id) {
        BuyerVO vo = new BuyerVO(daoBuyer.findById(id));
        return vo;
    }

    @Override
    public boolean updateBuyer(BuyerVO vo) {
        return daoBuyer.update(vo.getEntity());
    }

    @Override
    public boolean insertBuyer(BuyerVO vo) {
        return daoBuyer.insert(vo.getEntity());
    }

    @Override
    public boolean deleteBuyer(UUID id) {
        return daoBuyer.delete(id);
    }

    @Override
    public List<DiscountVO> findAllDiscounts() {
        List<DiscountEntity> discountEntities = daoDiscount.findAll();
        List<DiscountVO> discountVOS = new ArrayList<>();
        if(discountEntities==null){
            return discountVOS;
        }
        discountEntities.forEach(vo -> discountVOS.add(new DiscountVO(vo)));

        return discountVOS;
    }

    @Override
    public DiscountVO findDiscountById(UUID id) {
        return new DiscountVO(daoDiscount.findById(id));
    }

    @Override
    public boolean updateDiscount(DiscountVO vo) {
        return daoDiscount.update(vo.getEntity());
    }

    @Override
    public boolean insertDiscount(DiscountVO vo) {
        return daoDiscount.insert(vo.getEntity());
    }

    @Override
    public boolean deleteDiscount(UUID id) {
        return daoDiscount.delete(id);
    }

    @Override
    public DiscountVO findDiscountByIdSellerAndProduct(UUID idSeller, UUID idProduct) {
        return daoDiscountFindById.findDiscountByIdSellerAndProduct(idSeller,idProduct);
    }

    @Override
    public List<ProductVO> findAllProducts() {
        List<ProductEntity> productEntities = daoProduct.findAll();
        List<ProductVO> productVOS = new ArrayList<>();
        if(productEntities==null){
            return productVOS;
        }
        productEntities.forEach(vo -> productVOS.add(new ProductVO(vo)));
        return productVOS;
    }


    @Override
    public ProductVO findProductById(UUID id) {
        return new ProductVO(daoProduct.findById(id));
    }

    @Override
    public boolean updateProduct(ProductVO vo) {
        return daoProduct.update(vo.getEntity());
    }

    @Override
    public boolean insertProduct(ProductVO vo) {
        return daoProduct.insert(vo.getEntity());
    }

    @Override
    public boolean deleteProduct(UUID id) {
        return daoProduct.delete(id);
    }

    @Override
    public List<SaleVO> findAllSales() {
        List<SaleEntity> saleEntities = daoSale.findAll();
        List<SaleVO> saleVOS = new ArrayList<>();
        if(saleEntities==null){
            return saleVOS;
        }
        saleEntities.forEach(vo -> saleVOS.add(new SaleVO(vo)));
        return saleVOS;
    }

    @Override
    public SaleVO findSaleById(UUID id) {
        return new SaleVO(daoSale.findById(id));
    }

    @Override
    public boolean updateSale(SaleVO vo) {
        return daoSale.update(vo.getEntity());
    }

    @Override
    public boolean insertSale(SaleVO vo) {
        return daoSale.insert(vo.getEntity());
    }

    @Override
    public boolean deleteSale(UUID id) {
        return daoSale.delete(id);
    }

    @Override
    public List<SellerVO> findAllSellers() {
        List<SellerEntity> sellerEntities = daoSeller.findAll();
        List<SellerVO> sellerVOS = new ArrayList<>();
        if(sellerEntities==null){
            return sellerVOS;
        }
        sellerEntities.forEach(vo -> sellerVOS.add(new SellerVO(vo)));
        return sellerVOS;
    }

    @Override
    public SellerVO findSellerById(UUID id) {
        return new SellerVO(daoSeller.findById(id));
    }

    @Override
    public boolean updateSeller(SellerVO vo) {
        return daoSeller.update(vo.getEntity());
    }

    @Override
    public boolean insertSeller(SellerVO vo) {
        return daoSeller.insert(vo.getEntity());
    }

    @Override
    public boolean deleteSeller(UUID id) {
        return daoSeller.delete(id);
    }
}
