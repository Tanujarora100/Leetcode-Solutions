    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int colorArray[] = new int[V];
        Arrays.fill(colorArray, -1);
        for (int i = 0; i < V; i++) {
            if (colorArray[i] == -1) {
                if (checkGraph(adj, i, colorArray) == false)
                    return false;
            }
        }
        return true;
    }

    private boolean checkGraph(ArrayList<ArrayList<Integer>> adj, int i, int[] colorArray) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        colorArray[i] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Integer it : adj.get(curr)) {
                if (colorArray[it] == -1) {
                    // It is not colour-1 coz if it is zero -1 it is -1 again and then the graph
                    // will be again visited.
                    colorArray[it] = 1 - colorArray[curr];
                    q.add(it);
                } else if (colorArray[it] == colorArray[curr])
                    return false;

            }
        }
        return true;
    }
