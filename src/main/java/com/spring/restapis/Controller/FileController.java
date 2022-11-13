package com.spring.restapis.Controller;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.classic.Logger;

@RestController
public class FileController {

   private Logger logger = (Logger) LoggerFactory.getLogger(FileController.class);


    @PostMapping("/upload")
    public ResponseEntity<?> uploadMultipleFile(@RequestParam("files") MultipartFile[] files) {
        this.logger.info("no of files uploaded: " + files.length);
Arrays.stream(files).forEach(file -> {
            this.logger.info("file name: " + file.getOriginalFilename());
            this.logger.info("file content:" + file.getContentType());
            this.logger.info("file" + file.getClass());
       
        });


        return ResponseEntity.ok("File uploaded successfully");


    }
}


