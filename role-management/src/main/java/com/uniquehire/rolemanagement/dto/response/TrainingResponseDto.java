package com.uniquehire.rolemanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingResponseDto {

    private Long trainingId;
    private String trainingName;
    private String batchNo;
    private String trainerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer noOfTrainees;
    private Long departmentId;
}