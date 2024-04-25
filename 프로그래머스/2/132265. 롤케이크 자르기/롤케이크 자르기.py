from collections import Counter


def solution(toppings):
    answer = 0
    up = Counter(toppings)
    down = set()

    for topping in toppings:
        up[topping] -= 1
        down.add(topping)

        if up[topping] == 0:
            up.pop(topping)

        if len(up.keys()) == len(down):
            answer += 1

    return answer


print(solution([1, 2, 1, 3, 1, 4, 1, 2]))