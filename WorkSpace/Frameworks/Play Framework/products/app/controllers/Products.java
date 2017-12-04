package controllers;

import java.util.List;



import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Products extends Controller {
	private static final Form<Product> productForm = Form.form(Product.class);

	public static Result list() {
		List<Product> products = Product.findAll();
		System.out.println("produ" + products);
		return ok(views.html.list.render(products));
	}

	public static Result details(String ean) {
		return TODO;
	}

}
