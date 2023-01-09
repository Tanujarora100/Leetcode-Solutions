class Solution:
    def areNumbersAscending(self, s: str) -> bool:
        hash_set = set(range(1, 101))
        s = list(s)
        result_list = []
        print(s)
        for i in range(len(s)):
            if s[i] in hash_set:
                result_list.append(s[i])
        print(result_list)
        if result_list == result_list.sort():
            return True
        else:
            return False
