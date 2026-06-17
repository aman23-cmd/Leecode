/*
class Solution {
    public int minCost(int n, int[] cuts) {
        int[]newcut= new int[cuts.length+2];
        newcut[0]=0;
        newcut[newcut.length-1]=n;
        Arrays.sort(cuts);
        for(int i=0;i<cuts.length;i++){
            newcut[i+1]=cuts[i];
        }
        Integer[][]dp=new Integer[cuts.length+2][cuts.length+2];
        return solve(1,cuts.length,newcut,dp);
    }
    public int solve(int i,int j,int[]arr,Integer[][]dp){
        if(i>j)return 0;
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int mini=Integer.MAX_VALUE;
        for(int idx=i;idx<=j;idx++){
            int cost=arr[j+1]-arr[i-1]+solve(i,idx-1,arr,dp)+solve(idx+1,j,arr,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
}
*/
class Solution {
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;
        Arrays.sort(cuts);
        for (int i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }
        int m = arr.length;
        int[][] dp = new int[m][m];
        for (int i = cuts.length; i >= 1; i--) {
            for (int j = i; j <= cuts.length; j++) {
                int mini = Integer.MAX_VALUE;
                for (int idx = i; idx <= j; idx++) {
                    int cost = arr[j+1]-arr[i-1]+dp[i][idx-1]+dp[idx+1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][cuts.length];
    }
}