import java.util.*;
 
abstract class Node implements Comparable<Node> {
    
  	public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right; 
    public Node(int freq) { 
    	frequency = freq;
   	}
 
    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
  
}
 
class HuffmanLeaf extends Node {
    
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
  
}
 
class HuffmanNode extends Node {
    
    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 

    void decode(String s, Node root) {
        Node curr = root;
    for (int i = 0; i < s.length(); i++) {
        curr = (s.charAt(i) == '0') ? curr.left : curr.right;
        
        if (curr.left == null && curr.right == null) {
            System.out.print(curr.data);
            curr = root;
        }
    }


    }

