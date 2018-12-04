package project.ru.model.dao;

import org.springframework.stereotype.Repository;
import project.ru.model.dto.SaleEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class DAOSaleImpl implements DAO<SaleEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SaleEntity> findAll() {
        System.out.println("ORMServices - findAllSales вызван:");
        String query = "from SaleEntity order by id";
        TypedQuery<SaleEntity> typedQuery = entityManager.createQuery(query, SaleEntity.class);
        return typedQuery.getResultList();
    }

    @Override
    public SaleEntity findById(UUID id) {
        System.out.println("ORMServices - findSaleById вызван:");
        return entityManager.find(SaleEntity.class, id);
    }

    @Override
    public boolean update(SaleEntity saleEntity) {
        System.out.println("ORMServices - updateSale вызван:");

        String query = "UPDATE sale SET order_date=? , date_of_delivery=? , quantity=? , price=? , comment=?, address=?, id_seller=?,id_buyer=?,id_product=?  WHERE id=?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, saleEntity.getOrderDate());
        nativeQuery.setParameter(2, saleEntity.getDateOfDelivery());
        nativeQuery.setParameter(3, saleEntity.getQuantity());
        nativeQuery.setParameter(4, saleEntity.getPrice());
        nativeQuery.setParameter(5, saleEntity.getComment());
        nativeQuery.setParameter(6, saleEntity.getAddress());
        nativeQuery.setParameter(7, saleEntity.getSeller().getId());
        nativeQuery.setParameter(8, saleEntity.getBuyer().getId());
        nativeQuery.setParameter(9, saleEntity.getProduct().getId());
        nativeQuery.setParameter(10,saleEntity.getId());
        int res = nativeQuery.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean insert(SaleEntity saleEntity) {
        System.out.println("ORMServices - insertSale вызван:");

        String qlquery = "INSERT INTO sale (id,order_date, date_of_delivery, quantity, price,comment, address,id_seller,id_buyer,id_product) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, saleEntity.getId());
        query.setParameter(2, saleEntity.getOrderDate());
        query.setParameter(3, saleEntity.getDateOfDelivery());
        query.setParameter(4, saleEntity.getQuantity());
        query.setParameter(5, saleEntity.getPrice());
        query.setParameter(6, saleEntity.getComment());
        query.setParameter(7, saleEntity.getAddress());
        query.setParameter(8, saleEntity.getSeller().getId());
        query.setParameter(9, saleEntity.getBuyer().getId());
        query.setParameter(10, saleEntity.getProduct().getId());
        int res = query.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean delete(UUID id) {
        System.out.println("ORMServices - deleteSale вызван:");

        String qlquery = "DELETE FROM sale WHERE id=?";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, id);
        int res = query.executeUpdate();

        return res > 0;
    }
}
