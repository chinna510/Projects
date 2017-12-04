package com.paas_gui.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.paas_gui.register.CheckLoginDAO;
import com.paas_gui.register.Employee;
import com.paas_gui.register.userDAO;
import com.paas_gui.vpc.CloudProviders;
import com.paas_gui.vpc.ContainerTypes;
import com.paas_gui.vpc.EnvironmentTypes;
import com.paas_gui.vpc.FirewallInbounds;
import com.paas_gui.vpc.FirewallOutbounds;
import com.paas_gui.vpc.HostScalingPolicy;
import com.paas_gui.vpc.ImageRegistry;
import com.paas_gui.vpc.ResourceSelection;
import com.paas_gui.vpc.ScalingAndRecovery;
import com.paas_gui.vpc.ServiceAffinities;
import com.paas_gui.vpc.Subnet;
import com.paas_gui.vpc.Vpc_pozo;

@Path("/fetchData")
public class FetchData {

	private static final Logger LOGGER = Logger.getLogger(FetchData.class);

	
                 /*for registration*/
	
	
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postMsg(String msg) {
		
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		Employee user = null;
		try {
			user = mapper.readValue(msg, Employee.class);
			userDAO s = new userDAO();
			s.viewdata(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("{Param1}/{Param2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUnique(@PathParam("Param1") String username,@PathParam("Param2") String password) {
		String name;
		LOGGER.info(password);
		CheckLoginDAO sa = new CheckLoginDAO();
		boolean flag = sa.viewdata(password, username);
		LOGGER.info("returnd : " + flag);
		if (flag == false) {
			name = "try another";

		} else {
			name = password;
		}
		return name;
	}

	@GET
	@Path("{Param1}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUnique(@PathParam("Param1") String username) {
		String name;
		CheckEmail sa = new CheckEmail();
		boolean flag = sa.viewdata(username);
		LOGGER.info("returnd : " + flag);
		if (flag == false) {
			name = username;

		} else {
			name = "Email Already Exists";
		}
		return name;
	}
                    
	    /*===========ending of registration==============*/
	
	
	@GET
	@Path("/selectVpc")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectVpc() {

		LOGGER.info("Rest.. Select");
		List<Vpc_pozo> customers = new ArrayList<Vpc_pozo>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectVpc();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	
	@POST
	@Path("/storeVpc")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postVpc(String msg) {
		LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		Vpc_pozo user = null;
		try {
			user = mapper.readValue(msg, Vpc_pozo.class);
			userDAO s = new userDAO();
			s.viewVpc(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GET
	@Path("/deleteData/{data}")
	public void deleteData(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteData(data);
	}
	           
	          /*UPDATE VPC DATA*/
	   
	 /*=====================pending ?????????==========================*/

        /*==================ending of vpc=================*/
	

	
	@GET
	@Path("/selectSubnet")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectSubnet() {

		LOGGER.info("Rest.. Select");
		List<Subnet> customers = new ArrayList<Subnet>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectSubnet();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeSubnet")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postSubnet(String msg) {
		LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		Subnet user = null;
		try {
			user = mapper.readValue(msg, Subnet.class);
			userDAO s = new userDAO();
			s.viewSubnet(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteSubnet/{data}")
	public void deleteSubnet(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteSubnet(data);
	}

	
	                    /*==================ending of subnet===================*/
	
/*================scaling and recovery starts===================*/
	

	@GET
	@Path("/selectSAR")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectSAR() {

		LOGGER.info("Rest.. Select");
		List<ScalingAndRecovery> customers = new ArrayList<ScalingAndRecovery>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectSAR();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeSAR")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postSAR(String msg) {
		LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		ScalingAndRecovery user = null;
		try {
			user = mapper.readValue(msg, ScalingAndRecovery.class);
			userDAO s = new userDAO();
			s.viewSAR(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteSAR/{data}")
	public void deleteSAR(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteSAR(data);
	}
	          /*============END================*/
	
/*================HOST SCALING POLICY===================*/
	

	@GET
	@Path("/selectHSP")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectHSP() {

		LOGGER.info("Rest.. Select");
		List<HostScalingPolicy> customers = new ArrayList<HostScalingPolicy>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectHSP();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeHSP")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postHSP(String msg) {
		LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		HostScalingPolicy user = null;
		try {
			user = mapper.readValue(msg, HostScalingPolicy.class);
			userDAO s = new userDAO();
			s.viewHSP(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteHSP/{data}")
	public void deleteHSP(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteHSP(data);
	}
	          /*============END================*/
	
	
	
/*================SERVICE AFFINITY STARTS===================*/
	

	@GET
	@Path("/selectServiceAffinities")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectServiceAffinities() {

		LOGGER.info("Rest.. Select");
		List<ServiceAffinities> customers = new ArrayList<ServiceAffinities>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectServiceAffinities();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeServiceAffinities")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postServiceAffinities(String msg) {
		LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		ServiceAffinities user = null;
		try {
			user = mapper.readValue(msg, ServiceAffinities.class);
			userDAO s = new userDAO();
			s.viewServiceAffinities(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteServiceAffinities/{data}")
	public void deleteServiceAffinities(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteServiceAffinities(data);
	}
	          /*============END================*/
	
	
	
	
/*================RESOURCE SELECTION STARTS===================*/
	

	@GET
	@Path("/selectResourceSelection")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectResourceSelection() {

		LOGGER.info("Rest.. Select");
		List<ResourceSelection> customers = new ArrayList<ResourceSelection>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectResourceSelection();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeResourceSelection")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postResourceSelection(String msg) {
		//LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		ResourceSelection user = null;
		try {
			user = mapper.readValue(msg, ResourceSelection.class);
			userDAO s = new userDAO();
			s.viewResourceSelection(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteResourceSelection/{data}")
	public void deleteResourceSelection(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteResourceSelection(data);
	}
	          /*============END================*/
	
	
	
/*================CONTAINER TYPES STARTS===================*/

	@GET
	@Path("/selectContainerTypes")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectContainerTypes() {

		LOGGER.info("Rest.. Select");
		List<ContainerTypes> customers = new ArrayList<ContainerTypes>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectContainerTypes();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeContainerTypes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postContainerTypes(String msg) {
		//LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		ContainerTypes user = null;
		try {
			user = mapper.readValue(msg, ContainerTypes.class);
			userDAO s = new userDAO();
			s.viewContainerTypes(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteContainerTypes/{data}")
	public void deleteContainerTypes(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteContainerTypes(data);
	}
	          /*============END================*/
	
	
	/*================CLOUD PROVIDRTS STARTS===================*/

	@GET
	@Path("/selectCloudProviders")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectCloudProviders() {

		LOGGER.info("Rest.. Select");
		List<CloudProviders> customers = new ArrayList<CloudProviders>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectCloudProviders();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeCloudProviders")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCloudProviders(String msg) {
		//LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		CloudProviders user = null;
		try {
			user = mapper.readValue(msg, CloudProviders.class);
			userDAO s = new userDAO();
			s.viewCloudProviders(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteCloudProviders/{data}")
	public void deleteCloudProviders(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteCloudProviders(data);
	}
	          /*============END================*/
	
	
	/*================IMAGE REGISTRY STARTS===================*/

	@GET
	@Path("/selectImageRegistry")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectImageRegistry() {

		LOGGER.info("Rest.. Select");
		List<ImageRegistry> customers = new ArrayList<ImageRegistry>();

		userDAO customerDao = new userDAO();
		customers = customerDao.selectImageRegistry();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeImageRegistry")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postImageRegistry(String msg) {
		//LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		ImageRegistry user = null;
		try {
			user = mapper.readValue(msg, ImageRegistry.class);
			userDAO s = new userDAO();
			s.viewImageRegistry(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteImageRegistry/{data}")
	public void deleteImageRegistry(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteImageRegistry(data);
	}
	          /*============END================*/
	
	
	/*================ENVIRONMENT TYPES STARTS===================*/

	@GET
	@Path("/selectEnvironmentTypes")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectEnvironmentTypes() {

		LOGGER.info("Rest.. Select");
		List<EnvironmentTypes> customers = new ArrayList<EnvironmentTypes>();
           
		userDAO customerDao = new userDAO();
		customers = customerDao.selectEnvironmentTypes();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeEnvironmentTypes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postEnvironmentTypes(String msg) {
		//LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		EnvironmentTypes user = null;
		try {
			user = mapper.readValue(msg, EnvironmentTypes.class);
			userDAO s = new userDAO();
			s.viewEnvironmentTypes(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteEnvironmentTypes/{data}")
	public void deleteEnvironmentTypes(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteEnvironmentTypes(data);
	}
	          /*============END================*/
	

	
	/*================FIREWALL OUTBOUNDS STARTS===================*/

	@GET
	@Path("/selectFirewallOutbounds")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectFirewallOutbounds() {

		LOGGER.info("Rest.. Select");
		List<FirewallOutbounds> customers = new ArrayList<FirewallOutbounds>();
           
		userDAO customerDao = new userDAO();
		customers = customerDao.selectFirewallOutbounds();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeFirewallOutbounds")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postFirewallOutbounds(String msg) {
		//LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		FirewallOutbounds user = null;
		try {
			user = mapper.readValue(msg, FirewallOutbounds.class);
			userDAO s = new userDAO();
			s.viewFirewallOutbounds(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteFirewallOutbounds/{data}")
	public void deleteFirewallOutbounds(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteFirewallOutbounds(data);
	}
	          /*============END================*/
	
	
	/*================FIREWALL INBOUNDS STARTS===================*/

	@GET
	@Path("/selectFirewallInbounds")
	@Produces(MediaType.APPLICATION_JSON)
	public String selectFirewallInbounds() {

		LOGGER.info("Rest.. Select");
		List<FirewallInbounds> customers = new ArrayList<FirewallInbounds>();
           
		userDAO customerDao = new userDAO();
		customers = customerDao.selectFirewallInbounds();
		LOGGER.info(customers);
		Gson gson = new Gson();
		String customersList = gson.toJson(customers);
		LOGGER.info("jsonCartList: " + customersList);
		return customersList;

	}
	
	@POST
	@Path("/storeFirewallInbounds")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postFirewallInbounds(String msg) {
		//LOGGER.info("hello...");
		ObjectMapper mapper = new ObjectMapper();

		LOGGER.info(msg);
		FirewallInbounds user = null;
		try {
			user = mapper.readValue(msg, FirewallInbounds.class);
			userDAO s = new userDAO();
			s.viewFirewallInbounds(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/deleteFirewallInbounds/{data}")
	public void deleteFirewallInbounds(@PathParam("data") String data) {
		
		userDAO customerDao = new userDAO();
		customerDao.deleteFirewallInbounds(data);
	}
	          /*============END================*/
	
	
	
	
}