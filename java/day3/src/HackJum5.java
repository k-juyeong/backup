import java.util.Scanner;

public class HackJum5 {
    public static void main(String[] args) {

        boolean stop = false;
        System.out.println("<< 3개의 과목을 입력받아 총점/평균 구하는 프로그램>>");


        while (!stop) {
            int koreanScore = inputValue("국어");
            if (koreanScore == -1) {
                stop = true;
                continue;
            }
            int englishScore = inputValue("영어");
            if (englishScore == -1) {
                stop = true;
                continue;
            }
            int mathScore = inputValue("수학");
            if (mathScore == -1) {
                stop = true;
                continue;
            }


            int sum = 0;
            double average = 0;

            sum = total(koreanScore, englishScore, mathScore);
            average = getAverage(sum, 3);

            System.out.println("총점 = " + sum);
            System.out.println("평균 = " + average);
        }
    }

    public static int inputValue(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title + " 점수 >> ");
        String input = scanner.nextLine();

        int score = 0;
        if (input.equals("Q") || input.equals("q")) {
            score = -1;
        } else {
            score = Integer.parseInt(input);
        }

        return score;
    }


    public static int total(int kor, int eng, int math) {
        //      return  kor + eng + math;
        int result = kor + eng + math;
        return result;
    }

    //평균 구하기
    public static double getAverage(int total, int count) {
        return  total / (double)count;
    }
}
