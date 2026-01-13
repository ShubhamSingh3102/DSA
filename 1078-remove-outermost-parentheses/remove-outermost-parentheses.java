class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){

            char ch = s.charAt(i);
            if(ch == '('){ // add + push
                if(!st.isEmpty()){
                    ans.append(ch);
                }
                st.push(ch);
            }
            else{ // ')' // pop + add
                st.pop();
                if(!st.isEmpty()){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}