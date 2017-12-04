package com.paas_gui.register;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.paas_gui.dbconnection.DBConnection;
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

public class userDAO {
	
	             /*SIGN UP*/          
	
	final Logger LOGGER=Logger.getLogger(userDAO.class);
	private static final String INSERTSQL = "INSERT INTO register VALUES(?,?,?,?)";
	public static Logger log=Logger.getLogger(userDAO.class);
	
	public boolean viewdata(Employee user) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement(INSERTSQL);
			pstmt.setString(1, user.getCompany_name());
			pstmt.setString(2, user.getCompany_address());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	
	              /*VPC PAGE*/ 
	
public List<Vpc_pozo> selectVpc() {
		
		List<Vpc_pozo> customers = new LinkedList<Vpc_pozo>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "select * from vpc";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			Vpc_pozo customer = null;
			while(resultSet.next()) {
				
				customer = new Vpc_pozo();
				customer.setVpc_name(resultSet.getString(1));
				customer.setVpc_region(resultSet.getString(2));
				customer.setCidr(resultSet.getString(3));
				customer.setAcl(resultSet.getString(4));
				
				customers.add(customer);
			}
			
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.error(e.getMessage());
			}
		}
		
		return customers;
	}
	
	public boolean viewVpc(Vpc_pozo user) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO vpc VALUES(?,?,?,?)");
			pstmt.setString(1, user.getVpc_name());
			pstmt.setString(2, user.getVpc_region());
			pstmt.setString(3, user.getCidr());
			pstmt.setString(4, user.getAcl());
			pstmt.executeUpdate();
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	
	
public void deleteData(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from vpc where vpc_name = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}

        /*======================end of vpc DAO==========================*/

   
/*======subnet starts=======*/

