package com.mysite.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mysite.myapp.model.Product;

@RepositoryRestResource(path="api-product")
public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByDescription(String description);
	
	// Find Product by Word contained in Description
	@Query("select p from Product p where p.description like %:description%")
    public List<Product> findByDescriptionLike(@Param("description") String description);
	
	public List<Product> findProductByUnitPriceBetween(Double price1, Double price2);
	
	public List<Product> findProductByName(String name);

	@Query("select p from Product p where p.category != null")
	public List<Product> getProductsWithCategory();
	
	@Query("select p from Product p where p.provider != null")
	public List<Product> getProductsWithProvider();

	@Query("select p from Product p where p.category != null and p.provider != null")
	public List<Product> getProductsWithCategoryAndProvider();
}