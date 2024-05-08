package com.example.demo.controller;


import com.example.demo.entity2.Ground;
import com.example.demo.pojo.GroundPojo;
import com.example.demo.service.GroundService;
import com.example.demo.shared.pojo.GlobalApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ground")
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;


    @GetMapping
    public GlobalApiResponse<List<Ground>> getData() {
        return GlobalApiResponse.
                <List<Ground>>builder()
                .data(this.groundService.getAll())
                .statusCode(200)
                .message("data retreived successfully")
                .build();
    }

    @PostMapping
    public GlobalApiResponse<String> save(@RequestBody @Valid GroundPojo groundPojo) {
        this.groundService.saveData(groundPojo);
        return GlobalApiResponse.
                <String>builder()
                .data("saved")
                .statusCode(200)
                .message("data saved successfully")
                .build();
    }

    @PutMapping
    public void update(@RequestBody GroundPojo groundPojo) {
        this.groundService.saveData(groundPojo);
    }

    @GetMapping("/{id}")
    public Optional<Ground> getData(@PathVariable Integer id) {
       return groundService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.groundService.deleteById(id);
    }

}
