from collections import deque

def is_valid(rotated_string):
    stack = []
    matching_brackets = {"(": ")", "[": "]", "{": "}"}
    for char in rotated_string:
        if char in "([{":
            stack.append(char)
        else:
            if not stack or matching_brackets.get(stack.pop()) != char:
                return False
    return len(stack) == 0


def solution(s):
    answer = 0
    n = len(s)
    queue = deque(s)

    for _ in range(n):
        rotated_string = "".join(queue)
        if is_valid(rotated_string):
            answer += 1
        queue.rotate(-1)
    return answer
