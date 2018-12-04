package project.ru.model.dao;

import org.springframework.stereotype.Repository;
import project.ru.model.dto.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class DAOProductImpl implements DAO<ProductEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductEntity> findAll() {
        System.out.println("ORMServices - findAllProducts вызван:");
        String query = "from ProductEntity order by id";
        TypedQuery<ProductEntity> typedQuery = entityManager.createQuery(query, ProductEntity.class);
        return typedQuery.getResultList();
    }

    @Override
    public ProductEntity findById(UUID id) {
        System.out.println("ORMServices - findProductById вызван:");
        return entityManager.find(ProductEntity.class, id);
    }

    @Override
    public boolean update(ProductEntity productEntity) {
        System.out.println("ORMServices - updateBuyer вызван:");

        String query = "UPDATE product SET name=? , unit=? ,price=?  WHERE id=?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, productEntity.getName());
        nativeQuery.setParameter(2, productEntity.getUnit());
        nativeQuery.setParameter(3, productEntity.getPrice());
        nativeQuery.setParameter(4, productEntity.getId());
        int res = nativeQuery.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean insert(ProductEntity productEntity) {
        System.out.println("ORMServices - insertBuyer вызван:");

        String qlquery = "INSERT INTO product (id,name, unit,price) VALUES (?,?,?,?)";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, productEntity.getId());
        query.setParameter(2, productEntity.getName());
        query.setParameter(3, productEntity.getUnit());
        query.setParameter(4, productEntity.getPrice());
        int res = query.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean delete(UUID id) {
        System.out.println("ORMServices - deleteProduct вызван:");

        String qlquery = "DELETE FROM product WHERE id=?";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, id);
        int res = query.executeUpdate();

        return res > 0;
    }
}
