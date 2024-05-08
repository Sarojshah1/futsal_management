package com.example.demo.service.impl;

import com.example.demo.entity2.Ground;
import com.example.demo.entity2.Roles;
import com.example.demo.repository.RolesRepository;
import com.example.demo.service.RolesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RolesServicesImpl implements RolesServices {
    private final RolesRepository rolesRepository;


    @Override
    public Optional<Roles> getRoleById(Integer id) {
        return rolesRepository.findById(id);
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public void saveRole(Roles roles) {
        rolesRepository.save(roles);
    }

    @Override
    public void deleteRoleById(Integer id) {
        rolesRepository.deleteById(id);
    }
}
