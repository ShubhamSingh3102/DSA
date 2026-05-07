class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;

        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        int ans = arr[0];

        for(int i = 1; i < n; i++){
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;

            noDelete = Math.max(noDelete + arr[i],arr[i]);

            int v2;
            if(prevOneDelete == Integer.MIN_VALUE){
                v2 = arr[i];
            } else {
                v2 = prevOneDelete + arr[i];
            }

            oneDelete = Math.max(v2,prevNoDelete);

            ans = Math.max(ans,Math.max(noDelete,oneDelete));
        }
        return ans;
    }
}