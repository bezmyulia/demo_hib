package org.dstu.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "sales", schema = "schema")
public class Sales {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "employeeLast_name")
    private String employeeLastName;

    @Column(name = "employeeFirst_name")
    private String employeeFirstName;

    @Column(name = "employeeMiddle_name")
    private String employeeMiddleName;

    @Column(name = "tour_name")
    private String nametour;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "quantity_sales")
    private Integer quantitysales;

    @ManyToOne
    @JoinColumn(name = "trip_id") // в этом поле будет храниться внешний ключ
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "client_id") // в этом поле будет храниться внешний ключ
    private Client client;

    public Sales(String employeeLastName, String employeeFirstName, String employeeMiddleName, String nametour, Integer quantity, Integer quantitysales, Trip trip, Client client) {
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.employeeMiddleName = employeeMiddleName;
        this.nametour = nametour;
        this.quantity = quantity;
        this.quantitysales = quantitysales;
        this.trip = trip;
        this.client = client;
    }
}