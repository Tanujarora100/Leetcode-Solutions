from collections import deque


def reverseLevelOrder(root):
    if root is None:
        return None
    queue = deque()
    queue.append(root)
    ans = deque()
    while queue:
        node = queue.popleft()

        ans.appendleft(node.data)

        if node.right:
            queue.append(node.right)

        if node.left:
            queue.append(node.left)
    return ans
