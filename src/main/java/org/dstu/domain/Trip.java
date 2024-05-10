package org.dstu.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Trip {
    private int id;
    private String nametourr;
    private boolean datestart;
    private boolean dateend;
    private String city;
    private int price;

    @Basic
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
    @Column(name = "tournament")
    public String getNametourr() {
        return nametourr;
    }

    public void setNametourr(String nametourr) {
        this.nametourr = nametourr;
    }

    @Basic
    @Column(name = "datestart")
    public boolean isDatestart() {
        return datestart;
    }

    public void setDatestart(boolean datestart) {
        this.datestart = datestart;
    }

    @Basic
    @Column(name = "dateend")
    public boolean isDateend() {
        return dateend;
    }

    public void setDateend(boolean dateend) {
        this.dateend = dateend;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String City) {
        this.city = city;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
