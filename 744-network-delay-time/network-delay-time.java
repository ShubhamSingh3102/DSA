class Solution {
    public class Pair{
        int node;
        int wt;

        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i <=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            int s = times[i][0];
            int d = times[i][1];
            int w = times[i][2];

            adj.get(s).add(new Pair(d,w));
        }


        ArrayList<Integer> dist = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            dist.add(Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b ) -> Integer.compare(a.wt, b.wt));

        dist.set(k,0);

        pq.add(new Pair(k,0));

        while (!pq.isEmpty()){
            Pair p = pq.poll();

            int node = p.node;
            int currDist = p.wt;

            if(currDist < dist.get(node)){
                continue;
            }

            for(int j = 0; j < adj.get(node).size(); j++){
                int neigh = adj.get(node).get(j).node;
                int weight = adj.get(node).get(j).wt;

                if(currDist + weight < dist.get(neigh)){
                    dist.set(neigh, currDist + weight);

                    pq.add(new Pair(neigh, dist.get(neigh)));
                }
            }
        }
        int ans = 0;

        for(int i = 1; i <=n; i++){
            if(dist.get(i) == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,dist.get(i));
        }
        return ans;
    }
}