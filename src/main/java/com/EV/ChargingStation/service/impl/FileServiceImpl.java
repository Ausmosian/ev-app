package com.EV.ChargingStation.service.impl;

import com.EV.ChargingStation.service.FileService;
import com.EV.ChargingStation.util.FileUtility;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        String fileName = FileUtility.getRandomImageName(file.getOriginalFilename());
        String filePath = path + File.separator + fileName;

        File newFile = new File(path);
        if(!newFile.exists()) newFile.mkdir();
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }
}
