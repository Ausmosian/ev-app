package com.EV.ChargingStation.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

public final class FileUtility {
    private FileUtility() {}

    public static String getRandomImageName(String imageName) {

        String newImageName = UUID.randomUUID().toString();
        return newImageName.concat(imageName.substring(imageName.lastIndexOf('.')));
    }

    public static String saveImage(String path, MultipartFile image) throws IOException {
        String imageName = FileUtility.getRandomImageName(Objects.requireNonNull(image.getOriginalFilename()));
        String imagePath = path + File.separator + imageName;

        File newImage = new File(path);
        if(!newImage.exists()) newImage.mkdir();
        Files.copy(image.getInputStream(), Paths.get(imagePath));

        return imageName;
    }
}
