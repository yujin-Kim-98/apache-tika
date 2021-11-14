package com.example.tika.controller;

import com.example.tika.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @PostMapping("/file-upload")
    public ResponseEntity fileUpload(@RequestParam("file")MultipartFile uploadFile) {
        fileService.fileUpload(uploadFile);
        return ResponseEntity.ok().build();
    }
}
