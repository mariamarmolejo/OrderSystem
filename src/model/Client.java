package model;
import java.io.*;
import java.util.Comparator;
import java.lang.Comparable.*;

public class Client implements Serializable , Comparable<Client>{
	
	public static final String CEDULA_CIUDADANIA = "CC";
	public static final String CEDULA_EXTRANJERIA = "CE";
	public static final String TARJETA_IDENTIDAD = "TI";
	public static final String PASAPORTE = "PP";
	private String name;
	private String lastName;
	private String type;
	private String address;
	private int id;
	private int phone;
	
	public Client(String name, String lastName, String type, String address, int id, int phone) {
		this.name = name;
		this.lastName = lastName;
		this.type = type;
		this.address = address;
		this.id = id;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public int compareTo(Client cl) {
		int comp;
		if(phone < cl.getPhone()) {
			comp = 1;
		}else if(phone > cl.getPhone()) {
			comp = -1;
		}else {
			comp = 0;
		}
		return comp;
	}
	
}
