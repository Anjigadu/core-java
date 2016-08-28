package com.msrm.corejava;

import java.util.List;

/**
 * Class is user defined data type in Java. It made up of variables,
 * constructors, methods
 * 
 * @author srirammuthaiah
 *
 */
public class BookClass {

	// variables declared
	private static int id = 999;

	private String isbnId;

	private float price;

	private String name;

	private String author;

	// constructors defined
	private BookClass() {
		id++;
		this.isbnId = "i-" + id;
	}

	public BookClass(String name, float price) {
		this(name, price, null);
	}

	public BookClass(String name, float price, String author) {
		this();
		this.name = name;
		this.price = price;
		this.author = author;
	}

	// methods added

	public void addToPack(List<BookClass> packs) {
		packs.add(this);
	}

	public String getIsbnId() {
		return isbnId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void printInfo() {
		System.out.printf("%-7s : %s%n%-7s : %s%n%-7s : %.2f%n%-7s : %s%n", "ISBN", isbnId, "Name", name, "Price", price,
				"Author", author);
	}

	@Override
	public String toString() {
		return "BookClass [id=" + id + ", isbnId=" + isbnId + ", price=" + price + ", name=" + name + ", author="
				+ author + "]";
	}

}
