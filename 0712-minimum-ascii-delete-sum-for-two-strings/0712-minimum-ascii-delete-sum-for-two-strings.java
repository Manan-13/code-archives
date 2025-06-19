class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        dp[s1.length()][s2.length()] = 0;
        for(int i=s1.length(); i>= 0; i--){
            for(int j=s2.length(); j>=0; j--){
                if(i == s1.length() && j == s2.length()) continue;

                if(i == s1.length()){
                    dp[i][j] = s2.charAt(j) + dp[i][j+1];
                } 
                else if(j == s2.length()){
                    dp[i][j] = s1.charAt(i) + dp[i+1][j];
                } else{
                    if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i+1][j+1];
                    else dp[i][j] = Math.min(s2.charAt(j)+dp[i][j+1], s1.charAt(i)+dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

    private int recur(int i, int j, String s1, String s2, int[][] dp){
        
        if(dp[i][j] != -1) return dp[i][j];

        if(i == s1.length()){
            return dp[i][j] = calcAscii(s2.substring(j));
        }
        if(j == s2.length()){
            return dp[i][j] = calcAscii(s1.substring(i));
        }

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = recur(i+1, j+1, s1, s2, dp);
        else return dp[i][j] = Math.min(s2.charAt(j)+recur(i, j+1, s1, s2, dp),
                             s1.charAt(i)+recur(i+1, j, s1, s2, dp));

    }

    private int calcAscii(String s){
        int total = 0;
        for(int i=0; i<s.length(); i++){
            total += s.charAt(i);
        }
        return total;
    }
}