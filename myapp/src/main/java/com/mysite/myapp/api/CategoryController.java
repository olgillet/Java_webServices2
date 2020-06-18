package com.mysite.myapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.myapp.model.Category;
import com.mysite.myapp.repository.CategoryRepository;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/categories")
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getOne(@PathVariable("id") Long id) {
		System.out.println("----- Category - get category by id : " + id);
		try {
			Category result = (Category)categoryRepository.getOne(id);
			System.out.println("----- Category - result = " + result);
			if(result == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				System.out.println("----- Category - resultToString = " + result.toString());
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/category")
	public void addCategory(@RequestBody Category category) {
		System.out.println(category);
		categoryRepository.save(category);
	}
	
}
