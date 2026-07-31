class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!mp.containsKey(num)) {
                mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
                res = Math.max(res, mp.get(num));
            }
        }
        System.out.println(mp);
        return res;
        */
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int curr = 1;
                while(set.contains(num + curr)) {
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }
        return res;

    }
}
