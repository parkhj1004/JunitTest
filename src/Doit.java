import org.junit.jupiter.api.Test;

public class Doit {

    @Test
    public void Chap1_10() {

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
