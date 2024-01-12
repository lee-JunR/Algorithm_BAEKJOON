T = int(input())
for i in range(0, T):
    print(" " * (i) + "*" * ((T - i) * 2 - 1))
for i in range(T - 2, -1, -1):
    print(" " * (i) + "*" * ((T - i) * 2 - 1))