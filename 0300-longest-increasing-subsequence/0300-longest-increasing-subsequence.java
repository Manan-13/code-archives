class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length+1][nums.length+1];
        int[] cur = new int[nums.length+1];
        int[] next = new int[nums.length+1];
        
        for(int i=nums.length-1; i>=0; i--){
            for(int j=i-1; j>= -1; j--){
                int notpick = next[j+1];
                int pick = 0;
                if(j == -1 || nums[i] > nums[j]) pick = 1 + next[i+1];

                cur[j+1] = Math.max(notpick, pick);
            }
            next = cur;
        }

        return cur[0];

    }

    // int recur(int index, int prev, int[] nums, int[][] dp){
        
    //     if(index == nums.length) return 0;
    //     if(dp[index][prev+1] != -1) return dp[index][prev+1];
    //     int notpick = recur(index+1, prev, nums, dp);

    //     int pick = 0;
    //     if(prev == -1 || nums[index] > nums[prev]) pick = 1+recur(index+1, index, nums, dp);

    //     return dp[index][prev+1] = Math.max(notpick, pick);
    // }
}