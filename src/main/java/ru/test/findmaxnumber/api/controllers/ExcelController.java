package ru.test.findmaxnumber.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.test.findmaxnumber.api.dto.ResultWithDataDto;
import ru.test.findmaxnumber.services.ExcelService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name="Эксель", description="Эндпоинты для взаимодействия с эксель сервисом")
@RequestMapping("/excel")
public class ExcelController {

    private final ExcelService excelService;

    @PostMapping("/upload")
    @Operation(
            summary = "Загрузка документа",
            description = "Позволяет загрузить собственный документ в локальную папку"
    )
    public ResponseEntity<ResultWithDataDto<String>> uploadFile(
            @RequestParam("file")  @Parameter(description = "Загружаемый файл") MultipartFile file) throws IOException {
        return ResponseEntity.ok(excelService.uploadFile(file));
    }

    @GetMapping("/find-max")
    @Operation(
            summary = "Поиск максимального значения",
            description = "Позволяет найти максимальный элемент в таблице"
    )
    public ResponseEntity<ResultWithDataDto<Double>> findMaxInFirstColumn(
            @RequestParam("filePath") @Parameter(description = "Путь до файла", example = "test/example.excel") String filePath) throws IOException {
        return ResponseEntity.ok(excelService.findMax(filePath));
    }

}
