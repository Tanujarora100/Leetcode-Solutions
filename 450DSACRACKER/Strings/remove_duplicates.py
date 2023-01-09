class Solution:
    def removeDups(self, S):
        hash_set = {}
        for i in range(len(S)):
            hash_set.pop(0)
        res = []
        for i in hash_set:
            res.append(i)
        return "".join(res)


ob = Solution()
A = "zvvo"
print("hello")
print(ob.removeDups(A))
