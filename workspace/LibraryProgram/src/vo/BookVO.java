package vo;

import java.sql.Date;

public class BookVO {
	
	private int book_no;
	private String title;
	private String author;
	private int price;
	private Date publication_date;
	private String isbn;
	
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(Date publication_date) {
		this.publication_date = publication_date;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "BookVO [book_no=" + book_no + ", title=" + title + ", author=" + author + ", price=" + price
				+ ", publication_date=" + publication_date + ", isbn=" + isbn + "]";
	}
	
	
	
}
