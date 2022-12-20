import sys

input = sys.stdin.readline

Number = ['ABC', "DEF", 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

word = list(input())
second = 0

for i in word:
    for j in Number:
        if i in j:
            second += Number.index(j) + 3

print(second)
