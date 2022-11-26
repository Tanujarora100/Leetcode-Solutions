
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;

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

public class iterativePostOrder {

    static List<Integer> preOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            result.add(root.data);

            if (root.left != null)
                st.push(root.left);
            if (root.right != null) {
                st.push(root.right);
            }
        }
        Collections.reverse(result); // O(N)
        return result;
    }
    // Collections reverse method reverses the element of ArrayList in linear time
    // i.e time complexity is O(n).
    // Collections reverse method accepts a List type as an argument.
    // So any List type can be reversed i.e LinkedList, Vector or any custom implementation.
