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
	public final static String SAVE_PATH_FILE_CLIENT = "data/client.txt";
	public final static String SAVE_PATH_FILE_RESTAURANT = "data/restaurant.txt";
	public final static String SAVE_PATH_FILE_PRODUCT = "data/product.txt";
	public final static String SAVE_PATH_FILE_ORDER = "data/order.csv";
	
	public void saveData() throws IOException{
	    ObjectOutputStream file_client = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_CLIENT));
	    ObjectOutputStream file_product = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PRODUCT));
	    ObjectOutputStream file_restaurant = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_RESTAURANT));
	    ObjectOutputStream file_order = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_ORDER));
	    file_client.writeObject(clients);
	    file_product.writeObject(products);
	    file_restaurant.writeObject(restaurants);
	    file_order.writeObject(orders);
	    file_client.close();
	    file_product.close();
	    file_restaurant.close();
	    file_order.close();
	 }

	
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
	
	public void addProduct(int code, String name, String description, int nit, double price) {
		Product pr = new Product(code,name,description,nit,price);
		products.add(pr);
	}
	
	public void addRestaurant(String name, int nit, String admin) throws IOException {
		Restaurant re = new Restaurant(name, nit, admin);
		restaurants.add(re);
		saveData();
	}
	
	public void addOrder(int code, int date, int hour, int clientCode, int nit, Boolean state, List<Product> productsOr) {
		Order or = new Order(code, date, hour, clientCode, nit, state, productsOr);
		orders.add(or);
	}
	
	public void addClient(String name, String lastname, String type, String address, int id, int phone) throws IOException{
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
			saveData();
		 }
	
	public String toStringClients() {
		String m;
		m  = "========================================\n";
		m += "                  CLIENTS\n";
		m += "========================================\n";
		for (int i = 0; i < clients.size(); i++) {
			m += "NAME:"+clients.get(i).getLastName() +" "+ clients.get(i).getName()+ "\n"
					+"ADDRESS:"+clients.get(i).getAddress()+ "\n"
					+"PHONE:"+clients.get(i).getPhone()+ "\n"
					+clients.get(i).getType()+": "+clients.get(i).getId()+ "\n"
					+ "----------------------------------------\n";
		 }
		
		return m;
	}

	public String toStringProducts() {
		String m;
		m  = "========================================\n";
		m += "                  PRODUCTS\n";
		m += "========================================\n";
		for (int i = 0; i < products.size(); i++) {
			m += products.get(i).getName() + ": " + products.get(i).getPrice()  + "\n";
		 }
		
		return m;
	}
	
	public String toStringRestaurants() {
		String m;
		m  = "========================================\n";
		m += "                  RESTAURANTS\n";
		m += "========================================\n";
		for (int i = 0; i < restaurants.size(); i++) {
			m += restaurants.get(i).getName() + " by: " + restaurants.get(i).getAdmin()  + "\n";
			m += "NIT:"+restaurants.get(i).getNit()+"\n";
			m += "----------------------------------------\n";
		 }
		
		return m;
	}
	
	public void sortByNameRestaurant() {
		NameComparator nc = new NameComparator();
		Collections.sort(restaurants,nc);
	}
	
	public void sortByPhoneClient() {
		Collections.sort(clients);
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
/*	public void sortByName() {
NameComparator nc = new NameComparator();
Collections.sort(clients,nc);
}
*/