package com.uniquehire.rolemanagement.service.impl;

import com.uniquehire.rolemanagement.dto.request.DepartmentRequest;
import com.uniquehire.rolemanagement.dto.response.DepartmentResponseDto;
import com.uniquehire.rolemanagement.entity.Department;
import com.uniquehire.rolemanagement.entity.Organization;
import com.uniquehire.rolemanagement.repository.DepartmentRepository;
import com.uniquehire.rolemanagement.repository.OrganizationRepository;
import com.uniquehire.rolemanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final OrganizationRepository organizationRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequest dto) {

        Organization organization = organizationRepository.findById(dto.getOrganizationId())
                .orElseThrow(() -> new RuntimeException(
                        "Organization not found with id: " + dto.getOrganizationId()));

        Department department = Department.builder()
                .departmentName(dto.getDepartmentName())
                .numberOfTrainingsGoingOn(dto.getNumberOfTrainingsGoingOn())
                .description(dto.getDescription())
                .organization(organization)
                .build();

        Department savedDepartment = departmentRepository.save(department);

        return mapToResponse(savedDepartment);
    }

    @Override
    public DepartmentResponseDto getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));

        return mapToResponse(department);
    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDto updateDepartment(Long id, DepartmentRequest dto) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));

        Organization organization = organizationRepository.findById(dto.getOrganizationId())
                .orElseThrow(() -> new RuntimeException(
                        "Organization not found with id: " + dto.getOrganizationId()));

        department.setDepartmentName(dto.getDepartmentName());
        department.setNumberOfTrainingsGoingOn(dto.getNumberOfTrainingsGoingOn());
        department.setDescription(dto.getDescription());
        department.setOrganization(organization);

        Department updatedDepartment = departmentRepository.save(department);

        return mapToResponse(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));

        departmentRepository.delete(department);
    }

    private DepartmentResponseDto mapToResponse(Department department) {

        return DepartmentResponseDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .numberOfTrainingsGoingOn(department.getNumberOfTrainingsGoingOn())
                .description(department.getDescription())
                .organizationId(department.getOrganization().getOrgId())
                .build();
    }
}