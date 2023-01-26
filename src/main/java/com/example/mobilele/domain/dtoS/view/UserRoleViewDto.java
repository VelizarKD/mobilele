package com.example.mobilele.domain.dtoS.view;

import com.example.mobilele.domain.enums.Role;

public class UserRoleViewDto {

    private Role role;

    public Role getRole() {
        return role;
    }

    public UserRoleViewDto setRole(Role role) {
        this.role = role;
        return this;
    }
}
