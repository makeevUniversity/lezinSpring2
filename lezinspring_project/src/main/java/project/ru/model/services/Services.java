package project.ru.model.services;

import project.ru.model.vo.*;

import java.util.List;
import java.util.UUID;

public interface Services {

    List<BuyerVO> findAllBuyers();

    BuyerVO findBuyerById(UUID id);

    boolean updateBuyer(BuyerVO vo);

    boolean insertBuyer(BuyerVO vo);

    boolean deleteBuyer(UUID id);

    List<DiscountVO> findAllDiscounts();

    DiscountVO findDiscountById(UUID id);

    boolean updateDiscount(DiscountVO vo);

    boolean insertDiscount(DiscountVO vo);

    boolean deleteDiscount(UUID id);

    DiscountVO findDiscountByIdSellerAndProduct(UUID idSeller, UUID idProduct);

    List<ProductVO> findAllProducts();

    ProductVO findProductById(UUID id);

    boolean updateProduct(ProductVO vo);

    boolean insertProduct(ProductVO vo);

    boolean deleteProduct(UUID id);

    List<SaleVO> findAllSales();

    SaleVO findSaleById(UUID id);

    boolean updateSale(SaleVO vo);

    boolean insertSale(SaleVO vo);

    boolean deleteSale(UUID id);

    List<SellerVO> findAllSellers();

    SellerVO findSellerById(UUID id);

    boolean updateSeller(SellerVO vo);

    boolean insertSeller(SellerVO vo);

    boolean deleteSeller(UUID id);


}
