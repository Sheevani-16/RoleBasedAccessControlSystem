package com.uniquehire.rolemanagement.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "trainings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;

    @Column(nullable = false)
    private String trainingName;

    @Column(nullable = false)
    private String batchNo;

    @Column(nullable = false)
    private String trainerName;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Integer noOfTrainees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    @JsonBackReference
    private Department department;
}