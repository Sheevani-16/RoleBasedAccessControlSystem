package com.uniquehire.rolemanagement.service;

import com.uniquehire.rolemanagement.dto.request.OrganizationRequestDto;
import com.uniquehire.rolemanagement.dto.response.OrganizationResponseDto;
import java.util.List;

public interface OrganizationService {

    OrganizationResponseDto createOrganization(OrganizationRequestDto requestDto);

    OrganizationResponseDto getOrganizationById(Long orgId);

    List<OrganizationResponseDto> getAllOrganizations();

    OrganizationResponseDto updateOrganization(Long orgId, OrganizationRequestDto requestDto);

    void deleteOrganization(Long orgId);
}