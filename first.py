# r = 800
# t = 110
# size = r*t/1000

# print("size: ", size, "MB")

#----------------------------------------------------

# family = ["mom", "dad", "sister", "brother"]

# family.remove("sister")

# print(family)

#----------------------------------------------------

# print('직각삼각형 그리기\n')
# leg = int(input('변의 길이: '))

# for i in range(leg):
#     print('* ' * (i + 1))

# area = (leg ** 2) / 2
# print('넓이:', area)

#----------------------------------------------------

# 제곱수 출력
# a = int(input())

# print(a*a)

#----------------------------------------------------

# num = 1

# while num <= 100:
#     print(num)
#     num += 1

#----------------------------------------------------

# a= int(input('정수를 입력하세요 : '))
# b = 1

# while b <= a:
#     print(a)
#     b += 1

#----------------------------------------------------

# num = int(input('정수를 입력하세요 : '))

# num1 = 1

# while num1 <= num:
#     print (num1, num1**2)
#     num1 += 1

#----------------------------------------------------

# height = 100
# times = 1

# while times <= 10 :
#     height = height*0.6

#     print(times, round(height,4))
#     times += 1

#----------------------------------------------------

# number = 358

# rem = rev = 0
# while number >= 1:
#     rem = number % 10
#     rev = rev * 10 + rem
#     number = number // 10

# print(rev) #결과 마춰따

#----------------------------------------------------

# num = int(input('1과 3사이의 수 입력 : '))

# if num == 1:
#     print('일')
# elif num == 2:
#     print('이')
# elif num == 3:
#     print('삼')
# else:
#     print('말을 안듣는군')

#----------------------------------------------------

# num = int(input('what year were you born?? '))

# if num <= 1924:
#     print('The greatest generation')
# elif 1945>= num >= 1925:
#     print('The silent generation')
# elif 1946 <= num <= 1964:
#     print('baby boomer')
# elif 1965 <= num <= 1980:
#     print('Generation X')
# elif 1981 <= num <= 1996:
#     print('millennial')
# elif 1997 <= num:
#     print('Generation Z')

#----------------------------------------------------

# a = 1
# sum = 0
# while a:
#     num = int(input())

#     if num >= 0:
#         sum = sum + num
#     else:
#         print(sum)
#         break

#----------------------------------------------------

# year = int(input('year : '))

# if year%4 == 0:
#     if year%100 == 0:
#         if year%400 == 0:
#             print(year,'년은 윤년입니다.')
#         else:
#             print(year,'년은 평년입니다')
#     else:
#         print(year, '년은 윤년입니다')
# else:
#     print(year, '년은 평년입니다')


#----------------------------------------------------
#함수 만들기
def compare(a, b):
    if a>b:
        print(a,'>',b)
    elif a<b:
        print(a,'<',b)
    else:
        print(a,'==',b)

compare(1,3)