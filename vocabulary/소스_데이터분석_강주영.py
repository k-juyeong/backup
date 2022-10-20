# 단어장 만들기
vocabulary = {}

# 메뉴 선택
flag = True

try :
    f = open('d:\\javaedu9\\project\\vocabulary\\voca.txt', 'r', encoding='UTF8')
except FileNotFoundError as e :
    print('저장된 단어 없음')
    pass
else :
    if f.readable() :
        for line in f.readlines() :
            print(line.strip())
        f.close

# 시작
while flag :
    def getVoca() :
        try :
            f = open('d:\\javaedu9\\project\\vocabulary\\voca.txt', 'r', encoding='UTF8')
        except FileNotFoundError as e :
            pass
        else :
            if f.readable() :
                for line in f.readlines() :
                    word = line.split(':')
                    vocabulary[word[0].strip()] = word[1].strip()
                f.close
    getVoca()

    print('메뉴 1.저장 2.검색 3.수정 4.삭제 5.목록 6.통계 7.종료(x)')
    menu = input('원하는 메뉴를 입력하세요 >> ')

    # 저장
    if menu == '1' :
        word = input('저장할 단어를 입력하세요 >> ').lower()
        if len(vocabulary) == 0 :
            meaning = input('단어의 뜻을 입력하세요 >> ')
            vocabulary[word] = meaning
        elif len(vocabulary) > 0 and len(vocabulary) < 5 :
            for key in vocabulary.keys() :
                if key == word :
                    print('이미 등록되었습니다.')
                    break
                else :
                    meaning = input('단어의 뜻을 입력하세요 >> ')
                    vocabulary[word] = meaning
                    break
        else :
            print('최대 5개 단어만 저장할 수 있습니다.')

        print(vocabulary)

    # 검색
    elif menu == '2' :
        word = input('찾을 단어를 입력하세요 >> ').lower()
        lengthOfWord = len(word)
        isExist = False

        for key in vocabulary.keys() :
            trimmedKey = key[0:lengthOfWord]
            if trimmedKey == word :
                print('{} : {}' .format(key, vocabulary[key]))
                isExist = True
                break

        if not isExist :
            print('단어를 검색할 수 없습니다')

        print(vocabulary)

    # 수정
    elif menu == '3' :
        word = input('수정할 단어를 입력하세요 >> ').lower()
        isExist = False

        for key in vocabulary.keys() :
            if key == word : 
                meaning = input('뜻을 입력하세요 >> ')
                vocabulary[key] = meaning
                isExist = True
                print('단어의 뜻을 수정하였습니다')
                break

        if not isExist :
            print('단어를 검색할 수 없습니다')

        print(vocabulary)

    # 삭제
    elif menu == '4' :
        word = input('삭제할 단어를 입력하세요 >> ').lower()
        isExist = False

        for key in vocabulary.keys() :
            if key == word : 
                del vocabulary[key]
                isExist = True
                print('단어를 삭제하였습니다')
                break

        if not isExist :
            print('단어를 검색할 수 없습니다')

        print(vocabulary)

    # 목록
    elif menu == '5' :
        print('1.오름차순 2.내림차순')
        submenu = input('원하는 정렬 방식을 입력하세요 >> ')
        sortedVocabulary = sorted(vocabulary.items())
        reversedVocabulary = reversed(sortedVocabulary)

        if submenu == '1' :
            print('==오름차순==')
            for item in sortedVocabulary :
                print('{} : {}' .format(item[0], item[1]))
        elif submenu == '2' :
            print('==내림차순==')
            for item in reversedVocabulary :
                print('{} : {}' .format(item[0], item[1]))
        else :
            print('잘못 입력하셨습니다.') 
            pass

    # 통계
    elif menu == '6' : 
        print('저장된 단어 갯수 : {}' .format(len(vocabulary)))

        longestWord = None
        for word1 in vocabulary.keys() :
            longestWord = word1
            for word2 in vocabulary.keys() :
                if len(longestWord) <= len(word2) :
                    longestWord = word2    
        print('단어의 문자 수가 가장 많은 단어 : {}' .format(longestWord))

        print('단어 글자 수 내림차순 출력(단어만)')

    # 종료
    elif menu == '7' or menu == 'x' or menu == 'X' :
        print('종료합니다')
        try :
            f = open('d:\\javaedu9\\project\\vocabulary\\voca.txt', 'a', encoding='UTF8')        
        except FileNotFoundError as e :
            f = open('d:\\javaedu9\\project\\vocabulary\\voca.txt', 'w')
            print(e)
        finally :
            if f.writable() :
                for item in vocabulary.items() :
                    f.write('{} : {} \n' .format(item[0], item[1]))
                f.close
        flag = False
    else :
        print('잘못 입력하셨습니다')
else :
    pass

