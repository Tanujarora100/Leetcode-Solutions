package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
    public static void bfsTraversal(int[][] adjMatrix) {
        Queue<Integer> vertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        visited[0] = true;
        vertices.add(0);
        while (!vertices.isEmpty()) {
            int curr = vertices.poll();
            System.out.print(curr + " ");
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[curr][i] == 1 && visited[i] == false) {
                    // Checking the Row for the current neighbour in the matrix
                    // 0--> 0, 1,1,0,0 like that.
                    vertices.add(i);
                    // Adding the Neighbour into the queue.
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < e; i++) {
            int V1 = sc.nextInt();
            int V2 = sc.nextInt();
            adjMatrix[V1][V2] = 1;
            adjMatrix[V2][V1] = 1;
        }

        sc.close();
        bfsTraversal(adjMatrix);
    }
}
