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

@Table(name="sales")
public class Sales {

    @Column(name = "id")
    private int id;

    @Column(name = "employeeLast_name")
    private String employeeLastName;

    @Column(name = "employeeFirst_name")
    private String employeeFirstName;

    @Column(name = "employeeMiddle_name")
    private String employeeMiddleName;

    @Column(name = "nametour")
    private String nametour;

    @Column(name = "quantity")
    private Integer quantity;


    @ManyToOne
    @JoinColumn(name = "name_tour") // в этом поле будет храниться внешний ключ
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "id") // в этом поле будет храниться внешний ключ
    private Client client;
}