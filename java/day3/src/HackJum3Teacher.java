import java.util.Scanner;

public class HackJum3Teacher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("<< 3개의 과목을 입력받아 총점/평균 구하는 프로그램>>");
        System.out.print("국어 점수 >> ");
        String input1 = scanner.nextLine();
        int koreanScore = Integer.parseInt(input1);

        System.out.print("영어 점수 >> ");
        String input2 = scanner.nextLine();
        int englishScore = Integer.parseInt(input2);

        System.out.print("수학 점수 >> ");
        String input3 = scanner.nextLine();
        int mathScore = Integer.parseInt(input3);

        int sum=0;
        double average=0;


        sum = total (koreanScore, englishScore, mathScore);
        average = getAverage(sum, 3);

        System.out.println("총점 = " + sum);
        System.out.println("평균 = " + average);


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
