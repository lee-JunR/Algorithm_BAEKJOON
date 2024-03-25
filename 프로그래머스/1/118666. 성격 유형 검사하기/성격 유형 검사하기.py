class Solution:
    def __init__(self, survey, choices):
        self.survey = survey
        self.choices = choices
        self.scoreboard = [3, 2, 1, 0, -1, -2, -3]
        self.scores = {
            "RT": 0,
            "TR": 0,
            "CF": 0,
            "FC": 0,
            "JM": 0,
            "MJ": 0,
            "AN": 0,
            "NA": 0
        }
        self.answer = [0] * 4  # answer 초기화 R, C, J, A

    def calculate_score(self):
        for i in range(len(self.survey)):
            # 각 선택지에 대해 해당하는 지표의 점수를 계산하여 누적
            survey_type = self.survey[i]
            choice = self.choices[i]
            self.scores[survey_type] += self.scoreboard[choice - 1]

    def get_result(self):
        self.calculate_score()
        result = ""
        for i, survey_type in enumerate(["RT", "CF", "JM", "AN"]):
            # 각 지표별로 높은 점수를 받은 성격 유형을 선택
            if self.scores[survey_type] < self.scores[survey_type[::-1]]:
                result += survey_type[1]  # 높은 점수를 받은 성격 유형의 두 번째 문자
            else:
                result += survey_type[0]  # 높은 점수를 받은 성격 유형의 첫 번째 문자
        return result
def solution(survey, choices):
    answer = Solution(survey, choices).get_result()
    return answer