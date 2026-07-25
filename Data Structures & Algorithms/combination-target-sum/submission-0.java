class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combinationSum(nums, 0, target, curr, res);
        return res;
    }

    private void combinationSum(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || index == nums.length) {
            return;
        }
        curr.add(nums[index]);
        combinationSum(nums, index, target - nums[index], curr, res);
        curr.removeLast();
        combinationSum(nums, index + 1, target, curr, res);
    }
}
