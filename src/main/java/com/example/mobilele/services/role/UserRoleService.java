package com.example.mobilele.services.role;

import com.example.mobilele.domain.dtoS.view.UserRoleViewDto;
import com.example.mobilele.services.init.DataBaseInitService;

import java.util.List;

public interface UserRoleService extends DataBaseInitService {
    List<UserRoleViewDto> getAll();
}
