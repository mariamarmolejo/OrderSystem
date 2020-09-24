package model;
import java.io.*;

public class Product{
	private int code;
	private String name;
	private String description;
	private int nit;
	private double price;
	
	public Product(int code, String name, String description, int nit, double price) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.nit = nit;
		this.price = price;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
