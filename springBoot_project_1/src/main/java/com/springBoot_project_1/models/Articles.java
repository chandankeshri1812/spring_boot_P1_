package com.springBoot_project_1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Articles {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aId;
	
	@Column(length=1000)
	private String title;
	
	@Column(length=1000)
	private String authors;
	
	
	@Column(length=1000)
	private String publisher;
	
	
	private String journal;
	private String book;
	
	
	private String publicationDate;
	private String totalCitations;
	private String pages;
	private String volumne;
	private String issue;
	
	@Column(length=1000)
	private String pdfLink;
	
	@Column(length=1000)
	private String titleLink;
	
	
	@Column(length=65530)
	private String description;

	@Column(length=65530)
	private String scholarArticles;
	
//	----------------------------------
	
	
	

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalCitations() {
		return totalCitations;
	}

	public void setTotalCitations(String totalCitations) {
		this.totalCitations = totalCitations;
	}

	public String getScholarArticles() {
		return scholarArticles;
	}

	public void setScholarArticles(String scholarArticles) {
		this.scholarArticles = scholarArticles;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getVolumne() {
		return volumne;
	}

	public void setVolumne(String volumne) {
		this.volumne = volumne;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPdfLink() {
		return pdfLink;
	}

	public void setPdfLink(String pdfLink) {
		this.pdfLink = pdfLink;
	}

	public String getTitleLink() {
		return titleLink;
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}

	@Override
	public String toString() {
		return "Articles [aId=" + aId + ", title=" + title + ", authors=" + authors + ", publicationDate="
				+ publicationDate + ", publisher=" + publisher + ", description=" + description + ", totalCitations="
				+ totalCitations + ", scholarArticles=" + scholarArticles + ", pages=" + pages + ", journal=" + journal
				+ ", book=" + book + ", volumne=" + volumne + ", issue=" + issue + ", pdfLink=" + pdfLink
				+ ", titleLink=" + titleLink + "]";
	}

	public Articles(int aId, String title, String authors, String publicationDate, String publisher, String description,
			String totalCitations, String scholarArticles, String pages, String journal, String book, String volumne, String issue,
			String pdfLink, String titleLink) {
		super();
		this.aId = aId;
		this.title = title;
		this.authors = authors;
		this.publicationDate = publicationDate;
		this.publisher = publisher;
		this.description = description;
		this.totalCitations = totalCitations;
		this.scholarArticles = scholarArticles;
		this.pages = pages;
		this.journal = journal;
		this.book = book;
		this.volumne = volumne;
		this.issue = issue;
		this.pdfLink = pdfLink;
		this.titleLink = titleLink;
	}

	public Articles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