public List<Subnet> selectSubnet() {
	
	List<Subnet> customers = new ArrayList<Subnet>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from subnet";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		Subnet customer = null;
		while(resultSet.next()) {
			
			customer = new Subnet();
			customer.setVpc_name(resultSet.getString(1));
			customer.setSubnet_name(resultSet.getString(2));
			customer.setCidr(resultSet.getString(3));
			customer.setAcl(resultSet.getString(4));
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewSubnet(Subnet subnet) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO subnet VALUES(?,?,?,?)");
			pstmt.setString(1, subnet.getVpc_name());
			pstmt.setString(2, subnet.getSubnet_name());
			pstmt.setString(3, subnet.getCidr());
			pstmt.setString(4, subnet.getAcl());
			pstmt.executeUpdate();
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteSubnet(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from subnet where subnet_name = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}
	
	                  /*=====================END OF SUBNET========================*/
/*==============scaling and recovery starts================*/

public List<ScalingAndRecovery> selectSAR() {
	
	List<ScalingAndRecovery> customers = new ArrayList<ScalingAndRecovery>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from scaling_and_recovery";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ScalingAndRecovery customer = null;
		while(resultSet.next()) {
			
			customer = new ScalingAndRecovery();
			customer.setApplication(resultSet.getString(1));
			customer.setServices(resultSet.getString(2));
			customer.setEnvironment_types(resultSet.getString(3));
			customer.setDesired_count(resultSet.getString(4));
			customer.setAuto_recovery(resultSet.getString(5));
			
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewSAR(ScalingAndRecovery sar) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO scaling_and_recovery VALUES(?,?,?,?,?)");
			pstmt.setString(1, sar.getApplication());
			pstmt.setString(2, sar.getServices());
			pstmt.setString(3, sar.getEnvironment_types());
			pstmt.setString(4, sar.getDesired_count());
			pstmt.setString(5, sar.getAuto_recovery());
			pstmt.executeUpdate();
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteSAR(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from scaling_and_recovery where application = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}
                      /*=======end=======*/


/*================HOST SCALING POLICY STARTS==================*/

public List<HostScalingPolicy> selectHSP() {
	
	List<HostScalingPolicy> customers = new ArrayList<HostScalingPolicy>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from host_scaling_policy";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		HostScalingPolicy customer = null;
		while(resultSet.next()) {
			
			customer = new HostScalingPolicy();
			customer.setName(resultSet.getString(1));
			customer.setHost_groups(resultSet.getString(2));
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewHSP(HostScalingPolicy hsp) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO host_scaling_policy VALUES(?,?)");
			pstmt.setString(1, hsp.getName());
			pstmt.setString(2, hsp.getHost_groups());
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteHSP(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from host_scaling_policy where name = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}

      /*============END=================*/



/*================SERVICE AFFINITIES STARTS==================*/

public List<ServiceAffinities> selectServiceAffinities() {
	
	List<ServiceAffinities> customers = new ArrayList<ServiceAffinities>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from service_affinities";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ServiceAffinities customer = null;
		while(resultSet.next()) {
			
			customer = new ServiceAffinities();
			customer.setApplication(resultSet.getString(1));
			customer.setServices(resultSet.getString(2));
			customer.setEnvironment_types(resultSet.getString(3));
			customer.setAffinity(resultSet.getString(4));
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewServiceAffinities(ServiceAffinities sa) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO service_affinities VALUES(?,?,?,?)");
			pstmt.setString(1, sa.getApplication());
			pstmt.setString(2, sa.getServices());
			pstmt.setString(3, sa.getEnvironment_types());
			pstmt.setString(4, sa.getAffinity());
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteServiceAffinities(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from service_affinities where application = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}
  
       /*============SERVICE AFFINITY ENDS=================*/



/*================RESOURCE SELECTION STARTS==================*/

public List<ResourceSelection> selectResourceSelection() {
	
	List<ResourceSelection> customers = new ArrayList<ResourceSelection>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from resource_selection";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ResourceSelection customer = null;
		while(resultSet.next()) {
			
			customer = new ResourceSelection();
			
			customer.setRank(resultSet.getString(1));
			customer.setName(resultSet.getString(2));
			customer.setContainer_types(resultSet.getString(3));
			customer.setEnvironment_types(resultSet.getString(4));
			customer.setHost_groups(resultSet.getString(5));
			customer.setPlacement(resultSet.getString(6));
			customer.setMinimum(resultSet.getString(7));
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewResourceSelection(ResourceSelection rs) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO resource_selection VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, rs.getRank());
			pstmt.setString(2, rs.getName());
			pstmt.setString(3, rs.getContainer_types());
			pstmt.setString(4, rs.getEnvironment_types());
			pstmt.setString(5, rs.getHost_groups());
			pstmt.setString(6, rs.getPlacement());
			pstmt.setString(7, rs.getMinimum());
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteResourceSelection(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from resource_selection where rank = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}              
/*============ENDS=================*/


/*================CONTAINER TYPES STARTS==================*/

public List<ContainerTypes> selectContainerTypes() {
	
	List<ContainerTypes> customers = new ArrayList<ContainerTypes>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from container_types";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ContainerTypes customer = null;
		while(resultSet.next()) {
			
			customer = new ContainerTypes();
			
			customer.setName(resultSet.getString(1));
			customer.setCpu_shares(resultSet.getInt(2));
			customer.setMemory(resultSet.getInt(3));
			customer.setDescription(resultSet.getString(4));
			
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewContainerTypes(ContainerTypes ct) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO container_types VALUES(?,?,?,?)");
			pstmt.setString(1, ct.getName());
			pstmt.setInt(2, ct.getCpu_shares());
			pstmt.setInt(3, ct.getMemory());
			pstmt.setString(4, ct.getDescription());
			
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteContainerTypes(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from container_types where name = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}              
/*============ENDS=================*/


/*================CLOUD PROVIDERS STARTS==================*/

public List<CloudProviders> selectCloudProviders() {
	
	List<CloudProviders> customers = new ArrayList<CloudProviders>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from cloud_providers";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		CloudProviders customer = null;
		while(resultSet.next()) {
			
			customer = new CloudProviders();
			
			customer.setName(resultSet.getString(1));
			customer.setType(resultSet.getString(2));
			customer.setPrivate_cloud(resultSet.getString(3));
			customer.setDescription(resultSet.getString(4));
			customer.setDefault_region(resultSet.getString(5));
			customer.setAccount_id(resultSet.getInt(6));
			customer.setExternal_id(resultSet.getString(7));
			customer.setRole_arn(resultSet.getString(8));
			
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewCloudProviders(CloudProviders cp) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO cloud_providers VALUES(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, cp.getName());
			pstmt.setString(2, cp.getType());
			pstmt.setString(3, cp.getPrivate_cloud());
			pstmt.setString(4, cp.getDescription());
			pstmt.setString(5, cp.getDefault_region());
			pstmt.setInt(6, cp.getAccount_id());
			pstmt.setString(7, cp.getExternal_id());
			pstmt.setString(8, cp.getRole_arn());
			
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteCloudProviders(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from cloud_providers where name = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}              
/*============ENDS=================*/


/*================IMAGE REGISTRY STARTS==================*/

public List<ImageRegistry> selectImageRegistry() {
	
	List<ImageRegistry> customers = new ArrayList<ImageRegistry>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from image_registry";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ImageRegistry customer = null;
		while(resultSet.next()) {
			
			customer = new ImageRegistry();
			
			customer.setName(resultSet.getString(1));
			customer.setLocation(resultSet.getString(2));
			customer.setVersion(resultSet.getString(3));
			customer.setPrivate_cloud(resultSet.getString(4));
			customer.setUser_name(resultSet.getString(5));
			customer.setPassword(resultSet.getString(6));
			
			
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewImageRegistry(ImageRegistry imgreg) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO image_registry VALUES(?,?,?,?,?,?)");
			pstmt.setString(1, imgreg.getName());
			pstmt.setString(2, imgreg.getLocation());
			pstmt.setString(3, imgreg.getVersion());
			pstmt.setString(4, imgreg.getPrivate_cloud());
			pstmt.setString(5, imgreg.getUser_name());
			pstmt.setString(6, imgreg.getPassword());
			
			
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteImageRegistry(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from image_registry where name = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}              
/*============ENDS=================*/




/*================ENVIROMENT TYPES STARTS==================*/

public List<EnvironmentTypes> selectEnvironmentTypes() {
	
	List<EnvironmentTypes> customers = new ArrayList<EnvironmentTypes>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from environment_types";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		EnvironmentTypes customer = null;
		while(resultSet.next()) {
			
			customer = new EnvironmentTypes();
			
			customer.setName(resultSet.getString(1));
			customer.setDescription(resultSet.getString(2));
			customer.setAccept_tag(resultSet.getString(3));
			customer.setPromote_tag(resultSet.getString(4));
			customer.setAction(resultSet.getString(5));
			customer.setRestart_interval(resultSet.getInt(6));
			customer.setQuiet_period(resultSet.getInt(7));
			
			
			
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewEnvironmentTypes(EnvironmentTypes envtypes) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO environment_types VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, envtypes.getName());
			pstmt.setString(2, envtypes.getDescription());
			pstmt.setString(3, envtypes.getAccept_tag());
			pstmt.setString(4, envtypes.getPromote_tag());
			pstmt.setString(5, envtypes.getAction());
			pstmt.setInt(6, envtypes.getRestart_interval());
			pstmt.setInt(7, envtypes.getQuiet_period());
	
			
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteEnvironmentTypes(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from environment_types where name = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}              
/*============ENDS=================*/


/*================FIREWALL OUTBOUNDS STARTS==================*/

public List<FirewallOutbounds> selectFirewallOutbounds() {
	
	List<FirewallOutbounds> customers = new ArrayList<FirewallOutbounds>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from firewall_outbounds";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		FirewallOutbounds customer = null;
		while(resultSet.next()) {
			
			customer = new FirewallOutbounds();
			
			customer.setOut_type(resultSet.getString(1));
			customer.setOut_protocol(resultSet.getString(2));
			customer.setOut_portrange(resultSet.getString(3));
			customer.setOut_source(resultSet.getString(4));
			customer.setOut_ip(resultSet.getString(5));
			
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewFirewallOutbounds(FirewallOutbounds fwlout) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO firewall_outbounds VALUES(?,?,?,?,?)");
			pstmt.setString(1, fwlout.getOut_type());
			pstmt.setString(2, fwlout.getOut_protocol());
			pstmt.setString(3, fwlout.getOut_portrange());
			pstmt.setString(4, fwlout.getOut_source());
			pstmt.setString(5, fwlout.getOut_ip());
	
			
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteFirewallOutbounds(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from firewall_outbounds where out_type = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}              
/*============ENDS=================*/


/*================FIREWALL INBOUNDS STARTS==================*/

public List<FirewallInbounds> selectFirewallInbounds() {
	
	List<FirewallInbounds> customers = new ArrayList<FirewallInbounds>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = (Connection) DBConnection.getConnection();
		String sql = "select * from firewall_inbounds";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		FirewallInbounds customer = null;
		while(resultSet.next()) {
			
			customer = new FirewallInbounds();
			
			customer.setIn_type(resultSet.getString(1));
			customer.setIn_protocol(resultSet.getString(2));
			customer.setIn_portrange(resultSet.getString(3));
			customer.setIn_source(resultSet.getString(4));
			customer.setIn_ip(resultSet.getString(5));
			
			
			customers.add(customer);
		}
		
		
	} catch (SQLException e) {
		LOGGER.error(e.getMessage());
		
	} finally {
		try {
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	return customers;
}


	public boolean viewFirewallInbounds(FirewallInbounds fwlin) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = (Connection) DBConnection.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO firewall_inbounds VALUES(?,?,?,?,?)");
			pstmt.setString(1, fwlin.getIn_type());
			pstmt.setString(2, fwlin.getIn_protocol());
			pstmt.setString(3, fwlin.getIn_portrange());
			pstmt.setString(4, fwlin.getIn_source());
			pstmt.setString(5, fwlin.getIn_ip());
	
			
			
			pstmt.executeUpdate();
			
			LOGGER.info("Data Inserted");
		} catch (SQLException sqlexp) {
			log.error(sqlexp.getMessage());
		}
		return true;
	}
	

public void deleteFirewallInbounds(String data) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = (Connection) DBConnection.getConnection();
			String sql = "delete from firewall_inbounds where in_type = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.executeUpdate();
			
		} catch(SQLException se) {
			LOGGER.error(se.getMessage());
		}
		
	}              
/*============ENDS=================*/


	
}
