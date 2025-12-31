class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //        n-(k-1) = n-k+1
        int[] ans = new int[n - k + 1];
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n - 1] = n;
        st.push(n - 1); // pushing index
        int z = 0;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        int j = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if (j >= i + k) { // jab j pura window se hi bahar nikal gya ho....
                j = i;
            }
            int max = Integer.MIN_VALUE;
            while (j < i + k) {
                max = nums[j];
                j = nge[j];
            }
            ans[z++] = max;
        }
        return ans;
    }
}