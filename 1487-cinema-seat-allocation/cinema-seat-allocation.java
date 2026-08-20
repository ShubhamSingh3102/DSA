class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,Integer> map = new HashMap<>();   // row --> seats in each row booked

        // TC --> O(n)
        // SC --> O(n)
        // Store booked seats using bitmask
        for(int i = 0; i < reservedSeats.length; i++){
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            // mask nikalo
            int mask = map.getOrDefault(row,0);

            mask = mask | (1 << seat);

            map.put(row,mask);
        }

        int result = (n - map.size()) * 2;


        int maskA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int maskB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int maskC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        // O(10^4)
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            int row = entry.getKey();
            int bookedSeatsMask = entry.getValue();


            // Group A: seats 2,3,4,5
            boolean groupA = (bookedSeatsMask & maskA) == 0;
            boolean groupB = (bookedSeatsMask & maskB) == 0;
            boolean groupC = (bookedSeatsMask & maskC) == 0;


            if(groupA && groupC){
                result += 2;
            }
            else if(groupA || groupB || groupC){
                result += 1;
            }
        }
        return result;
    }
}