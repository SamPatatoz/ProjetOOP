public class FileData {
    private char typeOfNode;
    private int childLeft;
    private int childRight;
    private String nodeDescription;

    /**
     * This function returns the type of node for a given file data.
     * 
     * @param data The parameter "data" is an object of type "FileData" which contains information
     * about a file node in a file system. The method "get_type" takes this object as input and returns
     * the type of the file node as a character.
     * @return The method `get_type` is returning the `typeOfNode` property of the `FileData` object
     * passed as a parameter. The type of the returned value is `char`. If return '?' => internal node, 
     * else => leaf node
     */
    public char get_type(FileData data){
        return data.typeOfNode;
    }

    /**
     * This function returns the child node of a given node in a binary tree represented by a FileData
     * object.
     * 
     * @param data an object of type FileData, which likely contains information about a file or
     * directory, including its children nodes.
     * @param node The parameter "node" is an integer representing the node for which we want to get
     * the child. If the value of "node" is 0, then we want to get the left child of the root node. If
     * the value of "node" is 1, then we want to get
     * @return The method `get_child` is returning an integer value which represents the child node of
     * a given `node` in a binary tree. If `node` is 0, it returns the value of `data.childLeft`,
     * otherwise it returns the value of `data.childRight`.
     */
    public int get_child(FileData data, int node){
        if(node == 0)
            return data.childLeft;
        else
            return data.childRight;
    }

    /**
     * The function returns the node description of a given file data object.
     * 
     * @param data an object of type FileData, which contains information about a node in a file.
     * @return The method `get_value` is returning the `nodeDescription` attribute of the `FileData`
     * object passed as a parameter.
     */
    public String get_value(FileData data){
        return data.nodeDescription;
    }
}
