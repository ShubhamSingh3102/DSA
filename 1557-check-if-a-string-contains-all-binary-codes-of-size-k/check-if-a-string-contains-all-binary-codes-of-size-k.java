class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();

        int n = s.length();

        int codes = 1 << k; // power(2,k)

        for (int i = k; i <= n; i++) {
            String sub = s.substring(i - k, i);

            if (!set.contains(sub)) {
                set.add(sub);
                codes--;
            }

            if (codes == 0) {
                return true;
            }
        }
        return false;
    }
}