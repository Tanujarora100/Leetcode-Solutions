    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] visited = new boolean[A + 1];
        for (int i = 0; i <= A; i++)
            visited[i] = false;

        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                if (dfsutil(i, visited, -1, B) == 1)
                    return 1;
            }
        }
        return 0;
    }

    public int dfsutil(int v, boolean[] visited, int parent, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;

        for (Integer i : adj.get(v)) {
            if (!visited[i]) {
                if (dfsutil(i, visited, v, adj) == 1) {
                    return 1;
                }
            } else if (visited[i] == true) {
                if (parent != i)
                    return 1;
            }
        }
        return 0;
    }
