/**
 * The `FileData` class contains methods for retrieving information about a file node in a file system,
 * including its type, child nodes, node description, and whether it is a leaf node.
 */
public class FileData {
    private char typeOfNode;
    private int childLeft;
    private int childRight;
    private int lineInFile;
    private String nodeDescription;

    // This is a constructor for the `FileData` class that takes in five parameters: `type` (a `char`
    // representing the type of node), `cL` (an `int` representing the index of the left child node),
    // `cR` (an `int` representing the index of the right child node), `description` (a `String`
    // representing the description of the node), and `line` (an `int` representing the line number of
    // the node in the file).
    public FileData(char type, int cL, int cR, String description, int line){
        typeOfNode = type;
        nodeDescription = description;
        lineInFile = line;
        if((cL > 0 && cR > 0)){
            childLeft = cL;
            childRight = cR;
        }
        else{
            childLeft = -1;
            childRight = -1;
        }
    }

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
     * The function returns the child node of a given FileData object based on a specified choice.
     * 
     * @param data A variable of type FileData, which likely contains information about a file or
     * directory, including its children.
     * @param choice The choice parameter is an integer that determines which child of the given
     * FileData object to return. If choice is 0, the left child is returned, and if choice is any
     * other integer, the right child is returned.
     * @return The method `get_child` is returning an integer value, which is either the value of
     * `data.childLeft` or `data.childRight` depending on the value of the `choice` parameter. If
     * `choice` is 0, then `data.childLeft` is returned, otherwise `data.childRight` is returned.
     */
    public int get_child(FileData data, int choice){
        if(choice == 0)
            return data.childLeft;
        else
            return data.childRight;
    }

    /**
     * The function returns the line number of a given file data object.
     * 
     * @param data The parameter "data" is of type "FileData", which is likely a custom class that
     * represents some data related to a file. The method "get_lineInFile" is a member of this class
     * and returns the line number in the file where this data is located.
     * @return The method `get_lineInFile` is returning an integer value which represents the line
     * number in a file. The value is obtained from the `lineInFile` field of the `FileData` object
     * passed as a parameter to the method.
     */
    public int get_lineInFile(FileData data){
        return data.lineInFile;
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
