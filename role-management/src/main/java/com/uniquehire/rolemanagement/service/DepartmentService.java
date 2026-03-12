package com.uniquehire.rolemanagement.service;
//
//import com.uniquehire.departmentservice.dto.request.DepartmentRequest;
//import com.uniquehire.departmentservice.dto.response.ApiResponse;
//import com.uniquehire.departmentservice.dto.response.DepartmentResponse;
//import com.uniquehire.departmentservice.enums.DepartmentName;
import com.uniquehire.rolemanagement.dto.request.DepartmentRequest;
import com.uniquehire.rolemanagement.dto.response.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequest dto);
    DepartmentResponseDto getDepartmentById(Long id);
    List<DepartmentResponseDto> getAllDepartments();
    DepartmentResponseDto updateDepartment(Long id, DepartmentRequest dto);
    void deleteDepartment(Long id);
}