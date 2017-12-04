package com.bizruntime;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/userget")
public class UserGet {
	Userdemo udemo=new Userdemo();
	private static String SUCCESS_RESULT="success";
	//private static String FAILURE_RESULT="failure";
		
	@GET
	@Path("{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("param") int userid ){
		User user=new User();
		user.setUid(userid);
		user.setUname("abc");
		return user;
	}
	 
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
	      return udemo.userList();
	}
  
  @PUT
  @Path("{param}")
  @Produces(MediaType.APPLICATION_JSON)
 // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String putUser(@PathParam("param") int id){
	 
	  List<User> ulist=udemo.userList();
	  boolean userExists = false;
      for(User user: ulist){
         if(user.getUid() == id){
            userExists = true;
            break;
         }
      }		
      if(!userExists){
    	  udemo.getList().add(new User(id,"chinna"));
      }
	  return SUCCESS_RESULT;
  }
  
  @POST
  @Path("{param}")
  @Produces(MediaType.APPLICATION_JSON)
  //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String postUser(@PathParam("param") int id){
	  udemo.getList().add(new User(id,"vijay"));
	  return SUCCESS_RESULT;
  }
  
  
   
   
}

