package ru.test.findmaxnumber.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    boolean success;
    String message;

}
