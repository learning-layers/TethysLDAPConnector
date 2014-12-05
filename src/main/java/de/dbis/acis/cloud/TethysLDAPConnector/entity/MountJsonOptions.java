package de.dbis.acis.cloud.TethysLDAPConnector.entity;

public class MountJsonOptions {

	private String user;
	private String bucket;
	private String region;
	private String key;
	private String tenant;
	private String password; 
	private String service_name;
	private String url;
	private String timeout;
	private String password_encrypted; // ZGU2Zjg3MGVjMWQxNjRmYqOhF2EcEtl3Wij0ASyhEXQ=    NOT GOOD CODE!
	
	public MountJsonOptions() {
		super();
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getBucket() {
		return bucket;
	}
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	public String getPassword_encrypted() {
		return password_encrypted;
	}
	public void setPassword_encrypted(String password_encrypted) {
		this.password_encrypted = password_encrypted;
	}
	
}
