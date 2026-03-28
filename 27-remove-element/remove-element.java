import java.util.*;

class Solution {
    public int removeElement(int[] nums, int val) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != val) {
                list.add(num);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }
}