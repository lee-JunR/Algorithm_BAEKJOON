week = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
month = [31,28,31,30,31, 30,31,31,30,31, 30,31]
x, d = map(int, input().split())
print(week[(sum(month[0:(x-1)]) + d) % 7])