package com.example.mobilele.services.role;
import com.example.mobilele.domain.dtoS.view.UserRoleViewDto;
import com.example.mobilele.domain.entities.UserRole;
import com.example.mobilele.domain.enums.Role;
import com.example.mobilele.reppositores.RoleRepository;
import com.example.mobilele.services.init.DataBaseInitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService, DataBaseInitService {
    private final RoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleServiceImpl(RoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.dbInit();
    }


    @Override
    public void dbInit() {
        if (!isDbInit()) {
            List<UserRole> roles = new ArrayList<>();

            roles.add(new UserRole().setRole(Role.USER));
            roles.add(new UserRole().setRole(Role.ADMIN));

            this.userRoleRepository.saveAllAndFlush(roles);
        }
    }

    @Override
    public boolean isDbInit() {
       return this.userRoleRepository.count() > 0;
    }

    public List<UserRoleViewDto> getAll() {
        return this.userRoleRepository.findAll()
                .stream()
                .map(r ->this.modelMapper.map(r, UserRoleViewDto.class))
                .collect(Collectors.toList());
    }
}
