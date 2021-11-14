package com.example.tika.service;

import com.example.tika.utils.FileUtils;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public void fileUpload(MultipartFile uploadFile) {
        try(InputStream inputStream = uploadFile.getInputStream()) {
            System.out.println("Content Type : " + uploadFile.getContentType());

            if(!uploadFile.isEmpty()) {
                boolean isValid = FileUtils.validImgFile(inputStream);
                if(!isValid) {
                    // exception 처리
                    System.out.println("이미지 파일만 업로드 가능합니다.");
                }
                // 업로드 로직
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
