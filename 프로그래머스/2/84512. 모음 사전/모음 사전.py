def solution(word):
    vowels = ['A', 'E', 'I', 'O', 'U']
    words = []

    def dfs(cur_word):
        # 현재 단어를 결과 리스트에 추가
        words.append(cur_word)

        # 길이가 5 이하인 경우에만 탐색을 진행
        if len(cur_word) < 5:
            for vowel in vowels:
                dfs(cur_word + vowel)

    # 깊이 우선 탐색 실행
    dfs("")

    # 사전에서 몇 번째 단어인지 계산하여 반환
    return words.index(word)