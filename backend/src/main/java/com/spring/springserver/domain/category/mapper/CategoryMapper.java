package com.spring.springserver.domain.category.mapper;

import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.category.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    @Mapping(target = "createData", ignore = true)
    List<CategoryDto.Data> entityToDto(List<Category> entity);


    default List<Category> dtoToEntity(List<CategoryDto.Data> dto){
        List<Category> categoryList = new ArrayList<Category>(dto.size());
        for ( CategoryDto.Data categoryDto : dto ) {
            Category category = new Category(categoryDto.getId(), categoryDto.getLayer(), categoryDto.getName());
            categoryList.add( category );
        }
        return categoryList;
    }
}
