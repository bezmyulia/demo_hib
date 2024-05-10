package org.dstu.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;


@Entity
public class Sales {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String nametour;
    private Integer quantity;
    private Trip trip;
    private Client client;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "nametour")
    public String getNametour() {
        return nametour;
    }

    public void setNametour(String nametour) {
        this.nametour = nametour;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chair_id")
    public Trip getChair() {
        return trip;
    }

    public void setChair(Trip trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return id == sales.id && Objects.equals(lastName, sales.lastName) && Objects.equals(firstName, sales.firstName) && Objects.equals(middleName, sales.middleName) && Objects.equals(nametour, sales.nametour) && Objects.equals(quantity, sales.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, nametour, quantity);
    }
}
