package controllers;
import static play.data.Form.form;
import play.*;
import play.data.DynamicForm;
import play.mvc.*;
import scala.xml.dtd.Decl;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result testMethod(){
    	DynamicForm dynaform=form().bindFromRequest();
    	String fname=dynaform.get("fname");
    	String lname=dynaform.get("lname");
    System.out.println(fname);
    	
    	return ok(demo.render(""));
    }

}
