class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        for(int[] arr: dp) Arrays.fill(arr, -1);
        dp[s1.length()][s2.length()] = 0;
        
        return recur(0, 0, s1, s2, dp);
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