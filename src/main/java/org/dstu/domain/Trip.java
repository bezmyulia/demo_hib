package org.dstu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name="Trip")
public class Trip {

    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "name_trip")
    private String nametourr;

    @Column(name = "start_date")
    private LocalDate datestart;

    @Column(name = "end_date")
    private LocalDate dateend;

    @Column(name = "city")
    private String city;

    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "id")
    private List<Sales> sales;

}