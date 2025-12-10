package com.example.authentication_service.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.authentication_service.model.Role;
import com.example.authentication_service.repository.RoleRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name).orElse(null);
    }
}
