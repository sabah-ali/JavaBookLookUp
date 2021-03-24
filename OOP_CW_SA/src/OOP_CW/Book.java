package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
public class Book {

	private int id;
	private String title;
	private String author;
	private int year;
	private int edition;
	private String publisher;
	private String isbn;
	private String cover;
	private String condition;
	private int price;
	private String notes;
	
	
	public Book(int ID, String title, String author, int year, int
			edition, String publisher, String isbn, String cover, String condition,
			int price, String notes) {
		
		this.id = ID;
		this.title = title;
		this.author = author;
		this.year = year;
		this.edition = edition;
		this.publisher = publisher;
		this.isbn = isbn;
		this.cover = cover;
		this.condition = condition;
		this.price = price;
		this.notes = notes;
		
	}

	/**
	 * @return the id
	 */
	public int getID() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setID (int id) {
		this.id = id; 
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}
	/**
	 * @return the edition
	 */
	public int getEdition() {
		return this.edition;
	}
	/**
	 * @param edition the edition to set
	 */
	public void setEdition (int edition) {
		this.edition = edition; 
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the publisher 
	 */
	public String getPublisher() {
		return this.publisher;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;	
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return this.price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the isbn
	 */
	public String getISBN() {
		  return this.isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the cover
	 */
	public String getCover() {
		return this.cover;
	}
	/**
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * @return the condition
	 */
	public String getCondition() {
		 return this.condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return this.notes; 
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes (String notes) {
		this.notes = notes;
	}
  
	@Override
	public String toString() {
		return "Book [ID=" + this.id + ", Title=" + this.title + ", Author=" + this.author + ", Year=" + this.year + ", Edition=" + this.edition + ", Publisher= " + this.publisher + 
				", ISBN= " + this.isbn + ", Cover = " + this.cover + ", Condition=" + this.condition + ", Price=" + this.price + ", Notes=" + this.notes +" ]";
	}




	

}
