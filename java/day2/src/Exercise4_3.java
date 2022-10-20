public class Exercise4_3 {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            if (i == 10) {
                break;
            }
        }
    }
}
