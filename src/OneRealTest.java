import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class OneRealTest {

    @Test
    public void test1() {

//        int A[] = {4,6,2,2,6,6,1};
        int A[] = {2,2,2,2,2,2,2};

        int N = A.length;
        int result = 0;

//        int B[] = new int[N];
//        System.arraycopy(A,0,B ,0 , N);
//        List<Integer> aList = new ArrayList<>();
//        aList = Arrays.stream(A).boxed().collect(Collectors.toList());
//
//        List<Integer> bList = aList.stream().collect(Collectors.toList());


        for (int i = 0; i < N; i++) {
            for (int j = (N-1); j >= 0; j--) {

//                System.out.println(A[i] + " , " + A[j]);

                if (A[i] == A[j]) {
                    result = Math.max(result, Math.abs(i - j));
                    break;
                }
            }
        }

//        return result;
        System.out.println(result);
    }

    @Test
    public void test2() {
        int A[] = {5,2,4,6,3,7};

        Supplier<IntStream> s = () -> IntStream.of(A);

        int min1 = s.get().min().getAsInt();
        int min2 = s.get().filter(x -> x > min1).min().getAsInt();

        System.out.println(min1 + min2);


    }
}
