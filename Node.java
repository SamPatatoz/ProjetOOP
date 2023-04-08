/**
 * The `Node` class represents a node in a tree data structure and contains information about its left
 * and right children, whether it is a leaf node, and the data it holds.
 */
public class Node {
    public Node right;
    public Node left;
    private boolean isLeaf;
    private FileData data;

    // This is a constructor for the `Node` class that takes a `FileData` object as a parameter. It
    // sets the `leaf` variable to `true` if the `is_leaf` method of the `FileData` object returns
    // `true`, and `false` otherwise. It then sets the `data` variable of the `Node` object to the
    // `FileData` object passed as a parameter.
    public Node(FileData data){
        char type = data.get_type(data);
        if(type == '=')
            isLeaf = true;
        else
            isLeaf = false;
        this.data = data;
        right = left = null;
    }

    /**
     * The function checks if a given node is a leaf node or not.
     * 
     * @param node The parameter "node" is an object of the class "Node". This method checks whether
     * the given node is a leaf node or not. A leaf node is a node that does not have any child nodes.
     * The method returns a boolean value of true if the given node is a leaf node, and
     * @return The method `is_leaf` is returning a boolean value indicating whether the input `Node`
     * object is a leaf node or not. If the `isLeaf` attribute of the `Node` object is `true`, then the
     * method will return `true`, indicating that the node is a leaf node. Otherwise, it will return
     * `false`, indicating that the node is not a leaf node.
     */
    public boolean is_leaf(Node node){
        return node.isLeaf;
    }

    /**
     * The function returns the data of a given node.
     * 
     * @param node The parameter "node" is of type "Node", which is likely a custom class representing
     * a node in a data structure such as a linked list or a tree. The method "get_data" takes in a
     * node object and returns the data associated with that node. The data could be of any type
     * @return The method `get_data` is returning an object of type `FileData`.
     */
    public FileData get_data(Node node){
        return node.data;
    }
}
