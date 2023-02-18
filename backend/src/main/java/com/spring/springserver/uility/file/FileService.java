package com.spring.springserver.uility.file;

import org.springframework.beans.factory.annotation.Autowired;

public class FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveFile(File file){
        return fileRepository.save(file);
    }
}
