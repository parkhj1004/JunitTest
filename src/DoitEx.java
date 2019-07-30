import org.junit.jupiter.api.Test;

public class DoitEx {

    @Test
    public void ex2_10() {

        int count = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        for(int n = 3; n <= 1000 ; n += 2) {
            int i;
            for(i = 1; i < ptr; i++) {
                count++;

                if (n % prime[i] == 0) {
                    break;
                }
            }

            if(ptr == i) {
                prime[ptr++] = n;
            }
        }

        for(int p : prime) {
            System.out.println(p);
        }

        System.out.printf("나눗셈을 수행한 횟수 : %d\n" , count);


    }

    @Test
    public void ex2_9() {

        int count = 0;
        int j;

        for(int i = 2; i <= 1000; i++) {
            for(j = 2; j < i ; j++) {
                count++;

                if(i%j == 0) {
                    break;
                }
            }

            if(i == j) {
                System.out.println(i);
            }
        }

        System.out.printf("나눗셈을 수행한 횟수 : %d" , count);
    }

    @Test
    public void ex2_8_B() {

        int num = 59;
        int cd = 16;
        int again = 0;

        System.out.println("10진수를 기수 변환합니다.");

        do {

            do {
                System.out.println("변환하는 음이 아닌 정수 : " + num);

            } while (num < 0);

            do{

                System.out.println("어떤 진수로 변환할까요? (2~36) " + cd);
            } while (cd < 2 || cd > 36);

            System.out.printf("%d 진수로는 %s 입니다." , cd , ex2_8_A(num , cd));

        } while (again != 0);


    }

//    @Test
//    public String ex2_8_A() {
    public String ex2_8_A(int in_1 , int in_2) {

//        int in_1 = 59;
//        int in_2 = 2;

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        String c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

//        System.out.println(c.length());

        char[] result = new char[c.length()];

        do {

            result[idx++] = c.charAt(in_1 % in_2);
            in_1/=in_2;
        } while (in_1 != 0);

        for(char tmp : result) {
//            System.out.print(tmp);
            sb.append(tmp);
        }

        return sb.toString();

    }
}
