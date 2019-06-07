import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RgpTest
{

    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    public static void main(String args[])
    {
        String ip1 = "127.0.0.1";
        String ip2 = "255.255.255.255";
        String ip3 = "255.255.255.256";

        String ipRegex = "(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])";
        System.out.println(ip1.matches(ipRegex));
        System.out.println(ip2.matches(ipRegex));
        System.out.println(ip3.matches(ipRegex));

        System.out.println("=======================================");

        String i1 = "01";
        Pattern a = Pattern.compile("(^([1-9])+([0-9])*)");
        Matcher a1 = a.matcher(i1);

        System.out.println(a1.matches());


        String test = "897617720.5446 BLACK";

        System.out.println("::::" + test.replaceAll("[a-zA-Z]","").trim() + ":::::");
        System.out.println("<<<" + "$0.01".replaceAll("^[$]" , "").trim() + "<<<");
        System.out.println("<<<" + new BigDecimal("$0.01".replaceAll("^[$]" , "").trim()) + "<<<");

        System.out.println(new BigDecimal("$0.01".replaceAll("^[$]" , "").trim()).multiply(new BigDecimal(test.replaceAll("[a-zA-Z]","").trim())).toString());


        System.out.println("91231dd46c77e19536543aaa866b59a3043caf5fd2fe01bb8bab6b2554154dda".length());

        Pattern p1 = Pattern.compile("(^[a-zA-Z1-5]{12,12}$)");

        String temp = "cryptotest14";
        Matcher m1 = p1.matcher(temp);

        if(m1.matches())
        {
            System.out.println("matcher :::::: " + m1.group(0));
        }else
        {
            System.out.println("없음");
        }


        Pattern p2 = Pattern.compile("(^[0-9]+$)");

        temp = "14";
        Matcher m2 = p2.matcher(temp);

        if(m2.matches())
        {
            System.out.println("matcher :::::: " + m2.group(0));
        }
        else{
            System.out.println("없음");
        }

        Pattern p3 = Pattern.compile("([T|S])");

        temp = "T,B,T,S,M,F,A,C,T";

        String aaaa[] = (temp.replaceAll(",+[T|S]|[T|S],+" , "")).split(",");
        System.out.println("dddd : " + aaaa.length);

        for(String aaa : aaaa) {
            System.out.println(aaa);
        }




        String date = "read|20180222";

        // 특정한 일자가 넘어 올 경우 해당 일자 파일 read
        // read|20180222
        Pattern p = Pattern.compile("^read\\|([0-9]{8})");
        Matcher m = p.matcher(date);

        if(m.matches())
        {
            date = m.group(1) != null ? m.group(1) : "";
        }

        System.out.println("date ======> " + date);

        System.out.println(EXAMPLE_TEST.matches("\\w.*"));

        System.out.println("===========================");

        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
        System.out.println(splitString.length);// should be 14


        for (String string : splitString) {
            System.out.println(string);
        }
        // replace all whitespace with tabs
        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));

        if(args != null && args.length > 0)
        {
            int k = Integer.parseInt(args[0]);
            for(int i = 1; i <= k; i++)
            {
                if( k % i == 0)
                {
                    System.out.print(i + " ");
                }
            }
        }


    }
}