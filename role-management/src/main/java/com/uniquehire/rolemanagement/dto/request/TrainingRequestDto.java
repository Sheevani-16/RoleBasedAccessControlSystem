package com.uniquehire.rolemanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingRequestDto {

    @NotBlank(message = "Training name is required")
    private String trainingName;

    @NotBlank(message = "Batch number is required")
    private String batchNo;

    @NotBlank(message = "Trainer name is required")
    private String trainerName;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotNull(message = "Number of trainees is required")
    private Integer noOfTrainees;

    @NotNull(message = "Department id is required")
    private Long departmentId;
}
