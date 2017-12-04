package com.biz;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.istack.logging.Logger;

@Path("/user")
public class GetUser {
	Logger log = Logger.getLogger(GetUser.class);
	
	@GET
	@Path("{param1}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getData(@PathParam("param1") int userid) throws ClassNotFoundException {

		/*log.info(" the Header is : " + logerHeader
				+ " , and the body is : " + body.toString());*/

		UserDAO s=new UserDAO();
		//selectuserDAO selectuserDAO = new selectuserDAO(exchange);
		User user = new User();

		//user.setId(Integer.parseInt(body));
		user.setId(userid);
		user.setName(name);
		user.setAddress(address);

		String name=s.viewdata(user);
		
		log.info("The data displayed ");
		return name;

	}

}
