import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int count = nums.length;

        for (int i = 0; i <= count; i++) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
        }

        for (int num : set) {
            return num;
        }

        return -1; 
    }
}