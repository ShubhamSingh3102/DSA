class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0; i < n; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){   // kyuki 2 element chahiye...
            int y = pq.poll();
            int x = pq.poll();

            if(x != y){
                pq.add(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}