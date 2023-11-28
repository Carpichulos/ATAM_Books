package es.atam.readFileDemo.json;


public class BookDate {
    private Book book;
    private String formattedDate;

    public BookDate(Book book, String formattedDate) {
        this.book = book;
        this.setFormattedDate(formattedDate);
    }

    public Book getBook() {
        return book;
    }

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

    
    
}
