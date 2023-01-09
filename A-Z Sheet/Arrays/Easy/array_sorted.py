class Solution:
    def arraySortedOrNot(self, arr, n):
        flag = True
        for i in range(1, n):
            if arr[i-1] > arr[i]:
                flag = False
        return flag

    def remove_duplicate(self, A, N):
        res = []
        for i in range(1, N):
            if A[i-1] != A[i]:
                res.append(A[i])
        return len(res)
