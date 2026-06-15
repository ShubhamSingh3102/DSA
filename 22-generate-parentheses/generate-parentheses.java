class Solution {
    public void find(int open, int close, int n, StringBuilder temp, List<String> res) {

        if (open == n && close == n) { // base condition
            res.add(temp.toString());
            return;
        }
        if (open < n) {
            // choice
            temp.append('(');
            find(open + 1, close, n, temp, res);

            // brackTrack
            temp.deleteCharAt(temp.length() - 1); // for reverse back....ek ka do choice h...
        }
        if (close < open) {
            temp.append(')');
            find(open, close + 1, n, temp, res);

            // brackTrack
            temp.deleteCharAt(temp.length() - 1);
        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        List<String> res = new ArrayList<>();
        // generate all parenthesis
        find(0, 0, n, temp, res);

        return res;
    }
}