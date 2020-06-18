package com.mysite.myapp.config;

public interface JsonPropertyView {
	public interface Basic {}
	public interface Product extends Basic {}
	public interface Category extends Basic {}
	public interface Provider extends Basic {}
	
	public interface CategoryAndProvider extends Basic {}
	
}
