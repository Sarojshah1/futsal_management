package com.example.demo.service;

import com.example.demo.entity2.Ground;
import com.example.demo.entity2.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesServices {
    Optional<Roles> getRoleById(Integer id);
    List<Roles> getAllRoles();
    void saveRole(Roles roles);
    void deleteRoleById(Integer id);
}
