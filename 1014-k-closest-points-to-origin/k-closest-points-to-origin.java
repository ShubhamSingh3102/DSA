class Solution {
    static class Pair{
        double first;  // distance
        int second;  // index

        Pair(double f, int s){
            this.first = f;
            this.second = s;
        }
    }
    public double calculateDistance(int x, int y){
        // under root(x2-x1)^2 + under root(y2-y1)^2  --> origin means x2 = 0 and y1 = 0
        // therefore under root((x1)^2 + (y1)^2)
        return Math.sqrt(x*x + y*y);
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.first != b.first){
                return Double.compare(b.first, a.first);
            }
            return b.second - a.second;
        });

        // first k points ke liye...
        for(int i = 0; i < k; i++){
            int x = points[i][0];
            int y = points[i][1];
            double dist = calculateDistance(x,y);
            pq.add(new Pair(dist,i));
        }

        // aab sbko push kro and then sabko pop kro
        for(int i = k; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            double dist = calculateDistance(x,y);
            pq.add(new Pair(dist,i));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];   // 2 cheez hai x and y
        int idx = 0;

        while (!pq.isEmpty()){
            Pair curr = pq.poll();

            ans[idx][0] = points[curr.second][0];
            ans[idx][1] = points[curr.second][1];

            idx++;
        }
        return ans;
    }
}