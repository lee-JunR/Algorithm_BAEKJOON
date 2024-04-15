def user_report_dict(id_list, report, k):
    user_report_info_dict = {id: {"report_ids": [], "reported_counts": 0, "is_banned" : False} for id in id_list}

    for report_string in report:
        reporter, reported_user = report_string.strip().split()

        # 신고 대상 유저 정보 추가
        user_report_info_dict[reporter]["report_ids"].append(reported_user)

        # 신고 받은 횟수
        user_report_info_dict[reported_user]["reported_counts"] += 1
    for reported_user in user_report_info_dict:
        if user_report_info_dict[reported_user]["reported_counts"] >= k:
            user_report_info_dict[reported_user]["is_banned"] = True

    return user_report_info_dict
def solution(id_list, report, k):
    # 각 유저는 한 번에 한 명의 유저 신고 가능 (동일 유저에 대한 신고 횟수는 1회로 처리됨)
    # k 번 이상 신고된 유저는 게시판 이용이 정지됨.
    # 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
    # 유저가 신고한 모든 내용을 취합하여 한꺼번에 게시판 이용 정지를 시키면서 정지 메일 발송.
    # id_list = 사용자들의 id 리스트 / report = 각 이용자가 신고한 id 정보가 담긴 문자열 배열 / k = 신고 횟수
    answer = [0] * len(id_list)

    # 일단 set으로 중복 제거 -> (동일 유저에 대한 신고 횟수는 1회로 처리됨)
    report = list(set(report))

    # 중복 제거한 데이터 파싱하여 신고 테이블 생성.(dict)
    user_report_table = user_report_dict(id_list, report,k)

    # is_banned = True 인 인원만 반환
    for idx, id in enumerate(id_list):
        for report_id in list(user_report_table[id]["report_ids"]):
            if user_report_table[report_id]["is_banned"]:
                answer[idx] += 1
    return answer