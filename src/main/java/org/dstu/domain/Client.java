package org.dstu.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="client", schema = "schema")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "passport")
    private int passport;

    @Column(name = "phone")
    private String phone;

    @Column(name = "discount")
    private Integer discount;

    public Client(String lastName, String firstName, String middleName, int passport, String phone, Integer discount) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.passport = passport;
        this.phone = phone;
        this.discount = discount;
    }
}