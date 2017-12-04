package controllers;

import play.*;

import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static  Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result hello(String name) {
    	return ok(views.html.hello.render(name));
    	}
}
