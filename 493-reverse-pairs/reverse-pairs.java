class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int low, int high){
        if(low >= high) return 0;

        int mid = low + (high - low) / 2;

        int count = 0;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    public int countPairs(int[] nums, int low, int mid, int high){
        int count = 0;
        int right = mid + 1;

        for(int i = low; i <= mid; i++){
            while(right <= high && (long)nums[i] > 2 * (long)nums[right]){
                right++;
            }
            count += (right - (mid + 1));
        }

        return count;
    }

    public void merge(int[] nums, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();

        int left = low, right = mid + 1;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while(left <= mid) temp.add(nums[left++]);
        while(right <= high) temp.add(nums[right++]);

        for(int i = low; i <= high; i++){
            nums[i] = temp.get(i - low);
        }
    }
}