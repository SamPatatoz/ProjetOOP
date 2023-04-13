import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Writer class writes user data to a file, including descriptions and questions for a decision
 * tree.
 */
public class Writer {
    private Tree tree;
    private String filename;
    private char answer;
    private Node currentNode;

    // This is a constructor for the Writer class that takes in a Tree object, a filename, a character
    // answer, and a Node object currentNode
    public Writer(Tree tree, String filename, char answer, Node currentNode){
        if(tree == null || filename == null || currentNode == null){
            System.out.println("ERROR : " + filename + 
                               "is not found or tree/node is/are not initialize !");
            System.exit(-1);
        }
        this.tree = tree;
        this.filename = filename;
        this.answer = answer;
        this.currentNode = currentNode;
    }

    /**
     * This function adds a user description to a list of strings.
     * 
     * @param description A string representing the user's description that needs to be written.
     * @param lines The "lines" parameter is a List of Strings that represents the lines of text that
     * will be written to a file or displayed on the screen. The "write_user_description" method adds a
     * new line to this list, which includes the user's description with an equals sign (=) added to
     * the beginning
     */
    private void write_user_description(String description, List<String> lines){
        description = "= " + description;
        lines.add(description);
    }

    /**
     * This function writes a user's question to a file and updates the parent node's line number.
     * 
     * @param question The question to be asked to the user as a String.
     * @param lines A list of strings representing the lines in a file.
     * @param answer The answer to the user's question, represented as a character (either 'Y' for yes
     * or 'N' for no).
     */
    private void write_user_question(String question, List<String> lines, char answer){
        String childLeft = null;
        String childRight = null;
        final char YES = 'Y';

        FileData dataNode = currentNode.get_data(currentNode);
        int lineNode = dataNode.get_lineInFile(dataNode);
        FileData dataParent = currentNode.parent.get_data(currentNode.parent);
        String parentLine = lines.get(dataParent.get_lineInFile(dataParent));
        String newParentLine = parentLine.replace(Integer.toString(lineNode), 
                                                Integer.toString(lines.size()));
        lines.set(dataParent.get_lineInFile(dataParent), newParentLine);

        if(answer == YES){
            childLeft = Integer.toString(lines.size() - 1);
            childRight = Integer.toString(lineNode);
        }
        else{
            childRight = Integer.toString(lines.size() - 1);
            childLeft = Integer.toString(lineNode);
        }
        
        question = "? "+ childLeft + " " + childRight + " " + question;
        lines.add(question);
    }

    /**
     * This Java function reads data from a file, updates the first line with a new value, writes user
     * description and question to the file, and then writes all the updated data back to the file.
     * 
     * @param question A string representing the question that the user wants to add to the data file.
     * @param description A String variable that contains the user's description or explanation for the
     * question they are asking.
     */
    public void write_user_data(String question, String description) throws IOException{
        //Read all the file and stock all the data in a list
        BufferedReader rd = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<>();
        String line = rd.readLine();
        while (line != null) {
            lines.add(line);
            line = rd.readLine();
        }
        rd.close();

        int nbrOfNode = tree.get_nbrOfNode(tree);
        final int FIRSTLINE = 0;
        String introLine = lines.get(FIRSTLINE);
        String newIntroLine = introLine.replace(Integer.toString(nbrOfNode), 
                                                Integer.toString(nbrOfNode + 2));
        lines.set(FIRSTLINE, newIntroLine);
        
        write_user_description(description, lines);
        write_user_question(question, lines, answer);
        
        FileWriter fw = new FileWriter(filename);
	    BufferedWriter bw = new BufferedWriter(fw);
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
        bw.close();
    }
    
}