package com.neogrid.simulator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	
	public User(String id, String ip, String name, String mail) {
		this.id = id;
		this.ip = ip;
		this.name = name;
		this.mail = mail;
	}
	
	@Id
	private String id;

	@Indexed
	private String ip;
	
	private String name;
	
	private String mail;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ip=" + ip + ", name=" + name + ", mail=" + mail + "]";
	}
}
