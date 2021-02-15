package com.stackroute.oops;

public class Book {

	/* Define the properties as given in problem.md */
	private long isbn;
	private String title;
	private String edition;
	private Author author;

	/*
	 * Complete the Parameterized constructor to initialize all properties of Author
	 */
	public Book(long isbn, String title, String edition, Author author) {
		this.isbn = isbn;
		this.title = title;
		this.edition = edition;
		this.author = author;
	}

	/*
	 * complete the Getters and Setters
	 */
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	/*
	 * This method should return a string containing the book details in below
	 * format Book{isbn=xxxxxxxx, title='xxxxxxxx', edition='xxxxxx',
	 * author=Author{name='xxxxxx', country='xxxxxx'}}
	 */

	public String getBookDetails() {
		return "Book{isbn=" + getIsbn() + "," + " title='" + getTitle() + "'," + " edition='" + getEdition() + "'"
				+ ", " + "author=" + "Author{" + "name='" + author.getName() + "', country='" + author.getCountry()
				+ "'}}";
	}
}