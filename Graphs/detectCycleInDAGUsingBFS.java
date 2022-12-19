    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();

            cnt++;
            for (int it : adj.get(curr)) {
                indegree[it]--;

                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return cnt == V ? false : true;
    }
