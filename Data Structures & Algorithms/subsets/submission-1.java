class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateSubsets(nums, 0, curr, res);
        return res;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        generateSubsets(nums, index + 1, curr, res);
        curr.removeLast();
        generateSubsets(nums, index + 1, curr, res);
    }
}
