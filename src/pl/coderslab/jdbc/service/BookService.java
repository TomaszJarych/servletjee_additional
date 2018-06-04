package pl.coderslab.jdbc.service;

import java.util.List;

import pl.coderslab.jdbc.BookDAO;
import pl.coderslab.mvc.entities.Book;

public class BookService {
	private BookDAO bookDAO;

	public BookService() {
		this.bookDAO = new BookDAO();
	}

	public String saveBook(Book book) {
		String msg;
		int code = bookDAO.insertBook(book);
		if (code > 0) {
			msg = "<h1>Zapisano" + book.toString() + "</h1>";
		} else {
			msg = "<h1> Nie mozna zapisac ksiazki</h1>";
		}
		return msg;
	}

	public String deleteBook(long id) {
		String msg;
		int code = bookDAO.deleteBook(id);
		if (code > 0) {
			msg = "<h1>Skasowano ksiazke o  id = " + id + "</h1>";
		} else if (code == 0) {
			msg = "<h1>Ksiazka o = " + id + " nie istnieje </h1>";
		} else {
			msg = "<h1>Nie mozna usunac ksiazki </h1>";
		}
		return msg;
	}
	public List<Book> allBook(){
		return bookDAO.allBooks();
	}
	public Book bookById (long id){
		return bookDAO.findById(id);
		
	}
	
	public String updateBook(Book book){
		String msg;
		int code = bookDAO.updateBook(book);
		if (code > 0) {
			msg = "Dane ksiazki zakutalizowano z powodzeniem";
		}else {
			msg = "Nie mozna zaktualizowac danych!";
		}
		return msg;
	}
	
	public List<Book> bookByTitle(String title){
		return bookDAO.searchByTitle(title);
	}
	
}
