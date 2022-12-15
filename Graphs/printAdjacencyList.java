    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            // V Represents the vertices in the Graph
            ans.add(new ArrayList<Integer>());
            // Adding v-1 ArrayLists to the Main ArrayList of ArrayList
        }

        for (int i = 0; i < V; i++) {
            ans.get(i).add(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                ans.get(i).add(adj.get(i).get(j));
            }
        }
        return ans;
    }
