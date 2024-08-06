package library2;

import java.util.Scanner;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// Display Menu
		System.out.println("\nWelcome to the School Library!\n");
		System.out.println("\nSelect from the following options: ");
		
		//creating object of book class
		books ob = new books();
		readers obreader = new readers();
		
		int choice;
		int searchChoice;
		
		//creating menu
		do {
			ob.dispMenu();
			choice = s.nextInt();
			//Switch case
			switch(choice) {
			
			case 1:
				book b = new book();
				ob.addBook(b);
				break;
				
			case 2:
				ob.updateBookQty();
				break;
				
			case 3:
				System.out.println("press 1 to check with Book No.");
				System.out.println("press 2 to check with Book Name.");
				searchChoice = s.nextInt();
				
				//Nested switch
				switch(searchChoice) {
				
				case 1:
					ob.searchByBno();
					
				case 2:
					obreader.searchByRno();
					break;
					
				}
				break;
				
			case 4:
				ob.showAllBooks();
				break;
				
			case 5:
				reader r = new reader();
				obreader.addReader(r);;
				
			case 6:
				obreader.showAllReaders();
				break;
				
			case 7:
				obreader.checkOutBook(ob);
				
			case 8:
				obreader.checkInBook(ob);
				break;
				
			default:
				System.out.println("Enter between 0 to 8.");
			}
		}
		while(choice != 0);
	}
}
