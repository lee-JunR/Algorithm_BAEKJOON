import sys
input = sys.stdin.readline

def remove_node(v):
    tree[v] = -2
    for i in range(n):
        if v == tree[i]:
            remove_node(i)

n = int(input())
tree = list(map(int, input().split()))
erase = int(input())

remove_node(erase)
remaining_subtrees = sum(1 for i in range(n) if tree[i] != -2 and i not in tree)

print(remaining_subtrees)
