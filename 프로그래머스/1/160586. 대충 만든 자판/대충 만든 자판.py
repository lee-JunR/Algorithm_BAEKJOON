def get_min_press_dict(keymap_list):
    keymap_dict = {}
    for keymap in keymap_list:
        for press_count, key in enumerate(keymap):
            if keymap_dict.get(key) is None:
                keymap_dict[key] = press_count+1
            else:
                keymap_dict[key] = min(int(keymap_dict.get(key)), press_count+1)
    return keymap_dict

def solution(keymap, targets):
    # 일단 keymap에 리스트당 나올 수 있는 key 와 그 key의 최소 눌러야하는 횟수를 딕셔너리 타입으로 변환 하기. -> 해당 키맵 리스트들을 더해도 될듯.
    # 그리고 target 들을 돌면서 해당 내용의 눌러야하는 횟수를 출력 (만약 없으면 -1 출력)
    answer = []
    keymap_dict = get_min_press_dict(keymap)
    for target in targets:
        count = 0
        for t in target:
            try:
                count += keymap_dict.get(t)
            except:
                count = -1
                break
        answer.append(count)
    return answer