package com.ebay.listing.category;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "Category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "display_id") })
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "display_id", unique = true, nullable = false)
    private Integer displayId;

    @Column(nullable = false)
    private String text;

    @Column(columnDefinition = "TINYINT", name = "is_pre_approved")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isPreApproved;

    public Category() {}

    public Category(Integer displayId, String text, boolean isPreApproved) {
        this.displayId = displayId;
        this.text = text;
        this.isPreApproved = isPreApproved;
    }

    public Long getId() {
        return id;
    }

    public Integer getDisplayId() {
        return displayId;
    }

    public void setDisplayId(Integer displayId) {
        this.displayId = displayId;
    }

    public String getText() {
        return text;
    }

    public boolean isPreApproved() {
        return isPreApproved;
    }

    public void setPreApproval(boolean preApproval) {
        this.isPreApproved = preApproval;
    }
}
