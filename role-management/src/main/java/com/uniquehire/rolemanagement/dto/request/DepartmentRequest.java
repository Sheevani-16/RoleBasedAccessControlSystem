package com.uniquehire.rolemanagement.dto.request;

import com.uniquehire.rolemanagement.enums.DepartmentName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {

    @NotNull(message = "Department name is required")
    private DepartmentName departmentName;

    @NotNull(message = "Number of trainings going on is required")
    private Integer numberOfTrainingsGoingOn;

    @NotNull(message = "Description is required")
    private String description;

    @NotNull(message = "Organization id is required")
    private Long organizationId;
}