 public int binarysearch(int arr[], int n, int k) {
        // Check first if the Array is sorted in ascending order or descending order
        if (arr[0] < arr[1]) {
            sortedAscending(arr, n, k);
        } else {
            sortedDescending(arr, n, k);
        }
        return -1;
    }

    private int sortedDescending(int[] arr, int n, int k) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k)
                return mid;
            if (arr[mid] < k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int sortedAscending(int arr[], int n, int k) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k)
                return mid;
            if (arr[mid] < k)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
