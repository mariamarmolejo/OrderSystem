package model;
import java.util.*;
import java.io.*;
import  model.*;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Comparable;

public class OrderSystem implements Serializable {
	public final static long serialVersionUID = 1;
	public ArrayList<Order> orders;
	public ArrayList<Product> products;
	public ArrayList<Client> clients;
	public ArrayList<Restaurant> restaurants;
	
	public OrderSystem(){
		this.products = new ArrayList<Product>();
		this.clients = new ArrayList<Client>();
		this.restaurants = new ArrayList<Restaurant>();
		this.orders = new ArrayList<Order>();
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(ArrayList<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	public void addProduct(int code, String name, String description, int nit, int price) {
		Product pr = new Product(code,name,description,nit,price);
		products.add(pr);
	}
	
	public void addRestaurant(String name, int nit, String admin) {
		Restaurant re = new Restaurant(name, nit, admin);
		restaurants.add(re);
	}
	
/*	public void sortByName() {
		NameComparator nc = new NameComparator();
		Collections.sort(clients,nc);
	}
	*/
	public void addClient(String name, String lastname, String type, String address, int id, int phone){
		  	Client c = new Client (name, lastname, type, address, id, phone);
			if(clients.isEmpty()){
		 		clients.add(c);
		  	}else{
		  		int i = 0;
		 		while(i<clients.size() && clients.get(i).getLastName().compareTo(c.getLastName())>0){
		  			i++;
		 		}
		 		while(i<clients.size() && clients.get(i).getName().compareTo(c.getName())>0){
		  			i++;
		 		}
		 		((ArrayList<Client>)clients).add(i,c);
		 	}
		 }
	
	public String toStringClients() {
		String m;
		m  = "========================================\n";
		m += "                  CLIENTS\n";
		m += "========================================\n";
		for (int i = 0; i < clients.size(); i++) {
			m += clients.get(i).getLastName() +" "+ clients.get(i).getName()+", "+clients.get(i).getAddress()+", "+
					clients.get(i).getPhone()+", "+
					clients.get(i).getType()+": "+
					clients.get(i).getId()+ "\n";
		 }
		
		return m;
	}
	
	public String toStringRestaurants() {
		String m;
		m  = "========================================\n";
		m += "                  RESTAURANTS\n";
		m += "========================================\n";
		for (int i = 0; i < clients.size(); i++) {
			m += clients.get(i).getLastName() + " " + clients.get(i).getName()  + "\n";
		 }
		
		return m;
	}
}
/*	 public void ordenar() {
	        for (int j = 0; j < 4; j++) {
	            for (int i = 0; i < 4 - j; i++) {
	                if (clients.get(i).compareTo(clients.get(i+1)) > 0) {
	                    String aux; 
	                    aux = clients.get(i);
	                    clients.get(i) = clients.get(i+1);
	                    clients.get(i+1) = aux;
	                }
	            }
	        }
	    }
	
	public void addOrder(int code, int date, int hour, int clientCode, int nit, Boolean state, List<Product> productsOr) {
		Order or = new Order(code, date, hour, clientCode, nit, state, productsOr);
		orders.add(or);
	}
	
	
}
/*
 * public void addClient(String name, String type, String address, int id, int phone){
 * 		Client c = new Client (name, type, address, id, phone);
 * 		if(clients.isEmpty()){
 * 			clients.add(c);
 * 		}else{
 * 			int i = 0;
 * 			while(c.getName()<clients.get(i).getName()){
 * 				i++;
 * 			}
 * 			clients.add(i,c);
 * 		}
 * } 
 */
