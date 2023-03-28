package com.zhihuang.ontodo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/")
public class FileUploadController {
    @PostMapping("/upload")
    public String upload(String username, MultipartFile photo, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        saveFile(photo, path);
        return "Upload completed.";
    }

    private void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(System.getProperty("user.dir") + "/upload/" + photo.getOriginalFilename());
        photo.transferTo(file);
    }

}