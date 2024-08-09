# Spring Data JPA

## Overview

Spring Data JPA, part of the larger Spring Data family, makes it easy to easily implement JPA based repositories. 
This module deals with enhanced support for JPA based data access layers. 
It makes it easier to build Spring-powered applications that use data access technologies.

## Features

### JPA Repository Abstraction

Allows developers to work with JPA entities without having to write boilerplate code.

### Query Methods

Spring Data JPA supports the creation of JPA queries from method names.

### Custom Queries

Spring Data JPA allows developers to define custom queries using JPQL, SQL, or native queries.

### Paging & Sorting

Spring Data JPA supports pagination and sorting for JPA repositories.

### Auditing

Spring Data JPA provides auditing support for JPA entities.

### Transaction Management

Spring Data JPA provides transaction management support for JPA repositories.

## Entity Inheritance

Spring Data JPA supports entity inheritance strategies. There are three inheritance strategies supported by JPA:

1. Single Table
2. Joined
3. Table Per Class

**Single Table**

In this strategy, all classes in the hierarchy are mapped to a single table in the database.
```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String employeeType;
    // Getters and Setters
}

@Entity
@DiscriminatorValue("full_time")
public class FullTimeEmployee extends Employee {
    private double salary;
    private double bonus;
    // Getters and Setters
}

@Entity
@DiscriminatorValue("part_time")
public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    // Getters and Setters
}
```

**Joined**

In this strategy, each class in the hierarchy is mapped to its table in the database.
```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    // Getters and Setters
}

@Entity
public class FullTimeEmployee extends Employee {
    private double salary;
    private double bonus;
    // Getters and Setters
}

@Entity
public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    // Getters and Setters
}
```

**Table Per Class**

In this strategy, each class in the hierarchy is mapped to its table in the database.
```java
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    // Getters and Setters
}

@Entity
public class FullTimeEmployee extends Employee {
    private double salary;
    private double bonus;
    // Getters and Setters
}

@Entity
public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    // Getters and Setters
}
```

## Entity Association Mapping

Spring Data JPA supports the following types of entity associations:
    
1. One-to-One
2. One-to-Many
3. Many-to-One
4. Many-to-Many

**One-to-One**

In this type of association,

- Each record in the source entity is associated with one record in the target entity.
- Implemented using `@OneToOne` annotation
- Typically, uses a foreign key in the owner entity's table. Owner Entity is the one where the foreign key is created

```java
@Entity
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate allocatedDate;
    private String accessCode;
    // Getters and Setters
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @OneToOne
    private AccessCard accessCard;
    // Getters and Setters
}
```

**One To Many**

In this type of association, 

- One record in the source entity is associated with multiple records in the target entity.
- Implemented using `@OneToMany` annotation.
- Typically, uses a foreign key in the target entity's table. Target Entity is the one where the foreign key is created.

```java
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    // Getters and Setters
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @ManyToOne
    private Department department;
    // Getters and Setters
}
```