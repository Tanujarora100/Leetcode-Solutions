    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (findCycle(i, adj, visited) == true)
                    return true;
            }
            // Sending the Starting index of each Component one by One.
        }
        return false;
    }

    private boolean findCycle(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(v, -1));
        visited[v] = true;
        while (!q.isEmpty()) {
            int curr = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for (Integer it : adj.get(curr)) {
                if (visited[it] == false) {
                    q.add(new Pair(it, curr));
                    visited[it] = true;
                } else if (visited[it] == true) {
                    if (parent != it)
                        return true;
                }
            }
        }
        return false;
    }
