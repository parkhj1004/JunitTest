import java.util.Arrays;
import java.util.Objects;
import org.junit.Test;

public class DoitEx {

    @Test
    public void ex3_1() {
        int in = 7;
        int[] array = {6,4,3,2,1,9,8};

        int find = 3;

        System.out.printf("   |");
        for(int i = 0; i < in; i++) {
            System.out.printf(" %d " , i );
        }

        System.out.println("\n---+---------------------");

        for(int i = 0; i < in; i++) {
            System.out.print("   |");
            for(int j = 0; j < in; j++) {
                if(i == j) {
                    System.out.printf(" *");
                } else {
                    System.out.printf("   ");
                }
            }
            System.out.println();
            System.out.printf( "%d  |" , i);
            for(int k = 0; k < in; k++) {
                System.out.printf(" %d " , array[k]);
            }
            System.out.println();

            if(array[i] == find) {
                System.out.printf("%d은 array[%d]에 있습니다. " , find , i);
                break;
            }
        }
    }

    @Test
    public void ex2_14() {

        Phy[] phy = {
                new Phy("A" , 162 , 0.3),
                new Phy("AA" , 162 , 0.3),
                new Phy("B" , 173 , 0.7),
                new Phy("C" , 175 , 2.0),
                new Phy("D" , 171 , 1.5),
                new Phy("E" , 168 , 0.4),
                new Phy("F" , 174 , 1.2),
                new Phy("G" , 169 , 0.8),
        };

        System.out.printf("평균키는 %5.1fcm\n" , aveHeight(phy));

        int dist[] = new int[Phy.iMax];

        System.out.println("시력 분포");
        distVision(phy , dist);
        for(int i = 0; i < Phy.iMax; i++) {
//            System.out.printf("%3.1f ~ : %2d 명\n" , i / 10.0 ,  dist[i]);
            System.out.printf("%3.1f ~ : %s\n" , i / 10.0 ,  new String(new char[dist[i]]).replace("\0", "*"));
        }
    }
    public double aveHeight(Phy[] data) {

        double sum = 0;

        sum = Arrays.asList(data).stream().mapToDouble(x -> x.height).sum();

        return !Objects.isNull(data) && data.length > 0 ?  sum / data.length : 0;
    }

    public void distVision(Phy[] data , int[] dist) {

        for(Phy d : data) {
            dist[(int) (d.vision * 10)]++;
        }

    }

    public class Phy {
        static final int iMax = 21;
        private String name;
        private int height;
        private double vision;

        Phy(String name, int height , double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }



    @Test
    public void ex2_13() {

        int [][] mdays = {
                {31,28,31,30,31,30,31,31,30,31,30,31}, // 평년
                {31,29,31,30,31,30,31,31,30,31,30,31}  // 운년
        };

        int year = 2019;
        int month =  3;
        int day = 15;

        System.out.println("그 해 경과 일 수를 구합니다.");
        System.out.printf("년 : %d\n" , year);
        System.out.printf("월 : %d\n" , month);
        System.out.printf("일 : %d\n" , day);

        int result = 0;
        int iYear = isLeap(year);

        for(int i= 0; i < month -1; i ++) {
            result += mdays[iYear][i];
        }

        result = result + day;

        System.out.printf("그 해 %d일째 입니다.\n" , result);
    }

    /**
     * 윤년, 평년 확인 하는 부분
     * @param year
     * @return
     */
    public static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 !=0 || year % 400 == 0) ? 1 : 0;
    }

    /**
     * https://ledgku.tistory.com/61
     * 소수의 특성과 에라토스테네스의 체
     * : 주어진 자연수 N 이 소수이기 위한 필요 충분조건은 N이 N의 제급근보다 크지 않은 어떤 소수로 나눠지지 않는다.
     * 수가 수를 나누면 몫이 발생하게 되는데  몫과 나누는 수, 둘 중 하나는 반드시 제곱근 이하이기 때문이다.
     */
    @Test
    public void ex2_11() {

        int count = 0;
        int ptr = 0;

        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;
        boolean flag = false;

        for(int n = 5; n <= 1000; n += 2) {
            flag = false;
            for(int i = 1; prime[i] * prime[i] <= n; i++) {
                count += 2;
                if(n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                prime[ptr++] = n;
                count++;
            }

        }

        for(int p : prime) {
            System.out.println(p);
        }

        System.out.printf("나눗셈을 수행한 횟수 : %d\n" , count);

    }

    @Test
    public void ex2_10() {
        int count = 0;
        int ptr = 0;
        int j = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        for(int n=3; n <= 1000; n+=2) {
            for(j =1; j <ptr; j++) {
                count++;

                if(n%prime[j] == 0) {
                    break;
                }
            }
            if(ptr == j) {
                prime[ptr++] = n;
            }
        }

        System.out.printf("나눗셈을 수행한 횟수 : %d" , count);
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
