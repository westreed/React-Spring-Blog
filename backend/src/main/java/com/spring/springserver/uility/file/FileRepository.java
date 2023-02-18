package com.spring.springserver.uility.file;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class FileRepository {
    private final EntityManager entityManager;

    public FileRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public File save(File image){
        entityManager.persist(image);
        return image;
    }

    public Optional<File> findById(Long id){
        File image = entityManager.find(File.class, id);
        return Optional.ofNullable(image);
    }
}
