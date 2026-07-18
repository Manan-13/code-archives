class Solution {
    public int minRefuelStops(int target, int fuelLeft, int[][] stations) {
        
        int curPos = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        int i=0;
        int stopsMade = 0;
        while(fuelLeft > 0 || !pq.isEmpty()){
            if(curPos + fuelLeft >= target) return stopsMade;
            if(i < stations.length && stations[i][0] - curPos <= fuelLeft){
                fuelLeft -= stations[i][0] - curPos;
                curPos = stations[i][0];
                pq.offer(stations[i][1]);
                i++;
            }else{
                if(pq.isEmpty()) return -1;
                fuelLeft += pq.poll();
                stopsMade++;
            } 
        }
        return -1;
    }
}