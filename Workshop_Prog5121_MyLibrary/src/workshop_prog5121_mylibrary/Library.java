
package workshop_prog5121_mylibrary;

import javax.swing.JOptionPane;

public class Library 
{
    
    // variable declarations    
    private String bookName;
    private String ISBN;
    private String bookDescription;
    private String authorDetails;
    private int readingDuration;
    private String bookID;
    private String readingStatus;
    private int sum = 0;
    
    public void addBook(String bookName, String ISBN, String bookDescription, String authorDetails, int readingDuration, String bookID, String readingStatus)
    {
        this.bookName = bookName;
        this.ISBN = ISBN;
        CheckBookDescription(bookDescription);
        this.authorDetails = authorDetails;
        this.readingDuration = readingDuration;
        CreateBookID(bookName, ISBN, authorDetails);
        this.readingStatus = readingStatus;
    }

    private boolean CheckBookDescription(String bookDescription) 
    {
        if(bookDescription.length() <= 100)
        {
            return true;
        }
        else return false;
    }

    //first 2 letters of the book, #, ISBN, #, last 2 letters of the authors first name
    private String CreateBookID(String bName, String ISBN, String aName) 
    {
        String output;
        
        if(aName.contains(" ") && bName.length() > 2)
        {
            int space = aName.indexOf(" ");
            
            //syntax: variableName.substring(int start, int end)
            String authorID = aName.substring(space-2, space).toUpperCase();
            String nameID = bName.substring(0, 2).toUpperCase();
            
            //construct the output
            output = nameID + "#" + ISBN + "#" + authorID;
            bookID = output;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "An Error has occurred.");
        }
        return bookID;
    }
    
    //string manipulation
    public String PrintBookDetails()
    {
        StringBuilder display = new StringBuilder();
        //append, toString...
        display.append("\nStatus: ").append(readingStatus);
        display.append("\nBook Author: ").append(authorDetails);
        display.append("\nISBN: ").append(ISBN);
        display.append("\nBook Name: ").append(bookName);
        display.append("\nBook Description: ").append(bookDescription);
        display.append("\nBook ID: ").append(bookID);
        display.append("\nReading Duration: ").append(readingDuration);
        
        return display.toString();
    }
    
    public int ReturnTotalHours(int duration)
    {
            sum += duration;
            readingDuration = sum;
            return sum;
    }
    
    public String CalculateStatus(int bookStat)
    {
        while(true)
        {
            switch (bookStat)
            {
                case 1:
                    readingStatus = "ON MY BOOKSHELF";
                    break;
                    
                case 2:
                    readingStatus = "COMPLETED";
                    break;
                    
                case 3:
                    readingStatus = "CURRENTLY READING";
                    break;
                    
                default:
                    //JOptionPane.showMessageDialog(null, "The value you have entered is incorrect. Please enter a number.");
                    bookStat = Integer.parseInt(JOptionPane.showInputDialog("Please enter the status of the book: \n1. ON MY BOOKSHELF\n2. COMPLETED\n3. CURRENTLY READING"));
                    break;
            }
        }
    }
    
    public void LibraryMenu()
    {
        int option = Integer.parseInt(JOptionPane.showInputDialog("Please select an option: \n1. Add Book\n2. Show Report\n 3. Quit"));
        
        while(!(option == 3))
        {
            try
            {
                switch(option)
                {
                    case 1:
                        int numBooks =Integer.parseInt(JOptionPane.showInputDialog("How many books would you like to enter?"));
                        
                        for(int x=0; x< numBooks; x++)
                        {

                            //user enters the name of the book
                            String bName = JOptionPane.showInputDialog("Please enter the name of the book");
                            
                            //user enters the ISBN number
                            String isbn = JOptionPane.showInputDialog("Please enter the ISBN number of " + bName);
                            
                            //user enters the first name and last name of the author
                            String aDetails = JOptionPane.showInputDialog("Please enter the author of  " + bName);
                                                        
                            //user enters the reading duration of the book
                            int duration = Integer.parseInt(JOptionPane.showInputDialog("Please enter the estimated reading duration of " + bName + " (hours)"));
                                    
                            //user enters the status of the book
                            String rStatus = JOptionPane.showInputDialog("Please enter the status of the book:\n1. On my bookshelf\n2. Completed\n3. Currently reading");

                            //user enters a brief description of the book
                            String description = JOptionPane.showInputDialog("Please enter a brief description of  " + bName);
                            
                            //checks if the description meets the requirements
                            if(CheckBookDescription(description))
                            {
                                JOptionPane.showMessageDialog(null, "Book successfully captured");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Please enter a brief description of  " + bName + "(please ensure it is less that 100 characters)");
                            }
                            
                            addBook(bName, isbn, description, aDetails, duration, bookID, rStatus);
                            JOptionPane.showMessageDialog(null, PrintBookDetails());
                        }
                        break;
                        
                    case 2:
                        JOptionPane.showMessageDialog (null, "COMING SOON!");
                        break;
                        
                    case 3:
                        System.exit(0);
                        break;
                        
                    default:
                        System.exit(0);
                }
            }
            catch(NumberFormatException n)
            {
                JOptionPane.showInputDialog(null, "Error: " + n + " Invalid value please enter a number");
            }
           
            option = Integer.parseInt(JOptionPane.showInputDialog("Please select an option: \n1. Add Book\n2. Show Report\n 3. Quit"));

        }
    }
}
















