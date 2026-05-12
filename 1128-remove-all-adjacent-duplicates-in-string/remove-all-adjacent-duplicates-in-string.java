class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
            } else {
                if(ch != st.peek()){
                    st.push(ch);
                }else {
                    st.pop();
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}