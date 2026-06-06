class Solution {
    static class Pair{
        int first;   // maxFrequency
        Character second;   // letter

        Pair(int f, Character s){
            this.first = f;
            this.second = s;
        }
    }
    public String reorganizeString(String s) {
        // Frequency Count
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        // Max Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.first != b.first){
                return b.first - a.first;
            } else {
                return b.second - a.second;
            }
        });

        // Push all characters into heap
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
        }

        StringBuilder res = new StringBuilder();
        int seat = 0;  // 0 wala seat pe rkhna chahte hai...

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            if(seat == 0 || res.charAt(seat - 1) != p.second){
                res.append(p.second);   // push back  // 1 admi ko place kiye h...
                seat++;
                p.first--;
                if(p.first > 0){   // agar baacha h toh....
                    pq.add(new Pair(p.first,p.second));
                }
            } else {   // same hoga
                // agla baacha pkka baith skta hai agar hoga then...
                if(pq.isEmpty()){
                    return "";
                }
                Pair p2 = pq.peek();
                pq.poll();   // ye pkka baith skta hai...

                res.append(p2.second);
                seat++;
                p2.first--;
                if(p2.first > 0){    // agar baacha h toh....
                    pq.add(new Pair(p2.first,p2.second));
                }
                // ek baar aur push krna hoga...
                pq.add(new Pair(p.first,p.second));  //  <1,b>
            }
        }
        return res.toString();
    }
}