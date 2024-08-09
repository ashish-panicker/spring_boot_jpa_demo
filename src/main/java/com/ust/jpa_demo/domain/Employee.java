package com.ust.jpa_demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String fullName;
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "access_card_id", referencedColumnName = "cardId")
    private AccessCard accessCard;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "emp_projects",
            joinColumns = {@JoinColumn(name = "emp_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> projects;

}
