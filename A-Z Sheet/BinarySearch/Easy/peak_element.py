from typing import List


class solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        while l < r:
            mid = (l + r) // 2
            if nums[mid] < nums[mid + 1]:
                l = mid + 1
            else:
                r = mid
        return l


'''
0  1 2 3 4 5 6
[1,2,1,3,5,6,4]
    6+0/2-->arr[3]-->3
    start-4+6/2->arr[5]-->6
    start-4+5/2-->arr[4]->5
    start-5+6/2->arr[5]->6
    end->5 start-5 condition break
    return start
'''
