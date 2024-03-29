def solution(n, lost, reserve):
    real_lost = set(lost) - set(reserve)
    real_reserve = set(reserve) - set(lost)
    
    real_lost = sorted(list(real_lost))
    
    for student in real_lost:
        if student - 1 in real_reserve:
            real_reserve.remove(student - 1)
        elif student + 1 in real_reserve:
            real_reserve.remove(student + 1)
        else:
            n -= 1  
            
    return n