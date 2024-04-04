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

    for i in range(len(discount) - total_count + 1):
        if list_to_dict(discount[i:total_count + i]) == wishlist:
            answer += 1

    return answer
