package com.ust.jpa_demo.payload;

import com.ust.jpa_demo.dto.AddressDto;

import java.util.List;

public record EmpAddrUpdateReq(int empId, List<AddressDto> addressDtoList) {
}
