import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//Pair Class and Node class
class Pair {
    int hd;
    Node node;

    public Pair(int hd, Node node) {
        this.node = node;
        this.hd = hd;
    }

    class Node {
        int data;
        Node right;
        Node left;

        public Node(int data, Node root) {
            this.data = data;
            root = null;
        }
    }

    public class topView {

        static ArrayList<Integer> topView2(Node root) {
            Queue<Pair> q = new LinkedList<>();
            Map<Integer, Integer> map = new TreeMap<>();
            q.add(new Pair(0, root));
            while (!q.isEmpty()) {
                Pair temp = q.poll();
                // Temp mei node aagya root
                // Uss Node ke Horizontal distance ko access karne ke liye
                // Pair class ka HD nikal lo and Root ke data ke liye use the Node object of the
                // Node Class to access Data
                int rootData = temp.node.data;
                if (!map.containsKey(temp.hd)) {
                    map.put(temp.hd, rootData);
                }
                // Horizontal Distance add karo left vala and left vala node daal do.
                // Pair class ke object se mai Node class ke Attributes access kr raha hu.
                if (temp.node.left != null) {
                    q.add(new Pair(temp.hd - 1, temp.node.left));
                }
                if (temp.node.right != null) {
                    q.add(new Pair(temp.hd + 1, temp.node.right));
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }
            return ans;

        }
