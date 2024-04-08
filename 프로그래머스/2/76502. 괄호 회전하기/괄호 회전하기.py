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
    for i in range(len(s)):
        if is_valid(s):
            answer += 1
        s = s[1:] + s[0]
    return answer