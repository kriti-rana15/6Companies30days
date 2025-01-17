/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */
class Solution {
    public int findPeak(MountainArray mountainArr, int len) {
        int low = 0, high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int current = mountainArr.get(mid);
            int next = mountainArr.get(mid + 1);
            
            if (current < next) low = mid + 1;
            else high = mid;
        }
        return low; 
    }
    private int binarySearch(MountainArray mountainArr, int low, int high, int target, boolean isIncreasing) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = mountainArr.get(mid);
            if (current == target) {
                return mid; 
            } 
            if (isIncreasing) {
                if (current < target) low = mid + 1;  // Move right in the increasing part
                else high = mid - 1;  // Move left in the increasing part
            } 
            else {
                if (current < target) high = mid - 1;  // Move left in the decreasing part
                else low = mid + 1;  // Move right in the decreasing part
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peakIdx = findPeak(mountainArr, len);
        int leftSearch = binarySearch(mountainArr, 0, peakIdx, target, true);
        if (leftSearch != -1) {
            return leftSearch; 
        }
        return binarySearch(mountainArr, peakIdx + 1, len - 1, target, false);
    }
}
