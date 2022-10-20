public class HackJum2 {
    public static void main(String[] args) {
        int koreanScore = 68;
        int mathScore = 90;
        int englishScore = 98;

        int sum;
        System.out.println("총점: " + sum(koreanScore, mathScore, englishScore));

        double average;
        System.out.println("평균: " + average(koreanScore, mathScore, englishScore));

    }

    public static int sum(int x, int y, int z) {
        int sum = x + y + z;

        return sum;
    }

    public static double average(int x, int y, int z) {
        double average = (x + y + z) / 3;

        return average;
    }
}
