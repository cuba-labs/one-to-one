package com.company.onetoone.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@NamePattern("%s|notes")
@Table(name = "ONETOONE_CUSTOMER_DETAILS")
@Entity(name = "onetoone$CustomerDetails")
public class CustomerDetails extends StandardEntity {
    private static final long serialVersionUID = 1363190781657227505L;

    @Column(name = "NOTES")
    protected String notes;

    @Lob
    @Column(name = "COMMENTS")
    protected String comments;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "details")
    protected Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }


}