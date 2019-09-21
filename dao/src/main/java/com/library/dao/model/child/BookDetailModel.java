package com.library.dao.model.child;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class BookDetailModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field("format")
	private FormatModel format;

	@Field("dimensions")
	private String deimensions;

	@Field("publication")
	private String publication;

	@Field("publication_date")
	private String publicationDate;

	@Field("imprint")
	private String imprint;

	@Field("language")
	private String language;

	@Field("sell_rank")
	private String sellRank;

	public FormatModel getFormat() {
		return format;
	}

	public void setFormat(FormatModel format) {
		this.format = format;
	}

	public String getDeimensions() {
		return deimensions;
	}

	public void setDeimensions(String deimensions) {
		this.deimensions = deimensions;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getImprint() {
		return imprint;
	}

	public void setImprint(String imprint) {
		this.imprint = imprint;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSellRank() {
		return sellRank;
	}

	public void setSellRank(String sellRank) {
		this.sellRank = sellRank;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
}
