package com.ibrahim.productservice.mapper;

import com.ibrahim.productservice.dto.ProductRequestDTO;
import com.ibrahim.productservice.dto.ProductResponseDTO;
import com.ibrahim.productservice.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public Product fromRequestDTO(ProductRequestDTO requestDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(requestDTO, product);
        return product;
    }

    public List<ProductResponseDTO> fromProductList(List<Product> product) {
        List<ProductResponseDTO> responseDTO = (List<ProductResponseDTO>) new ProductResponseDTO();
        BeanUtils.copyProperties(product, responseDTO);
        return responseDTO;
    }
}
