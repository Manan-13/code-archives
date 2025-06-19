class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=len1; i>= 0; i--){
            for(int j=len2; j>=0; j--){
                if(i == len1 && j == len2) dp[i][j] = 0;
                else if(i == len1){
                    dp[i][j] = s2.charAt(j) + dp[i][j+1];
                } 
                else if(j == len2){
                    dp[i][j] = s1.charAt(i) + dp[i+1][j];
                } else{
                    if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i+1][j+1];
                    else dp[i][j] = Math.min(s2.charAt(j)+dp[i][j+1], s1.charAt(i)+dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
}