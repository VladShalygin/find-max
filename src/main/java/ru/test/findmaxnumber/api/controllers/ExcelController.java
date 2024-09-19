package ru.test.findmaxnumber.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.test.findmaxnumber.api.dto.ResultWithDataDto;
import ru.test.findmaxnumber.services.ExcelService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")
public class ExcelController {

    private final ExcelService excelService;

    @PostMapping("/upload")
    public ResponseEntity<ResultWithDataDto<String>> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(excelService.uploadFile(file));
    }

    @GetMapping("/find-max")
    public ResponseEntity<ResultWithDataDto<Double>> findMaxInFirstColumn(@RequestParam("filePath") String filePath) throws IOException {
        return ResponseEntity.ok(excelService.findMax(filePath));
    }

}
