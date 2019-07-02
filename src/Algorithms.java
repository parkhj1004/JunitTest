import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(value=Parameterized.class)
public class Algorithms {

    private int first;
    private int second;
    private int result;

    @Parameterized.Parameters
    public static Collection<int[]> input() {
        return Arrays.asList(new int[][] { {1,2,3} , {11,22,33} , {111,222,333}});
    }

    public  Algorithms(int first , int second , int result) {

        this.first = first;
        this.second = second;
        this.result = result;
    }


    @Test
    public void testParameter() {

        assertEquals(result , (first+second) , 0);

    }


    @Test
    public void binaryTest() {

        int num = 35;

        String temp = Integer.toBinaryString(num);

        System.out.println(temp);

        System.out.println(Stream.of(Integer.toBinaryString(num).replaceAll("0+$","").split("0+"))
                .filter(a -> a != null)
                .map(String::length)
                .max(Integer::compare)
                .orElse(0));





    }


    @Test
    public void max() {

        int input = 909;

        String tmp = String.valueOf(input);
        char check , check2;
        char cInput[];

        String tmpMax , tmpMin;

        if(input > 0)
        {
            cInput = tmp.toCharArray();
            check = cInput[0];
            check2 = cInput[1];


            switch (check) {
                case '9' :
                    tmpMax = tmp.replaceAll(String.valueOf(check2) , "9");
                    break;
                default :
                    tmpMax = tmp.replaceAll(String.valueOf(check) , "9");
                    break;
            }

            tmpMin = tmp.replaceAll(String.valueOf(check) , "1");

            System.out.println(tmpMin + " , " + tmpMax);
            System.out.println(Integer.valueOf(tmpMax) - Integer.valueOf(tmpMin));

        }
    }

    @Test
    public void k1() {
//        int n = 6;

//        int arr1[] = {46, 33,33,22,31,50};
//        int arr2[] = {27 ,56, 19, 14, 14, 10};

        int n = 5;

        int arr1[] = {9, 20, 28, 18, 11};
        int arr2[] = {30, 1, 21, 17, 28};

        String result [] = new String[n];
        int arr1_n = arr1.length;
        int arr2_n = arr2.length;

        if(arr1 != null &&  1 <= arr1_n  && arr1_n <= n  && arr2 != null && 1<= arr2_n && arr2_n <= n && arr1_n == arr2_n) {
            for(int i = 0 ; i <n ; i++) {
                result[i] = (Integer.toBinaryString(arr1[i] | arr2[i])).chars()
                .mapToObj(x -> ('1' == (char)x) ? "#" : " ").collect(Collectors.joining());

                System.out.println(result[i]);
            }
        } else {
            System.out.println("error");
        }

    }

    @Test
    public void k3() {

        int cacheSize = 3;
//        String[] cites = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju",
//                "Pangyo", "Seoul", "NewYork", "LA"};

        String[] cites = new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};


        int runtime = 0;
        Queue cacheQueue = new LinkedList();

        for(String citi : cites) {
            if(cacheSize == 0) {
                runtime += 5;
                continue;
            }

            if(cacheQueue.contains(citi.toUpperCase())) {
                runtime += 1;
            } else {
                if(cacheQueue.size() > cacheSize) {
                    cacheQueue.poll();
                }

                cacheQueue.add(citi.toUpperCase());
                runtime += 5;
            }

        }

        System.out.println(runtime);


    }

    @Test
    public void challengesOperators() {
        double meal_cost = 12.00;
        int tip_percent = 20;
        int tax_percent = 8;

        BigDecimal percent = BigDecimal.valueOf(100);

        BigDecimal meal = new BigDecimal(Double.toString(meal_cost));
        BigDecimal tip = new BigDecimal(Integer.toString(tip_percent));
        BigDecimal tax = new BigDecimal(Integer.toString(tax_percent));

        System.out.println(meal.multiply(tip.divide(percent, 2, BigDecimal.ROUND_HALF_UP)));
        System.out.println(meal.multiply(tax.divide(percent, 2, BigDecimal.ROUND_HALF_UP)));

        System.out.println( (meal.add((meal.multiply(tip.divide(percent, 2, BigDecimal.ROUND_HALF_UP)))
                .add( (meal.multiply(tax.divide(percent, 2, BigDecimal.ROUND_HALF_UP))) ))).setScale(0,BigDecimal.ROUND_HALF_UP));
//                .add(
//                meal.multiply(tax.divide(percent, 2, BigDecimal.ROUND_HALF_UP))).setScale(0,BigDecimal.ROUND_HALF_UP));



    }

    @Test
    public void programmers_42576() {



//        String[] participant = {"leo", "kiki", "eden" };
//        String[] completion = {"eden" , "kiki"};

//        String[] participant = {"stanko","mislav" , "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};

        String[] participant = 	{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        Arrays.sort(participant);
        Arrays.sort(completion);

        String answer = "";

        for(int i = 0; i < completion.length; i++)
        {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }


        System.out.println(answer.equals("") ? participant[participant.length - 1] : answer);





//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};

//        List<String> pList = Arrays.asList(participant);
//        List<String> cList = Arrays.asList(completion);


//
//        IntStream.range(0, pList.size())
//                .filter(i -> cList.contains(pList.get(i)))
//                .boxed()
//                .map(i -> //{
//                    pList.remove(i)
//
////                    return pList;
//                //}
//                );


//        pList.removeIf(x -> cList.contains(x));

//        pList.stream().filter( x ->  {
//            if(cList.contains(x)) {
//                pList.remove(x);
//                cList.remove(x);
//            }
//            return pList != null ? true : false;
//
//        });









    }
}
