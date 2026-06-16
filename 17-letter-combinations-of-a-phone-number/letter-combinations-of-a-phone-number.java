class Solution {
    public void find(String digits,int idx,StringBuilder diary,List<String> res){

        int n = digits.length();
        HashMap<Character,String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if(idx == n){
            res.add(String.valueOf(diary));
            return;
        }

        // haar choice ko banao aaram se...
        String choice = map.get(digits.charAt(idx));

        for(int j = 0; j < choice.length(); j++){
            diary.append(choice.charAt(j));
            find(digits,idx + 1,diary,res);
            diary.deleteCharAt(diary.length() - 1);
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        StringBuilder diary = new StringBuilder();
        List<String> res = new ArrayList<>();
        int n = digits.length();

        find(digits,0,diary,res);
        return res;
    }
}