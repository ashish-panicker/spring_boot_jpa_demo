package com.ust.jpa_demo.dto;

import jakarta.annotation.Nullable;

import java.util.List;
import java.util.Set;

public record EmployeeDto(
        @Nullable Integer id, String fullName, String email, @Nullable Float salary, @Nullable Integer bonus,
        @Nullable Float dailyWage, @Nullable Integer contractPeriod, AcessCardDto accessCard,
        @Nullable List<AddressDto> addresses, @Nullable Set<ProjectDto> projects) {
}
