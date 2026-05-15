class Solution {
    public boolean find(HashMap<Character,Integer> have, HashMap<Character,Integer> needed){
        // hamko needed se mtlb hai...
        for(char ch : needed.keySet()){
            int fNeed = needed.get(ch);
            int fHave = have.getOrDefault(ch,0);

            if(fHave < fNeed){
                return false;
            }
        }
        return true;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> have = new HashMap<>();  // magazine
        HashMap<Character,Integer> needed = new HashMap<>();  // ransomNote

        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            needed.put(ch, needed.getOrDefault(ch,0) + 1);
        }

        for(int i = 0; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            have.put(ch, have.getOrDefault(ch,0) + 1);
        }
        return find(have,needed);
    }
}