class solution_class():
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

    def calculate_score(self):  # 결과 문자열 변환 함수
        for i in range(len(self.survey)):
            self.scores[self.survey[i]] += self.scoreboard[self.choices[i] - 1]

        self.answer[0] = self._compare('RT', 'TR')
        self.answer[1] = self._compare('CF', 'FC')
        self.answer[2] = self._compare('JM', 'MJ')
        self.answer[3] = self._compare('AN', 'NA')

    def _compare(self, key1, key2):
        if self.scores[key1] < self.scores[key2]:
            return 1
        return 0

    def get_result(self):
        self.calculate_score()
        result = ""
        for i in range(4):
            if self.answer[i] == 0:
                result += "RTCFJMAN"[i * 2]
            else:
                result += "RTCFJMAN"[i * 2 + 1]
        return result

def solution(survey, choices):
    answer = solution_class(survey, choices)
    return answer.get_result()