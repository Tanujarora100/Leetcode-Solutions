    public boolean isBipartite(int[][] graph) {
        int[] colors= new int[graph.length];
        Arrays.fill(colors,-1);
       for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) { //if not yet coloured.
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1; //color it with blue
                while (!q.isEmpty()) {
                    int cur = q.poll(); //start polling the current node
                    for (int x : graph[cur]) {
                        if (colors[x] == -1) { //if not yet colored
                            colors[x] = 1-colors[cur]; 
                            q.offer(x);
                        } else if (colors[x]== colors[cur])
                            return false;
                    }
                }

            }
        }
        return true;
    }
