package com.devslashnil.adelie.dto.convertor;

import com.devslashnil.adelie.dto.ProductDTO;
import com.devslashnil.adelie.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConvertor extends ConvertorToDTO<Product, ProductDTO> {

    @Override
    public ProductDTO convertToDTO(Product entity){
        return modelMapper.map(entity, ProductDTO.class);
    }

}
