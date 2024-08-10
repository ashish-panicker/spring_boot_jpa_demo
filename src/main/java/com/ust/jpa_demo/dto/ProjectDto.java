package com.ust.jpa_demo.dto;

import java.time.LocalDate;

public record ProjectDto(
        int id,
        LocalDate startDate,
        String title
) {
}
