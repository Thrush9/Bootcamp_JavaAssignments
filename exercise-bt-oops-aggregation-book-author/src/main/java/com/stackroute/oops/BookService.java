package com.stackroute.oops;

public class BookService {

	/*
	 * This method should create an author object using the values of author
	 * properties passed as parameters and return the author object
	 */
	public Author createAuthor(String name, String country) {
		Author author = new Author(name, country);
		return author;
	}

	/*
	 * This method should create a book object using the values of book and author
	 * properties passed as parameters and return the book object
	 */
	public Book createBook(long isbn, String bookTitle, String bookEdition, String authorName, String authorCountry) {
		Author author = new Author(authorName, authorCountry);
		Book book = new Book(isbn, bookTitle, bookEdition, author);
		return book;
	}

}