package com.mysite.myapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.mysite.myapp.config.JsonPropertyView;

@Entity
@Table(name="Products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(JsonPropertyView.Basic.class)
	Long id;
	
	public Product() {
		super();
	}
	public Product(String name, Double unitPrice) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public Product(String name, Double unitPrice, String image, Date productDate, Boolean available, Integer quantity,
			String description, Category category) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.image = image;
		this.productDate = productDate;
		this.available = available;
		this.quantity = quantity;
		this.description = description;
		this.category = category;
	}

	@JsonView(JsonPropertyView.Basic.class)
	String name;
	
	Double unitPrice;
	String image;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	Date productDate;
	Boolean available;
	//Integer categoryId;
	Integer quantity;
	String description;
	
	@JsonIgnoreProperties("products")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonView(JsonPropertyView.Category.class)
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoryId")
	Category category;
	
	@JsonIgnoreProperties("products")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonView(JsonPropertyView.Provider.class)
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="providerId")
	Provider provider;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", image=" + image
				+ ", productDate=" + productDate + ", available=" + available + ", quantity=" + quantity
				+ ", description=" + description + ", category=" + category + "]";
	}
	
}
