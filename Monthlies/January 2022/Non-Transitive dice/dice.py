"""
//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : January 30th, 2022
//PROBLEM ID                : USACO Drought
//SOURCES/HELPERS/HELPED    : Mr.H
"""



n = int(input())
a = [-1]*4
b = [-1]*4
winner = 0 # 0 if a wins, 1 if b wins, 2 if tie

def check(c):
    awins = 0
    cwins = 0
    for j in range(4):
        if a[j] > c[j]:
            awins += 1
        elif a[j] < c[j]:
            cwins += 1
    if awins > cwins:
        return False
    bwins = 0
    cwins = 0
    for j in range(4):
        if c[j] > b[j]:
            cwins += 1
        elif c[j] < b[j]:
            bwins += 1
    if bwins > cwins:
        return True
    return False
    """
    if(winner == 0):
        awins = 0
        cwins = 0
        for j in range(4):
            if a[j] > c[j]:
                awins += 1
            elif a[j] < c[j]:
                cwins += 1
        if awins > cwins:
            return False
        bwins = 0
        cwins = 0
        for j in range(4):
            if c[j] > b[j]:
                cwins += 1
            elif c[j] < b[j]:
                bwins += 1
        if bwins > cwins:
            return True
        return False
    elif(winner == 1):
        bwins = 0
        cwins = 0
        for j in range(4):
            if b[j] > c[j]:
                bwins += 1
            elif b[j] < c[j]:
                cwins += 1
        if bwins > cwins:
            return False
        awins = 0
        cwins = 0
        for j in range(4):
            if c[j] > a[j]:
                cwins += 1
            elif c[j] < a[j]:
                awins += 1
        if awins > cwins:
            return True
        return False
    else:
        cwins = 0
        awins = 0
        for j in range(4):
            if c[j] > a[j]:
                cwins += 1
            elif c[j] < a[j]:
                awins += 1
        if cwins > awins:
            bwins = 0
            cwins = 0
            for j in range(4):
                if c[j] > b[j]:
                    cwins += 1
                elif c[j] < b[j]:
                    bwins += 1
            if bwins > cwins:
                return True
            else:
                return False
        elif(awins > cwins):
            bwins = 0
            cwins = 0
            for j in range(4):
                if c[j] > b[j]:
                    cwins += 1
                elif c[j] < b[j]:
                    bwins += 1
            if cwins > bwins:
                return True
            else:
                return False
        else:
            return False"""

for i in range(n):
    string = input().split(" ")
    for j in range(4):
        a[j] = int(string[j])
    
    for j in range(4):
        b[j] = int(string[j+4])
    a.sort()
    b.sort()
    bwins = 0
    awins = 0
    for j in range(4):
        if a[j] > b[j]:
            awins += 1
        elif a[j] < b[j]:
            bwins += 1
    if awins > bwins:
        winner = 0
    else:
        print("no")
        continue
    c = [-1]*4
    flag = True
    for j in range(1,11):
        if not(flag):
            break
        for k in range(1,11):
            if not(flag):
                break
            for l in range(1,11):
                if not(flag):
                    break
                for m in range(1,11):
                    if not(flag):
                        break
                    c[0] = j
                    c[1] = k
                    c[2] = l
                    c[3] = m
                    if check(c):
                        print("yes")
                        flag = False
                        break
    if flag:
        print("no")


