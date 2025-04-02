package com.day2.demo_day2.mongodb.controller;

import com.day2.demo_day2.mongodb.model.Product;
import com.day2.demo_day2.mongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProduct()
    {
        return productService.getAllProduts();
    }
    @GetMapping("/{id}")
   public Optional<Product> getProductById(@PathVariable String id)
   {
    return productService.getProductById(id);
   }
    @PutMapping("updateProduct/{id}")
     public Optional<Product> updateProduct(@PathVariable String id,@RequestBody Product product)
      {
         return productService.updateProduct(id,product);
          }

      @DeleteMapping("deleteProduct/{id}")
      public void deleteProduct(@PathVariable String id)
      {
          productService.deleteProd(id);
      }
   @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
   {
       return productService.addProduct(product);
   }
}
