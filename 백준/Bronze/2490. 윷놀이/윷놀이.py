for _ in range(3):
  i = sum(list(map(int, input().split())))
  if i == 0:
    print("D") #윷
  elif i == 1:
    print("C") #걸
  elif i == 2:
    print("B") #개
  elif i == 3:
    print("A") #도
  else:
    print("E") #모