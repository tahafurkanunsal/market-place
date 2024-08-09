package com.tfunsal.marketplace.service.product;

import com.tfunsal.marketplace.dto.ProductDto;
import com.tfunsal.marketplace.model.Product;
import com.tfunsal.marketplace.request.AddProductRequest;
import com.tfunsal.marketplace.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    Product addProduct(AddProductRequest addProductRequest);

    Product getProductById(Long id);

    void deleteProduct(Long id);

    Product updateProduct(UpdateProductRequest request, Long productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);
}
