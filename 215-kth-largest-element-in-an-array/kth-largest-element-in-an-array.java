class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // minHeap

        if (k <= 0 || k > nums.length) {
            return -1;
        }

        // now push k element in heap and wo automatically largest element ko dekhta h...
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        // now rest of the elements e compare kro...
        for (int i = k; i < nums.length; i++) {
            if (nums[i] <= pq.peek()) {
                continue;
            } else {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}