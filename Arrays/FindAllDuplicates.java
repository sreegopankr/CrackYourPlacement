import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int value = Math.abs(nums[i]);
            int idx = value-1;
            if(nums[idx]<0){
                list.add(value);
                continue;
            }
            nums[idx]*=-1;
        }
        return list;
    }
}