package com.spring.springserver.uility.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/api/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @Value("${variable.url}") String envUrl){
        // TODO: https://gilssang97.tistory.com/43 이미지 업로드 및 불러오기 만들기
        try {
            // 이미지 저장
            String fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            // 폴더가 없으면 생성해주기
            Path uploadPath = Paths.get("uploads");
            if (!Files.exists(uploadPath)) {
                Files.createDirectory(uploadPath);
            }
            Path path = Paths.get("uploads/" + fileName);
            Files.write(path, bytes);

            String url = envUrl + "/uploads/" + fileName;
            System.out.println(url);
            // 이미지 URL 반환
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
