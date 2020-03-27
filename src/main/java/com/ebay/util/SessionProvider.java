package com.ebay.util;

import com.ebay.account.Seller;
import com.ebay.listing.category.Category;
import com.ebay.listing.item.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();
            sessionFactory = config.configure()
                    .addAnnotatedClass(Seller.class)
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Category.class)
                    .buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Error creating SessionFactory:" + e.getMessage());
            throw e;
        }
    }

    public static Session createSession() {
        return sessionFactory.openSession();
    }
}
