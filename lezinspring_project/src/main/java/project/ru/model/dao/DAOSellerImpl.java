package project.ru.model.dao;

import org.springframework.stereotype.Repository;
import project.ru.model.dto.SellerEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class DAOSellerImpl implements DAO<SellerEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SellerEntity> findAll() {
        System.out.println("ORMServices - findAllSellers вызван:");
        String query = "from SellerEntity order by id";
        TypedQuery<SellerEntity> typedQuery = entityManager.createQuery(query, SellerEntity.class);
        return typedQuery.getResultList();
    }

    @Override
    public SellerEntity findById(UUID id) {
        System.out.println("ORMServices - findSellerById вызван:");
        return entityManager.find(SellerEntity.class, id);
    }

    @Override
    public boolean update(SellerEntity sellerEntity) {
        System.out.println("ORMServices - updateSeller вызван:");

        String query = "UPDATE seller SET name=? , birthday=? , email=? , phone_number=? , address=?  WHERE id=?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, sellerEntity.getName());
        nativeQuery.setParameter(2, sellerEntity.getBirthday());
        nativeQuery.setParameter(3, sellerEntity.getEmail());
        nativeQuery.setParameter(4, sellerEntity.getPhoneNumber());
        nativeQuery.setParameter(5, sellerEntity.getAddress());
        nativeQuery.setParameter(6, sellerEntity.getId());
        int res = nativeQuery.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean insert(SellerEntity sellerEntity) {
        System.out.println("ORMServices - insertSeller вызван:");

        String qlquery = "INSERT INTO seller (id,name, birthday,date_of_employment, email, phone_number, address) VALUES (?,?,?,?,?,?,?)";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, sellerEntity.getId());
        query.setParameter(2, sellerEntity.getName());
        query.setParameter(3, sellerEntity.getBirthday());
        query.setParameter(4, sellerEntity.getDateOfEmployment());
        query.setParameter(5, sellerEntity.getEmail());
        query.setParameter(6, sellerEntity.getPhoneNumber());
        query.setParameter(7, sellerEntity.getAddress());
        int res = query.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean delete(UUID id) {
        System.out.println("ORMServices - deleteSeller вызван:");

        String qlquery = "DELETE FROM seller WHERE id=?";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, id);
        int res = query.executeUpdate();

        return res > 0;
    }
}
