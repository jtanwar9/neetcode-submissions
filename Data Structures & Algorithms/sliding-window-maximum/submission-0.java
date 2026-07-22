class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0;i<nums.length;i++) {
            while(!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if(queue.getFirst() < i - k + 1) {
                queue.removeFirst();
            }
            if((i + 1) >= k) {
                result[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return result;
    }
}
