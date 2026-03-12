package com.uniquehire.rolemanagement.service;
import com.uniquehire.rolemanagement.dto.request.TrainingRequestDto;
import com.uniquehire.rolemanagement.dto.response.TrainingResponseDto;

import java.util.List;

public interface TrainingService {
    TrainingResponseDto createTraining(TrainingRequestDto dto);
    TrainingResponseDto getTrainingById(Long id);
    List<TrainingResponseDto> getAllTrainings();
    TrainingResponseDto updateTraining(Long id, TrainingRequestDto dto);
    void deleteTraining(Long id);
}