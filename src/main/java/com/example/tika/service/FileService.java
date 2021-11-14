package com.example.tika.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
    void fileUpload(MultipartFile uploadFile);
}
