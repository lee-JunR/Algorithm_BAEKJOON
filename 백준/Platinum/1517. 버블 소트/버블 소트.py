import sys

def merge(arr, left, mid, right):
    swaps = 0
    left_arr = arr[left:mid+1]
    right_arr = arr[mid+1:right+1]
    
    i = j = k = 0
    while i < len(left_arr) and j < len(right_arr):
        if left_arr[i] <= right_arr[j]:
            arr[left+k] = left_arr[i]
            i += 1
        else:
            arr[left+k] = right_arr[j]
            j += 1
            swaps += len(left_arr) - i  # 왼쪽 배열에서 현재 원소보다 큰 원소들의 개수를 더합니다.
        k += 1
    
    while i < len(left_arr):
        arr[left+k] = left_arr[i]
        i += 1
        k += 1
    
    while j < len(right_arr):
        arr[left+k] = right_arr[j]
        j += 1
        k += 1
    
    return swaps

def merge_sort(arr, left, right):
    swaps = 0
    if left < right:
        mid = (left + right) // 2
        swaps += merge_sort(arr, left, mid)
        swaps += merge_sort(arr, mid + 1, right)
        swaps += merge(arr, left, mid, right)
    return swaps

# 입력 받기
n = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))

# Merge Sort Swap 횟수 출력
print(merge_sort(array, 0, n-1))
