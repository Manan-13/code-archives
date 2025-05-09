package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxProfitJobScheduling {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] st = {4,2,4,8,2};
        int[] ed = {5,5,5,10,8};
        int[] pf = {1,2,8,10,4};
        System.out.println(s.jobScheduling(st,ed,pf));
    }
}
class Solution2 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Interval> intervalList = new ArrayList<>();
        for(int i=0; i<startTime.length; i++){
            intervalList.add(new Interval(startTime[i], endTime[i], profit[i]));
        }
        intervalList.sort(Comparator.comparingInt(i -> i.st));
        int[] dp = new int[intervalList.size()];
        Arrays.fill(dp, -1);
        return recur(0, intervalList, dp);
    }

    private int recur(int index, List<Interval> intervalList, int[] dp){
        if(index == intervalList.size()) return 0;
        if(dp[index] != -1) return dp[index];
        int nextIndex = findNext(index, intervalList);
        int pick = intervalList.get(index).pf + recur(nextIndex, intervalList, dp);;
        int notPick = recur(index+1, intervalList, dp);
        return dp[index] = Math.max(pick, notPick);
    }

    int findNext(int index, List<Interval> intervalList){
        int low = index+1;
        int high = intervalList.size()-1;

        int curIndexEndTime = intervalList.get(index).et;
        int nextIndex = intervalList.size();
        while(low <= high){
            int mid = (low+high)/2;
            if(intervalList.get(mid).st >= curIndexEndTime){
                nextIndex = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return nextIndex;
    }
}

class Interval{
    int st;
    int et;
    int pf;
    Interval(int s, int e , int p){
        st=s;
        et=e;
        pf=p;
    }
}