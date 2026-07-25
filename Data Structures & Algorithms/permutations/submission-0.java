class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }

    private void permute(int[] nums, int index, List<List<Integer>> res) {
        if(index == nums.length) {
            List<Integer> curr = Arrays.stream(nums)
            .boxed().collect(Collectors.toList());
            res.add(curr);
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permute(nums, index + 1, res);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
