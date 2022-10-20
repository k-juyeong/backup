package com.kh.dic;

import java.util.*;

public class Dictionary {
    private TreeMap<String, String> dictionary = new TreeMap<>();
    private String word;
    private String meaning;
    private int submenu = 0;
    Scanner scanner = new Scanner(System.in);

    public Dictionary() {
        super();
    }

    //저장
    public void addWord() throws DictionaryException {
        System.out.println("저장할 단어를 입력하세요.");
        System.out.print("단어: ");
        String firstWord = scanner.nextLine();
        word = firstWord.toLowerCase();
        if (dictionary.keySet().size() == 5) {
            System.out.println("최대 5개단어만 저장할 수 있습니다.");
            return;
        }
        if (dictionary.containsKey(word.toLowerCase())) {
            throw new DictionaryException("이미 등록되었습니다.");
        }
        System.out.print("뜻: ");
        meaning = scanner.nextLine();
        dictionary.put(word, meaning);
    }

    //검색
    public void searchWord() {
        System.out.println("검색할 단어를 입력하세요.");
        System.out.print("단어: ");
        word = scanner.nextLine();
        String theWord = dictionary.ceilingKey(word);
        if (dictionary.ceilingKey(word) == null) {
            System.out.println("단어를 검색할 수 없습니다.");
        } else if (!dictionary.containsKey(word.toLowerCase()) && !dictionary.containsKey(dictionary.ceilingKey(word))) {
            System.out.println("단어를 검색할 수 없습니다.");
        } else if (dictionary.containsKey(dictionary.ceilingKey(word))) {
            System.out.println(theWord + " : " + dictionary.get(theWord));
        } else if(dictionary.containsKey(word.toLowerCase())){
            System.out.println(word + ":" + dictionary.get(word));
        }
    }


    //삭제
    public void deleteWord() {
        System.out.println("삭제할 단어를 입력하세요.");
        System.out.print("단어: ");
        word = scanner.nextLine();
        if (!dictionary.containsKey(word.toLowerCase())) {
            System.out.println("단어를 검색할 수 없습니다.");
            return;
        }
        dictionary.remove(word);
        System.out.println("단어를 삭제하였습니다.");
    }

    //수정
    public void correctWord() {
        System.out.println("수정할 단어를 입력하세요.");
        System.out.print("단어: ");
        word = scanner.nextLine();
        if (!dictionary.containsKey(word.toLowerCase())) {
            System.out.println("단어를 검색할 수 없습니다.");
            return;
        }
        System.out.println("수정할 뜻을 입력하세요.");
        System.out.print("뜻: ");
        meaning = scanner.nextLine();
        dictionary.replace(word, meaning);
        System.out.println("단어의 뜻을 수정하였습니다.");
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionary=" + dictionary +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", scanner=" + scanner +
                '}';
    }


    //목록
    public void listWord() {
        boolean flag = false;
        while (!flag) {
            System.out.println("[서브메뉴] 1.오름차순 2.내림차순");
            System.out.print("원하는 메뉴 번호를 입력하세요: ");
            submenu = Integer.parseInt(scanner.nextLine());
            if (submenu == 1) {
                System.out.println(dictionary.entrySet());
                break;
            } else if (submenu == 2) {
                System.out.println(dictionary.descendingMap());
                break;
            } else {
                continue;
            }
        }
    }

    //색인
    public void indexWord() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.print("검색할 단어의 첫 알파벳을 입력하세요: ");
        String selectedAlphabet = scanner.nextLine();
        int num = alphabet.indexOf(selectedAlphabet)+1;
        String nextAlphabet = String.valueOf(alphabet.charAt(num));
        NavigableMap<String, String> subMap = dictionary.subMap(selectedAlphabet, true, nextAlphabet, false);
        System.out.println(subMap);

    }



    public Dictionary(TreeMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public TreeMap<String, String> getDictionary() {
        return dictionary;
    }


    //통계
    public void totalWord() {
        System.out.println("1.저장된 단어 개수: " + dictionary.keySet().size());
//        String longestWord=dictionary.

        System.out.println("2. 단어의 문자수가 가장 많은 단어: ");

        System.out.println("3.단어 글자수 내림차순 출력: ");
        Comparator op1 = new Comparator<Dictionary>() {
            @Override
            public int compare(Dictionary o1, Dictionary o2) {
                int result = 0;
                if (o1.word.length() > o2.word.length()) {
                    result = 1;
                } else if (o1.word.length() < o2.word.length()) {
                    result = -1;
                }
                return result -1;
            }
        };
        TreeMap<String, String> dictionaries = new TreeMap<>(op1);
        dictionaries.putAll(dictionary);
        System.out.println(dictionaries);
//


    }


}

