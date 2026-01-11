class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;;
        int maxArea = 0;
        for(int i=0;i<=n-1;i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                int area = arr[element] * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse = n;
            int element = st.peek();
            st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            int area = arr[element] * (nse-pse-1);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;

        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
