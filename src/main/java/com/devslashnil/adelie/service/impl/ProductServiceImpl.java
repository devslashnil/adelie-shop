package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.dto.ProductDTO;
import com.devslashnil.adelie.dto.convertor.EntityConvertor;
import com.devslashnil.adelie.model.Product;
import com.devslashnil.adelie.repository.ProductRepository;
import com.devslashnil.adelie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductServiceImpl extends CrudServiceImpl<Product, Integer, ProductRepository, ProductDTO>
        implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository dao, EntityConvertor<Product, ProductDTO> conv) {
        super(dao, ProductDTO.class, Product.class, conv);
    }

    protected ProductDTO addSelfLink(ProductDTO dto) {
        return dto.add(linkTo(methodOn(getClass()).findById(dto.getId())).withRel("self"));
    }

    protected ProductDTO addListLink(ProductDTO dto) {
        dto.add(linkTo(methodOn(getClass()).findAll()).withRel("All products"));
        return dto;
    }

}
