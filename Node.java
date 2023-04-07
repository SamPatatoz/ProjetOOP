public class Node {
    public Node right;
    public Node left;
    public String data;
    public boolean leaf;

    public Node(String data){
        this.data = data;
        right = null;
        left = null;
    }
}
