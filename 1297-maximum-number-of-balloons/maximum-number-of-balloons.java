class Solution {
    public int maxNumberOfBalloons(String text) {
       int n = text.length();
        HashMap<Character,Integer> have = new HashMap<>();  // text
        HashMap<Character,Integer> needed = new HashMap<>();  // balloon

        // for needed
        needed.put('b',1);
        needed.put('a',1);
        needed.put('l',2);
        needed.put('o',2);
        needed.put('n',1);

        // for have
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            have.put(ch,have.getOrDefault(ch,0) + 1);
        }

        int res = Integer.MAX_VALUE;
        // hamko needed se mtlb hai...
        for(char ch : needed.keySet()){
            int fNeed = needed.get(ch);
            int fHave = have.getOrDefault(ch,0);

            int times = fHave / fNeed;
            res = Math.min(res,times);
        }
        return res; 
    }
}