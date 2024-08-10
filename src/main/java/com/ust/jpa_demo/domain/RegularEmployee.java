package com.ust.jpa_demo.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
//@DiscriminatorValue("REGULAR")
public class RegularEmployee extends Employee {
    private float salary;
    private int bonus;

    public RegularEmployee(String fullName, String email, AccessCard accessCard,
                           List<Address> addresses, Set<Project> projects, float salary, int bonus) {
        super(fullName, email, accessCard, addresses, projects);
        this.salary = salary;
        this.bonus = bonus;
    }
}
