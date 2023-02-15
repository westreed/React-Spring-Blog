package com.spring.springserver.domain.category.mapper;

import com.spring.springserver.domain.category.dto.CategoryDto.Data;
import com.spring.springserver.domain.category.dto.CategoryDto.Data.DataBuilder;
import com.spring.springserver.domain.category.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-15T14:15:03+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Amazon.com Inc.)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public List<Data> entityToDto(List<Category> entity) {
        if ( entity == null ) {
            return null;
        }

        List<Data> list = new ArrayList<Data>( entity.size() );
        for ( Category category : entity ) {
            list.add( categoryToData( category ) );
        }

        return list;
    }

    protected Data categoryToData(Category category) {
        if ( category == null ) {
            return null;
        }

        DataBuilder data = Data.builder();

        data.id( category.getId() );
        data.layer( category.getLayer() );
        data.name( category.getName() );

        return data.build();
    }
}
