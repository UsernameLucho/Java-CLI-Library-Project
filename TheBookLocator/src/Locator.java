import java.util.ArrayList;

public class Locator {
    private App controller;
    
//I used array list because it allows me to have a dynamic amount of indexes. So instead of having a large fixed amount of indexes, one can simply be added instead, which isn't possible with normal arrays. 
//I used my knowledge on normal arrays and the documentation provided to use array list. I heard about array lists a while ago.  
    private ArrayList<Book> bookList = new ArrayList<Book>();
/**
 * This is the constructor for the locator class which is a model for the program.
 * 
 */
    public Locator(App controller){
        this.controller = controller;
       // books = new String[bookAmount];
        //peopleLocated = new String[bookAmount];


    }
   /** Returns the total amount of books in the booklist array
    */
    public int getBookAmount() {
        return bookList.size();
    }
   
    /** This method returns the amount of total books in the booklist array array. 
    */
    public String getBook(int index){
        return bookList.get(index).getBookName();
    }
    /** Returns the name at a specified index*/
    public String getName(int index){
        return bookList.get(index).getHolderName();
    }
   
    /** Sets the name of a book at a specific index */
    public void setBook(int index, String bookName){
        bookList.get(index).setBookName(bookName);
    }
    /** Adds a book to the array */
    public void addBook(String bookName, String holderName){
        bookList.add(new Book(bookName, holderName));
    }
    
    /** Sets the name of a person at an index */
    public void setBookHolder(int index, String name){
        bookList.get(index).setBookHolder(name);
    }




    
}
