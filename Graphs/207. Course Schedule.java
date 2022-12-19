 Queue<Integer> q = new LinkedList<>();
        int toposort[] = new int[n];
        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
            // Making the adjacencyList for the Graph.
        }
        // To Store the topological Sort
        // Storing the Indegree of all the Nodes
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
                // Storing all the indegree of the adjacent nodes and adjusting for the zero
                // based indexing.
            }
        }
        for (int i = 0; i < n; i++) {
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
        // If i value is equal to vertices which means that everyvertice is added in the
        // array.
        // If coz we are adding first and then incrementing the i value.
        if (i == n) {
            return toposort;
        }
        int arr[] = {};
        return arr;
    }
