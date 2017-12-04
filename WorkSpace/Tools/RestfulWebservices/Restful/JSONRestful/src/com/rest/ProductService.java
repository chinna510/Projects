package com.rest;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductService {

	ProductDao productDao;

	public ProductService() {
		productDao = ProductDao.instance;
	}

	public void createProduct(Product product) {
		productDao.getProducts().put(product.getId(), product);
	}

	public Product getProduct(String id) {
		return productDao.getProducts().get(id);
	}

	public Map<String, Product> getProducts() {
		return productDao.getProducts();
	}

	public List<Product> getProductAsList() {
		List<Product> productList = new ArrayList<Product>();
		productList.addAll(productDao.getProducts().values());
		return productList;
	}

	public int getProductsCount() {
		return productDao.getProducts().size();
	}

	public void deleteProduct(String id) {
		productDao.getProducts().remove(id);
	}

}