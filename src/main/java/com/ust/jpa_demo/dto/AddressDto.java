package com.ust.jpa_demo.dto;

public record AddressDto(
        int id,
        String city,
        String state,
        String country
) {
}
