class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // TC --> O(n)
        // SC --> O(k)
        // Variable Sliding Window...
        int low = 0;
        int high = 0;

        int result = Integer.MIN_VALUE;

        while (high < fruits.length) {
            // include current fruit
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);

            while (map.size() > 2) {
                // low ko badhao...window size decrease kro...

                map.put(fruits[low], map.get(fruits[low]) - 1);

                if (map.get(fruits[low]) == 0) {
                    // now remove it from the map;
                    map.remove(fruits[low]);
                }
                low++;
            }
            // now 2 cases....map.size == k or map.size < k
            int length = high - low + 1;
            result = Math.max(length, result);
            high++;
        }
        return result;
    }
}