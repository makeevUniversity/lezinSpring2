package project.ru.model.dao;

import org.springframework.stereotype.Repository;
import project.ru.model.dto.DiscountEntity;
import project.ru.model.vo.DiscountVO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class DAODiscountImpl implements DAO<DiscountEntity>, DAODiscount {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DiscountEntity> findAll() {
        System.out.println("ORMServices - findAllDiscounts вызван:");
        String query = "from DiscountEntity order by id";
        TypedQuery<DiscountEntity> typedQuery = entityManager.createQuery(query, DiscountEntity.class);
        return typedQuery.getResultList();
    }

    @Override
    public DiscountEntity findById(UUID id) {
        System.out.println("ORMServices - findDiscountById вызван:");
        return entityManager.find(DiscountEntity.class, id);
    }

    @Override
    public boolean update(DiscountEntity discountEntity) {
        System.out.println("ORMServices - updateDiscount вызван:");

        String query = "UPDATE discount SET date_in=? , min_quantity=? , price=? , id_product=? , id_seller=? , date_with=?  WHERE id=?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, discountEntity.getIn());
        nativeQuery.setParameter(2, discountEntity.getMinQuantity());
        nativeQuery.setParameter(3, discountEntity.getPrice());
        nativeQuery.setParameter(4, discountEntity.getProduct());
        nativeQuery.setParameter(5, discountEntity.getSeller());
        nativeQuery.setParameter(6, discountEntity.getWith());
        nativeQuery.setParameter(7, discountEntity.getId());
        int res = nativeQuery.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean insert(DiscountEntity discountEntity) {
        System.out.println("ORMServices - insertDiscount вызван:");

        String qlquery = "INSERT INTO discount (id,min_quantity, price, date_with, date_in, id_seller, id_product) VALUES (?,?,?,?,?,?,?) ";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, discountEntity.getId());
        query.setParameter(2, discountEntity.getMinQuantity());
        query.setParameter(3, discountEntity.getPrice());
        query.setParameter(4, discountEntity.getWith());
        query.setParameter(5, discountEntity.getIn());
        query.setParameter(6, discountEntity.getSeller().getId());
        query.setParameter(7, discountEntity.getProduct().getId());
        int res = query.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean delete(UUID id) {
        System.out.println("ORMServices - deleteDiscount вызван:");

        String qlquery = "DELETE FROM discount WHERE id=?";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, id);
        int res = query.executeUpdate();

        return res > 0;
    }

    @Override
    public DiscountVO findDiscountByIdSellerAndProduct(UUID idSeller, UUID idProduct) {
        String qlquery = "SELECT d from DiscountEntity d where d.product.id=:idProduct and d.seller.id=:idSeller";
        Query query = entityManager.createQuery(qlquery);

        query.setParameter("idSeller", idSeller);
        query.setParameter("idProduct", idProduct);

        List<DiscountEntity> list = query.getResultList();
        if (list != null && list.size() != 0) {
            return new DiscountVO(list.get(0));
        }
        return null;
    }
}
