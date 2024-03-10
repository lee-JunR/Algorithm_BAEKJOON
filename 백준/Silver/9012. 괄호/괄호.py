def is_valid_parenthesis(string):
    stack = []
    for char in string:
        if char == '(':
            stack.append(char)
        elif char == ')':
            if not stack or stack.pop() != '(':
                return False
    return not stack

def main():
    t = int(input())
    for _ in range(t):
        string = input()
        print("YES" if is_valid_parenthesis(string) else "NO")

if __name__ == "__main__":
    main()