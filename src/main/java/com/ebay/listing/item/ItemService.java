package com.ebay.listing.item;

import com.ebay.listing.category.Category;
import com.ebay.util.DataAccessObject;
import com.ebay.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unchecked unused")
public class ItemService implements DataAccessObject<Item> {
    @Override
    public Item get(Long id) {
        Session session = SessionProvider.createSession();

        String queryText = "From Item I WHERE I.id = :id";
        Query<Item> query = session.createQuery(queryText);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<Item> list() {
        Session session = SessionProvider.createSession();
        String queryText = "From Item I";
        return session.createQuery(queryText).list();
    }

    @Override
    public void create(Item item) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        session.save(item);
        session.getTransaction().commit();
    }

    @Override
    public void update(Item item) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        session.saveOrUpdate(item);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        String queryText = "DELETE FROM Item I WHERE I.id = :id";

        Query<Category> query = session.createQuery(queryText);
        query.setParameter("id", id);

        query.executeUpdate();
        session.getTransaction().commit();
    }

    public Item getItemForSeller(String title, Long sellerId) {
        Session session = SessionProvider.createSession();

        String queryText = "From Item I WHERE I.title = :title AND I.sellerId = :sellerId";
        Query<Item> query = session.createQuery(queryText);
        query.setParameter("title", title);
        query.setParameter("sellerId", sellerId);

        return query.getSingleResult();
    }
}
