package ru.test.findmaxnumber.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Сущность ответа сервера")
public class ResultWithDataDto<T> {

    @Schema(description = "Результат выполнения операции", example = "true")
    boolean success;

    @Schema(description = "Значение ответа", example = "test/file.xlsx")
    T data;

}
