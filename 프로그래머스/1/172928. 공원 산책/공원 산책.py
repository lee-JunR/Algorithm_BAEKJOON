def solution(park, routes):
    def find_character(park, c):
        for i in range(len(park)):
            for j in range(len(park[i])):
                if park[i][j] == c:
                    return [i, j]

    def is_valid_move(x, y):
        return 0 <= x < len(park) and 0 <= y < len(park[0]) and park[x][y] != 'X'

    cur_location = find_character(park, "S")

    for i in routes:
        op, s = i.split()
        s = int(s)
        new_location = cur_location.copy()
        if op == 'N':
            for _ in range(s):
                if is_valid_move(cur_location[0] - 1, cur_location[1]):
                    cur_location[0] -= 1
                else:
                    cur_location = new_location[:]
                    break

        elif op == 'S':
            for _ in range(s):
                if is_valid_move(cur_location[0] + 1, cur_location[1]):
                    cur_location[0] += 1
                else:
                    cur_location = new_location[:]
                    break

        elif op == 'W':
            for _ in range(s):
                if is_valid_move(cur_location[0], cur_location[1] - 1):
                    cur_location[1] -= 1
                else:
                    cur_location = new_location[:]
                    break

        elif op == 'E':
            for _ in range(s):
                if is_valid_move(cur_location[0], cur_location[1] + 1):
                    cur_location[1] += 1
                else:
                    cur_location = new_location[:]
                    break

    return cur_location
