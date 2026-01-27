class Solution {
    static class P {
        int first, second;

        P(int f, int s) {
            first = f; // distance
            second = s; // node
        }
    }

    public int minCost(int n, int[][] edges) {

        // Adjacency list
        HashMap<Integer, List<P>> adj = new HashMap<>();

        // Initialize empty list for all nodes...
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0]; // starting node
            int v = edge[1]; // ending node
            int wt = edge[2]; // weight (cost) of the edge

            adj.get(u).add(new P(v, wt));
            adj.get(v).add(new P(u, 2 * wt)); // reversed edge
        }

        // Min-heap based on distance...
        PriorityQueue<P> pq = new PriorityQueue<>((a, b) -> a.first - b.first);

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[0] = 0;
        pq.add(new P(0, 0));

        while (!pq.isEmpty()) {
            P top = pq.poll();
            int d = top.first;
            int node = top.second;

            if (node == n - 1) {
                return result[n - 1];
            }

            // Traverse neighbours
            for (P p : adj.get(node)) {
                int adjNode = p.first;
                int dist = p.second;

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.add(new P(d + dist, adjNode));
                }
            }
        }

        return -1;
    }
}