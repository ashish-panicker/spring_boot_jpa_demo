package com.ust.jpa_demo.payload;

import com.ust.jpa_demo.domain.AccessCard;
import com.ust.jpa_demo.dto.AcessCardDto;
import com.ust.jpa_demo.dto.AddressDto;
import com.ust.jpa_demo.dto.EmployeeDto;

import java.util.List;

public record EmpCreationReq(
        EmployeeDto employeeDto,
        List<AddressDto> addressDtoList,
        AcessCardDto acessCardDto
) {
}
