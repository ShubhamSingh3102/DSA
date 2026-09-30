class Solution {
    public int maxDistinct(String s) {
        String[] ch = s.split("");

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < ch.length; i++){
            map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
        }

        return map.size();
    }
}