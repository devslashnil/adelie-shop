package com.devslashnil.adelie;

import com.devslashnil.adelie.dto.convertor.EntityConvertor;
import com.devslashnil.adelie.model.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.RepresentationModel;

@Configuration
public class BeanConfig {

    @Bean EntityConvertor<? extends BaseEntity, ? extends RepresentationModel<?>> getEntityConvertor() {
        return new EntityConvertor<>(new ModelMapper());
    }

}
