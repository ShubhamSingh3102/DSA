class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            pq.add(nums[i]);
        }

        int i = 0;

        while (!pq.isEmpty()){
            int a = pq.poll();
            int b = pq.poll();

            res[i] = b;
            res[i + 1] = a;
            i = i + 2;
        }
        return res;
    }
}