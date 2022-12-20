package com.ibrahim.productservice.service;

import com.ibrahim.productservice.dto.ProductRequestDTO;
import com.ibrahim.productservice.dto.ProductResponseDTO;
import com.ibrahim.productservice.model.Product;

import java.util.List;

public interface IProductService {
    public Product createProduct(ProductRequestDTO requestDTO);
    public List<ProductResponseDTO> getAllProducts();
}
