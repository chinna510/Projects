package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import play.data.validation.Constraints;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;

public class Product {
	private static List<Product> products;

	static {
		products = new ArrayList<Product>();
		products.add(new Product("1111111111111", "Paperclips", " description 1"));
		products.add(new Product("2222222222222", "Paperclips", " description "));
		products.add(new Product("3333333333333", "Paperclips ", "description 3"));
		products.add(new Product("4444444444444", "Paperclips ", "description 4"));
		products.add(new Product("5555555555555", "Paperclips ", "description 5"));
	}

	@Constraints.Required
	@MinLength(6)
	@MaxLength(10)
	public String ean;
	@Constraints.Required
	@MinLength(10)
	@MaxLength(20)
	public String name;
	public String description;

	public Product() {
	}

	public Product(String ean, String name, String description) {
		this.ean = ean;
		this.name = name;
		this.description = description;

	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [ean=" + ean + ", name=" + name + ", description=" + description + "]";
	}

	public static List<Product> findAll() {
		System.out.println(products);
		return new ArrayList<Product>(products);
	}

	public static Product findByEan(String ean) {
		for (Product candidate : products) {
			if (candidate.ean.equals(ean)) {
				return candidate;
			}
		}
		return null;
	}

	public static List<Product> findByName(String term) {
		final List<Product> results = new ArrayList<Product>();
		for (Product candidate : products) {
			if (candidate.name.toLowerCase().contains(term.toLowerCase())) {
				results.add(candidate);
			}
		}
		return results;
	}

	public static boolean remove(Product product) {
		return products.remove(product);
	}

	public void save() {
		products.remove(findByEan(this.ean));
		products.add(this);
	}

	public List<Tag> tags = new LinkedList<Tag>();

	
}
