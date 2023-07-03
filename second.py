# def numOfDigits():
#     num = input('정수를 입력하세요 : ')
#     print(len(num))

# numOfDigits()

#####

# for i in range(2,10):
#     for j in range(1,10):
#         # print(i, '*',j,'=',i*j)
#         print(f'{i} * {j} = {i*j}') #f문자열 사용법

###

# def area(a, h):
#     l = input('밑변과 높이를 입력하세요 : ')
#     a,h = map(int, l.split())
#     b = a*h/2

#     return b

# a, h = 0,0
# c = area(a,h)

# print(c)

###

# def korean_number(x):
#     x = input()
#     match x % 10:
#        case 1:
#             print('일'); 

###

# def triple(x):
#     print(x*3)

# triple(2)
# triple('h') #문자 숫자를 내가 구분할 필요가 없다는 것을 간과

# from functools import reduce
# print(reduce(lambda x,y : x+y, [0,1,2,3,4]))

# def read(text):
#     ridename, limit = map(str.strip, text.split(':'))
    
#     cmmin = cmmax = None
#     if '~' in limit:
#         templist = []
#         for x in limit.split('~'):
#             templist.append(x.replace('cm', ''))
#         cmmin, cmmax = templist[0], templist[1]
#     elif "이상" in limit:
#         cmmin = int(limit.split("cm")[0])

#     return ridename, cmmin, cmmax


# if __name__ == "__main__":
#     ridename, cmmin, cmmax = read(input())
#     print("이름:", ridename)
#     print("하한:", cmmin)
#     print("상한:", cmmax)

###

# def palindrome(x):
#     x = x.lower()
#     x = x.replace(' ', '')
#     if x == x[::-1]:
#         print('True')
#     else:
#         print('False')

# palindrome('anna')
# palindrome('banana')
# palindrome('Anna')
# palindrome('My gym')

###

# def sumOfDigits(num):
#     num = int(input('숫자를 입력하세용 : '))
#     a = 0
#     for i in list(str(num)):
#         a += int(i)
#     return(a)

# x = int
# print(sumOfDigits(x))

###

