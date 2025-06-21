class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        // for(int i=0; i<nums.length; i++) dp[nums.length][i] = 0;
        return recur(0, nums.length, nums, dp);

    }

    int recur(int index, int prev, int[] nums, int[][] dp){
        
        if(index == nums.length) return 0;
        if(dp[index][prev] != -1) return dp[index][prev];
        int notpick = recur(index+1, prev, nums, dp);

        int pick = 0;
        if(prev == nums.length || nums[index] > nums[prev]) pick = 1+recur(index+1, index, nums, dp);

        return dp[index][prev]=Math.max(notpick, pick);
    }
}