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
import com.mysite.myapp.model.Provider;
import com.mysite.myapp.repository.CategoryRepository;
import com.mysite.myapp.repository.ProviderRepository;

@RestController
public class ProviderController {
	
	@Autowired
	ProviderRepository providerRepository;

	@GetMapping("/providers")
	public List<Provider> getAll() {
		return providerRepository.findAll();
	}

	@GetMapping("/provider/{id}")
	public ResponseEntity<Provider> getOne(@PathVariable("id") Long id) {
		System.out.println("----- Provider - get provider by id : " + id);
		try {
			Provider result = (Provider)providerRepository.getOne(id);
			System.out.println("----- Provider - result = " + result);
			if(result == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				System.out.println("----- Provider - resultToString = " + result.toString());
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/provider")
	public void addProvider(@RequestBody Provider provider) {
		System.out.println(provider);
		providerRepository.save(provider);
	}
	
}
