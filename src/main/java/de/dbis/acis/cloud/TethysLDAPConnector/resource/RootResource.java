package de.dbis.acis.cloud.TethysLDAPConnector.resource;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


/**
 *
 * 
 * @author Gordon Lawrenz <lawrenz@dbis.rwth-aachen.de>
 */
@Path("/")
public class RootResource {

//	curl -X POST http://137.226.58.11:8081/i5Cloud/users -H 'X-Auth-Token: 88a6923e7a8f45bab034a7aacd191120' -H 'Content-Type: application/json' -d '{"name":"1","password":"1"}'
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("mount.json")
	public Response getMountJson(@HeaderParam("pw") String pw) {
		Response r = null;
		
		if(pw.equals("useanotherpw")){
			try(Reader reader = new InputStreamReader(new FileInputStream("/var/www/owncloud6/data/mount.json"))){
	            Gson gson = new GsonBuilder().create();
	            //MountObject mountJson = gson.fromJson(reader, MountObject.class);
	            JsonObject mountJson = gson.fromJson(reader, JsonObject.class);
	            r = Response.ok(mountJson).build();
	        } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return r;
	}
	
	@GET
	public String test(){
		return "TEST";
	}
}