package es.atam.readFileDemo.json;

public class Author {

	private String name;
	private String firstSurname;
	private String bio;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstSurname() {
		return firstSurname;
	}
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public Author() {
		super();
	}
	@Override
	public String toString() {
		return "Author [name=" + name + ", firstSurname=" + firstSurname + ", bio=" + bio + "]";
	}
	
	
}
