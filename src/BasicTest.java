import java.io.File;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
* Created by we on 2017. 12. 12..
*/
public class BasicTest {

    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";


    public static String makeHashData(StringBuffer sb) throws NoSuchAlgorithmException {
        byte[] bNoti = sb.toString().getBytes();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(bNoti);

        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            int c = digest[i] & 0xff;
            if (c <= 15) {
                strBuf.append("0");
            }
            strBuf.append(Integer.toHexString(c));
        }

        return strBuf.toString();
    }

    public static <E> E getWeightedRandom(Map<E, Double> weights, Random random) {
        E result = null;
        double bestValue = Double.MAX_VALUE;

        System.out.println("Double.MAX_VALUE  :: " + Double.MAX_VALUE);

        System.out.println(" Math.log  MAX :: " + Math.log(Double.MAX_VALUE));

        for (E element : weights.keySet()) {

            double testD = random.nextDouble();

            System.out.println("Math::: " + Math.log(100));
            System.out.println("Math::: " + Math.log(10));
            System.out.println("Math::: " + Math.log10(100));

            System.out.println(" random.nextDouble() :: " + testD);
            System.out.println(" Math.log  :: " + Math.log(testD));

            System.out.println(" weights.get(element):: " + weights.get(element));

            double value = -Math.log(random.nextDouble()) / weights.get(element);

            System.out.println("value :::: " + value + " , bestValue :: " + bestValue);

            if (value < bestValue) {
                bestValue = value;
                result = element;
            }

            System.out.println("bestValue :::: " + bestValue + " , result :: " + result);

        }
        return result;
    }

    private static long setIpLong(String clientIp) { //throws Exception{
        String[] addrArray = clientIp.split("\\.");
        long ipLong = 0;
        for (int i=0;i<addrArray.length;i++) {
            int power = 3-i;
            ipLong += ((Integer.parseInt(addrArray[i])%256 * Math.pow(256,power)));
        }
        return ipLong;
    }

    public static void main(String[] args) {

        System.out.println( " <<<< >>> " + setIpLong("211.63.24.67"));

        String strTest ="aa";
        String strNull = null;

        if("aa".equals(strTest))
        {
            System.out.println("ok");
        }
        else if(strNull.equals(strTest))
        {
            System.out.println("null");
        }

        Map<String, Double> w = new HashMap<String, Double>();
        w.put("ball", 25D);
        w.put("strike", 70D);
        w.put("wild pitch", 5D);
        Random rand = new Random();
        System.out.println(getWeightedRandom(w, rand));

        System.out.println("***** : " + Stream.of(new File(".").listFiles()).flatMap(
                file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles())
                ).collect(Collectors.toList()));

        System.out.println("^^^^^^^ : " + Stream.of(new File(".").listFiles()).map(
                file -> file.listFiles() == null ? file : file.listFiles()
        ).collect(Collectors.toList()));

//        List<Person> people = Arrays.asList(
//                new Person("dJohn", new ArrayList<String>(Arrays.asList("jja","jjja","j111a"))),
//                new Person("aJohn", new ArrayList<String>(Arrays.asList("jjb","jjjb","j111b"))),
//                new Person("bJane", new ArrayList<String>(Arrays.asList("jjc","jjjc","j111c"))),
//                new Person("cGreg", new ArrayList<String>(Arrays.asList("jjd","jjjd","j111d")))

//            new Person("John", 21),
//            new Person("Parkhj", 19),
//
//            new Person("Jane", 21),
//            new Person("Greg", 35)
//        );

//        List<Person> olderThan20 =
//                people.stream().filter(p -> p.getAge() > 20)
//                .collect(ArrayList::new , ArrayList::add , ArrayList::addAll);
//
//        System.out.println("People older than 20 :: " + olderThan20);

        String[][] sample = new String[][]{
                {"a", "b"}, {"c", "d"}, {"e", "a"}, {"a", "h"}, {"i", "j"}
        };

//without .flatMap()
        Stream<String> stream1 = Stream.of(sample)
                .flatMap(array -> Arrays.stream(array))
                .filter(x-> "a".equals(x));

        stream1.forEach(System.out::println);

        System.out.println("================");

        Stream<String> stream2 = Stream.of(sample)
                .flatMap(array -> Arrays.stream(array))
                .distinct();

        stream2.forEach(System.out::println);

        System.out.println("================");

        Stream<String> stream3 = Stream.of(sample).map(a-> a.toString());
        stream3.forEach(b -> System.out.println(b.toString()));

        System.out.println(">>>>>>>>>>>>>>>>");




