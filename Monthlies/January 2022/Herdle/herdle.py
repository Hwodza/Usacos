"""
//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : January 30th, 2022
//PROBLEM ID                : USACO Herdle
//SOURCES/HELPERS/HELPED    : Mr.H
"""

rows, cols = (3,3)
correct = [['0' for i in range(cols)] for j in range(rows)]
guess = [['0' for i in range(cols)] for j in range(rows)]
check = [[False for i in range(cols)] for j in range(rows)]
used = [[False for i in range(cols)] for j in range(rows)]
for i in range(3):
    temp = input()
    for j in range(3):
        correct[i][j] = temp[j]
for i in range(3):
    temp = input()
    for j in range(3):
        guess[i][j] = temp[j]

green, yellow = 0,0

for i in range(3):
    for j in range(3):
        if correct[i][j] == guess[i][j]:
            green += 1
            check[i][j] = True
            used[i][j] = True
flag = True
for i in range(3):
    for j in range(3):
        if(flag == True):
            if check[i][j] == False:
                for k in range(3):
                    if(flag == True):
                        for l in range(3):
                            #print("Correct", i,j, "Guess", k,l)
                            if(flag == True):
                                if(used[k][l] == False):
                                    if correct[i][j] == guess[k][l]:
                                        #print("Here")
                                        yellow += 1
                                        check[i][j] = True
                                        used[k][l] = True
                                        flag = False
        flag = True    
                    
            

print(green)
print(yellow)
