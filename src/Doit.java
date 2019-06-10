import com.sun.tools.javac.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class Doit {

    @Test
    public void Chap1_16() {

        int step = 4;
        BigDecimal total = new BigDecimal(String.valueOf(step)).multiply(new BigDecimal("2")).subtract(new BigDecimal("1"));

        int center = total.divide(
                new BigDecimal("2") , 1 , BigDecimal.ROUND_CEILING).intValue();

        System.out.println(center);

        for(int i = 0; i < total.intValue(); i++) {

            if(i != center) {
                System.out.print(" ");
            } else {
                System.out.print("*");
            }

        }

    }

    @Test
    public void Chap1_15() {
        int num = 5;

        System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
        System.out.printf("몇 단 삼각형입니까? : %d\n" , num);

        for(int i = 0; i < num; i++) {
            for(int j = num-i ; j >= 1; j--) {
                System.out.printf("%s" , "*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();


        for(int i = 0; i < num; i++) {
            for(int k = 0; k < i; k++) {
                System.out.printf("%s" , " ");
            }
            for(int j = 0; j < num -i; j++){
                System.out.printf("%s" , "*");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();

        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= i; j++){
                System.out.printf("%s" , "*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for(int i = 1; i <= num; i++) {
            for(int k = 0; k < num - i; k++) {
                System.out.printf("%s" , " ");
            }
            for(int j = 1; j <= i; j++){
                System.out.printf("%s" , "*");
            }
            System.out.println();
        }
    }

    @Test
    public void Chap1_14() {

        int num = 5;

        System.out.println("사격형을 출력합니다.");
        System.out.printf("단 수 : %d\n" , num);

        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= num; j++){
                System.out.printf("%s" , "*");
            }
            System.out.println();
        }
    }

    @Test
    public void Chap1_13() {

        System.out.print("   |");
        for(int i = 1;  i <= 9; i++) {
            System.out.printf("%3d" , i);
        }
        System.out.println("\n---+---------------------------");

        for(int i = 1; i <= 9; i++) {
            System.out.printf("%2d|", i);
            for(int j = 1; j <= 9; j++) {
                System.out.printf("%3d" , i+j);
            }
            System.out.println();
        }
    }

    @Test
    public void Chap1_12() {

        System.out.print("   |");
        for(int i = 1; i <=9; i++)
            System.out.printf("%3d" , i);
        System.out.println("\n---+---------------------------");

        for(int i = 1; i <= 9; i ++) {
            System.out.printf("%2d |" , i);
            for(int j = 1; j <= 9; j++) {
                System.out.printf("%3d" , i * j);
            }
            System.out.println();
        }
    }

    @Test
    public void Chap1_11() {

        int a = -100;

        while(a < 0) {
            System.out.println("양의 정수를 입력 하세요.");
            a = 1358;
        }

        System.out.printf("그 수는 %d 자리 입니다." , String.valueOf(a).toCharArray().length);

    }

    @Test
    public void Chap1_10() {

        int a = 6;
        int b = 6;

        do {

            System.out.printf("a의 값:%d \n" , a);
            System.out.printf("b의 갑:%d \n" , b);
            System.out.printf("a보다 큰 값을 입력하세요!\n");

            b = 8;
        } while (a >= b);

        System.out.printf("b 의 값:%d\n" , b);
        System.out.printf("b - a는 %d 입니다.\n", b-a);

    }

    @Test
    public void ForSum_7() {

        int num = 7;
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for(int i=1; i <= num; i++) {
            sb.append(i);
            sb.append("+");
            sum += i;
        }
        System.out.println(sb.deleteCharAt(sb.length()-1).toString() + "=" + sum);
    }

    @Test
    public void ForSum_8() {

        int num = 2;
        int sum = num * (1+num)/2;

        System.out.println("sum ::" + sum);
    }

    @Test
    public void ForSum_9() {

        int startNum= 3;
        int endNum = 6;

        // 예외 처리
        if (startNum == 0 || endNum == 0) {
            throw new ArithmeticException("0 값이 올 수 없습니다.");
        }

        int totalSum = endNum * (endNum +1)/2;
        int beforeSum = startNum * (startNum-1)/2;

        // mine
        System.out.println(totalSum  + " , " + beforeSum);

        System.out.println(totalSum - beforeSum);

        // 마지막 수가 홀수 값이라면 저장
        int oddLastNum = 0;

        // 홀수인 경우 마지막 홀수의 값은 별도의 변수에 저장을 하고, endNum을 짝수로 바꿔준다. oddLastNum는 최종 결과 값에 더해줄 값이 된다.
        if (endNum % 2 == 1) {
            oddLastNum = endNum;
            endNum = endNum - 1;
        }

        int addResult = startNum + endNum;
        int multiplayNum = (endNum - startNum + 1) / 2;

        int result = (addResult * multiplayNum) + oddLastNum;

        System.out.println(result);
    }
}
