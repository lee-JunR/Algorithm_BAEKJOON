def gcd(a, b):
  while b != 0:
    remainder = a % b
    a = b
    b = remainder

  return a

def main():
  n = int(input())  

  for _ in range(n):
    a, b = map(int, input().split())  
    gcd_value = gcd(a, b)
    print(gcd_value)

if __name__ == "__main__":
  main()