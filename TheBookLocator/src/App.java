import java.io.*;
public class App {
    private Locator locator;
    private Printer printer;


/**
 * The start method for the program
 * Initializes the printer and locator objects
 * Conatins the methods that should run in the beggining
 */
    public void start(){
        printer = new Printer(this);
        locator = new Locator(this);
        printer.startView();
        readFromFile();
        printer.run();
        
       
    
    }
   
/** This method uses the IO library to read from a file specified in the parameter. The file name and extention has to be included
 * This method prints each line from a specified text file to console
 */
    public void finalOutput(){
        for(int i = 0; i < locator.getBookAmount(); i++){
            printer.displayInfo(i, locator.getBook(i), locator.getName(i),"#");
        }
        
        

    }
    /**This method reads the text files book.txt and names.txt to set up the array
     * Run this method only once or else there may be dupclicate or missing data
     * In this program this method runs at the start.
     */
    public void readFromFile(){
        // I used this video for the readline: https://www.youtube.com/watch?v=ScUJx4aWRi0
        //I understood this more than using a scanner to read the files
        //The books.txt file determines when the loop stops because the book names are more important than holder names
        //If a book has no holder than it is fine, but their can't be a holder with no book
        //If a line in names.txt is null then it is determined that there is no holder.
        try{
            BufferedReader bookReader = new BufferedReader(new FileReader("books.txt"));
            BufferedReader nameReader = new BufferedReader(new FileReader("names.txt"));
            String line;
            String line2;
            String name = "";
            String book = "";
            while((line = bookReader.readLine()) != null){
                line2 = nameReader.readLine();
                book = line;
                if(line2 == null){
                    line2 = "none";
                }
                name = line2;
                locator.addBook(book, name); 
                
                
            }
            bookReader.close();
            nameReader.close();
            printer.output("File Read and Array Set up\n");
            


        }catch(FileNotFoundException e){
            e.printStackTrace();

        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    /** This method allows users to change the information of a book at a specific index in the array or add a new book to the array
     * At the end of the method, the contents of the array are saved on a text file
    */
    public void setBooks(){
        while(true){
            String yesOrNo = printer.input("Do you want to change a book or name at a specific index, add a new book(set book/set name/add/ or no)? ");
            if(yesOrNo.toLowerCase().equals("set book")){
                if(locator.getBookAmount()<= 0){
                    printer.output("You have to add books first\n");
                }
                else{
                    System.out.println("there are " + locator.getBookAmount() + " indexes");
                    String ans = printer.input("Do you want to see all the books in the array(yes/No)? ");
                    if(ans.toLowerCase().equals("yes")){
                        for(int i = 0; i<locator.getBookAmount(); i++){
                            printer.output((i+1)+". " + locator.getBook(i)+" \n");
                        }
                    }
                    String whichBook = printer.input("at what index is the book?");
                    int index = Integer.parseInt(whichBook);
                    String bookName = printer.input("What is the name of the new book? ");
                    locator.setBook(index - 1 , bookName);

                }
                

            }else if(yesOrNo.toLowerCase().equals("set name")){
                System.out.println("there are " + locator.getBookAmount() + " indexes");
                String ans = printer.input("Do you want to see all the names in the array(yes/No)? ");
                if(ans.toLowerCase().equals("yes")){
                    for(int i = 0; i<locator.getBookAmount(); i++){
                        printer.output((i+1) + ". "+locator.getName(i)+" \n");
                    }
                }
                String whichHolder = printer.input("at what index is the name at? ");
                int index = Integer.parseInt(whichHolder);
                String holderName = printer.input("what is the name of the book holder? ");
                locator.setBookHolder(index-1, holderName);


            }
            else if(yesOrNo.toLowerCase().equals("add")){
                String bookName = printer.input("What is the Name of the new book? ");
                String holderName = printer.input("What is the name of the book holder(type none if nobody holds the book)? ");
                locator.addBook(bookName, holderName);
            }
            else{
                break;
            }
            

        }
        writeToFile();
        
    }
   
    /**user specifies which file to make the final changes to
     * This method writes the elements of both arrays into the specified file
     * This method is ran in the setup method
     */
    public void writeToFile(){
        //I used this video https://www.youtube.com/watch?v=ScUJx4aWRi0
        //This method reads the array and saves the corresponding data into the text files
        //The text files are used as save files
        try{
            BufferedWriter bookWriter = new BufferedWriter(new FileWriter("books.txt"));
            for(int i = 0; i< locator.getBookAmount(); i++){
                String line = locator.getBook(i);
                bookWriter.write(line + "\n");
            }
            bookWriter.close();

            BufferedWriter nameWriter = new BufferedWriter(new FileWriter("names.txt"));
            for(int i = 0; i<locator.getBookAmount();i++){
                String line = locator.getName(i);
                nameWriter.write(line+"\n");
            }
            nameWriter.close();

            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        

    }
    public static void main(String[] args) throws Exception {
        new App().start();
        
    }
}
