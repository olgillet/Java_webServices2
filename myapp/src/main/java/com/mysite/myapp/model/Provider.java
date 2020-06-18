package com.mysite.myapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="Provider")
public class Provider {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	String companyname;
	String bankaccountnumber;
	
	@JsonIgnoreProperties("provider")
	@OneToMany(mappedBy="provider", fetch = FetchType.EAGER)
	List<Product> products;
	
	public Provider() {
		super();
	}
	
	public Provider(String companyname, String bankaccountnumber) {
		super();
		this.companyname = companyname;
		this.bankaccountnumber = bankaccountnumber;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getBankaccountnumber() {
		return bankaccountnumber;
	}

	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Provider [id=" + id + ", companyName=" + companyname + ", bankAccountNumber=" + bankaccountnumber + ", products=" + products + "]";
	}
	
}
