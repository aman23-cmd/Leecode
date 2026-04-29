class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,h,piles)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int k,int h,int[]arr){
        long totalHours=0;
        for (int pile:arr) {
            totalHours+=(pile+k-1)/k;
        }
        return totalHours <=h;
    }
}