package library2;

import java.util.Scanner;

public class reader {

	String rno;
	String readername;
	String gender;
	int borrowedbook1;
	
	book borrowedBooks[] = new book[3];
	public int booksCount = 0;
	
	Scanner s = new Scanner(System.in);
	
	public reader() {
		System.out.println("Enter Reg no: ");
		this.rno = s.nextLine();
		
		System.out.println("Enter reader name: ");
		this.readername = s.nextLine();
		
		System.out.println("Enter gender: ");
		this.gender = s.nextLine();
		
		System.out.println("Enter borrowedbook1: ");
		this.borrowedbook1 = s.nextInt();
		
	}

	public int nextInt() {
		// TODO Auto-generated method stub
		return 0;
	}
}
