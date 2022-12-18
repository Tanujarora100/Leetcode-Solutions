  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int colorArray[] = new int[V];
        Arrays.fill(colorArray, -1);
        for (int i = 0; i < V; i++) {
            if (colorArray[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colorArray[i] = 1;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (Integer it : adj.get(curr)) {
                        if (colorArray[it] == -1) {
                            colorArray[it] = 1 - colorArray[curr];
                            q.add(it);
                        } else if (colorArray[it] == colorArray[curr])
                            return false;

                    }
                }

            }
        }
        return true;
    }
