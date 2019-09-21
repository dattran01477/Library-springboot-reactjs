package com.library.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.model.child.BookDetailModel;
import com.library.dao.model.child.ReviewModel;

@Document("book")
public class BookModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("name")
	private String name;

	@Field("author")
	private AuthorModel author;

	@Field("sumary")
	private String sumary;

	@Field("total_star")
	private double starTotal;

	@Field("price")
	private double price;

	@Field("prive_sale_off")
	private double saleOffPrice;

	@Field("percent_sale")
	private int percentSale;

	@Field("click_view")
	private int clickViewTotal;

	@Field("link_big_image")
	private String bigImageLink;

	@Field("link_small_image")
	private String smallImageLink;

	@Field("type")
	private String type;

	@Field("category")
	private List<CategoryModel> category = new ArrayList<CategoryModel>();

	@Field("age_range_from")
	private int ageRangeFrom;

	@Field("age_range_to")
	private int ageRangeTo;

	@Field("languae")
	private String languae;

	@Field("content")
	private String content;

	@Field("reviews")
	private List<ReviewModel> reviews = new ArrayList<ReviewModel>();

	@Field("book_detail")
	private BookDetailModel bookDetail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthorModel getAuthor() {
		return author;
	}

	public void setAuthor(AuthorModel author) {
		this.author = author;
	}

	public String getSumary() {
		return sumary;
	}

	public void setSumary(String sumary) {
		this.sumary = sumary;
	}

	public double getStarTotal() {
		return starTotal;
	}

	public void setStarTotal(double starTotal) {
		this.starTotal = starTotal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSaleOffPrice() {
		return saleOffPrice;
	}

	public void setSaleOffPrice(double saleOffPrice) {
		this.saleOffPrice = saleOffPrice;
	}

	public int getPercentSale() {
		return percentSale;
	}

	public void setPercentSale(int percentSale) {
		this.percentSale = percentSale;
	}

	public int getClickViewTotal() {
		return clickViewTotal;
	}

	public void setClickViewTotal(int clickViewTotal) {
		this.clickViewTotal = clickViewTotal;
	}

	public String getSmallImageLink() {
		return smallImageLink;
	}

	public void setSmallImageLink(String smallImageLink) {
		this.smallImageLink = smallImageLink;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CategoryModel> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryModel> category) {
		this.category = category;
	}

	public int getAgeRangeFrom() {
		return ageRangeFrom;
	}

	public void setAgeRangeFrom(int ageRangeFrom) {
		this.ageRangeFrom = ageRangeFrom;
	}

	public int getAgeRangeTo() {
		return ageRangeTo;
	}

	public void setAgeRangeTo(int ageRangeTo) {
		this.ageRangeTo = ageRangeTo;
	}

	public String getLanguae() {
		return languae;
	}

	public void setLanguae(String languae) {
		this.languae = languae;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ReviewModel> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewModel> reviews) {
		this.reviews = reviews;
	}

	public BookDetailModel getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetailModel bookDetail) {
		this.bookDetail = bookDetail;
	}

	public String getBigImageLink() {
		return bigImageLink;
	}

	public void setBigImageLink(String bigImageLink) {
		this.bigImageLink = bigImageLink;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
