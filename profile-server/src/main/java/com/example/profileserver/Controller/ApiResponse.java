package com.example.profileserver.Controller;

import com.example.profileserver.Domain.Profile;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String message;
    private T data;
}