# 11728

import sys


def merge_and_sorted_array(arr1, arr2):
    sorted_arr = arr1 + arr2
    sorted_arr.sort()
    return sorted_arr


# 입력
a, b = map(int, sys.stdin.readline().split())
arr_A = list(map(int, sys.stdin.readline().split()))
arr_B = list(map(int, sys.stdin.readline().split()))

# 출력
print(*merge_and_sorted_array(arr_A, arr_B))