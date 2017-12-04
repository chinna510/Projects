package controllers;

import java.util.ArrayList;
import java.util.List;
import controllers.Products;
import models.Product;
import models.Tag;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.index;

public class Products extends Controller {
	private static final Form<Product> productForm = Form.form(Product.class);

	public static Result list() {
		List<Product> products = Product.findAll();
		System.out.println("produ" + products);
		return ok(views.html.list.render(products));
	}

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result details(String ean) {
		final Product product = Product.findByEan(ean);
		if (product == null) {
			return notFound(String.format("Product %s does not exist.", ean));
		}
		Form<Product> filledForm = productForm.fill(product);
		return ok(views.html.details.render(filledForm));
	}

	public static Result newProduct() {
		return ok(views.html.details.render(productForm));
	}

	public static Result save() {
		Form<Product> boundForm = productForm.bindFromRequest();
		if (boundForm.hasErrors()) {
			flash("error", "Please correct the form below.");
			return badRequest(views.html.details.render(boundForm));
		}
		Product product = boundForm.get();
		
	
		product.save();
		flash("success", String.format("Successfully added product %s", product));
		return redirect(routes.Products.list());
	}

	public static Result delete(String ean) {
		final Product product = Product.findByEan(ean);
		if (product == null) {
			return notFound(String.format("Product %s does not exists.", ean));
		}
		Product.remove(product);
		return redirect(routes.Products.list());
	}
	

}
