import java.io.*;
/**
 * The Reader class reads and processes data from an input stream and file, and returns the data as an
 * array of FileData objects.
 */
public class Reader 
{
    private BufferedReader br;

    // This is a constructor for the `Reader` class that takes a `BufferedReader` object as a
    // parameter.
    public Reader(BufferedReader br){
        if(br == null){
            System.out.println("ERROR : Buffered Reader not initialize !");
            System.exit(-1);
        }
        this.br = br;
    }

    /**
     * This function reads the number of nodes from an input stream
     * 
     * @return The method is returning an integer value which represents the number of nodes.
     */
    public int read_numberOfNodes() throws IOException{
        int numberOfNode = br.read();
        char character = (char) numberOfNode;
        final int conversion = 48;
        
        return ((int) character) - conversion;
    }

    /**
     * This function reads a line of text from an input stream and returns it as a string.
     * 
     * @return The method `read_introduction()` is returning a `String` variable named `description`.
     */
    public String read_introduction() throws IOException{
        String description = br.readLine();
        return description;
    }

    /**
     * The function checks the number of nodes in a file and returns the count.
     * 
     * @param filename The filename parameter is a String that represents the name of the file that
     * needs to be read.
     * @param nbrOfNode The parameter nbrOfNode is not used in the method and is therefore irrelevant.
     * It is not necessary for the method to function properly.
     * @return The method is returning an integer value which represents the number of lines in the
     * file (specified by the filename parameter) minus one. This value is obtained by counting the
     * number of lines in the file using a BufferedReader and FileReader, and then subtracting one from
     * the total count.
     */
    public int check_nbrOfNodes(String filename) throws FileNotFoundException{
        FileReader fr = new FileReader(filename);
        int nbrOfLines = 0;
        try (BufferedReader br = new BufferedReader(fr)) {
            while(br.readLine() != null)
                nbrOfLines++;
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nbrOfLines - 1;
    }

    /**
     * This function reads data from a file and stores it in an array of FileData objects.
     * 
     * @param data an array of FileData objects that will be populated with data read from a file
     * @param nbrOfNode The number of nodes to be read from the file.
     * @return The method is returning an array of FileData objects.
     */
    public FileData[] read_fileData(FileData[] data, int nbrOfNode) throws IOException{
        int x = 0;
        final char internal = '?';
        char typeOfNode;
        int childLeft;
        int childRight;
        int lineInFile;
        String nodeDescription;

        while(x < nbrOfNode){
            typeOfNode = (char) br.read();
            br.read();
            String line = br.readLine();
            String[] words = line.split(" ");
            int i;
            if(typeOfNode == internal){
                childLeft = Integer.parseInt(words[0]);
                childRight = Integer.parseInt(words[1]);
                nodeDescription = words[2];
                i = 3;
                if(childLeft < 1 || childRight < 1){
                    System.out.println("ERROR: Child value not valid (< 1) in line ("
                                        +line+")");
                    System.exit(-1);
                }
                if(childLeft > nbrOfNode || childRight > nbrOfNode){
                    System.out.println("ERROR: Child value not valid "
                                       +"(> Number of nodes) in line ("+line+")");
                    System.exit(-1);
                }
            }
            else{
                childLeft = -1;
                childRight = -1;
                nodeDescription = words[0];
                i = 1;
            }
            while(i < words.length){
                nodeDescription = nodeDescription + " " + words[i];
                i++;
            }
            
            lineInFile = x + 1;
            data[x] = new FileData(typeOfNode, childLeft, 
                                   childRight, nodeDescription, lineInFile);
            x++;
        }

        return data;
    }

}