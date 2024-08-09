package com.ust.jpa_demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "access_cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private LocalDate allocatedDate;
    private String accessCode;

    @OneToOne(mappedBy = "accessCard")
    private Employee employee;
}
