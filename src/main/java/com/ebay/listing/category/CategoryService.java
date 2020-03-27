package com.ebay.listing.category;

import com.ebay.util.DataAccessObject;
import com.ebay.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("unchecked")
public class CategoryService implements DataAccessObject<Category> {
    @Override
    public Category get(Long id) {
        Session session = SessionProvider.createSession();

        String queryText = "From Category C WHERE C.id = :id";
        Query<Category> query = session.createQuery(queryText);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<Category> list() {
        Session session = SessionProvider.createSession();
        String queryText = "From Category C";
        return session.createQuery(queryText).list();
    }

    @Override
    public void create(Category category) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        session.save(category);
        session.getTransaction().commit();
    }

    @Override
    public void update(Category category) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        session.saveOrUpdate(category);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = SessionProvider.createSession();
        session.beginTransaction();

        String queryText = "DELETE FROM Category C WHERE C.id = :id";

        Query<Category> query = session.createQuery(queryText);
        query.setParameter("id", id);

        query.executeUpdate();
        session.getTransaction().commit();
    }

    public Category getByDisplayId(Integer displayId) {
        Session session = SessionProvider.createSession();

        String queryText = "From Category C WHERE C.displayId = :displayId";
        Query<Category> query = session.createQuery(queryText);
        query.setParameter("displayId", displayId);

        return query.getSingleResult();
    }

    public boolean isApprovedCategory(Integer displayId) {
        Session session = SessionProvider.createSession();

        String queryText = "From Category C WHERE C.isPreApproved = 1 AND C.displayId = :displayId";
        Query<Category> query = session.createQuery(queryText);
        query.setParameter("displayId", displayId);

        return query.list().size() > 0;
    }
}
