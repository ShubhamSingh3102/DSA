class Solution {
    public void generate(StringBuilder curr, int n, List<String> list) {
        if (curr.length() == n) {
            list.add(curr.toString());
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch) {
                continue;
            }

            // Do
            curr.append(ch);

            // Explore
            generate(curr, n, list);

            // Undo
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        generate(curr, n, list);

        if (k > list.size()) {
            return ""; // empty string....
        }
        return list.get(k - 1);
    }
}