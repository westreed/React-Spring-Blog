package com.spring.springserver.domain.category.repository;

import com.spring.springserver.domain.category.entity.Category;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaCategoryRepository implements CategoryRepository {

    private final EntityManager entityManager;

    public JpaCategoryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Category save(Category category) {
        entityManager.persist(category);
        return category;
    }

    @Override
    public void saveAll(List<Category> categories) {
        for (Category category : categories){
            this.save(category);
        }
    }

    @Override
    public Optional<Category> findById(Long id) {
        Category category = entityManager.find(Category.class, id);
        return Optional.ofNullable(category);
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    @Override
    public Optional<Category> update(Category category) {
        Optional<Category> res = this.findById(category.getId());
        if(res.isPresent()){
            Category prevCategory = res.get();
            prevCategory.setLayer(category.getLayer());
            prevCategory.setName(category.getName());
            entityManager.merge(prevCategory);
            return Optional.of(prevCategory);
        }
        return Optional.empty();
    }

    @Override
    public void updateAll(List<Category> categories) {
        for (Category category : categories){
            this.update(category);
        }
    }

    @Override
    public void delete(Category category){
        if (entityManager.contains(category)) {
            entityManager.remove(category);
        }
        else{
            entityManager.remove(entityManager.merge(category));
        }
    }

    @Override
    public void deleteAll() {
        List<Category> categories = this.findAll();
        for (Category category : categories){
            this.delete(category);
        }
    }
}
