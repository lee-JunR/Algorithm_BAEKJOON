word = input()
for i, w in enumerate(word):
    print(w, end="")
    if i % 10 == 9: print()