//        Map<String, List<Person>> nameOfPeopleByAge =
//                people.stream()
//                        //.sorted(Comparator.comparing(Person::getName))
//                        .collect((Collectors.groupingBy(
//                                Person::getName, Collectors.toList()))
//
//                        );
//
//        System.out.println("People grouped by age : " + nameOfPeopleByAge);
//
//        System.out.println(" 우하하 이거거덩 :: " + nameOfPeopleByAge.entrySet().stream().sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue , (oldValue , newValue)
//                -> oldValue , LinkedHashMap::new)));
//
//        System.out.println(people.stream()
//                .sorted(Comparator.comparing(Person::getName)).collect(Collectors.groupingBy(Person::getName))
//        );
//
//        System.out.println("이거는 1 :: " + people.stream().map(p->p.getName()).collect(Collectors.toList()));
//        System.out.println("이거는 2 :: " + people.stream().sorted(Comparator.comparing(Person::getName)).map(p->p.getName()).collect(Collectors.toList()));
//
//        try
//        {
//            StringBuffer sb = new StringBuffer();
//
//            sb.append("G0001").append(getMertKey("G0001"));
//
//            System.out.println("makeHashData : " + makeHashData(sb));
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }

        List<String> friendList = Arrays.asList("Brian" , "Jackie" , "Mike");

        Function<String , Predicate<String>> startWithLetter =
                letter -> name -> name.startsWith(letter);

        long coutFriendsStartN = friendList.stream().filter(startWithLetter.apply("J")).count();

        System.out.println("coutFriendsStartN : " + coutFriendsStartN);

        Function<String, Integer> fun = str -> Integer.parseInt(str);
        Integer result = fun.apply("1");

        System.out.println("result : " + result);


        Predicate<String> p = str -> str.isEmpty();
        boolean testResult = p.test("hello");

        System.out.println("testResult : " + testResult);






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


        int width = 9;
        int height = 5;
        int center = new BigDecimal(String.valueOf(width)).divide(
                new BigDecimal("2") , 1 , BigDecimal.ROUND_CEILING).intValue();

        System.out.println("");

        for(int i =0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if( center - i <= j && j  <=  center + i)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        double d1 = 1.0;
        double d2 = 0.1;



//        for(int i=0; i<5; ++i){
//            d1 += d2;
//            System.out.println(d1);
//        }


        BigDecimal bd1 = new BigDecimal(String.valueOf(d1));
        BigDecimal bd2 = new BigDecimal(String.valueOf(d2));

        for(int i=0; i<5; ++i){
            bd1 = bd1.add(bd2);
            System.out.println(bd1.toString());
        }

        String test = "dd ee ea eef";

        List<String> tests = Arrays.asList(test.split(" "));

        Collections.reverse(tests);

        System.out.println(tests);

        List<String> friends = Arrays.asList("a" , "b"  , "c" , "d" , "parkhj");

        friends.forEach( (String friend) -> System.out.println(friend) );
        friends.forEach( (friend) -> System.out.println(friend) );
        friends.forEach( friend -> System.out.println(friend) );
        friends.forEach(System.out::println);

        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("====");

        friends.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
        friends.stream().map(name -> name.length()).forEach(cnt -> System.out.println(cnt + " "));

        friends.stream().map(String::toUpperCase).forEach(System.out::println);

        List<String> sLists = friends.stream().filter( name -> name.startsWith("p") ).collect(Collectors.toList());

        sLists.forEach(System.out::println);

        System.out.println(String.format("Found %d names :: " , sLists.size()));



//        String  a = "TestWord";
        String a = " This is a test! ";
//       String a = "";

        System.out.println(a.chars().count());
        a.chars().forEach(ch -> System.out.println(ch));

        List<String> as = Arrays.asList(a.split(" "));
        System.out.println(as);
        System.out.println(as.stream().count());

        a.matches("\\w.*");

        System.out.println( "1 : " +  Arrays.asList((a.replaceAll("\\s+","|")).split("|")).stream().filter(tmp -> tmp.matches("|")).count());

        System.out.println("2 : " +  Arrays.asList(((a.replaceAll("\\s+","|")).split("|"))).stream().collect(Collectors.toList()));

        System.out.println("2-1 : " +  Arrays.asList(((a.replaceAll("\\s+","|")).split("|"))));

        System.out.println("3 : " +  Arrays.asList((a.replaceAll("\\s+","|")).split("|")).stream().count());

        System.out.println("4 : " +  Arrays.asList(a.split("\\w+")).stream().filter(tmp -> tmp.length() >0).count());

        System.out.println("5 : " +  Arrays.asList((a.replaceAll("\\s+","|"))));

        System.out.println("6 : " +  Arrays.asList(a.split("\\w+")));

        System.out.println("7 : " +  Arrays.asList(a.split("\\s+")).stream().filter(tmp -> tmp.length() >0).count());

        System.out.println("----------------");


        int to = 1;
        int from = 16;

        StringBuilder sb = new StringBuilder();

        for(int j = to ; j <= from; j++)
        {

            if((j % 3) == 0 || ( j % 5) == 0)
            {
                if(j % 3 == 0)
                    sb.append("RPG");
                if(j % 5 == 0)
                    sb.append("KOREA");
            }
            else
            {
                sb.append(j);
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());








        Double [] tDoubles = {-1.5d , 0d, 4.4d, 5d,7d};
        Double [] tDoubles2 = { 4.4d, 5d,7d ,-1.5d , 0d};

        System.out.println("정렬이 되나??? " + Arrays.asList(tDoubles2).stream().map(pp-> pp.longValue()).collect(Collectors.toList()));

//        Double [] tDoubles = {-1.5d , 0d, 4.4d, 5d,6d, 7d};


//        BigDecimal[] bigDecimals = {"-1.5" , "0", "4.4", "5","7"};

//        Double tDouble = 4.5d;
        Double tDouble = 5.5d;

//        BigDecimal bigDecimal = BigDecimal.valueOf(5.5);
        BigDecimal bigDecimal = BigDecimal.valueOf(4.5);



        System.out.println("tDoucles List : " + Arrays.asList(tDoubles).stream().map(tmp -> BigDecimal.valueOf(tmp))
                .collect(Collectors.toList()));

        System.out.println("big :: " + Arrays.asList(tDoubles).stream().map(tmp -> BigDecimal.valueOf(tmp))
                .collect(Collectors.toList()).stream().sorted(Comparator.naturalOrder())
                .reduce((tmp1 , tmp2) -> ( bigDecimal.subtract(tmp1).compareTo(BigDecimal.ZERO) == -1
                                        ? (bigDecimal.subtract(tmp1)).multiply(BigDecimal.valueOf(-1d))
                                        : (bigDecimal.subtract(tmp1))
                                         ).compareTo(
                                        ( bigDecimal.subtract(tmp2).compareTo(BigDecimal.ZERO) == -1
                                        ? (bigDecimal.subtract(tmp2)).multiply(BigDecimal.valueOf(-1d))
                                        : (bigDecimal.subtract(tmp2))
                                        )
                                        ) >= 0
                        ? tmp2 : tmp1
                )
        );

        System.out.println(Arrays.asList(tDoubles).stream().sorted(Comparator.naturalOrder())
                .reduce((tmp1 , tmp2) -> ((tDouble - tmp1) > 0 ? (tDouble - tmp1) : (tDouble - tmp1) * -1)
                        >= ((tDouble - tmp2) > 0 ? (tDouble - tmp2) : (tDouble - tmp2) * -1) ?
                        tmp2 : tmp1
                )
        );

        System.out.println(Arrays.asList(tDoubles).stream().map(tmp1 -> ((tDouble - tmp1) > 0 ? (tDouble - tmp1) : (tDouble - tmp1) * -1))
                .collect(Collectors.toList()).stream().sorted(Comparator.reverseOrder()).findFirst());



        String strUrl = "https://www.wemakeprice.com/mypage";

//        Pattern urlPattern = Pattern.compile("^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$");
          Pattern urlPattern = Pattern.compile("^https?:\\/\\/([^:\\/\\s]+):?[^\\/]*?\\/[\\w]*");

        String findUrl = "";


        Matcher mc = urlPattern.matcher(strUrl);


        if(mc.matches())
        {
            if(mc.group(1) != null)
            {
                System.out.println("domain :: " + mc.group(1));
                findUrl = mc.group(1);
            }

            System.out.println("fileurl :: " + findUrl);


            System.out.println(Arrays.asList(findUrl.split("\\.")).stream().skip(3-1).findFirst().get());

            System.out.println(Arrays.asList(findUrl.split("\\.")).stream().reduce((f , s) -> s).orElse(null));



//            for(int i=0;i<=mc.groupCount();i++)
//                System.out.println("group("+i+") = "+mc.group(i));
        }

        List<String> valueList = new ArrayList<String>();
        valueList.add("Joe");
        valueList.add("John");
        valueList.add("Sean");

        long count = valueList.stream().count();
        Stream<String> stream = valueList.stream();

        System.out.println(stream.skip(count - 1).findFirst().get());




    }



}