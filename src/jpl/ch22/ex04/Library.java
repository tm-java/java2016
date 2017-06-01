package jpl.ch22.ex04;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Library {
	private final List<Book> books = new LinkedList<Book>();
	public final Book JPL = new Book("JPL", false);
	public final Book JAVA_8 = new Book("Java 8", false);
	public Library(){
		books.add(JPL);
		books.add(JAVA_8);
	}
	
	public void returnBook(Book b) {
		b.changeState(true);
	}
	
	public void borrowBook(Book b) {
		b.changeState(false);
	}
	
	public class Book extends Observable {
		private Attr book;
		
		private Book(String name, boolean reserve) {
			book = new Attr(name, reserve);
		}
		
		public Attr getBook() {
			return book;
		}
		
		public String getName() {
			return book.getName();
		}
		
		public boolean canBorrow() {
			return (Boolean)book.getValue();
		}
		
		private void changeState(boolean r) {
			book.setValue(r);
			setChanged();
			notifyObservers(this);
		}
	}

}
