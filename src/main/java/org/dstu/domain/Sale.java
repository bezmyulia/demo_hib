package org.dstu.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "sales", schema = "schema")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_middle_name")
    private String employeeMiddleName;

    @Column(name = "name_tour")
    private String nametour;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "quantity_sales")
    private Integer quantitysales;

    @Column(name = "date_sales")
    private LocalDate dateOfSale;

    @ManyToOne
    @JoinColumn(name = "trip_id") // в этом поле будет храниться внешний ключ
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "client_id") // в этом поле будет храниться внешний ключ
    private Client client;

    public Sale(String employeeLastName, String employeeFirstName, String employeeMiddleName, String nametour, Integer quantity, Integer quantitysales, LocalDate dateOfSale, Trip trip, Client client) {
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.employeeMiddleName = employeeMiddleName;
        this.nametour = nametour;
        this.quantity = quantity;
        this.quantitysales = quantitysales;
        this.dateOfSale = dateOfSale;
        this.trip = trip;
        this.client = client;
    }
}