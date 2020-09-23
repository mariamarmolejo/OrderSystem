package model;
import model.Product;
import java.io.*;
import java.util.*;

public class Order{
	
	private int code;
	private int date;
	private int hour;
	private int clientCode;
	private int nit;
	private Boolean state;
	private List<Product> productsOr;
	
	public Order(int code, int date, int hour, int clientCode, int nit, Boolean state, List<Product> productsOr) {
		this.code = code;
		this.date = date;
		this.hour = hour;
		this.clientCode = clientCode;
		this.nit = nit;
		this.state = state;
		this.productsOr = new ArrayList<Product>();
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getClientCode() {
		return clientCode;
	}
	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public List<Product> getProductsOr() {
		return productsOr;
	}
	public void setProducts(List<Product> productsOr) {
		this.productsOr = productsOr;
	}
	
	
}
