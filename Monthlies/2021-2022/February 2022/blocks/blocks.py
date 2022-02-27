"""
//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : February 27th, 2022
//PROBLEM ID                : USACO Blocks
//SOURCES/HELPERS/HELPED    : Mr.H
"""


canUse = [True]*4
n = int(input())
blocks = []
for i in range(4):
    blocks.append(list(input()))

def good(word, count):
    if count == 3:
        return True
    for i in range(4):
        if word[count] in blocks[i] and canUse[i]:
            canUse[i] = False
            if good(word, count+1) == True:
                return True
    return False
    

for i in range(n):
    canUse = [True]*4
    word = input()
    if(good(word, 0)):
        print("YES")
    else:
        print("NO")