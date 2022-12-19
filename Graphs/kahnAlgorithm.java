  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // We do not require the Visited array in the topological sorting coz
        // we are eliminating all the nodes using the indegree array and removing them
        // from the queue.

        Queue<Integer> q = new LinkedList<>();
        int toposort[] = new int[V];
        int indegree[] = new int[V];

        // To Store the topological Sort
        // Storing the Indegree of all the Nodes
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
                // Storing all the indegree of the adjacent nodes and adjusting for the zero
                // based indexing.
            }
        }
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        // Adding all the Zero Indegree in the Queue

        int i = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            toposort[i++] = curr;
            // Storing the elements of the topological sort in the array.
            for (int it : adj.get(curr)) {
                indegree[it]--;
                // Decrease the Indegree of the all the adjacent neighbours in each iteration.
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return toposort;
    }
