import java.io.*;
public class Reader 
{
    private BufferedReader br;

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