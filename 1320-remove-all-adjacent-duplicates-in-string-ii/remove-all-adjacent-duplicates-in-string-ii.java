class Solution {
    public class Pair {
        char ch;
        int count;

        Pair(char ch,int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> st = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            // safe condition
            if(st.isEmpty()){
                st.push(new Pair(ch,1));
                continue;
            }
            if(st.peek().ch != ch){
                st.push(new Pair(ch,1));
                continue;
            } else {  // yaha empty bhi nhi h and top character same h...
                if(st.peek().count < (k-1)){
                    // phele stack se nikal lo phir count ++ krke phir se daal do
                    Pair p = st.peek();
                    st.pop();
                    st.push(new Pair(ch, p.count + 1));
                } else {
                    st.pop(); // simply bekar element hai
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            Pair p = st.peek();
            st.pop();
            for(int i = 0; i < p.count; i++){ // jiska count hoga utna baar chalega loop
                ans.append(p.ch);
            }
        }
        return ans.reverse().toString();
    }
}