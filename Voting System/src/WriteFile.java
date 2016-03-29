import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFile 
{ 
    private String fileName;
    private FileWriter myFileWriter;
    private BufferedWriter myBufferedWriter;
    private boolean fileExists;
     
    public WriteFile(String lname, String fname)
    {
        fileName = lname + "_" + fname + "_ballot.txt";
        fileExists = new File(fileName).exists();
        myFileWriter = null;
        myBufferedWriter = null;
    }
   
    public boolean alreadyVoted()
    {
        return(fileExists);
    }
    public void createFile(String text)
    {
        try
        {
            //Create a output file
            myFileWriter = new FileWriter(fileName);
            myBufferedWriter = new BufferedWriter(myFileWriter);
            myBufferedWriter.write(text);
            myBufferedWriter.close();
        }
        catch (Exception error)
        {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
