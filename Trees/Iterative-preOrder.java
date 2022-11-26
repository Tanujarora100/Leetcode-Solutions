import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    Node left;
    Node right;
    int data;

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}

public class iterativePreOrder {

    // Using a Stack Data Structure
    // Algorithm
    /*
     * Whatever is at the root of the tree put that into the stack
     * take out of Stack and print it
     * Then Take right and then take the left--> not the other way around.
     * Last in first out coz pehle left bahar aayega fir
     * The Moment that stack becomes empty
     */

    static List<Integer> preOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            result.add(root.data);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null)
                st.push(root.left);
        }
        return result;
    }

}
