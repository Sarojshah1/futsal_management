package com.example.demo.shared.pojo;


import com.example.demo.entity2.Ground;
import lombok.*;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlobalApiResponse<T> {
    private String message;
    private Integer statusCode;
    private T data;
}
