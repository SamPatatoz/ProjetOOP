/**
 * The `Node` class represents a node in a data structure and contains attributes and methods for
 * accessing and manipulating the data and structure of the node.
 */
public class Node {
    public Node right;
    public Node left;
    public Node parent;
    private boolean isLeaf;
    private FileData data;
    private String description;

    public Node(FileData data){
        char type = data.get_type(data);
        if(type == '=')
            isLeaf = true;
        else
            isLeaf = false;
        this.data = data;
        right = left = null;
        this.description = data.get_description(data);
        parent = null;  
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

    /**
     * The function returns the description of a given node.
     * 
     * @param node The parameter "node" is an object of the class "Node". It is being passed as an
     * argument to the method "get_description". The method returns the description of the node object.
     * @return The method `get_description` is returning the description of the `Node` object passed as
     * a parameter.
     */
    public String get_description(Node node){
        return node.description;
    }

}
