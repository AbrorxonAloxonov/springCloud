package uz.najot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najot.entity.ProductEntity;
import uz.najot.model.ProductModel;
import uz.najot.service.ProductService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/all")
    public ResponseEntity getProducts(){
        return productService.getAllProduct();
    }
    @PostMapping("/save")
    public ResponseEntity saveProduct(@RequestBody ProductEntity product) throws IOException, TimeoutException {
        return productService.saveProduct(product);
    }
    @PostMapping("/pay")
    public ResponseEntity payProduct(@RequestBody ProductModel productModel) throws IOException, TimeoutException {
        return productService.payProduct(productModel);
    }
}
