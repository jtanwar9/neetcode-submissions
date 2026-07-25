class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, curr, res);
        return res;
    }

    private void combinationSum(int[] candidates, int index, int target, List<Integer> curr, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || index >= candidates.length) {
            return;
        }

        for(int i=index;i<candidates.length;i++) {
            if(candidates[i] > target) {
                break;
            }
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            curr.add(candidates[i]);
            combinationSum(candidates, i + 1, target - candidates[i], curr, res);
            curr.removeLast();
        }
    }
}
