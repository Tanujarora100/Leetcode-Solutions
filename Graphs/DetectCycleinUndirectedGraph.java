package Graph.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class detectCycleInUndirectedGraph {
    /*
     * 
     * 1-create an Adjacency List for the Graph.
     * 2-Visit the Equidistant Nodes at each level using BFS.
     * 3-If Two Ways are going to the same node that means there is a cycle present.
     * 4- Define a Queue and Insert the First Node in the Queue(1,T)
     * 5-Create a Visited Array and Mark them as False.
     * 6-Someone at the same level must be visitng the next node and if someone else
     * is also reaching
     * means there is a cycle present at the same.
     */
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int parent[]) {
        Queue<Node> q = new LinkedList<>(); // BFS
        q.add(new Node(s, -1));
        vis[s] = true;

        // until the queue is empty
        while (!q.isEmpty()) {
            // source node and its parent node
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // go to all the adjacent nodes
            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }

                // if adjacent node is visited and is not its own parent node
                else if (par != it)
                    return true;
            }
        }

        return false;
    }

    // function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++)
            if (vis[i] == false)
                if (checkForCycle(adj, i, vis, parent))
                    return true;

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        detectCycleInUndirectedGraph obj = new detectCycleInUndirectedGraph();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}

class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
