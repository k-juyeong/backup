public class HackJum {
    public static void main(String[] args) {
        int koreanScore = 60;
        int englishScore = 100;
        int mathScore = 80;

        int sum = koreanScore + mathScore + englishScore;
        System.out.println("총점=" + sum);

        double average = sum / 3;
        System.out.println("평균=" + average);
    }
}
