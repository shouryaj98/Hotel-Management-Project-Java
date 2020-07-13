package project;

import java.io.Serializable;

public class Guest implements Serializable{
	String name;
    String contact;
    String gender;
    
    
	public Guest(String name, String contact, String gender) {
		this.name = name;
		this.contact = contact;
		this.gender = gender;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
    
    
}