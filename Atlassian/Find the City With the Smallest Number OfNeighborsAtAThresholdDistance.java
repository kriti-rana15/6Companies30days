class Pair implements Comparable<Pair> {
    int n;
    int weight;
    public Pair(int n, int weight) {
        this.n = n;
        this.weight = weight;
    }
    @Override
    public int compareTo(Pair p2) {
        return this.weight - p2.weight; // Min-Heap Priority Queue
    }
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int src = 0; src < n; src++) {
            // Perform Dijkstra for each city as the source
            int reachable = dijkstra(n, graph, src, distanceThreshold);
            if (reachable <= minReachable) {
                minReachable = reachable;
                resultCity = src; // Update the city with the smallest ID if tie
            }
        }

        return resultCity;
    }

    private int dijkstra(int n, ArrayList<ArrayList<Pair>> graph, int src, int distanceThreshold) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int currNode = curr.n;

            if (visited[currNode]) continue;
            visited[currNode] = true;

            for (Pair neighbor : graph.get(currNode)) {
                int currNode = neighbor.n;
                int weight = neighbor.weight;

                if (dist[currNode] + weight < dist[currNode]) {
                    dist[currNode] = dist[currNode] + weight;
                    pq.add(new Pair(currNode, dist[currNode]));
                }
            }
        }
        int count = 0;
        for (int d : dist) {
            if (d <= distanceThreshold) count++;
        }
        return count;
    }
}
