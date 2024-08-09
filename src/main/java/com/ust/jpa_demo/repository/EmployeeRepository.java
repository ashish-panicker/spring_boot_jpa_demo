package com.ust.jpa_demo.repository;

import com.ust.jpa_demo.domain.Employee;
import com.ust.jpa_demo.domain.RegularEmployee;
import com.ust.jpa_demo.domain.TempEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from RegularEmployee e")
    List<RegularEmployee> findAllRegularEmployees();

    @Query("select e from TempEmployee e")
    List<TempEmployee> findAllTempEmployees();

    List<TempEmployee> findAllByDailyWageGreaterThan(float dailyWage);
}
