package de.dbis.acis.cloud.TethysLDAPConnector.resource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * 
 * @author Gordon Lawrenz <lawrenz@dbis.rwth-aachen.de>
 */
@Path("/")
public class RootResource {


	@GET
	public String test(){
		return "This Web Application helps making Tethys and Owncloud useable with LDAP users./n";
	}
}
