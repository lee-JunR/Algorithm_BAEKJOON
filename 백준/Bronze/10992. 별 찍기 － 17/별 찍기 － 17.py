T = int(input())
for i in range(1, T + 1):
    if i == 1:
        print((T-i) * ' '+"*")
    elif (i == T):
        print("*" * (T*2-1))
    else:
        print((T-i) * ' '+'*' + ' '*(2*i-3)+'*')