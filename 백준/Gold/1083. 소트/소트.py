def sort_with_limited_swaps(nums, s):

  n = len(nums)
  for i in range(n):
    max_idx = i + nums[i:min(n, i + s + 1)].index(max(nums[i:min(n, i + s + 1)]))
    for j in range(max_idx, i, -1):
      nums[j], nums[j - 1] = nums[j - 1], nums[j]
    s -= (max_idx - i)
    if s <= 0:
      break

  return nums

n, nums = int(input()), list(map(int, input().split()))
s = int(input())

sorted_nums = sort_with_limited_swaps(nums, s)
print(*sorted_nums)