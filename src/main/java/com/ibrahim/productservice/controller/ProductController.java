package com.ibrahim.productservice.controller;

import com.ibrahim.productservice.dto.ProductRequestDTO;
import com.ibrahim.productservice.dto.ProductResponseDTO;
import com.ibrahim.productservice.model.Product;
import com.ibrahim.productservice.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequestDTO requestDTO)
    {
        return productService.createProduct(requestDTO);
    }

    @GetMapping("/allProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDTO> getAllProducts()
    {
        return productService.getAllProducts();
    }
}
