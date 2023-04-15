import java.io.IOException;
import java.util.Scanner;
/**
 * The `Tree` class creates and manipulates a binary tree data structure using an array of `Node`
 * objects.
 */
public class Tree {
    private Node[] node;
    private int nbrOfNode;
    private Node root;

    // This is a constructor for the `Tree` class that takes an integer `nbrOfNode` as a parameter.
    public Tree(int nbrOfNode){
        this.nbrOfNode = nbrOfNode;
        node = new Node[this.nbrOfNode];
        root = null;
    }

    /**
     * The function returns the number of nodes in a given tree.
     * 
     * @param tree The parameter "tree" is an object of the class "Tree". The method "get_nbrOfNode"
     * takes this object as input and returns the number of nodes in the tree.
     * @return The method `get_nbrOfNode` is returning an integer value which represents the number of
     * nodes in the `Tree` object passed as a parameter.
     */
    public int get_nbrOfNode(Tree tree){
        return tree.nbrOfNode;
    }

    /**
     * This function returns the root node of a given tree.
     * 
     * @param tree The parameter "tree" is an object of the class "Tree".
     * @return The method `get_root` is returning the root node of the `Tree` object passed as a
     * parameter.
     */
    public Node get_root(Tree tree){
        return tree.root;
    }

    /**
     * The function finds the root node of a given node in a tree data structure.
     * 
     * @param node The starting node from which we want to find the root node of its tree.
     * @return the root node of the tree that the input node belongs to.
     */
    public Node find_root(Tree tree){
        Node currentNode = tree.node[0];
        while(currentNode.parent != null){
            currentNode = currentNode.parent;
        }
        return currentNode;
    }

    /**
     * This function creates a complete binary tree from an array of file data.
     * 
     * @param tree The original tree that the complete tree will be based on.
     * @param data an array of FileData objects that contain the data to be stored in each node of the
     * tree.
     * @return The method is returning a Tree object.
     */
    public Tree create_complete_tree(Tree tree, FileData[] data){
        int nbrOfNode = tree.nbrOfNode;
        //store data in each node
        for(int i = 0; i < nbrOfNode; i++){
            tree.node[i] = new Node(data[i]);
        }
        final int left = 0;
        final int right = 1;
        FileData tempData = null;
        //set the children for each node
        for(int i = 0; i < nbrOfNode; i++){
            //check if not a leaf and then set the children
            if(!(tree.node[i].is_leaf(tree.node[i]))){
                tempData = tree.node[i].get_data(tree.node[i]);
                //set the children of the current node
                tree.node[i].intLeft = tempData.get_child(tempData, left);
                tree.node[i].intRight = tempData.get_child(tempData, right);
                int leftNode = tree.node[i].intLeft;
                int rightNode = tree.node[i].intRight;
                tree.node[i].left = tree.node[leftNode - 1];
                tree.node[i].right = tree.node[rightNode - 1];
                //set the parent to the children
                tree.node[i].left.parent = tree.node[i];
                tree.node[i].right.parent = tree.node[i];
            }
        }
        tree.root = find_root(tree);
        return tree;
    }

    /**
     * This function plays a game where the user answers yes or no questions to guess a chosen item,
     * and if the program fails to guess, it asks the user for a distinguishing question.
     * 
     * @param tree The tree object that represents the game's decision tree structure.
     * @param intro A String representing the introduction to the game, typically the player's name or
     * a greeting.
     * @throws IOException
     */
    public void play_tree(Tree tree, String intro, String filename) throws IOException{
        System.out.println("Welcome to the game !");
        System.out.println(intro + ", and then press <return>.");

        Node currentNode = tree.root;
        char answer;
        final char YES = 'Y';
        final char NO = 'N';
        Scanner sc = new Scanner(System.in);

        while(currentNode != null){
            if(currentNode.is_leaf(currentNode))
                System.out.println("Is it " + currentNode.get_description(currentNode) + " ? (Y/N)");
            else
                System.out.println(currentNode.get_description(currentNode) + " ? (Y/N)");
            System.out.printf("> ");
            answer = sc.next().charAt(0);
            while(answer != YES && answer != NO){
                System.out.println("WARNING: Please choose between 'Y' or 'N'");
                System.out.println(currentNode.get_description(currentNode) + " (Y/N)");
                System.out.printf("> ");
                answer = sc.next().charAt(0);
            }
            
            if(answer == YES){
                if(currentNode.is_leaf(currentNode))
                    System.out.println("I have won !");
                currentNode = currentNode.left;
            }
            else if (answer == NO){
                if(currentNode.is_leaf(currentNode)){
                    //ask the choosen answer
                    System.out.println("I am unable to guess; you have won!");
                    System.out.println("What did you choose?");
                    System.out.printf("> ");
                    sc.nextLine();
                    String winnerDescription = sc.nextLine();
                    
                    //Ask the question to distinguish
                    System.out.println("What question could I ask to distinguish " 
                    + winnerDescription + " from " 
                    + currentNode.get_description(currentNode) + " ?");
                    System.out.printf("> ");
                    String winnerQuestion = sc.nextLine();

                    //Yes or No for the question to distinguish
                    System.out.println("For " + winnerDescription 
                                        + ", would you answer yes or no to this question(Y/N)?");
                    System.out.printf("> ");  
                    answer = sc.next().charAt(0);                 
                    while(answer != YES && answer != NO){
                        System.out.println("WARNING: Please choose between 'Y' or 'N'");
                        System.out.printf("> ");
                        answer = sc.next().charAt(0);
                    }
                    //Write in the file the new data from the user
                    Writer wt = new Writer(tree, filename, answer, currentNode);
                    wt.write_user_data(winnerQuestion, winnerDescription);
                    System.out.println("Thank you !");
                }
                currentNode = currentNode.right;
            }
            
        }
        sc.close();
    }
    
}

