package jpl.ch22.ex04;

import java.util.Observable;
import java.util.Observer;

public class User implements Observer {
	private ReserveBooks wantList;
	private String userName;
	
	public User(String name) {
		this.userName = name;
		wantList = new ReserveBooks();
	}
	
	public void addBooks(Library.Book b) {
		wantList.add(b);
		b.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Library.Book book = (Library.Book) arg;
		if (book.canBorrow()) {
			System.out.println(userName + " borrows '" + book.getName() + "'");
			wantList.remove(book.getName());
		} else {}
	}
}
