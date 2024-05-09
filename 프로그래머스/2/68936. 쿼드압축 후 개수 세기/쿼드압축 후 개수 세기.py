def compress(arr, x, y, size):
    # 영역이 모두 같은 값인지 확인하는 함수
    initial_value = arr[x][y]
    for i in range(size):
        for j in range(size):
            if arr[x + i][y + j] != initial_value:
                return False
    return True


def count_compression(arr, x, y, size, count):
    # 현재 영역이 모두 같은 값이라면
    if compress(arr, x, y, size):
        count[arr[x][y]] += 1  # 해당 값(0 또는 1)의 개수를 증가
        return
    
    # 그렇지 않다면, 4개 영역으로 나누어 재귀적으로 압축 수행
    half = size // 2
    count_compression(arr, x, y, half, count)
    count_compression(arr, x, y + half, half, count)
    count_compression(arr, x + half, y, half, count)
    count_compression(arr, x + half, y + half, half, count)


def solution(arr):
    n = len(arr)  # arr의 크기
    count = [0, 0]  # [0의 개수, 1의 개수]
    count_compression(arr, 0, 0, n, count)
    return count
