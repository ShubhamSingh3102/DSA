class Solution {

    public ArrayList<ArrayList<Integer>> subArray(ArrayList<Integer> nums) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            ArrayList<Integer> sub = new ArrayList<>();

            for (int j = i; j < nums.size(); j++) {
                sub.add(nums.get(j));

                result.add(new ArrayList<>(sub));
            }
        }

        return result;
    }

    public int sumCounts(List<Integer> nums) {

        ArrayList<Integer> arr = new ArrayList<>(nums);

        ArrayList<ArrayList<Integer>> subArrays = subArray(arr);

        int ans = 0;

        for (ArrayList<Integer> sub : subArrays) {

            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < sub.size(); i++) {
                set.add(sub.get(i));
            }

            int uniqueCount = set.size();

            ans = ans + uniqueCount * uniqueCount;
        }
        return ans;
    }
}