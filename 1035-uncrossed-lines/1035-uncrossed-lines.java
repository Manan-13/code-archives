class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        
        return recur(nums1, nums2, 0, 0, dp);
    }

    private int recur(int[] nums1, int[] nums2, int i, int j, int[][] dp){

        if(i == nums1.length || j == nums2.length) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(nums1[i] == nums2[j]) return dp[i][j] = 1 + recur(nums1, nums2, i+1, j+1, dp);

        return dp[i][j] = Math.max(recur(nums1, nums2, i+1, j, dp), recur(nums1, nums2, i, j+1, dp));
    }
}