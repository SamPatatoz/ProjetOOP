/**
 * The `Tree` class creates and manipulates a binary tree data structure using an array of `Node`
 * objects.
 */
public class Tree {
    private Node[] node;
    private int nbrOfNode;

    // This is a constructor for the `Tree` class that takes an integer `nbrOfNode` as input. It sets
    // the `nbrOfNode` instance variable of the `Tree` object to the value of `nbrOfNode`, and
    // initializes the `node` array with a length equal to `nbrOfNode`.
    public Tree(int nbrOfNode){
        this.nbrOfNode = nbrOfNode;
        node = new Node[this.nbrOfNode];
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
     * This function creates a complete binary tree from an array of file data.
     * 
     * @param tree The original tree that the complete tree will be based on.
     * @param data an array of FileData objects that contain the data to be stored in each node of the
     * tree.
     * @return The method is returning a Tree object.
     */
    public Tree create_complete_tree(Tree tree, FileData[] data){
        int nbrOfNode = tree.nbrOfNode;
        Tree treeTemp = new Tree(nbrOfNode);
        final int root = 0;

        //store data in each node
        for(int i = root; i < nbrOfNode; i++){
            treeTemp.node[i] = new Node(data[i]);
        }

        final int left = 0;
        final int right = 1;
        //set the children for each node
        for(int i = root; i < nbrOfNode; i++){
            //check if not a leaf
            if(!(treeTemp.node[i].is_leaf(treeTemp.node[i]))){
                FileData tempData = treeTemp.node[i].get_data(treeTemp.node[i]);

                int leftNode = tempData.get_child(tempData, left);
                int rightNode = tempData.get_child(tempData, right);

                treeTemp.node[i].left = treeTemp.node[leftNode];
                treeTemp.node[i].right = treeTemp.node[rightNode];
            }
        }

        tree = treeTemp;
        return tree;
    }
}

