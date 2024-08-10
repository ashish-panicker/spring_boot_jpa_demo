package com.ust.jpa_demo.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
//@DiscriminatorValue("TEMP")
public class TempEmployee extends Employee {
    private float dailyWage;
    private int contractPeriod;
}
