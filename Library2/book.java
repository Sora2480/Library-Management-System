package library2;

import java.util.Scanner;

public class book {

	public int bno;
	public String bname;
	public String publisher;
	public int publishDate;
	public int bookQty;
	public int bookQtyCopy;
	
	Scanner s = new Scanner(System.in);
	
	public book() {
		System.out.println("Enter book no: ");
		this.bno = s.nextInt();
		s.nextLine();
		
		System.out.println("Enter book name: ");
		this.bname = s.nextLine();
		
		System.out.println("Enter publisher: ");
		this.publisher = s.nextLine();
		
		System.out.println("Enter publish date: ");
		this.publishDate = s.nextInt();
		
		System.out.println("Enter quantity of Books: ");
		this.bookQty = s.nextInt();
		bookQtyCopy = this.bookQty;
		
	}
}
