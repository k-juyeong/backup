
from traceback import print_tb


vocabulary = {}

vocabulary['student'] = '학생'
vocabulary['teacher'] = '선생님'
vocabulary['classroom'] = '교실'
vocabulary['smart'] = '똑똑한'
vocabulary['lunch'] = '점심'

# # 저장
# word = input('저장할 단어를 입력하세요 >> ')


# # 최대 5개까지
# # 중복 불가
# if len(vocabulary) == 0 :
#     meaning = input('단어의 뜻을 입력하세요 >> ')
#     vocabulary[word] = meaning
# elif len(vocabulary) > 0 and len(vocabulary) < 5 :
#     for key in vocabulary.keys() :
#         if key == word :
#             print('이미 등록된 단어입니다.')
#             break
#         else :
#             meaning = input('단어의 뜻을 입력하세요 >> ')
#             vocabulary[word] = meaning
#             break
# else :
#     print('단어는 최대 5개까지만 입력가능합니다.')

# print(vocabulary)

# 검색
# word = input('찾을 단어를 입력하세요 >> ')
# lengthOfWord = len(word)

# for key in vocabulary.keys() :
#     trimmedKey = key[0:lengthOfWord]
#     if trimmedKey == word :
#         print('{} : {}' .format(key, vocabulary[key]))
#         break
#     else :
#         print('단어를 검색할 수 없습니다')
#         break


# 수정
# word = input('수정할 단어를 입력하세요 >> ')
# isExist = False

# for key in vocabulary.keys() :
#     if key == word : 
#         meaning = input('뜻을 입력하세요 >> ')
#         vocabulary[key] = meaning
#         isExist = True
#         break

# if not isExist :
#     print('단어를 검색할 수 없습니다')

# print(vocabulary)

# 삭제
# word = input('삭제할 단어를 입력하세요 >> ')
# isExist = False

# for key in vocabulary.keys() :
#     if key == word : 
#         del vocabulary[key]
#         isExist = True
#         print('단어를 삭제하였습니다')
#         break

# if not isExist :
#     print('단어를 검색할 수 없습니다')

# print(vocabulary)

# 목록
# print('1.오름차순 2.내림차순')
# submenu = input('원하는 정렬 방식을 입력하세요 >> ')
# sortedVocabulary = sorted(vocabulary.items())
# reversedVocabulary = reversed(sortedVocabulary)

# if submenu == '1' :
#     for item in sortedVocabulary :
#         print('{} : {}' .format(item[0], item[1]))
# elif submenu == '2' :
#     for item in reversedVocabulary :
#         print('{} : {}' .format(item[0], item[1]))
# else :
#     print('잘못 입력하셨습니다.') 
#     pass


# 통계
def infoOfVocabulary() :
    print('저장된 단어 갯수 : {}' .format(len(vocabulary)))

    longestWord = None
    for word1 in vocabulary.keys() :
        longestWord = word1
        for word2 in vocabulary.keys() :
            if len(longestWord) <= len(word2) :
                longestWord = word2    
    print('단어의 문자 수가 가장 많은 단어 : {}' .format(longestWord))

    import operator 
    vocabularyWithLength = {}
    for item1 in vocabulary.keys() :
        for item2 in vocabulary.keys() :
            result = operator.ge(len(item1), len(item2))
            print(result)
            if result :
                item1
            else :
                item2
    # print(sortedVocabulary)
    print('단어 글자 수 내림차순 출력(단어만)')

infoOfVocabulary()
# 종료

# 공통
# 파일 IO