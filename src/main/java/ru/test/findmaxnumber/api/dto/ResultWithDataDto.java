package ru.test.findmaxnumber.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultWithDataDto<T> {

    boolean success;
    T data;

}
