package ru.test.findmaxnumber.api.controllers;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.test.findmaxnumber.api.dto.ErrorResponse;
import ru.test.findmaxnumber.api.dto.ResultWithDataDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        ErrorResponse result =  ErrorResponse.builder()
                .success(false)
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(Exception e) {

        ErrorResponse result = ErrorResponse.builder()
                .success(false)
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}