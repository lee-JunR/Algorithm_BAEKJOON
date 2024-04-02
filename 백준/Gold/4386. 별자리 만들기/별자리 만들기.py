import math

def find_root(node):  # Using "root" for clarity
    if node != data[node]:  # Using "data" for the parent array
        data[node] = find_root(data[node])  # Path compression for efficiency
    return data[node]

def union(a, b):
    root_a = find_root(a)
    root_b = find_root(b)

    if root_a < root_b:  # Maintain structure for efficiency
        data[root_b] = root_a
    else:
        data[root_a] = root_b

num_stars = int(input())
data = [i for i in range(num_stars + 1)]  # Parent array with size n+1

star_positions = []
edges = []

for _ in range(num_stars):
    x, y = map(float, input().split())
    star_positions.append((x, y))

for i in range(num_stars - 1):
    for j in range(i + 1, num_stars):
        distance = math.sqrt((star_positions[i][0] - star_positions[j][0])**2 + (star_positions[i][1] - star_positions[j][1])**2)
        edges.append((distance, i, j))

edges.sort()

total_cost = 0
for edge in edges:
    cost, node1, node2 = edge

    if find_root(node1) != find_root(node2):
        union(node1, node2)
        total_cost += cost

print(round(total_cost, 2))