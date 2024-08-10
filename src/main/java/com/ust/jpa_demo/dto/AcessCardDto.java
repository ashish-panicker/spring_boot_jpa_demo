package com.ust.jpa_demo.dto;

import java.time.LocalDate;

public record AcessCardDto(int id,LocalDate allocatedDate, String accessCode) {
}
