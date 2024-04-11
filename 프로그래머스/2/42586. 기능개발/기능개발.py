def solution(progresses, speeds):
    queue = [(progress, speed) for progress, speed in zip(progresses, speeds)]
    answer = []
    while queue:
        count = 0
        while queue and queue[0][0] >= 100:
            queue.pop(0)
            count += 1
        if count:
            answer.append(count)
        for i in range(len(queue)):
            queue[i] = (queue[i][0] + queue[i][1], queue[i][1])
    return answer
