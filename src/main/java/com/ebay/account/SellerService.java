package com.ebay.account;

import com.ebay.util.DataAccessObject;
import com.ebay.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unchecked")
public class SellerService implements DataAccessObject<Seller> {
    @Override
    public Seller get(Long id) {
        Session session = SessionProvider.createSession();

        String queryText = "From Seller S WHERE S.id = :id";
        Query<Seller> query = session.createQuery(queryText, Seller.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<Seller> list() {
        Session session = SessionProvider.createSession();
        String queryText = "From Seller S";
        return session.createQuery(queryText, Seller.class).list();
    }

    @Override
    public void create(Seller seller) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        session.save(seller);
        session.getTransaction().commit();
    }

    @Override
    public void update(Seller seller) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        session.saveOrUpdate(seller);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        String queryText = "DELETE FROM Seller S WHERE S.id = :id";

        Query<Seller> query = session.createQuery(queryText, Seller.class);
        query.setParameter("id", id);

        query.executeUpdate();
        session.getTransaction().commit();
    }

    public Seller getByUserName(String userName) {
        Session session = SessionProvider.createSession();

        String queryText = "From Seller S WHERE S.userName = :userName";
        Query<Seller> query = session.createQuery(queryText, Seller.class);
        query.setParameter("userName", userName);

        return query.getSingleResult();
    }

    public boolean sellerIsEnrolled(String userName) {
        Session session = SessionProvider.createSession();

        String queryText = "From Seller S WHERE S.enrolledInShipping = 1 AND enrolledInShipping = :userName";
        Query<Seller> query = session.createQuery(queryText, Seller.class);
        query.setParameter("userName", userName);

        return query.list().size() > 0;
    }
}

