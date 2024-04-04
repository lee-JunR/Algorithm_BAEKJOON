def list_to_dict(lst):
    dct = {}
    for i in lst:
        if i in dct:
            dct[i] += 1
        else:
            dct[i] = 1
    return dct

def solution(want, number, discount):
    answer = 0
    wishlist = dict(zip(want, number))
    total_count = sum(number)
    discount_dict = list_to_dict(discount[:total_count])

    for i in range(len(discount) - total_count + 1):
        if discount_dict == wishlist:
            answer += 1
        # 할인 목록을 한 칸씩 옮겨가면서 사전을 업데이트
        if i + total_count < len(discount):
            discount_dict[discount[i]] -= 1
            if discount_dict[discount[i]] == 0:
                del discount_dict[discount[i]]
            if discount[i + total_count] in discount_dict:
                discount_dict[discount[i + total_count]] += 1
            else:
                discount_dict[discount[i + total_count]] = 1

    return answer
