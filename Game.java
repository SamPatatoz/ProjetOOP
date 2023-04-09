public class Game {
    public static void main(final String[] args) {
        // This code is checking if the length of the `args` array is greater than 0
        if(!(args.length > 0)){
            
            System.out.println("ERROR : missing argument (Input .txt file)");
            System.exit(-1);
        }
        int nbrOfNode = 5;
        FileData[] data = new FileData[nbrOfNode];
        data[1] = new FileData('=', -1, -1, "une vache", 2);
        data[0] = new FileData('?', 3, 5, "Poilu ?", 1);
        data[2] = new FileData('=', -1, -1, "un singe", 3); 
        data[3] = new FileData('?', 2, 1, "Est ce qu'il a 4 pattes ?", 4);
        data[4] = new FileData('=', -1, -1, "une femme", 5);
        
        Tree tree = new Tree(nbrOfNode);
        tree = tree.create_complete_tree(tree, data);
        tree.play_tree(tree, "Please choose an animal");
    }
}