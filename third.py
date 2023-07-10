
# leaf1 = [0,0,2,4,7,7,9]
# leaf2 = [1,1,3,8]
# leaf3 = [0]

# steam_leaf = [leaf1, leaf2, leaf3]
# print(steam_leaf)

# for i in range(3):
#     print(f'{i}: {steam_leaf[i]}')

##

# a = int(input())
# bina = bin(a)
# bina = list(bina)

# print(bina[2:])

###
# def read_date():
#     year, month, day = tuple(map(int, input().split()))
#     return year, month, day

# def print_date(date):
#     year, month, day = date
#     print("%02d/%02d/%04d" % (month, day, year))

# def advance_day(date):
#     year, month, day = date
    
#     # end_of_month = (month == 1 and day == 31) or \
#                # (month == 2 and day == 28) or \
#                # (month == 3 and day == 31) or \
#                # (month == 4 and day == 30) or \
#                # (month == 5 and day == 31) or \
#                # (month == 6 and day == 30) or \
#                # (month == 7 and day == 31) or \
#                # (month == 8 and day == 31) or \
#                # (month == 9 and day == 30) or \
#                # (month == 10 and day == 31) or \
#                # (month == 11 and day == 30) or \
#                # (month == 12 and day == 31)
    
#     #end_of_month = (month in [1, 3, 5, 7, 8, 10, 12] and day == 31) or \
#     #                     (month in [4, 6, 9, 11] and day == 30) or \
#     #                     (month == 2 and day == 28)
    
#     end_of_month = (month, day) in [(1, 31), (2, 28), (3, 31), (4, 30), (5,
#         31), (6, 30), (7, 31), (8, 31), (9, 30), (10, 31), (11, 30), (12, 31)]
    
#     end_of_year = month == 12 and day == 31
    
#     if end_of_month:
#         if end_of_year:
#             year += 1
#             month = 1
#             day = 1
#         else:
#             month += 1
#             day = 1
#     else:
#         day += 1
    
#     return year, month, day
    
# if __name__ == "__main__":
#     today = read_date()
#     print_date(today)
#     tomorrow = advance_day(today)
#     print_date(tomorrow)

###
# txt = '''신경발달장애 Neurodevelopmental Disorders
# 조현병 스펙트럼 및 기타 정신병적 장애 Schizophrenia Spectrum and Other Psychotic Disorders
# 양극성 및 관련 장애 Bipolar and Related Disorders
# 우울장애 Depressive Disorders
# 불안장애 Anxiety Disorder
# 강박 및 관련 장애 Obsessive－Compulsive and Related Disorders
# 외상 및 스트레스 관련 장애 Trauma－and Stressor－Related Disorders
# 해리장애 Dissociative Disorders
# 신체증상 및 관련 장애 Somatic Symptom and Related Disorders
# 급식 및 섭식장애 Feeding and Eating Disorders
# 배설장애 Elimination Disorders
# 수면－각성 장애 Sleep－Wake Disorders
# 성기능부전 Sexual Dysfunctions
# 성별 불쾌감 Gender Dysphoria
# 파괴적, 충동조절 및 품행 장애 Disruptive, Impulse－Control, and Conduct Disorders
# 물질관련 및 중독 장애 Substance－Related and Addictive Disorders
# 신경인지장애 Neurocognitive Disorders
# 성격장애 Personality Disorders
# 변태성욕장애 Paraphilic Disorders
# 기타 정신질환 Other Mental Disorders'''

# disorders = dict()

# is_eng = lambda x: 65 <= ord(x) <= 90 or 97 <= ord(x) <= 122

# for l in txt.splitlines():
#     i = 0
#     while not is_eng(l[i]):
#         i += 1
#     else:
#         ko, en = l[:i - 1], l[i:]
#         disorders[ko] = en

# print(disorders)


###
# dice1 = (1, 2, 3, 4, 5, 6)
# dice2 = (2, 3, 5, 7, 11, 13)
# results = []

# for i in range(len(dice1)):
#     for j in range(len(dice2)):
        
#         S = dice1[i] + dice2[j]
#         results.append(S)

# print(set(results))

###

# voca = """
# 게맛살
# 구멍
# 글라이더
# 기차
# 대롱
# 더치페이
# 도리
# 롱다리
# 리본
# 멍게
# 박쥐
# 본네트
# 빨대
# 살구
# 양심
# 이빨
# 이자
# 자율
# 주기
# 쥐구멍
# 차량
# 차박
# 트라이앵글
# """.split()

# init_word = '기차'
# print('끝말잇기를 하자. 내가 먼저 말할게.\n' + init_word)
# spoken_words = [init_word]

# while True:
#     user_input = input('> ')
    
#     if not user_input:
#         continue
#     elif user_input == "졌다":
#         print('야호!')
#         break
#     elif user_input[0] != spoken_words[-1][-1]:
#         print('글자가 안 이어져. 내가 이겼다!')
#         break
#     elif user_input in spoken_words:
#         print('아까 했던 말이야. 내가 이겼어!')
#         break
#     else:
#         spoken_words.append(user_input)
#         my_word = None
#         for word in list(set(voca) - set(spoken_words)):
#             if word[0] == user_input[-1]:
#                 my_word = word
#                 break
       
#         if not my_word:
#             print('모르겠다. 내가 졌어.')
#             break
#         else:
#             print(my_word)
#             spoken_words.append(my_word)
#             continue
    

# from tkinter import *

# widget = Label(None, text='I love Python!')
# widget.pack()

###########

# import math
# y, z = 0,0

# def hypotenus(a,b):
#     a,b = map(int, input().split())
#     x = a**2 + b**2
#     x = math.sqrt(x)
#     print(round(x, 2))

# hypotenus(y,z)

import calendar
c  = calendar.TextCalendar
print(help(c))