def dfs(idx, cnt):
    if cnt == 6:
        for i in range(length):
            if check[i]:
                print(input_data[i], end=' ')
        print()
        return

    for i in range(idx, length):
        check[i] = True

        dfs(i+1, cnt+1)

        check[i] = False

while True:
    input_data = [int(x) for x in input().split(' ')]
    length = input_data[0]
    if length == 0:
        break

    input_data = input_data[1:]
    check = [False] * length
    dfs(0,0)
    print()