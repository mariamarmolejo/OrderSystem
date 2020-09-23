package model;
import java.io.*;

public class Restaurant{
	
	private String name;
	private int nit;
	private String admin;
	
	public Restaurant(String name, int nit, String admin) {
		this.name = name;
		this.nit = nit;
		this.admin = admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
}
