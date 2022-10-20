# 파일 존재여부 판단하기

import os.path

file = r'd:\javaedu9\project\python\test.txt'
print(os.path.exists(file))

vocabulary = None
if not os.path.exists(file) :
    # 파일이 존재하지 않으면 신규
    vocabulary = open(file, 'w', encoding='UTF8')
    print('신규파일 열기')
else :
    # 파일이 존재하면 추가
    vocabulary = open(file, 'a', encoding='UTF8')
    print('기존파일 열기')
