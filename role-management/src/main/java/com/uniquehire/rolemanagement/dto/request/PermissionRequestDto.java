package com.uniquehire.rolemanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PermissionRequestDto {
    @NotBlank(message="Name is required")
    private String name;
    private String description;
}
