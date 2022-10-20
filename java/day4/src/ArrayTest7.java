public class ArrayTest7 {
    public static void main(String[] args) {
        int[] x = new int[]{1, 2, 3, 4, 5};

        //일반 for문
        for (int i = 3; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
        System.out.println("====================");
        //향상된 for문
        //배열 or 컬렉션의 모든 요소를 순차적으로 접근하고자 할 때 일반 for문 대신 사용
        //for (요소를 대입할 변수 : 배열 or 컬렉션)
        for (int i : x) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

        int i = 0;
        for (i = 3; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
