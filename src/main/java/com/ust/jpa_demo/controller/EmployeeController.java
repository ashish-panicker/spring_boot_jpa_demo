package com.ust.jpa_demo.controller;

import com.ust.jpa_demo.domain.AccessCard;
import com.ust.jpa_demo.domain.Address;
import com.ust.jpa_demo.domain.Employee;
import com.ust.jpa_demo.domain.RegularEmployee;
import com.ust.jpa_demo.dto.AcessCardDto;
import com.ust.jpa_demo.dto.AddressDto;
import com.ust.jpa_demo.dto.EmployeeDto;
import com.ust.jpa_demo.payload.EmpCreationReq;
import com.ust.jpa_demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/regular")
    public ResponseEntity<Employee> addRegularEmployee(@RequestBody EmpCreationReq request) {

        AcessCardDto cardDto = request.acessCardDto();
        EmployeeDto employeeDto = request.employeeDto();
        List<AddressDto> addressDtos = request.addressDtoList();

        List<Address> addresses = (List<Address>) addressDtos.stream()
                .map(addressDto -> Address.builder()
                        .city(addressDto.city())
                        .state(addressDto.state())
                        .country(addressDto.country())
                        .build())
                .toList();

        AccessCard accessCard = AccessCard.builder()
                .accessCode(cardDto.accessCode())
                .allocatedDate(cardDto.allocatedDate())
                .build();

        RegularEmployee regularEmployee = RegularEmployee.builder()
                .fullName(employeeDto.fullName())
                .email(employeeDto.email())
                .salary(employeeDto.salary())
                .bonus(employeeDto.bonus())
                .accessCard(accessCard)
                .addresses(addresses)
                .build();

        addresses.forEach(address -> address.setEmployee(regularEmployee));
        accessCard.setEmployee(regularEmployee);

        employeeService.createEmployee(regularEmployee);

        return ResponseEntity.ok(regularEmployee);
    }
}
