package com.mysite.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mysite.myapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
