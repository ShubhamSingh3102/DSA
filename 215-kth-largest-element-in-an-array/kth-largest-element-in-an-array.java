class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(k <= 0 || k > nums.length){
            return -1;
        }

        // now push k element in heap and wo automatically largest element ko dekhta h...
        for(int i = 0; i < k; i++){    // log(k)
            pq.add(nums[i]);
        }
        // (n - k) * ( log(k) + log(k))
        // TC ---> O(n log k)
        // SC -->O(k)
        // now rest of the elements e compare kro...
        for(int i = k; i < nums.length; i++){
            // phele sabko push kro and then pop
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}