public class HackJum2Teacher {
    public static void main(String[] args) {
        int koreanScore = 68;
        int mathScore = 90;
        int englishScore = 98;

        int sum;
        double average;

        sum = total (koreanScore, englishScore, mathScore);
        average = getAverage(sum, 3);

        System.out.println("총점 = " + sum);
        System.out.println("평균 = " + average);


        System.out.println(total(1, 2, 3));
        System.out.println(getAverage(100,10));
    }

    //3과목의 합계
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
