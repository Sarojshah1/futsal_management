package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroundPojo {


    private Integer id;

    @NotNull(message = "Ground name is required field")
    private String groundName;
}
