class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // 1. Already Sorted
        boolean sorted = true;

        for(int i = 1; i < n; i++){
            if(s.charAt(i) < s.charAt(i-1)){
                sorted = false;  // sorted nhi h...
                break;
            }
        }

        if(sorted){
            return 0;
        }

        // 2. Length 2 and not sorted
        if(n == 2){
            return -1;
        }

        // 3. Find minimum and maximum character
        char min = 'z';
        char max = 'a';

        for(int i = 0; i < n; i++){
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        // 4. Minimum is already at first
        // Or Maximum is already at last

        if(s.charAt(0) == min || s.charAt(n-1) == max){
            return 1;
        }

        // 5. Maximum at first AND minimum at last
        if(s.charAt(0) == max && s.charAt(n-1) == min){
            boolean middle = false;

            for(int i = 1; i < n-1; i++){
                if(s.charAt(i) == min || s.charAt(i) == max){
                    middle = true;
                    break;
                }
            }

            if(!middle){
                return 3;
            }
        }

        //6. Remaining cases
        return 2;
    }
}