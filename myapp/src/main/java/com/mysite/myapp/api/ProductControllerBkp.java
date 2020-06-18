package com.mysite.myapp.api;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mysite.myapp.config.JsonPropertyView;
import com.mysite.myapp.model.Product;
import com.mysite.myapp.repository.ProductRepository;


//@RestController
public class ProductControllerBkp {

	/*
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	@GetMapping("/productsBasic")
	@JsonView(JsonPropertyView.Basic.class)
	public List<Product> getAllBasic() {
		return productRepository.findAll();
	}
	
	@GetMapping("/productsWithCategory")
	@JsonView(JsonPropertyView.Category.class)
	public List<Product> getAllWithCategory() {
		return productRepository.getProductsWithCategory();
	}
	
	@GetMapping("/productsWithProvider")
	@JsonView(JsonPropertyView.Provider.class)
	public List<Product> getAllWithProvider() {
		return productRepository.getProductsWithProvider();
	}
	
	@GetMapping("/productsWithCategoryAndProvider")
	@JsonView(JsonPropertyView.CategoryAndProvider.class)
	public List<Product> getAllWithCategoryAndProvider() {
		return productRepository.getProductsWithCategoryAndProvider();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getOne(@PathVariable("id") Long id) {
		System.out.println("----- Product - get product by id : " + id);
		try {
			Product result = (Product)productRepository.getOne(id);
			System.out.println("----- Product - result = " + result);
			if(result == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else{
				System.out.println("----- Product - resultToString = " + result.toString());
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product product) {
		System.out.println(product);
		productRepository.save(product);
	}

	@PutMapping("/product/{id}")
	public Product edit(@RequestBody Product product, @PathVariable long id) {
		productRepository.save(product);
		return productRepository.findById(product.getId()).get();
	}
	
	@PatchMapping("/product/{id}")
	public Product partialEdit(@RequestBody Map<String, Object> fields, @PathVariable long id) {
		Product product = productRepository.findById(id).get();
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Product.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, product, value);
		});
		productRepository.save(product);
		return product;
	}
	
	@DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) {
		productRepository.deleteById(id);
    }
	
	*/
}
