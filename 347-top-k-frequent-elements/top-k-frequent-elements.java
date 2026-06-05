class Solution {
    static class Pair {
        int first;   // frequency
        int second;  // element

        // constructor
        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
    // O(n) + O(n log k)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // phele hashmap me store kro frequency....

        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        // heap me store kro mean
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.first != b.first){
                return a.first - b.first;
            }
            return a.second - b.second;
        });

        // Hashmap me traverse krke heap me push kro
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(pq.size() < k){
                pq.add(new Pair(entry.getValue(), entry.getKey()));   // frequency, element
                continue;
            } else {
                if(entry.getValue() <= pq.peek().first){
                    continue;       //// ignore
                } else {
                   pq.poll();   // top wala k logo se chota ho jayega wo answer nhi ho payega...
                   pq.add(new Pair(entry.getValue(), entry.getKey()));
                }
            }
        }
        int[] ans = new int[k];
        int idx = 0;

        // heap ko khali kr do
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            ans[idx++] = curr.second;
        }
        return ans;
    }
}