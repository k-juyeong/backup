import java.util.Scanner;

public class HackJum4 {
    public static void main(String[] args) {


        System.out.println("<< 3개의 과목을 입력받아 총점/평균 구하는 프로그램>>");



        int koreanScore = inputValue("국어");
        int englishScore = inputValue("영어");
        int mathScore = inputValue("수학");


        int sum=0;
        double average=0;


        sum = total (koreanScore, englishScore, mathScore);
        average = getAverage(sum, 3);

        System.out.println("총점 = " + sum);
        System.out.println("평균 = " + average);


    }

    public static int inputValue(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title + " 점수 >> ");
        int score = Integer.parseInt(scanner.nextLine());
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
