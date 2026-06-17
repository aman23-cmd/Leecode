class Solution {
  public int climbStairs(int n) {
    if(n==0)return 0;
    if(n<=2) return n;
    int prev_2=1;
    int prev_1=1;
    for(int i=2;i<=n;i++){
        int curr = prev_1 + prev_2;
        prev_2 = prev_1;
        prev_1 = curr;
    }
    return prev_1;
  }
}