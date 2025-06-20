class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int[][] dp = new int[s.length()+1][s.length()+1];
        String s1 = s;
        String s2 = reverse(s);
        for(int i=0; i<=s.length(); i++) {
            dp[i][s.length()] = 0;
            dp[s.length()][i] = 0;
        }
        for(int i=s.length()-1; i>=0; i--){
            for(int j=s.length()-1; j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }

        return dp[0][0];
    }

    // public int lcs(int i, int j, String s1, String s2, int[][] dp){

    //     if(i == s1.length() || j == s2.length()) return 0;
    //     if(s1.charAt(i) == s2.charAt(j)) return 1 + lcs(i+1, j+1, s1, s2, dp);
    //     else {
    //         return Math.max(lcs(i+1, j, s1, s2, dp), lcs(i, j+1, s1, s2, dp));
    //     }
    // }

    String reverse(String s){
    
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}