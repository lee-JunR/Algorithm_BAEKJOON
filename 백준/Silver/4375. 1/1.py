while True:
    try:
        n = int(input())
        cn = '1'
        while int(cn) % n != 0:
            cn = cn + '1'
        print(len(cn) )
    except:
        break