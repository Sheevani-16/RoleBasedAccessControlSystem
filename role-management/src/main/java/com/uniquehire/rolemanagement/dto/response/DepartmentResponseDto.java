package com.uniquehire.rolemanagement.dto.response;

import com.uniquehire.rolemanagement.enums.DepartmentName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.uniquehire.rolemanagement.enums.DepartmentName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentResponseDto {

    private Long id;
    private DepartmentName departmentName;
    private Integer numberOfTrainingsGoingOn;
    private String description;
    private Long organizationId;
}