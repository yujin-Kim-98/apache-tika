package com.example.tika.utils;

import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

    private static final Tika tika = new Tika();

    public static File multipartfileToFile(MultipartFile multipartFile) {
        try {
            File file = new File(multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean validImgFile(File file, InputStream inputStream) {
        try {
            List<String> notValidTypeList = Arrays.asList("text/html");

            String mimeType = tika.detect(inputStream);
            System.out.println("MimeType : " + mimeType);

            boolean isValid = notValidTypeList.stream().anyMatch(notValidType -> notValidType.equalsIgnoreCase(mimeType));

            return isValid;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
