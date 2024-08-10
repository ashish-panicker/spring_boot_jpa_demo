package com.ust.jpa_demo.payload;

import com.ust.jpa_demo.dto.ProjectDto;

import java.util.Set;

public record EmpPrjUpdateReq(int empId, Set<ProjectDto> projects) {
}
