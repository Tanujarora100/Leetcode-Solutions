def maximumSumSubarray(self, K, Arr, N):
    i = 0
    j = 0
    maxi = -9999
    local_max = 0
    # Using Sliding Window
    while j < N:
        local_max = local_max+Arr[j]
        if j-i+1 < K:
            j += 1
        elif j-i+1 == K:
            maxi = max(maxi, local_max)
            local_max = local_max-Arr[i]
            i += 1
            j += 1
    return maxi
