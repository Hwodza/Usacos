"""
//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : February 27th, 2022
//PROBLEM ID                : USACO Photoshoot 2
//SOURCES/HELPERS/HELPED    : Mr.H
"""

n = int(input())
original = list(map(int, input().split()))
desired = list(map(int, input().split()))

total = 0
cutoff = 0
while(cutoff < n and original[cutoff] == desired[cutoff]):
    cutoff += 1

while(cutoff < n):
    if original[cutoff] == desired[cutoff]:
        cutoff += 1
        continue
    for i in range(cutoff, n):
        if desired[cutoff] == original[i]:
            original.insert(cutoff, original[i])
            original.pop(i+1)
            total += 1
            cutoff += 1
print(total)
