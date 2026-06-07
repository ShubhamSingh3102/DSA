class Solution {
    static class Pair{
        int first;      // capital
        int second;     // profit

        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;

        ArrayList<Pair> proj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            proj.add(new Pair(capital[i],profits[i]));
        }

        proj.sort((a,b) -> a.first - b.first);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        int idx = 0;

        while(k-- > 0){
            while(idx < n){
                if(proj.get(idx).first >  w){
                    break;
                } else {
                    // push profit in the heap
                    pq.add(proj.get(idx).second);
                    idx++;
                }
            }
            if(pq.isEmpty()){
                return w;
            }
            w = w + pq.peek();
            pq.poll();
        }
        return w;
    }
}