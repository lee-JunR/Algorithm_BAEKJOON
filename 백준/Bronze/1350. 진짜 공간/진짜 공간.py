import sys
from math import ceil


def calculate_disk_amount(N, file_space, cluster_space):
    """
    프로그램에 파일 크기와 클러스터 크기를 입력받아 사용되는 실제 디스크 공간을 계산하여 출력하는 함수
    
    :param N: (int) 파일의 개수
    :param file_space: (list) 각 파일의 사이즈가 들어있는 리스트
    :param cluster_space: (int) 클러스터 크기
    :return: 각 파일당 총 차지하는 디스크의 공간
    """
    amount = 0

    for i in range(N):
        # 크기가 0인 파일은 클러스터가 필요 없으므로 디스크 크기에 영향 X
        if file_space[i] == 0:
            continue
        amount += cluster_space * ceil(file_space[i] / cluster_space)

    return amount


# INPUT

N = int(sys.stdin.readline())  # 파일의 개수 N
file_space = list(map(int, sys.stdin.readline().split()))  # 각 파일의 사이즈
cluster_space = int(sys.stdin.readline())  # 클러스터 크기

# OUTPUT
print(calculate_disk_amount(N, file_space, cluster_space))
