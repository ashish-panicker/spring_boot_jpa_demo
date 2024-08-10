package com.ust.jpa_demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "access_cards")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private LocalDate allocatedDate;
    private String accessCode;

    @JsonBackReference
    @OneToOne(mappedBy = "accessCard")
    private Employee employee;
}
