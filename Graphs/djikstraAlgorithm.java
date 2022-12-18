class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        pq.add(new Pair(0, S));
        while (!pq.isEmpty()) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (dis + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance;
    }
    /*
     * Note: This set approach cannot be implemented in JAVA by using TreeSet or
     * HashSet. For implementing Dijkstra’s Algorithm in JAVA
     * we would use a priority queue only.
     */
}
