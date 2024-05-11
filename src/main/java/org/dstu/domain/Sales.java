package org.dstu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

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
}