package Library;

import java.util.Scanner;
import java.util.*;

public class Main {

	static Scanner s;
	static Database database;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		database = new Database();
		System.out.println("Welcome to Library Management System!");
		
		int num;
//		do {
			System.out.println("0. Exit\n1. Login\n2. New User");
			s = new Scanner(System.in);
			num = s.nextInt();
			
			switch (num) {
				case 1: login();
				case 2: newuser(); 
			}
//		} while(num!=0);
	}

	private static void login() {
		System.out.println("Enter phone number:");
		String phonenumber = s.next();
		System.out.println("Enter email:");
		String email = s.next();
		int n = database.login(phonenumber, email);
		if(n != -1){
			User user = database.getUser(n);
			user.menu(database, user);
		} else {
			System.out.println("User doesn't exist!");
		}
	}
	
	private static void newuser() {
		// TODO Auto-generated method stub
		System.out.println("Enter name:");
		String name = s.next();
		System.out.println("Enter phone number:");
		String phonenumber = s.next();
		System.out.println("Enter email:");
		String email = s.next();
		System.out.println("1. Admin\n2. Normal User");
		int n2 = s.nextInt();
		User user;
		if(n2==1) {
			user = new Admin(name, email, phonenumber);
		} else {
			user = new NormalUser(name, email, phonenumber);
			database.AddUser(user);
		}
		database.AddUser(user);
		user.menu(database, user);
	}

}
