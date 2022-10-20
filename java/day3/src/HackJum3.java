import java.util.Scanner;

public class HackJum3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(">> 국,영,수 총점, 평균 구하기 <<");
        System.out.println("국어, 영어, 수학 점수를 입력하세요");

        System.out.print("국어: ");
        int koreanScore = Integer.parseInt(scanner.nextLine());
        System.out.print("영어: ");
        int englishScore = Integer.parseInt(scanner.nextLine());
        System.out.print("수학: ");
        int mathScore = Integer.parseInt(scanner.nextLine());

        int sum=0;
        double average=0;


        System.out.println("평균: " + average(koreanScore, englishScore, mathScore));
        System.out.println("총점: " + sum(koreanScore, englishScore, mathScore));

    }

    public static int sum(int x, int y, int z) {
        int result = x + y + z;

        return result;
    }

    public static double average(int x, int y, int z) {
        double result = (x + y + z) / 3;

        return result;
    }
}
