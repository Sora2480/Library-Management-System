package library2;

import java.util.Scanner;

public class readers {

	Scanner s = new Scanner(System.in);
	reader theReaders[] = new reader[50];
	
	public static int count = 0;
	
	//add books
	public void addReader (reader s) {
		for(int i = 0; i < count; i++) {
			if(s.rno.equalsIgnoreCase(theReaders[i].rno)) {
				System.out.println("Reader of Registration No "+ s.rno+ "is already registered.");
		
				return;
			}
		}
		
		if(count <= 50) {
			theReaders[count] = s;
			count++;
		}
	}
	
	//Search readers information by rno
	public void searchByRno() {
		
		System.out.println("\t\t\tSearch by Reg No\n");
		
		String rno;
		System.out.println("Enter Reg No: ");
		rno = s.nextLine();
		
		int flag = 0;
		System.out.println("R.No\t\treadername\t\tgender\t\tborrowed book");
		for(int i = 0; i < count; i++) {
			if(rno == theReaders[i].rno) {
				System.out.println(
						theReaders[i].rno+ "\t\t"
						+theReaders[i].readername+ "\t\t"
						+theReaders[i].gender+ "\t\t"
						+theReaders[i].borrowedbook1);
				flag++;
				return;
			}
		}
		if(flag == 0)
			System.out.println("No reader for this registration no"+ rno+ " Found.");
	}
	
	//Display information of all readers
	public void showAllReaders() {
		System.out.println("Registration No\t\tReader name\t\tGender\t\tborrowedbook1");
		for(int i = 0; i < count; i++) {
			System.out.println(theReaders[i].rno +"\t\t\t"
					+theReaders[i].readername +"\t\t\t"
					+theReaders[i].gender +"\t\t\t"
					+theReaders[i].borrowedbook1);
		}
	}
	
	//Check the Reader
	public int isReader() {
		System.out.println("Enter Reg No: ");
		String rno = s.nextLine();
		for(int i = 0; i < count; i++) {
			if(theReaders[i].rno.equalsIgnoreCase(rno)) {
				return i;
			}
		}
		
		//print statements
		System.out.println("Reader is not Registered.");
		System.out.println("Get Registered First.");
		
		return -1;
	}
	
	// Check out the book
	public void checkOutBook(books book) {
		int readerIndex = this.isReader();
		if(readerIndex != -1) {
			System.out.println("Checking Out.");
			
			book.showAllBooks();
			book b = book.checkOutBook();
			
			System.out.println("Checking Out.");
			if(b != null) {
				if(theReaders[readerIndex].booksCount <= 3) {
					System.out.println("adding book");
					theReaders[readerIndex].borrowedBooks[theReaders[readerIndex].booksCount] = b;
					theReaders[readerIndex].booksCount++;
					return;
				}
				else {
					System.out.println("Reader can not borrow more than 3 books.");
					return;
				}
			}
			System.out.println("Book is not available.");
		}
	}
	
	//Check in the book
	public void checkInBook(books book) {
		int readerIndex = this.isReader();
		if(readerIndex != -1) {
			System.out.println("R.No\t\tbook name\t\tpublisher\\publishDate");
			reader s = theReaders[readerIndex];
			
			for(int i = 0; i < count; i++) {
				System.out.println(
						s.borrowedBooks[i].bno +"\t\t\t"
						+ s.borrowedBooks[i].bname +"\t\t\t"
						+ s.borrowedBooks[i].publisher +"\t\t\t"
						+ s.borrowedBooks[i].publishDate);
			}
			
			System.out.println("Enter number of the book to be Checked In: ");
			int bno = s.nextInt();
			
			for(int i = 0; i < count; i++) {
				if(bno == s.borrowedBooks[i].bno) {
					book.checkInBook(s.borrowedBooks[i]);
					s.borrowedBooks[i] = null;
					return;
				}
			}
			
			System.out.println("Book No "+ bno+ "not Found");
		}
	}
}
