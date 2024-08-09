package com.ust.jpa_demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    private int addressId;
    private String city;
    private String state;
    private String country;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
    private Employee employee;

}
