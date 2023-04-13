import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Writer {
    private Tree tree;
    private String filename;
    private char answer;
    private Node currentNode;

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

    private void write_user_description(String description, List<String> lines){
        description = "= " + description;
        lines.add(description);
    }

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