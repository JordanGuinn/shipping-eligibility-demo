package com.ebay.listing.item;

import com.ebay.account.Seller;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@SuppressWarnings("unused")
@Entity
@Table(name = "Item", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = { "title", "seller_id", "category" })})
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer category;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false, referencedColumnName = "id")
    private Seller seller;

    public Item() {}

    public Item(String title, Integer category, Double price, Seller seller) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.seller = seller;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getCategory() {
        return category;
    }
}
