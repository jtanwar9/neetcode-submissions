class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, 0, curr, res);
        return res;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for(int i=index;i<nums.length;i++) {
            if(i > index && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            generateSubsets(nums, i + 1, curr, res);
            curr.removeLast();
        }       
    }
}
