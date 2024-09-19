package ru.test.findmaxnumber.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Find max number API",
                description = "Приложение для поиска максимального числа в excel файлу",
                version = "1.0.0"
        )
)
public class SwaggerConfig {
}
