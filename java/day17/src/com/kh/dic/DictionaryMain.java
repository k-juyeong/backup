package com.kh.dic;

import java.util.Scanner;

public class DictionaryMain {
    public static void main(String[] args) throws DictionaryException {

        Scanner scanner = new Scanner(System.in);
        String menu;

        Dictionary dictionary = new Dictionary();

        boolean stop = false;
        do {
            System.out.println();
            System.out.println("=============================================================");
            System.out.println("[메뉴] 1.저장 2.검색 3.수정 4.삭제 5.목록 6.색인 7.통계 8.종료(x) ");
            System.out.print("원하는 메뉴 번호를 입력하세요: ");
            menu = scanner.nextLine();
            switch (menu) {
                case "1": //저장
                    try {
                        dictionary.addWord();
                    } catch (DictionaryException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2": //검색
                    dictionary.searchWord();
                    break;
                case "3": //수정
                    dictionary.correctWord();
                    break;
                case "4": //삭제
                    dictionary.deleteWord();
                    break;
                case "5": //목록
                    dictionary.listWord();
                    break;
                case "6": //색인
                    dictionary.indexWord();
                    break;
                case "7": //통계
                    dictionary.totalWord();
                    break;
                case "8": //종료
                    System.out.println("작업이 종료됩니다.");
                    stop = true;
                    break;
                default:
                    System.out.println("없는 메뉴입니다.");
                    break;
            }
        } while (!stop);
    }
}
