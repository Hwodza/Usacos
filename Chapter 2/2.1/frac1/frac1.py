"""
ID: hwodza1
TASK: frac1
LANG: PYTHON3                 
"""

"""
//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : March 15, 2022
//PROBLEM ID                : USACO Ordered Fractions
//PROBLEM DESCRIPTION       : Print out all fractions between 0 and 1 with denominators <= N
//SOURCES/HELPERS/HELPED    : Mr.H
"""
import math

#IO
fin = open ('frac1.in', 'r')
fout = open ('frac1.out', 'w')
N = int(fin.readline())

#Arrays for numerator, denominator, and fraction
num = [0,1]
den = [1,1]
dec = [0,1]

#Loop through all fractions
for i in range(2,N+1):
    x = 1
    for j in range(1,i):
        temp = float(j)/i

        #If the fraction is equal to a previous fraction, skip it
        if j != 1:
            gcd = math.gcd(j,i)
            if gcd != 1:
                continue    
        #Finds the right spot to insert the fraction
        while x < len(dec) and temp > dec[x]:
            x += 1
        #Inserts the fraction
        dec.insert(x,temp)
        num.insert(x,j)
        den.insert(x,i)

#Prints out the fractions
for x in range(len(dec)):
    fout.write(str(num[x])+'/'+str(den[x])+'\n')
