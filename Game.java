import java.io.*;
public class Game {
    public static void main(final String[] args) throws IOException {
        // This code is checking if the length of the `args` array is greater than 0
        if(!(args.length > 0)){
            
            System.out.println("ERROR : missing argument (Input .txt file)");
            System.exit(-1);
        }
         
        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Reader rd = new Reader(br);

        int nbrOfNode = rd.read_numberOfNodes();
        if(nbrOfNode < 1){
            System.out.println("ERROR : Number of nodes not valid in file!");
            System.exit(-1);
        }
        String intro = rd.read_introduction();
        if(intro == null){
            System.out.println("ERROR : Introuction not valid in file!");
            System.exit(-1);
        }

        FileData[] data = new FileData[nbrOfNode];
        data = rd.read_fileData(data, nbrOfNode);
        
        Tree tree = new Tree(nbrOfNode);
        tree = tree.create_complete_tree(tree, data);
        tree.play_tree(tree, intro);
    }
}