package library2;

import java.util.Scanner;

public class books {

	book theBooks[] = new book[50];
	public static int count;
	
	Scanner s = new Scanner(System.in);
	
	
	//Compare books
	public int compareBookObjects(book b1, book b2) {
		// if bname matches
		if(b1.bname.equalsIgnoreCase(b2.bname)) {
			System.out.println("Book of this name already exists.");
			return 0;
		}
		
		if(b1.bno == b2.bno) {
			System.out.println("Book of this serial no already exists.");
			return 0;
		}
		return 1;
	}
	
	//add book
	public void addBook(book b) {
		for(int i = 0; i < count; i++) {
			if(this.compareBookObjects(b, this.theBooks[i])
					== 0)
				return;
		}
		
		if(count < 50) {
			theBooks[count] = b;
			count++;
		}
		else {
			System.out.println("No space to add more books.");
		}
	}
	
	//Search book by book no
	public void searchByBno() {
		
		System.out.println("\t\t\tCheck by Book No\n");
		
		int bno;
		System.out.println("Enter no of the book: ");
		bno = s.nextInt();
		
		int flag = 0;
		System.out.println("B.No\t\tbname\t\tpublisher\t\tpublishDate");
		for(int i = 0; i < count; i++) {
			if(bno == theBooks[i].bno) {
				System.out.println(
						theBooks[i].bno+ "\t\t"
						+theBooks[i].bname+ "\t\t"
						+theBooks[i].publisher+ "\t\t"
						+theBooks[i].publishDate);
				flag++;
				return;
			}
		}
		if(flag == 0)
			System.out.println("No book for serial no"+bno+ " Found.");
	}
	
	//display all book
	public void showAllBooks() {
		System.out.println("\t\t\tDisplay Information of the books");
		System.out.println("B.No\t\tBName\t\t\tPublisher\t\tPublishDate\tAvailableQty");
		
		for(int i = 0; i < count; i++) {
			System.out.println(
					theBooks[i].bno+ "\t\t"
					+theBooks[i].bname+ "\t\t"
					+theBooks[i].publisher+ "\t\t"
					+theBooks[i].publishDate+ "\t\t"
					+theBooks[i].bookQtyCopy);
		}
	}
	
	//update book
	public void updateBookQty() {
		System.out.println("\t\t\tUpdate quantity of the book\n");
		System.out.println("Enter serial no of book");
		
		int bno = s.nextInt();
		for(int i = 0; i < count; i++) {
			if(bno == theBooks[i].bno) {
				System.out.println("Enter no of books to be added: ");
				
				int addingQty = s.nextInt();
				theBooks[i].bookQty += addingQty;
				theBooks[i].bookQtyCopy += addingQty;
				
				return;
			}
		}
	}
	
	//create menu
	public void dispMenu() {
		 System.out.println("Press 1 to Add new Book.");
	        System.out.println("Press 0 to Exit Application.");
	        System.out.println("Press 2 to Update Quantity of a Book.");
	        System.out.println("Press 3 to Search.");
	        System.out.println("Press 4 to Show All Books.");
	        System.out.println("Press 5 to Register Student.");
	        System.out.println(
	            "Press 6 to Show All Registered Students.");
	        System.out.println("Press 7 to Check Out the Book. ");
	        System.out.println("Press 8 to Check In the Book");
	}
	
	// check the book if it is available 
	public int isAvailable(int bno) {
		for(int i = 0; i < count; i++) {
			if(bno == theBooks[i].bno) {
				if(theBooks[i].bookQtyCopy > 0) {
					System.out.println("Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable.");
				return -1;
			}
		}
		
		System.out.println("Book no "+ " Available in Library.");
		return -1;
	}
	
	// check out the book from library
	public book checkOutBook() {
		System.out.println("Enter no of the book to be checked out. ");
		int bno = s.nextInt();
		
		int bookIndex = isAvailable(bno);
		
		if(bookIndex != -1) {
			theBooks[bookIndex].bookQtyCopy--;
			return theBooks[bookIndex];
		}
		return null;
	}
	
	//check in the book to the library
	public void checkInBook(book b) {
		for(int i = 0; i < count; i++) {
			if(b.equals(theBooks[i])) {
				theBooks[i].bookQtyCopy++;
				return;
			}
		}
	}
}
