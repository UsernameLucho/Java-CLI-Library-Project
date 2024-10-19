import java.util.Scanner;
import java.io.*;
public class Printer {
    private App controller;
    Scanner in = new Scanner(System.in);
/**Constructor for printer class. 
 * The controller is the only parameter
 */
    public Printer(App controller){
        this.controller = controller;
    }
/**This method is for the output.
 * The parmeter "s" contains the string to output.
 * 
 */
    public void output(String s){
        //This code was from the madlib example in codehs
        for(int i = 0; i < s.length(); i++){
            String c = s.substring(i, i+1);
            System.out.print(c);
            /*try{
                Thread.sleep(50);
            }catch(InterruptedException e){


            }*/
        }
    }
   /** Fancy Intro for the app */
    public void startView(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("frame.txt"));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);

            }
            reader.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
     /**This method is for input
     * the parmeter prompt string is to output the question for the user to answer
     * This method makes it simpler to setup user input since a new scanner doesn't have to be initialized for a new input and a seperate print line doesn't have to be written
     */
    public String input(String promptString){
        //This code was from the madlib example in codehs
        output(promptString);
        return in.nextLine();

    }
    /** This method contains the format for the final output of the files
     * 
     */
    public void displayInfo(int index, String bookName, String holderName, String topFrame){
        //Instead of reading directly from a file for output, I thought it would be simpler to read from the array. 
        for(int i = 0; i < bookName.length(); i++){
            output(topFrame);
        }
        output("\n");
        output(index +1 +". "+ bookName +"\n" +"    name: " + holderName +"\n");
    }
/** Displays the options for the user to choose from.
 * The controller paramter in the constructor is necessary for this method so that it knows what methods from the controller are to be run depending on user input
  */
    public void run() {
        //Putting the while loop in this method made the code for the start method in the controller look more simple
        //This is also a user interface so it makes sense for this code to be in this class too
        String option;
        while(true){
            option = input("Do you want to setup the books(input: set) or read the final output(input: read)? Type anything else to exit: ");
            if(option.toLowerCase().equals("set")){
                controller.setBooks();

            }
            else if(option.toLowerCase().equals("read")){
                controller.finalOutput();
            }

            else{
                break;
            }  
            
        } 
    }
}
