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
@Table(name = "trips", schema = "schema")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Trip(String nametourr, LocalDate datestart, LocalDate dateend, String city, Integer price) {
        this.nametourr = nametourr;
        this.datestart = datestart;
        this.dateend = dateend;
        this.city = city;
        this.price = price;
    }
}