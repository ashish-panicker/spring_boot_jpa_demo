package com.ust.jpa_demo.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.STRING)
public class Employee extends BaseEntity{

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

    public Employee(String fullName, String email, AccessCard accessCard,
                    List<Address> addresses, Set<Project> projects) {
        this.fullName = fullName;
        this.email = email;
        this.accessCard = accessCard;
        this.addresses = addresses;
        this.projects = projects;
    }
}
