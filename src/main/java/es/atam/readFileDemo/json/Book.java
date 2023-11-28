package es.atam.readFileDemo.json;

public class Book  {

	private Long id;
	private String title;
	private Long publicationTimestamp;
    private String formattedDate;
	private int pages;
	private String summary;
	private Author author;
	
	public Book() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPublicationTimestamp() {
		return publicationTimestamp;
	}

	public void setPublicationTimestamp(Long publicationTimestamp) {
		this.publicationTimestamp = publicationTimestamp;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publicationTimestamp=" + publicationTimestamp
				+ ", formattedDate=" + formattedDate + ", pages=" + pages + ", summary=" + summary + ", author="
				+ author + "]";
	}


}
