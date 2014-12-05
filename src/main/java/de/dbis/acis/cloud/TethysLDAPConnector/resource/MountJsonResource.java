package de.dbis.acis.cloud.TethysLDAPConnector.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import de.dbis.acis.cloud.TethysLDAPConnector.entity.MountJsonObject;

@Path("/mount.json")
@Api(value="/mount.json", description = "Operations about the connection between Owncloud and Tethys")
public class MountJsonResource {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
//	curl -X POST http://137.226.58.11:8081/i5Cloud/users -H 'X-Auth-Token: 88a6923e7a8f45bab034a7aacd191120' -H 'Content-Type: application/json' -d '{"name":"1","password":"1"}'
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Returns the json contained in mount.json of owncloud")
	@ApiResponses( {
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 204, message = "NO CONTENT"),
		@ApiResponse(code = 500, message = "Please check Permission rights of mount.json")
	} )
	public Response getMountJson(@HeaderParam("pw") String pw) {
		Response r = null;
		if(pw!= null && pw.equals("useanotherpw")){
			MountJsonObject mountJson = this.readMountJson();  
			r = Response.ok(mountJson).build();
		}
		return r;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@ApiOperation(value="Adds entry to mount.json for a new user and so connects the user to swift")
	@ApiResponses( {
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 204, message = "NO CONTENT"),
		@ApiResponse(code = 500, message = "Please check Permission rights of mount.json")
	} )
	public Response connectLDAPUsertoSwift(@HeaderParam("pw") String pw, @PathParam("id") String id){
		Response r = null;
		if(pw!= null && pw.equals("useanotherpw")){
			MountJsonObject mountJson = this.readMountJson();
			mountJson.getUser().put(id, MountJsonObject.getTemplate(id));
			this.writeToMountJson(gson.toJson(mountJson));
			r = Response.ok(mountJson).build();
		}
		return r;
	}
	
	private MountJsonObject readMountJson(){
		Reader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream("/var/www/owncloud/data/mount.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return gson.fromJson(reader, MountJsonObject.class);
	}
	
	private void writeToMountJson(String string){
		Writer writer;
		try {
			writer = new OutputStreamWriter(new FileOutputStream("/var/www/owncloud/data/mount.json"));
			writer.write(string);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
