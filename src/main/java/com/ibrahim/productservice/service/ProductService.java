package com.ibrahim.productservice.service;

import com.ibrahim.productservice.dto.ProductRequestDTO;
import com.ibrahim.productservice.dto.ProductResponseDTO;
import com.ibrahim.productservice.mapper.ProductMapper;
import com.ibrahim.productservice.model.Product;
import com.ibrahim.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ProductService implements IProductService{
   private ProductRepository repository;
    private ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Product createProduct(ProductRequestDTO requestDTO)
    {
        Product product = mapper.fromRequestDTO(requestDTO);
//        product.setId(UUID.randomUUID().toString());
        repository.save(product);
        log.info("Product {} saved succefully", product.getId());
        return product;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products=repository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponseDTO mapToProductResponse(Product product)
    {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice()).build();
    }
}
