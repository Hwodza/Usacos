"""
ID: hwodza1
TASK: fact4
LANG: PYTHON3                 
"""
import math

fin = open ('fact4.in', 'r')
fout = open ('fact4.out', 'w')
n = fin.readline()
fact = math.factorial(int(n))
txt = str(fact) [::-1]
print(txt)
fact = int(txt)
fout.write(str(fact)[0] + '\n')

fin.close()
