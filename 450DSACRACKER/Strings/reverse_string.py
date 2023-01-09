def reverse(S):
    stack = []
    for i in range(len(S)):
        stack.append(S[i])
    res = []
    while stack:
        res.append(stack[len(stack)-1])
        stack.pop(len(stack)-1)
    return "".join(res)


S = "GeeksforGeeks"
print(reverse(S))
