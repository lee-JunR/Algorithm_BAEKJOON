str = input().upper()
arr = []
str_set = list(set(str))


for i in str_set:
    arr.append(str.count(i))

if arr.count(max(arr)) >= 2:
    print("?")
else:
    print(str_set[(arr.index(max(arr)))])