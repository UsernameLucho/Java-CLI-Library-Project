public class Book {
//I wrote this class so that I don't write two arrays. One array contains all the objects and the objects conatin the data related to them
    private String name;
    private String holder;
/**This constructor is for the book class which is a model for a book
 * Contains the name of the book and the holder of the book.
 * 
 */
    public Book(String bookName, String bookHolder){
        name = bookName;
        holder = bookHolder;


    }
    /**A setter for the name of the book */
    public void setBookName(String bookName){
        name = bookName;

    }
    /** A setter for the name of the book holder */
    public void setBookHolder(String holderName){
        holder = holderName;
    }
    /** A getter for the name of the book */
    public String getBookName(){
        return name;
    }
    /** A getter for the name of the book holder */
    public String getHolderName(){
        return holder;
    }
    
    
}
