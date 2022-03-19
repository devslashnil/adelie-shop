package com.devslashnil.adelie;

import com.devslashnil.adelie.dto.convertor.DataConvertor;
import com.devslashnil.adelie.model.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.RepresentationModel;

@Configuration
public class BeanConfig {

    @Bean
    DataConvertor<? extends BaseEntity, ? extends RepresentationModel<?>> getEntityConvertor() {
        return new DataConvertor<>(new ModelMapper());
    }

}
