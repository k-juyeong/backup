public class HackJumTeacher {
    public static void main(String[] args) {
        int kor = 60;
        int eng = 100;
        int math = 81;

        int sum = 0;
        double average = 0.0;

       sum = kor + eng + math;
       //case1)
       //average = (double)sum / 3;
       //case2)
       //average = sum / (double)3;
       //case3)
       average = sum / (3 * 1.0);
        System.out.println("총점= " + sum);
        System.out.println("평균= " + average);
    }
}
