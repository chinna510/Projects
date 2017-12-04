package com.biz;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.istack.logging.Logger;



@Path("/userend")
public class UserEndPoint {
	Logger log = Logger.getLogger(UserEndPoint.class);
	
	private static final String SUCCESS_RESULT = "success";
	private static final String FAILURE_RESULT = "failure";
	
	@GET
	@Path("{param1}/{param2}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUser(@PathParam("param1") int userid ,@PathParam("param2") String name){
		String usr = "Hello "+name+" your id is: "+userid;
		User user = new User();
		user.setId(userid);
		user.setName(name);
		log.info(SUCCESS_RESULT);
		return usr;
	}
	
	@PUT
	@Path("{param}/{param2}/{param3}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser(@PathParam("param1") int userid ,
			@PathParam("param2") String name, @PathParam("param3") String add){
		
				return null;
	
	}
}
