import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxlen = 0;
        for(int num :set){
            if(!set.contains(num - 1)){
                int currnum = num;
                int count = 1;
                while(set.contains(currnum + 1)){
                    currnum++;
                    count++;
                }
                maxlen = Math.max(maxlen, count);
            }
        }
        return maxlen;
    }
}