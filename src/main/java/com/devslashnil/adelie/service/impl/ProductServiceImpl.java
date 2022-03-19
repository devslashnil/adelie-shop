package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.dto.ProductDTO;
import com.devslashnil.adelie.dto.convertor.DataConvertor;
import com.devslashnil.adelie.model.Product;
import com.devslashnil.adelie.repository.ProductRepository;
import com.devslashnil.adelie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends CrudServiceImpl<Product, Integer, ProductRepository, ProductDTO>
        implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository dao, DataConvertor<Product, ProductDTO> conv) {
        super(dao, ProductDTO.class, Product.class, conv);
    }

}
