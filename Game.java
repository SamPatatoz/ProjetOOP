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
        if(nbrOfNode < 3){
            System.out.println("ERROR : Number of nodes not valid in file!");
            System.exit(-1);
        }

        String intro = words[1];
        for(int i = 2; i < words.length; i++)
            intro = intro + " " + words[i];
        if(intro == null){
            System.out.println("ERROR : Introuction not valid in file!");
            System.exit(-1);
        }

        FileData[] data = new FileData[nbrOfNode];
        data = rd.read_fileData(data, nbrOfNode);

        br.close();
        
        Tree tree = new Tree(nbrOfNode);
        tree = tree.create_complete_tree(tree, data);
        tree.play_tree(tree, intro, filename);
    }
}