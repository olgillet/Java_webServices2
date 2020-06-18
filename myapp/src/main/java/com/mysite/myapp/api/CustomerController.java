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

import com.mysite.myapp.model.Customer;
import com.mysite.myapp.model.Product;
import com.mysite.myapp.repository.CustomerRepository;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/customers")
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getOne(@PathVariable("id") Long id) {
		System.out.println("----- Customer - get customer by id : " + id);
		try {
			Customer result = (Customer)customerRepository.getOne(id);
			System.out.println("----- Customer - result = " + result);
			if(result == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else{
				System.out.println("----- Customer - resultToString = " + result.toString());
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/customer")
	public void addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		customerRepository.save(customer);
	}

	@PutMapping("/customer/{id}")
	public Customer edit(@RequestBody Customer customer, @PathVariable long id) {
		customerRepository.save(customer);
		return customerRepository.findById(customer.getId()).get();
	}
	
	@PatchMapping("/customer/{id}")
	public Customer partialEdit(@RequestBody Map<String, Object> fields, @PathVariable long id) {
		Customer customer = customerRepository.findById(id).get();
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Product.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, customer, value);
		});
		customerRepository.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customer/{id}")
    public void delete(@PathVariable Long id) {
		customerRepository.deleteById(id);
    }
	
	
}
