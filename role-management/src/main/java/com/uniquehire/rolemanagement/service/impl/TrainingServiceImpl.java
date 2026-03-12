package com.uniquehire.rolemanagement.service.impl;
import com.uniquehire.rolemanagement.dto.request.TrainingRequestDto;
import com.uniquehire.rolemanagement.dto.response.TrainingResponseDto;
import com.uniquehire.rolemanagement.entity.Department;
import com.uniquehire.rolemanagement.entity.Training;
import com.uniquehire.rolemanagement.repository.DepartmentRepository;
import com.uniquehire.rolemanagement.repository.TrainingRepository;
import com.uniquehire.rolemanagement.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public TrainingResponseDto createTraining(TrainingRequestDto dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + dto.getDepartmentId()));

        Training training = Training.builder()
                .trainingName(dto.getTrainingName())
                .batchNo(dto.getBatchNo())
                .trainerName(dto.getTrainerName())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .noOfTrainees(dto.getNoOfTrainees())
                .department(department)
                .build();

        return mapToResponse(trainingRepository.save(training));
    }

    @Override
    public TrainingResponseDto getTrainingById(Long id) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training not found with id: " + id));
        return mapToResponse(training);
    }

    @Override
    public List<TrainingResponseDto> getAllTrainings() {
        return trainingRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TrainingResponseDto updateTraining(Long id, TrainingRequestDto dto) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training not found with id: " + id));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + dto.getDepartmentId()));

        training.setTrainingName(dto.getTrainingName());
        training.setBatchNo(dto.getBatchNo());
        training.setTrainerName(dto.getTrainerName());
        training.setStartDate(dto.getStartDate());
        training.setEndDate(dto.getEndDate());
        training.setNoOfTrainees(dto.getNoOfTrainees());
        training.setDepartment(department);

        return mapToResponse(trainingRepository.save(training));
    }

    @Override
    public void deleteTraining(Long id) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training not found with id: " + id));
        trainingRepository.delete(training);
    }

    private TrainingResponseDto mapToResponse(Training training) {
        return TrainingResponseDto.builder()
                .trainingId(training.getTrainingId())
                .trainingName(training.getTrainingName())
                .batchNo(training.getBatchNo())
                .trainerName(training.getTrainerName())
                .startDate(training.getStartDate())
                .endDate(training.getEndDate())
                .noOfTrainees(training.getNoOfTrainees())
                .departmentId(training.getDepartment().getId())
                .build();
    }
}