package com.uniquehire.rolemanagement.service.impl;
import com.uniquehire.rolemanagement.dto.request.OrganizationRequestDto;
import com.uniquehire.rolemanagement.dto.response.OrganizationResponseDto;
import com.uniquehire.rolemanagement.entity.Organization;
import com.uniquehire.rolemanagement.repository.OrganizationRepository;
import com.uniquehire.rolemanagement.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationResponseDto createOrganization(OrganizationRequestDto dto) {
        Organization organization = Organization.builder()
                .orgName(dto.getOrgName())
                .address(dto.getAddress())
                .code(dto.getCode())
                .build();

        return mapToResponse(organizationRepository.save(organization));
    }

    @Override
    public OrganizationResponseDto getOrganizationById(Long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
        return mapToResponse(organization);
    }

    @Override
    public List<OrganizationResponseDto> getAllOrganizations() {
        return organizationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public OrganizationResponseDto updateOrganization(Long id, OrganizationRequestDto dto) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));

        organization.setOrgName(dto.getOrgName());
        organization.setAddress(dto.getAddress());
        organization.setCode(dto.getCode());

        return mapToResponse(organizationRepository.save(organization));
    }

    @Override
    public void deleteOrganization(Long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
        organizationRepository.delete(organization);
    }

    private OrganizationResponseDto mapToResponse(Organization organization) {
        return OrganizationResponseDto.builder()
                .orgId(organization.getOrgId())
                .orgName(organization.getOrgName())
                .address(organization.getAddress())
                .code(organization.getCode())
                .build();
    }
}