package com.day2.demo_day2.mongodb.service;

import com.day2.demo_day2.mongodb.model.Product;
import com.day2.demo_day2.mongodb.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepo productRepo;

    public List<Product> getAllProduts()
    {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(String id)
    {
        return productRepo.findById(id);
    }

    public void deleteProd(String id)
    {
        productRepo.deleteById(id);
    }

    public Product addProduct(Product product)
    {
        return productRepo.save(product);
    }


    public Optional<Product> updateProduct(String id, Product product) {
        return productRepo.findById(id).map(existingProduct -> {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            return productRepo.save(existingProduct);
        });
    }
}
