def organize_clothes(clothes):
    clothes_dict = {}
    for item, category in clothes:
        if category in clothes_dict:
            clothes_dict[category].append(item)
        else:
            clothes_dict[category] = [item]
    return clothes_dict

def solution(clothes):
    answer = 1
    clothes_dict = organize_clothes(clothes)
    for category, items in clothes_dict.items():
        answer *= len(items) + 1
    return answer - 1