def solution(numbers):
  stack = []
  result = [-1] * len(numbers)

  for i in range(len(numbers) - 1, -1, -1):
    while stack and stack[-1] <= numbers[i]:
      stack.pop()
    result[i] = stack[-1] if stack else -1
    stack.append(numbers[i])

  return result