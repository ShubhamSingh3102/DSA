class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> st = new Stack<>();
        ArrayList<String> res = new ArrayList<>();
        int a = 1;
        int i = 0;

        while (a <= target[target.length - 1]) {
                if (a == target[i]) {
                    st.push(a);
                    res.add("Push");
                    a++;
                    i++;
                } else {
                    st.push(a);
                    res.add("Push");

                    st.pop();
                    res.add("Pop");
                    a++;
                }
            }
        return res;
    }
}