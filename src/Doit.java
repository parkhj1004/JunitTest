import org.junit.jupiter.api.Test;

public class Doit {

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
}
