class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return climbStairs(n, cache);
        //return cache[n];
    }

    public int climbStairs(int n, int[] cache) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(cache[n] != -1) return cache[n];
        return cache[n] = climbStairs(n-1, cache) + climbStairs(n-2, cache);   
    }
}
