package pl.coderslab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.mvc.entities.Book;

public class BookDAO {
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "coderslab";
	private static final String INSERT_BOOK = "INSERT INTO servletJDBC.Book(author,title,isbn)VALUES(?,?,?)";
	private static final String DELETE_BOOK = "DELETE FROM servletJDBC.Book WHERE id=?;";
	private static final String ALLBOOKS = "SELECT * FROM servletJDBC.Book";
	private static final String SELECT_BY_ID = "SELECT * FROM servletJDBC.Book WHERE id=?";
	private static final String UPDATE_BOOK = "UPDATE servletJDBC.Book SET author = ?,title = ?, isbn = ? WHERE id = ?";
	private static final String SEARCH_BY_TITILE= "SELECT * FROM servletJDBC.Book WHERE title LIKE ?";
	public int insertBook(Book book) {
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_BOOK);
			preparedStatement.setString(1, book.getAuthor());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getIsbn());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int deleteBook(long id) {
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_BOOK);
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public List<Book> allBooks() {
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			List<Book> books = new ArrayList<>();
			PreparedStatement preparedStatement = conn.prepareStatement(ALLBOOKS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getLong("id"));
				book.setAuthor(resultSet.getString("author"));
				book.setTitle(resultSet.getString("title"));
				book.setIsbn(resultSet.getString("isbn"));
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

	}

	public Book findById(long id) {
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_ID);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			Book book = new Book();
			if (resultSet.next()) {
				book.setId(resultSet.getLong("id"));
				book.setAuthor(resultSet.getString("author"));
				book.setTitle(resultSet.getString("title"));
				book.setIsbn(resultSet.getString("isbn"));
				return book;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int updateBook(Book book) {
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_BOOK);
			preparedStatement.setString(1, book.getAuthor());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getIsbn());
			preparedStatement.setLong(4, book.getId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	public List<Book> searchByTitle(String title) {
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			List<Book> books = new ArrayList<>();
			PreparedStatement preparedStatement = conn.prepareStatement(SEARCH_BY_TITILE);
			preparedStatement.setString(1, "%"+title+"%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getLong("id"));
				book.setAuthor(resultSet.getString("author"));
				book.setTitle(resultSet.getString("title"));
				book.setIsbn(resultSet.getString("isbn"));
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

	}

}
