class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()) {
            queue.add(new int[]{key, map.get(key)});
            if(queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }
}
