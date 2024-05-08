package com.example.demo.controller;

import com.example.demo.entity2.Roles;
import com.example.demo.service.RolesServices;
import com.example.demo.shared.pojo.GlobalApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RolesServices rolesService;

    @GetMapping
    public GlobalApiResponse<List<Roles>> getAllRoles() {
        return GlobalApiResponse
                .<List<Roles>>builder()
                .data(rolesService.getAllRoles())
                .statusCode(200)
                .message("Roles retrieved successfully")
                .build();
    }

    @PostMapping
    public GlobalApiResponse<String> saveRole(@RequestBody @Valid Roles roles) {
        rolesService.saveRole(roles);
        return GlobalApiResponse
                .<String>builder()
                .data("saved")
                .statusCode(200)
                .message("Role saved successfully")
                .build();
    }

    @PutMapping("/{id}")
    public GlobalApiResponse<String> updateRole(@PathVariable Integer id, @RequestBody @Valid Roles roles) {
        roles.setId(id);
        rolesService.saveRole(roles);
        return GlobalApiResponse
                .<String>builder()
                .data("updated")
                .statusCode(200)
                .message("Role updated successfully")
                .build();
    }

    @GetMapping("/{id}")
    public GlobalApiResponse<Roles> getRoleById(@PathVariable Integer id) {
        Optional<Roles> role = rolesService.getRoleById(id);
        return role.map(value ->
                        GlobalApiResponse.<Roles>builder()
                                .data(value)
                                .statusCode(200)
                                .message("Role retrieved successfully")
                                .build())
                .orElseGet(() ->
                        GlobalApiResponse.<Roles>builder()
                                .statusCode(404)
                                .message("Role not found")
                                .build());
    }

    @DeleteMapping("/{id}")
    public GlobalApiResponse<String> deleteRoleById(@PathVariable Integer id) {
        rolesService.deleteRoleById(id);
        return GlobalApiResponse
                .<String>builder()
                .data("deleted")
                .statusCode(200)
                .message("Role deleted successfully")
                .build();
    }
}
