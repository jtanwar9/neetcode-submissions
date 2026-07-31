class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int[] suffix = new int[n];
        int[] res = new int[n];
        suffix[n-1] = 1;

        for(int i = n-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i = 0; i < n; i++) {
            res[i] = prefix * suffix[i];
            prefix = prefix * nums[i];
        }

        return res;
        
    }
}  
