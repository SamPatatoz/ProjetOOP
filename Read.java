import java.io.*;
public class Read 
{
    public int read(String filename, BufferedReader br) throws IOException {
 
        int c = 0;             
        // Lire caractère par caractère
        while((c = br.read()) != -1)
        {
            // convertir l'entier en char
            char ch = (char) c;         
            // Afficher le caractère      
            System.out.println(ch);
        }
        
        return 0;
    }

    public int read_numberOfNode(String filename, BufferedReader br) throws IOException{

        int numberOfNode = br.read();
        char caractère = (char) numberOfNode;
        
        //System.out.println(caractère);

        return ((int) caractère) - 48;
    }

    public int read_introduction()

}