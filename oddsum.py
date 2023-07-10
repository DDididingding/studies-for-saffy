N = int(input())

for i in range(N):
    a = 0
    tenFigure = list(map(int, input().split()))
    for j in range(10):
        if tenFigure[j]%2 !=0:
            a = a + tenFigure[j]
    print(f'#{i+1} {a}')


