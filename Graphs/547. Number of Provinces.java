 public int findCircleNum(int[][] isConnected) {
        // No need to covert it into an Adjacency List and Just use the Matrix to
        // Traverse the Array.
        boolean visited[] = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        if (visited[i] == true)
            return;
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && j != i) {
                dfs(j, isConnected, visited);
            }
        }
    }
// BFS SOLUTION
      public int findCircleNum(int[][] isConnected) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                count++;
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int j = 0; j < isConnected[0].length; j++) {
                        if (visited[j] == false && isConnected[curr][j] == 1) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }

        }
        return count;
    }
