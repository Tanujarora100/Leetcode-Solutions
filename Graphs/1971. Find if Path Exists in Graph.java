  public boolean validPath(int n, int[][] edges, int s, int d) {
        if (s == d)
            return true;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        for (int i = 0; i < edges.length; i++)
            addEdge(adj, edges[i][0], edges[i][1]);

        return bfs(adj, s, d);

    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> adj, int s, int d) {
        boolean isVisited[] = new boolean[adj.size()];
        isVisited[s] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == d)
                return true;
            for (int v : adj.get(u))
                if (isVisited[v] == false) {
                    System.out.print(v + " ");

                    q.add(v);
                    isVisited[v] = true;
                }
        }
        return false;

    }
