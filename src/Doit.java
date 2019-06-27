import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class Doit {

    @Test
    public void Chap2_6() {

    }

    @Test
    public void Chap2_5() {
        int arr[] = {5,10,73,2,-5,42};
        int copy[] = {5,0,3,2,5,2};

        int size = arr.length;

        for(int i = 0; i < size; i++) {
            copy[size- (i+1)] = arr[i];
        }

        for(int tmp : copy) {
            System.out.println(tmp);
        }
    }

    @Test
    public void Chap2_4() {

        int arr[] = {5,10,73,2,-5,42};
        int copy[] = {5,0,3,2,5,2};


        copy = arr.clone();

        for(int tmp : copy) {
            System.out.println(tmp);
        }
    }

    @Test
    public void Chap2_3() {
        int arr[] = {5,10,73,2,-5,42};

        System.out.println(Arrays.stream(arr).sum());
    }

    @Test
    public void Chap2_2() {

        int arr[] = {5,10,73,2,-5,42};

        Chap2_2_print(arr);
        Chap2_2_reverse(arr);
    }

    private void Chap2_2_reverse(int arr[]) {

        int size = arr.length;
        int center = size / 2;

        int temp = -1;

        for(int i = 0; i < center; i++) {

            System.out.printf("a[%d]과(와) a[%d]를 교환합니다.\n" , i , size - (i+1));

            temp = arr[i];
            arr[i] = arr[size - (i+1)];
            arr[size - (i+1)] = temp;

            Chap2_2_print(arr);
        }

        System.out.println("역순 정렬을 마쳤습니다.");
    }

    private void Chap2_2_print(int arr[]) {

        for(int tmp : arr) {
            System.out.printf("%d " , tmp);
        }

        System.out.println();
    }




    @Test
    public void Chap1_17() {

        int step = 8;
        BigDecimal total = new BigDecimal(String.valueOf(step)).multiply(new BigDecimal("2")).subtract(new BigDecimal("1"));

        int center = total.divide(
                new BigDecimal("2") , 1 , BigDecimal.ROUND_CEILING).intValue();

        for(int i = 0; i < step; i++) {
            for(int j = 0; j < total.intValue(); j++) {

                if(j >= center -i && j <= center+i ) {
                    System.out.print(i+1);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void Chap1_16() {

        int step = 8;
        BigDecimal total = new BigDecimal(String.valueOf(step)).multiply(new BigDecimal("2")).subtract(new BigDecimal("1"));

        int center = total.divide(
                new BigDecimal("2") , 1 , BigDecimal.ROUND_CEILING).intValue();

        for(int i = 0; i < step; i++) {
            for(int j = 0; j < total.intValue(); j++) {

                if(j >= center -i && j <= center+i ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        // 책
        for (int i = 1; i <= step; i++) { 					// i행 (i = 1, 2, … ,n)
            for (int j = 1; j <= step - i + 1; j++) 		// n-i+1개의 ' '를 나타냄
                System.out.print(' ');
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) 	// (i-1)*2+1개의 '*'를 나타냄
                System.out.print('*');
            System.out.println(); 						// 개행(줄변환)
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

        System.out.printf("그 수는 %d 자리 입니다.\n" , String.valueOf(a).toCharArray().length);

        // 책
        int no = 0; 			// 자릿수
        while (a > 0) {
            a /= 10; 			// n을 10으로 나눔
            no++;
        }
        System.out.println("그 수는 " + no + "자리입니다.");
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
    public void ForSum_9() {

        int startNum= 3;
        int endNum = 6;

        // 예외 처리
        if (startNum == 0 || endNum == 0) {
            throw new ArithmeticException("0 값이 올 수 없습니다.");
        }

        System.out.println("a와 b를 포함하여 그 사이의 모든 정수의 합을 구합니다.");
        System.out.printf("a의 값：%d\n" , startNum);
        System.out.printf("b의 값：%d\n" , endNum);

        int totalSum = endNum * (endNum +1)/2;
        int beforeSum = startNum * (startNum-1)/2;

        System.out.printf("정수 a,b 사아의 모든 정수의 합은 %d 입니다. \n " , totalSum - beforeSum);

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

    @Test
    public void ForSum_8() {

        System.out.println("1부터 n까지의 합을 구합니다.");

        int num = 11;
        System.out.printf("n의 값：%d\n" , num);

        int sum = num * (1+num)/2;

        System.out.printf("1부터 %d 까지의 합은 %d 입니다",num, sum);
    }

    @Test
    public void ForSum_7() {

        int num = 7;
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for(int i=1; i <= num; i++) {
            sb.append(i);
            sb.append(" + ");
            sum += i;
        }

        System.out.println(sb.deleteCharAt(sb.lastIndexOf("+ ")).toString() + "= " + sum);
    }

    @Test
    public void ForSum_6() {

        int num = 9;
        int sum = num * (1+num)/2;

        System.out.println("sum ::" + sum);
    }

    /**
     * 가우스 법칙
     *  1 부터 n 까지의 합을 S라고 하고 아래와 같이 순서를 앞 뒤로 하여 두 번을 쓴 다음에
     *
     *         S = 1, 2, 3, … , n
     *         S = n, n-1, n-2, … , 1
     *         -------------------------
     *         두 줄을 합치면..
     *
     *         2S = (n+1) + (n+1) + (n+1) + … + (n+1)
     *         2S = (n+1) * n
     *         가 되어
     *         S = ((n+1) * n) / 2
     *         로 식이 나옵니다.
     */

    /**
     * 최대공약수
     * m >=n 인 두 양의 정수 , m이 n의 배수이면 최대공약수(gcd)는 n 이고,
     * 그렇지 않으면 gcd(m,n) = gcd(n , m%n) 이다
     */
    @Test
    public void etc1 () {

        int result = 0;

        result = gcd(3,15);
//        System.out.println(result);

//        result = gcd(15,3);
        System.out.println(result);

//        System.out.println(3%15);
//        System.out.println(15%3);

    }

    private int gcd(int p, int q) {

        System.out.printf("p:%d , q:%d \n" , p,q);

        if (q == 0) {
            return p;
        } else {
            return gcd(q,p%q);
        }
    }





}
