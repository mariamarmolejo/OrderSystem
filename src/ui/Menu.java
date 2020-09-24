package ui;
import model.OrderSystem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.IOException;

public class Menu {
	private OrderSystem conection = new OrderSystem();
	private BufferedReader br;
	private BufferedWriter bw;
	private final static int EXIT_OPTION = 5;
	public Menu(){
		
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	//Start the principal module
	public void startMenuPrincipal() throws IOException {
		
		String menu = getMenuPrincipal();
		int option;
		do {
			System.out.println(menu);
			option = readOption();
			executeOperation(option);
		}while(option!=EXIT_OPTION);
		
		bw.close();
		br.close();
		
	}
	
	//Print principal module
	private String getMenuPrincipal() {
		String menu; 
		menu =  "========================================\n";
		menu += "                Order System            \n";
		menu += "========================================\n";
		menu += "1. Registration module.\n";
		menu += "2. Update module. \n";
		menu += "3. Display module. \n";
		menu += "4. Search client\n";
		menu += "5. Exit\n";
		menu += "========================================\n";
		menu += "Please enter de option\n";
		menu += "========================================\n";
		return menu;
	}
	
	//Print registration module
	private String getMenuRegistration() {
		String menu; 
		menu =  "========================================\n";
		menu += "           REGISTRATION MODULE\n";
		menu += "========================================\n";
		menu += "1. Register a client.\n";
		menu += "2. Register a product.\n";
		menu += "3. Register a restaurant.\n";;
		menu += "4. Make an order.\n";
		menu += "========================================\n";
		menu += "Please enter de option\n";
		menu += "========================================\n";
		return menu;
	}
	
	//Print update module
	private String getMenuUpdate() {
		String menu; 
		menu =  "========================================\n";
		menu += "              UPDATE MODULE\n";
		menu += "========================================\n";
		menu += "1. Update a client\n";
		menu += "2. Update a product\n";
		menu += "3. Update a restaurant\n";
		menu += "4. Update a order\n";
		menu += "5. Update the status of an order\n";
		menu += "========================================\n";
		menu += "Please enter de option\n";
		menu += "========================================\n";
		return menu;
	}
	
	//Print display module
	private String getMenuDisplay() {
		String menu; 
		menu =  "========================================\n";
		menu += "              DISPLAY MODULE\n";
		menu += "========================================\n";
		menu += "1. Show list of restaurants\n";
		menu += "2. Show list of clients\n";
		menu += "========================================\n";
		menu += "Please enter de option\n";
		menu += "========================================\n";
		return menu;
	}

	//Start the registration module
	private void startRegistrationModule() throws IOException {
		String menu = getMenuRegistration();
		int option;
		System.out.println(menu);
		option = readOption();
		executeOperationRegister(option);
	}
	
	//Start the update module
	private void startUpdateModule() throws IOException {
		String menu = getMenuUpdate();
		int option;
		System.out.println(menu);
		option = readOption();
		executeOperationUpdate(option);
	}
	
	//Start the display module
	private void startDisplayModule() throws IOException {
		String menu = getMenuDisplay();
		int option;
		System.out.println(menu);
		option = readOption();
		executeOperationDisplay(option);
	}
	
	//Execute register module
	private void executeOperationRegister(int option) throws IOException {
		switch(option) {
			case 1:
				executeAddClient();
				System.out.println("========================================");
				System.out.println("              SUCCESSFUL");
			break;
			case 2:
				executeAddProduct();
				System.out.println("========================================");
				System.out.println("              SUCCESSFUL");
			break;
			case 3:
				executeAddRestaurant();
				System.out.println("========================================");
				System.out.println("              SUCCESSFUL");
			break;
			case 4:
				System.out.println("========================================");
				System.out.println("          AUN NO LO HAGO XD");
			break;
			default:
				System.out.println("Wrong option.");
			break;
		}
	}
	
	//Execute update module
	private void executeOperationUpdate(int option) {
		switch(option) {
			case 1:
				System.out.println("opcion 1 update");
			break;
			case 2:
				System.out.println("opcion 2 update");
			break;
			default:
				System.out.println("Wrong option.");
			break;
		}
	}
		
	//Execute display module
	private void executeOperationDisplay(int option) {
		switch(option) {
			//listar restaurantes por nombre orden alfabetico ascendente
			case 1:
				conection.sortByNameRestaurant();
				System.out.println(conection.toStringRestaurants());
			break;
			//listar clientes por telefono orden numerico descendente
			case 2:
				conection.sortByPhoneClient();
				System.out.println(conection.toStringClients());
			break;
			default:
				System.out.println("Wrong option.");
			break;
		}
	}

	//Execute principal module
	private void executeOperation(int option) throws IOException {
		switch(option) {
		case 1:
			startRegistrationModule();
		break;
		case 2:
			startUpdateModule();
		break;
		case 3:
			startDisplayModule();
		break;
		case 4:
			System.out.println(conection.toStringProducts());
		break;
		case 5:
			System.out.println("========================================");
			System.out.println("            COMMING SOON ;)");
			System.out.println("========================================");
		break;
		default:
			System.out.println("That option doesn't exits.");
		break;
		}
		
	}

	private int readOption() throws IOException {
		int op;
		op = Integer.parseInt(br.readLine());
		return op;
	}
	
	//Ask to add client
	private void executeAddClient() throws IOException {
		System.out.println("========================================");
		System.out.print("Write the name:");
		String na = br.readLine();
		System.out.println("========================================");
		System.out.print("Write the last name:");
		String ln = br.readLine();
		System.out.println("========================================");
		System.out.print("Write the type of id:");
		String ty = br.readLine();
		System.out.println("========================================");
		System.out.print("Write the address:");
		String ad = br.readLine();
		System.out.println("========================================");
		System.out.print("Write the number of id:");
		int id = Integer.parseInt(br.readLine());
		System.out.println("========================================");
		System.out.print("Write the phone:");
		int ph = Integer.parseInt(br.readLine());
		conection.addClient(na, ln, ty, ad,id, ph);
	}
	
	//Ask to add product
	private void executeAddProduct() throws IOException {
		System.out.println("========================================");
		System.out.print("Write the code:");
		int code = Integer.parseInt(br.readLine());
		System.out.println("========================================");
		System.out.print("Write the name:");
		String name = br.readLine();
		System.out.println("========================================");
		System.out.print("Write a little description:");
		String description = br.readLine();
		System.out.println("========================================");
		System.out.print("Write the nit:");
		int nit = Integer.parseInt(br.readLine());
		System.out.println("========================================");
		System.out.print("Write the price:");
		double price = Double.parseDouble(br.readLine());
		conection.addProduct(code, name, description, nit, price);
	}
	
	//Ask to add restaurant
	private void executeAddRestaurant() throws IOException {
		System.out.println("========================================");
		System.out.print("Write the name:");
		String name = br.readLine();
		System.out.println("========================================");
		System.out.print("Write the nit:");
		int nit = Integer.parseInt(br.readLine());
		System.out.println("========================================");
		System.out.print("Write the admin name:");
		String admin = br.readLine();
		conection.addRestaurant(name, nit, admin);
	}
}
