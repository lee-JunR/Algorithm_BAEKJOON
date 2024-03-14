import sys

n = int(sys.stdin.readline())

Deque = []
for i in range(n):
    command = sys.stdin.readline().split()

    if command[0] == 'push_front':
        Deque.insert(0, command[1])
    elif command[0] == 'push_back':
        Deque.append(command[1])
    elif command[0] == 'pop_front':
        if len(Deque) == 0:
            print(-1)
        else:
            print(Deque[0])
            del Deque[0]
    elif command[0] == 'pop_back':
        if len(Deque) == 0:
            print(-1)
        else:
            print(Deque[-1])
            del Deque[-1]
    elif command[0] == 'size':
        print(len(Deque))
    elif command[0] == 'empty':
        if len(Deque) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == 'front':
        if len(Deque) == 0:
            print(-1)
        else:
            print(Deque[0])
    elif command[0] == 'back':
        if len(Deque) == 0:
            print(-1)
        else:
            print(Deque[-1])