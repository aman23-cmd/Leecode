class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int i=0;i<weights.length;i++){
            low=Math.max(low,weights[i]);
            high +=weights[i];
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if (isPossible(weights,days,mid)){
                ans =mid;
                high =mid-1; 
            } else {
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] weights, int days, int capacity){
        int usedd=1;
        int currentload=0;
        for (int w :weights) {
            if (currentload + w>capacity) {
                usedd++;
                currentload =0;
            }
            currentload +=w;
        }
        return usedd<=days;
    }
}