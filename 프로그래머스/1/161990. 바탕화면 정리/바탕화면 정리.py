def solution(wallpaper):
    leftmost_x = len(wallpaper)
    leftmost_y = len(wallpaper[0])
    rightmost_x = -1
    rightmost_y = -1

    # 바탕화면을 순회하면서 파일의 위치를 찾음
    for x in range(len(wallpaper)):
        for y in range(len(wallpaper[x])):
            if wallpaper[x][y] == '#':
                # 가장 왼쪽 위의 파일 좌표 찾기
                leftmost_x = min(leftmost_x, x)
                leftmost_y = min(leftmost_y, y)
                # 가장 오른쪽 아래의 파일 좌표 찾기
                rightmost_x = max(rightmost_x, x)
                rightmost_y = max(rightmost_y, y)

    return [leftmost_x, leftmost_y, rightmost_x + 1, rightmost_y + 1]