class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1, right = (long)1e18;
        long ans = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReduce(long time, int height, int[] workers) {

        long total = 0;

        for (int w : workers) {

            long l = 0, r = (long)1e6;
            long best = 0;

            while (l <= r) {

                long mid = l + (r - l) / 2;

                long required = (long)w * mid * (mid + 1) / 2;

                if (required <= time) {
                    best = mid;
                    l = mid + 1;
                } 
                else {
                    r = mid - 1;
                }
            }

            total += best;

            if (total >= height)
                return true;
        }

        return false;
    }
}