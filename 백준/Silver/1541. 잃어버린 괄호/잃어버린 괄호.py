"""
55-50+40
['55', '50+40']
"""

exp = input().split("-")

num = []  # - 로 나눈 핟을의 합을 저장할 리스트

for i in exp:
    sum = 0
    tmp = i.split("+")
    for j in tmp:
        sum += int(j)
    num.append(sum)

n = num[0]

for i in range(1, len(num)):
    n -= num[i]

print(n)
