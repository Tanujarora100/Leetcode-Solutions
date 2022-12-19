   List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
       List<List<Integer>> revadj = new ArrayList<>();
        int indegree[] = new int [V];
        for(int i =0;i<V ;i++)
            revadj.add(new ArrayList<>());

        for(int i =0;i<V ;i++){
            for(Integer it : adj.get(i)){
                revadj.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safenode = new ArrayList<>();

        for(int i =0; i< V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safenode.add(node);
            for(Integer it : revadj.get(node)){
               indegree[it]--;
               if(indegree[it] == 0){
                   q.add(it);
               }
            }
        }

        Collections.sort(safenode);
        return safenode;
    }
