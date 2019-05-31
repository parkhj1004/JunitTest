import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OneTest {

    public static void main(String args[]) {

    }

    @Test
    public void frogRiverOne() {
        int A [] = {1,3,1,4,2,3,5,4};
//        int A[] = {2, 2, 2, 2, 2};
        int X = 5;
        Set<Integer> marks = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                marks.add(A[i]);

                if (marks.size() == X) {

                    System.out.println(i);
//                    return i;
                }
            }
        }

        System.out.println(-1);

//        return -1;

    }


    @Test
    public void permCheck2() {

        int A[] = {1,2,3};
        long N =  A.length;
        long disCnt = N - IntStream.of(A).distinct().count();
        int max = Arrays.stream(A).max().getAsInt();

        System.out.println( disCnt == 0 && max == N ? 1 : 0);
    }

    @Test
    public void permCheck1() {

        int A[] = {2,3,1};

        long N =  A.length;
        long disCnt = N - IntStream.of(A).distinct().count();

        if(disCnt > 0 ) {
//            return 0;
            System.out.println("0");
        }

        long total = (N * (N + 1)) / 2;
        for(int i : A) {
            total -= i;
        }

        System.out.println(total ==0l ? 1 : 0);
//        return total==0 && disCnt == 0l ? 1 : 0;
    }

    @Test
    public void permCheck() {

        int A[] = {2,3,1};

        long N =  A.length;
        Supplier<IntStream> s = () -> IntStream.of(A);
        long disCnt = N - s.get().distinct().count();

        if(disCnt > 0 ) {
//            return 0;
            System.out.println("0");
        }

        long total = (N * (N + 1)) / 2;
        long sum = s.get().sum();

        System.out.println(total-sum ==0l ? 1 : 0);
//        return total==0 && disCnt == 0l ? 1 : 0;
    }


    @Test
    public void tapeEquilibrium2() {
        int A[] = {3,1,2,4,3};
        long rsum = 0;

        for (int i = 1; i < A.length; i++)
            rsum += A[i];

        long lsum = A[0];
        int min = (int) Math.abs(lsum - rsum);

        for (int i = 1; i < A.length-1; i++) {
            lsum += A[i];
            rsum -= A[i];
            int diff = (int) Math.abs(lsum - rsum);
            if (diff < min)
                min = diff;
        }

        System.out.println(min);
//        return min;


    }

    @Test
    public void tapeEquilibrium() {

        int A[] = {3,1,2,4,3};
        int len = A.length;

        long sum1 = 0l;
        long sum2 = 0l;
        long result[] = new long[len-1];

        for(int k = 1; k < len; k++) {

            for(int j = 0 ; j < k; j++) {
                sum1 += A[j];
            }

            for(int i = k; i < len; i++) {
                sum2 += A[i];
            }

            result[k-1] = Math.abs(sum1 - sum2);
            sum1 = 0l;
            sum2 = 0l;
        }

        System.out.println(Arrays.stream(result).min().getAsLong());

//        return Arrays.stream(result).min().getAsInt();






    }


    @Test
    public void missingNumFind() {
        int A[] = {3,1};
        int len = A != null ? A.length : 0;

        long N =  len + 1;
        long total = (N * (N + 1)) / 2;

        long sum = 0L;

        for (int i : A) {

            sum += i;
        }

        System.out.println((int)(total - sum));

//        return (int)(total - sum);

//        return total;

//
//        System.out.println(lists.stream().reduce( (temp1, temp2) -> (temp2 - temp1) == 1 ? temp1 : temp2 ).get());

//
//        int result[] = IntStream.concat(Arrays.stream(A), Arrays.stream(temp)).toArray();
//
//        int r = 0;
//
//        for(int i : A) {
//            r ^= i;
//        }
//
//        System.out.println(r);

    }

    @Test
    public void test() {
        int X = 10;
        int Y = 85;
        int D = 30;

        int temp = (Y - X) / (D == 0 ? 1 : D);
        int remainder = (Y - X) % (D == 0 ? 1 : D);

        System.out.println(remainder > 0 ? ++temp : temp);
//        int result = 0;
//
//        do {
//
//            X += D;
//            result++;
//        } while (X <= Y);
//
//
//        System.out.println(result);
//        return result;

    }

    @Test
    public void rotationTest3(){

        int A[] = {3,2,1};
        int K[] = {1,2,3,4};

        int cnt = K.length;
        int aCnt = A.length;
        int result[] = new int[cnt];

        int max = 0; // max 자리 구하기

        for(int i = 0 ; i < cnt; i++)
        {
            result[i] = (max - (K[i]%aCnt));
            result[i] = result[i] < 0 ? result[i] + aCnt : result[i];
        }


        for(int i : result) {
            System.out.println(i);
        }

    }

    @Test
    public void rotationTest2(){

        System.out.println(4%3);


        int A[] = {3,8,9,7,6};
        int K = 12;

        int cnt = A.length;
        int result[] = new int[cnt];

        int jump = cnt > 0 ? K%cnt : 1;

        for(int i = 0 ; i < A.length; i++) {
            result[(i+jump) >= cnt ? (i+jump) - cnt : (i+jump)] = A[i];
        }


        for(int i : result) {
            System.out.println(i);
        }

    }

    @Test
    public void rotationTest(){
        int A[] = {3,8,9,7,6};
        int K = 12;

        int cnt = A.length;
        int result[] = new int[cnt];

        int jump = cnt > 0 ? K%cnt : 1;

        for(int i = 0 ; i < A.length; i++) {
            result[(i+jump) >= cnt ? (i+jump) - cnt : (i+jump)] = A[i];
        }


        for(int i : result) {
            System.out.println(i);
        }
        
    }

    @Test
    public void arrayTest(){

        int A[] = {8,8,9,3,9,3,9,6,9,6};

        int result = 0;

        for(int i : A){

            System.out.println("시작 : " + result);
            System.out.println("계산 : " +  i);
            result ^= i;
            System.out.println("결과 : " +  result);
        }

        System.out.println(result);


        List<Integer> lists = Arrays.stream(A).boxed().collect(Collectors.toList());

        Integer unDuplicated = lists.stream().filter(n -> lists.stream().filter(x -> x == n).count() == 1).findFirst().orElse(0);
        System.out.println(unDuplicated);
//
        Map<Integer, Long> counter =  Arrays.stream(A).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
        System.out.println(counter);
        System.out.println(counter.entrySet().stream().sorted(Map.Entry.comparingByValue()).filter(e -> e.getValue() == 1).findFirst().map(x -> x.getKey()).get());
//        return counter.entrySet().stream().sorted(Map.Entry.comparingByValue()).filter(e -> e.getValue() == 1).findFirst().map(x -> x.getKey()).get();
//        return counter.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().map(x -> x.getKey()).get();


    }

    @Test
    public void binaryTest2() {

//        int N = 561892;
        int N = 13;

        System.out.println(Integer.toBinaryString(N));

        System.out.println(Stream
                .of(
                        Integer.toBinaryString(N)
                                .replaceAll("0+$", "")
                                .split("1+"))
                .filter(a -> a != null)
                .map(String::length)
                .max(Integer::compare)
                .orElse(0));
    }

    @Test
    public void binaryTest() {

//        int test = 9;
//        int test = 2;
//        int test = 529;
        int test = 561892;
//        int test = 6;

        boolean flag = true;

        System.out.println(Integer.toBinaryString(test));

        String strTest = Integer.toBinaryString(test).replaceAll("0+$","");

        System.out.println(strTest);


//        Pattern pTest = Pattern.compile("[1]+([0]*)1([0]*)"); //1([0]*)1([0]*)
        Pattern pTest = Pattern.compile("[1]+([0]*)"); //1([0]*)1([0]*)

        Matcher mTest = pTest.matcher(strTest);
        String strTemp = "";
        List<Integer> result = new ArrayList<>();
//
        while(flag)
        {
            if(!strTemp.isEmpty()){
                strTest = strTest.replaceFirst(strTemp , "");
            }

            if(mTest.find()) {

                strTemp = mTest.group(0);

                if(mTest.group(1).matches("[0]+"))
                {
                    result.add(mTest.group(1).length());
                }
            }else {
                flag = false;
            }
        }

        if(result.isEmpty()) {
            System.out.println("0");
//            return 0;
        } else {
            System.out.println(result.stream().max(Comparator.comparing(Integer::intValue)).get());
//            return result.stream().max(Comparator.comparing(Integer::intValue)).get();
        }

    }

    @Test
        public void solution() {

//            int A[] = {-1,-3 , 1,2, 4};
            int A[] = {1,3,6,4,1,2};
            // write your code in Java SE 8

//            List<Integer> lists = IntStream.of(A).boxed().filter(x -> x > 0).collect(Collectors.toList());
            Map<Integer, Integer> lists = IntStream.of(A).boxed().filter(x -> x > 0).distinct().collect(Collectors.toMap(x -> x, x-> x));


            if(Objects.isNull(lists) || lists.isEmpty()) {
                System.out.println(1);
            }

            List<Integer> result = new ArrayList<>();

            for(int i = 1; i <= lists.size(); i++) {

                if(!lists.containsKey(i)){
                    result.add(i);
                }
            }

            if(result.isEmpty()) {
//                return Arrays.stream(A).max().getAsInt() + 1;

//                return lists.values().stream().max(Comparator.comparing(Integer::valueOf)).get() +1;
                System.out.println(lists.values().stream().max(Comparator.comparing(Integer::valueOf)).get() +1);
            }

//            return result.stream().min(Comparator.comparing(Integer::valueOf)).get();
            System.out.println(result.stream().min(Comparator.comparing(Integer::valueOf)).get());
        }
}
