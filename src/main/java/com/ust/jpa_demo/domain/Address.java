package com.ust.jpa_demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{

    @Id
    @GeneratedValue
    private int addressId;
    private String city;
    private String state;
    private String country;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
    private Employee employee;

}
