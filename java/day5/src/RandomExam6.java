import java.util.Arrays;

/*
    로또 프로그램 구현하기
    : 1~45 번호 중 중복되지 않는 6자리 추출하기
    Math.random() : 0 <= ? <1 사이의 랜덤한 실수 발생
 */
public class RandomExam6 {
    public static void main(String[] args) {
        Util util = new Util();
        String name = new String("홍길동");
//        name.
        //Scanner scanner = new Scanner(System.in);

        int[] lotto = new int[6];


        int count = 0; // for문 반복횟수 카운트

        //for문을 무한 루프 while문으로 수정하기
        boolean stop = false;

        while (!stop) {
            int num = (int) (Math.floor(Math.random() * 45) + 1);

            // 동일 번호가 존재하면
            if (util.isExist(lotto, num)) {
                continue;
            // 동일 번호가 존재하지 않으면 배열요소에 저장
            } else {
                lotto[count++] = num;
            }

            // 로또 번호 6개가 모두 추출되면 무한루프를 빠져나온다.
            if (count == lotto.length) {
                stop = true;
            }
        }
        for (int i = 0; i < lotto.length; i++) {
            Util.printLine('-', 3);
            System.out.println(lotto[i]);
        }
    }
}