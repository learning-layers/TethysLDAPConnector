package de.dbis.acis.cloud.TethysLDAPConnector.entity;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MountJsonObject {

	private Map<String,Map<String,MountJsonBackendSwift>> user;
	private Map<String,Map<String,MountJsonBackendSwift>> group;

	public MountJsonObject() {
		super();
	}

	public Map<String, Map<String, MountJsonBackendSwift>> getUser() {
		return user;
	}

	public void setUser(Map<String, Map<String, MountJsonBackendSwift>> user) {
		this.user = user;
	}

	public Map<String, Map<String, MountJsonBackendSwift>> getGroup() {
		return group;
	}

	public void setGroup(Map<String, Map<String, MountJsonBackendSwift>> group) {
		this.group = group;
	}
	
	//TODO: BAD CODING BUT QUICK!
	public static Map<String, MountJsonBackendSwift> getTemplate(String id) {
		Gson gson = new GsonBuilder().create();
		Map<String,MountJsonBackendSwift> template = new HashMap<String,MountJsonBackendSwift>();
		MountJsonBackendSwift backendData = gson.fromJson(
				"{"
                +	"\"class\": \"\\\\OC\\\\Files\\\\Storage\\\\Swift\","
                +	"\"options\": {"
                +   		"\"user\": \"swift\","
                +   		"\"bucket\": \""+id+"\","
                +   		"\"region\": \"RegionOne\","
                +			"\"key\": \"\","
                +   		"\"tenant\": \"service\","
                +   		"\"password\": \"\","
                +   		"\"service_name\": \"swift\","
                +   		"\"url\": \"http:\\/\\/137.226.58.2:5000\\/v2.0\","
                +			"\"timeout\": \"\","
                +   		"\"password_encrypted\": \"MmUxMzI1OGU4ZDIzYWI1NwO8yXu6uIq727WmFFyugM4=\""
				+		"},"
				+	"\"priority\": 100"
				+"}"	
				, MountJsonBackendSwift.class);
		template.put("/$user/files", backendData);
		return template;
	}
	
}
