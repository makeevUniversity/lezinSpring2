package project.ru.model.dao;

import org.springframework.stereotype.Repository;
import project.ru.model.dto.BuyerEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class DAOBuyerImpl implements DAO<BuyerEntity> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuyerEntity> findAll() {
        System.out.println("ORMServices - findAllBuyers вызван:");
        String query = "from BuyerEntity order by id";
        TypedQuery<BuyerEntity> typedQuery = entityManager.createQuery(query, BuyerEntity.class);
        return typedQuery.getResultList();
    }

    @Override
    public BuyerEntity findById(UUID id) {
        System.out.println("ORMServices - findBuyerById вызван:");
        return entityManager.find(BuyerEntity.class, id);
    }

    @Override
    public boolean update(BuyerEntity buyerEntity) {
        System.out.println("ORMServices - updateBuyer вызван:");

        String query = "UPDATE buyer SET name=? , birthday=? , email=? , phone_number=? , address=?  WHERE id=?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, buyerEntity.getName());
        nativeQuery.setParameter(2, buyerEntity.getBirthday());
        nativeQuery.setParameter(3, buyerEntity.getEmail());
        nativeQuery.setParameter(4, buyerEntity.getPhoneNumber());
        nativeQuery.setParameter(5, buyerEntity.getAddress());
        nativeQuery.setParameter(6, buyerEntity.getId());
        int res = nativeQuery.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean insert(BuyerEntity buyerEntity) {
        System.out.println("ORMServices - insertBuyer вызван:");

        String qlquery = "INSERT INTO buyer (id,name, birthday, email, phone_number, address) VALUES (?,?,?,?,?,?)";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, buyerEntity.getId());
        query.setParameter(2, buyerEntity.getName());
        query.setParameter(3, buyerEntity.getBirthday());
        query.setParameter(4, buyerEntity.getEmail());
        query.setParameter(5, buyerEntity.getPhoneNumber());
        query.setParameter(6, buyerEntity.getAddress());
        int res = query.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean delete(UUID id) {
        System.out.println("ORMServices - deleteBuyer вызван:");

        String qlquery = "DELETE FROM buyer WHERE id=?";
        Query query = entityManager.createNativeQuery(qlquery);
        query.setParameter(1, id);
        int res = query.executeUpdate();

        return res > 0;
    }
}
