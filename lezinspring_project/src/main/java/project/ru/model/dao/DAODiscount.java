package project.ru.model.dao;

import project.ru.model.vo.DiscountVO;

import java.util.UUID;

public interface DAODiscount {

    DiscountVO findDiscountByIdSellerAndProduct(UUID idSeller, UUID idProduct);
}
