class Solution {
    public int largestRectangleArea(int[] heights) {
        // calculating nse[]
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[heights.length];
        int n = heights.length;
        nse[n-1] = n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.empty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.empty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        // empyting the stack
        while(!st.isEmpty()){
            st.pop();
        }
        // calculating pse[]
        int[] pse = new int[heights.length];
        st.push(0);
        pse[0] = -1;
        for(int i=1;i<=n-1;i++){
            while(!st.empty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.empty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        // now calculating maximum area of rectangle...
        int max = -1;
        for(int i=0;i<n;i++){
            int area = heights[i]*(nse[i]-pse[i]-1);
            if(area>max){
                max = area;
            }
        }
        return max;
    }
}