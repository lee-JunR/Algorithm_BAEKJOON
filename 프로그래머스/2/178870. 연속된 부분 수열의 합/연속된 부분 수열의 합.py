def solution(sequence, k):
    left = 0  # 좌측 포인터
    right = 0  # 우측 포인터
    cur_sum = sequence[0]  # 현재 부분 수열의 합
    min_length = float('inf')  # 가장 짧은 부분 수열의 길이
    result = None  # 결과 변수 초기화

    while right < len(sequence):
        if cur_sum == k:  # 부분 수열의 합이 k와 같으면
            if right - left + 1 < min_length:  # 현재 부분 수열이 더 짧으면 결과 갱신
                min_length = right - left + 1
                result = [left, right]
            cur_sum -= sequence[left]  # 좌측 포인터를 한 칸 우측으로 이동하여 합 갱신
            left += 1
        elif cur_sum < k:  # 부분 수열의 합이 k보다 작으면 우측 포인터를 한 칸 우측으로 이동하여 합 갱신
            right += 1
            if right < len(sequence):
                cur_sum += sequence[right]
        else:  # 부분 수열의 합이 k보다 크면 좌측 포인터를 한 칸 우측으로 이동하여 합 갱신
            cur_sum -= sequence[left]
            left += 1

    return result

print(solution([1, 2, 3, 4, 5], 7))
print(solution([1, 1, 1, 2, 3, 4, 5], 5))
print(solution([2, 2, 2, 2, 2], 6))
