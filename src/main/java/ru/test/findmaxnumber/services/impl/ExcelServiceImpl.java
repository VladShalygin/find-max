package ru.test.findmaxnumber.services.impl;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.test.findmaxnumber.api.dto.ResultWithDataDto;
import ru.test.findmaxnumber.services.ExcelService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService  {

    private final String UPLOAD_DIR = "files";

    @Override
    public ResultWithDataDto<String> uploadFile(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        Files.write(filePath, file.getBytes());

        return ResultWithDataDto.<String>builder()
                .success(true)
                .data(filePath.toString())
                .build();
    }

    @Override
    public ResultWithDataDto<Double> findMax(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new BadRequestException("File doesn`t exist!");
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            double max = Double.NEGATIVE_INFINITY;

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    double value = cell.getNumericCellValue();
                    if (value > max) {
                        max = value;
                    }
                }
            }

            return ResultWithDataDto.<Double>builder()
                    .success(true)
                    .data(max)
                    .build();
        }
    }
}
