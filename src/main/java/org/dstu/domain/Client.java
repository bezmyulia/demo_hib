package org.dstu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name="client")
public class Client {

    @Id
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

    @OneToMany(mappedBy = "id")
    private List<Sales> sales ;

}