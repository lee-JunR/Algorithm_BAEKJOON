def solution(today, terms, privacies):
    # 결과를 저장할 리스트
    result = []

    # 오늘 날짜를 datetime 객체로 변환
    today_date = list(map(int, today.split('.')))

    # 약관 종류와 유효기간을 딕셔너리로 저장
    term_dict = {}
    for term in terms:
        t, period = term.split()
        term_dict[t] = int(period)

    # 개인정보를 순회하면서 보관 여부 확인
    for idx, priv in enumerate(privacies):
        date_str, term = priv.split()
        collect_date = list(map(int, date_str.split('.')))
        expiration_date = collect_date.copy() # expiration_day = [2] expiration_month [1] expiration_year[0]
        expiration_date[2] = collect_date[2] + term_dict[term] * 28 -1

        # 만약 만료 날짜가 해당 월의 일 수를 넘어간다면 다음 달로 넘어감
        while expiration_date[2] > 28:
            expiration_date[2] -= 28
            expiration_date[1] += 1
            if expiration_date[1] > 12:
                expiration_date[1] -= 12
                expiration_date[0] += 1

        # 파기해야 할 개인정보인지 확인
        if expiration_date < today_date:  # 유효기간이 지난 경우에만 추가
            result.append(idx + 1)

    return result