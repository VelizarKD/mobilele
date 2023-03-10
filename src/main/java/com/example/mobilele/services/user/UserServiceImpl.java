package com.example.mobilele.services.user;

import com.example.mobilele.reppositores.UserRepository;
import com.example.mobilele.services.init.DataBaseInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, DataBaseInitService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() > 0;
    }
}
