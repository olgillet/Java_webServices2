package com.mysite.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mysite.myapp.model.Provider;


public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
