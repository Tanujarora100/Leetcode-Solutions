class Solution:
    def removeVowels(self, s: str) -> str:
        vowels = set('aeiou')
        res = []
        # s=list(s)
        for i in range(len(s)):
            if s[i] not in vowels:
                res.append(s[i])
        return "".join(res)
