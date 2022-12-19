class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         Queue<Integer> q = new LinkedList<>();
        int toposort[] = new int[numCourses];
        int indegree[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
       for (int i = 0; i <numCourses ; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
                // Storing all the indegree of the adjacent nodes and adjusting for the zero
                // based indexing.
            }
        }
        for (int i = 0; i < numCourses; i++) {
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
        if (i == numCourses) {
            return toposort;
        }
        int arr[] = {};
        return arr;
    }
}
