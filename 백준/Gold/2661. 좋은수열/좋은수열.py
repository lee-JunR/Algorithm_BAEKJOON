def is_good_sequence(sequence):
    length = len(sequence)
    for i in range(1, (length // 2) + 1):
        if sequence[-i:] == sequence[-2 * i:-i]:
            return False
    return True


def generate_good_sequence(N, sequence):
    if N == 0:
        print(sequence)
        exit()

    for i in range(1, 4):
        new_sequence = sequence + str(i)
        if is_good_sequence(new_sequence):
            generate_good_sequence(N - 1, new_sequence)


N = int(input())
generate_good_sequence(N, "")
