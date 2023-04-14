import java.io.*;
public class Game {
    public static void main(final String[] args) throws IOException {
        // This code is checking if the length of the `args` array is greater than 0
        if(!(args.length > 0)){
            
            System.out.println("ERROR : missing argument (Input .txt file)");
            System.exit(-1);
        }
        
        final String filename = args[0];
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Reader rd = new Reader(br);
        String line = br.readLine();
        String[] words = line.split(" ");

        int nbrOfNode = Integer.parseInt(words[0]);
        //check if number of nodes >= 3
        if(nbrOfNode < 3){
            System.out.println("ERROR : Number of nodes not valid in file! (< 3)");
            System.exit(-1);
        }
        //check the real number of nodes
        else{
            BufferedReader checkBr = new BufferedReader(new FileReader(file));
            Reader check = new Reader(checkBr);
            if(nbrOfNode != check.check_nbrOfNodes(filename)){
                int realNbrOfNode = check.check_nbrOfNodes(filename);
                System.out.println("ERROR : Number of nodes not the same => "
                                    +nbrOfNode+" != "+realNbrOfNode);
                System.exit(-1);
            }
        }

        String intro = null;
        //check if there is an introduction
        if(words.length > 1){
        intro = words[1];
        for(int i = 2; i < words.length; i++)
            intro = intro + " " + words[i];
        }
        else{
            System.out.println("ERROR : Introduction not valid in file!");
            System.exit(-1);
        }

        //get all the data from the input file
        FileData[] data = new FileData[nbrOfNode];
        data = rd.read_fileData(data, nbrOfNode);

        br.close();
        
        //make the tree from data and start the game
        Tree tree = new Tree(nbrOfNode);
        tree = tree.create_complete_tree(tree, data);
        tree.play_tree(tree, intro, filename);
    }
}