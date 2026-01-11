class Solution {
    public int largestRectangleArea(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : arr[i];

            while (!st.isEmpty() && arr[st.peek()] > curr) {
                int height = arr[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, height * (nse - pse - 1));
            }
            st.push(i);
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
