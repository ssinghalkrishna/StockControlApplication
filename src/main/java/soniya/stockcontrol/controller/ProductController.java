package soniya.stockcontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soniya.stockcontrol.exception.ProductNotFoundException;
import soniya.stockcontrol.model.Product;
import soniya.stockcontrol.service.ProductServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/products")
//http://localhost:8080/h2-ui

public class ProductController {

    @Autowired
    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    //http://localhost:8080/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }

    //http://localhost:8080/api/products/searchname?name=java
    @GetMapping("/searchname")
    public List<Product> searchProductsByName(@RequestParam(value = "name") String name) {
        return productServiceImpl.findByName(name);
    }

    //http://localhost:8080/api/products/searchdescription?description=to
    @GetMapping("/searchdescription")
    public List<Product> searchProductsByDescription(@RequestParam(value = "description") String description) {
        return productServiceImpl.findByDescription(description);
    }

    @GetMapping("/{id}")
    public Product getProductsById(@PathVariable Long id) throws ProductNotFoundException {
        return productServiceImpl.getProductById(id);
    }

    //need to demonstrate a POST using Postman or have a front end form to pass the data
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        System.out.println(product.toString());
        return productServiceImpl.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productServiceImpl.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productServiceImpl.deleteProduct(id);
    }

}
