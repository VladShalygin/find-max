package ru.test.findmaxnumber.services;

import org.springframework.web.multipart.MultipartFile;
import ru.test.findmaxnumber.api.dto.ResultWithDataDto;

import java.io.IOException;

public interface ExcelService {
    ResultWithDataDto<String> uploadFile(MultipartFile file) throws IOException;

    ResultWithDataDto<Double> findMax(String filePath) throws IOException;
}
