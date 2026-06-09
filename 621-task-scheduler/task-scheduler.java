class Solution {
    static class Pair{
        int first;  //// frequency
        char second;  //// letter(char)

        Pair(int f, char s){
            this.first = f;
            this.second = s;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;

        // frequency ke liye....
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> free = new HashMap<>();
        // hashmap me daalo
        for(int i = 0; i < m; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0) + 1);
        }

        // maxHeap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.first != b.first){
                return b.first - a.first;
            } else {
                return b.second - a.second;
            }
        });

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getValue(),entry.getKey()));
            free.put(entry.getKey(),1);
        }

        int seat = 1;

        while (!pq.isEmpty()){

            // kona bana lo jiss kone me bhej denge jab koi seat me koi nhi baith payega....
            ArrayList<Pair> pulled = new ArrayList<>();

            while (!pq.isEmpty()) {
                Pair p = pq.poll();

                int freq = p.first;   // freq
                char child = p.second;  // letter

                // kya ye baacha iss seat pe baith skta ha....
                if (free.getOrDefault(child, 1) <= seat) {
                    // baith skta h..
                    if (p.first > 1) {
                        pq.add(new Pair((p.first - 1), p.second));
                    }
                    free.put(child, seat + n + 1);// here n is the gap   // seat + gap + 1;
                    break;
                } else {
                    // agar nhi baith skta to kya kru....
                    pulled.add(p);   // kone me baitha do
                }
            }
            // kone se utha kr heap me daalo do phir
            for(int i = 0; i < pulled.size(); i++){
                pq.add(pulled.get(i));
            }
            seat++;
        }
        return seat - 1;
    }
}