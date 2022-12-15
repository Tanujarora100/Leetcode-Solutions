package Graph;

import java.util.Scanner;

public class dfs {
    public static void dfsTraversal(int[][] adjMatrix, int currentVertex, boolean[] visited) {
        System.out.print(currentVertex + " ");
        visited[currentVertex] = true;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
                // Means it is a Neighbour
                dfsTraversal(adjMatrix, i, visited);
            }
        }
    }

    public static void dfsTraversal(int[][] adjMatrix) {
        boolean visited[] = new boolean[adjMatrix.length];
        dfsTraversal(adjMatrix, 0, visited);
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
        dfsTraversal(adjMatrix);
    }
}
