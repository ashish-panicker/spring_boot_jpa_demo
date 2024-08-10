package com.ust.jpa_demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue
    private int projectId;
    private LocalDate startDate;
    private String title;

    @JsonBackReference
    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<Employee> employees;
}
