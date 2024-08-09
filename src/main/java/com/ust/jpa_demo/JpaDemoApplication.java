package com.ust.jpa_demo;

import com.ust.jpa_demo.domain.RegularEmployee;
import com.ust.jpa_demo.domain.TempEmployee;
import com.ust.jpa_demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    // CommandLineRunner
//    @Bean
    public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            TempEmployee tempEmployee = new TempEmployee();
            tempEmployee.setFullName("John Doe");
            tempEmployee.setEmail("john.doe");
            tempEmployee.setDailyWage(3000);
            tempEmployee.setContractPeriod(6);
            employeeRepository.save(tempEmployee);
            System.out.println("Employee saved: " + tempEmployee);
            RegularEmployee regularEmployee = new RegularEmployee();
            regularEmployee.setFullName("Jane Doe");
            regularEmployee.setEmail("jane.doe");
            regularEmployee.setSalary(5000);
            regularEmployee.setBonus(500);
            employeeRepository.save(regularEmployee);

            employeeRepository.findAllByDailyWageGreaterThan(2000.0f).forEach(System.out::println);
        };
    }

}
