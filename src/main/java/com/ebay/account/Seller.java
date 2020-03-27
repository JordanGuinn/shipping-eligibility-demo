package com.ebay.account;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "Seller", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "user_name") })
public class Seller {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(columnDefinition = "TINYINT", name = "enrolled_in_shipping")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean enrolledInShipping;

    public Seller() {}

    public Seller(String userName, Boolean enrolledInShipping) {
        this.userName = userName;
        this.enrolledInShipping = enrolledInShipping;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public boolean isEnrolledInShippingProgram() {
        return enrolledInShipping;
    }

    public void setShippingEnrollment(boolean enrolledInShipping) {
        this.enrolledInShipping = enrolledInShipping;
    }
}
