import java.io.File;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;


/**
* Created by we on 2017. 12. 12..
*/
public class BasicTest {

    @Test
    public void shortenTeset() {
        //HashMap to store the longUrl and the randomly generated string
        HashMap<String,String> urlMap = new HashMap<>();

        String longUrl = "http://www.ddd.com";

        // Encodes a URL to a shortened URL.
//        public String encode(String longUrl) {
            Random rand = new Random();
            int urlLen = 8;
            char [] shortURL = new char[urlLen];
            String randChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

            for(int i = 0; i < urlLen; i++ )
                shortURL[i] = randChars.charAt(rand.nextInt(randChars.length()));

            StringBuilder sb = new StringBuilder("http://localhost/");
            sb.append(new String(shortURL));
            System.out.println(sb);

            urlMap.put(sb.toString(),longUrl);

            System.out.println(urlMap.toString());

//            return sb.toString();

//        }
    }

    // Decodes a shortened URL to its original URL.
//    public String decode(String shortUrl) {
//
//        return urlMap.get(shortUrl);
//
//    }

    @Test
    public void encryt() throws Exception{
        String md2 = getHash("test", "md2");
        String md5 = getHash("test", "md5");
        String sha1 = getHash("test", "sha1");
        String sha256 = getHash("test", "sha-256");
        String sha384 = getHash("test", "sha-384");
        String sha512 = getHash("test", "sha-512");
//        String crc32 = getHash("test", "CRC32");

        // “MD2″, “MD5″, “SHA1″, “SHA-256″, “SHA-384″, “SHA-512″
        System.out.println("MD2     : [" + md2 + "](" + md2.length() + ")");
        System.out.println("MD5     : [" + md5 + "](" + md5.length() + ")");
        System.out.println("SHA1    : [" + sha1 + "](" + sha1.length() + ")");
        System.out.println("SHA-256 : [" + sha256 + "](" + sha256.length() + ")");
        System.out.println("SHA-384 : [" + sha384 + "](" + sha384.length() + ")");
        System.out.println("SHA-512 : [" + sha512 + "](" + sha512.length() + ")");
//        System.out.println("CRC32 : [" + crc32 + "](" + crc32.length() + ")");
    }

    public static String getHash(String message, String algorithm)
            throws NoSuchAlgorithmException {

        try {
            byte[] buffer = message.getBytes();
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(buffer);
            byte[] digest = md.digest();
            StringBuilder hex = new StringBuilder();

            for(int i = 0 ; i < digest.length ; i++) {
                int b = digest[i] & 0xff;
                if (Integer.toHexString(b).length() == 1) hex.append("0");
                hex.append(Integer.toHexString(b));
            }

            return hex.toString();
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void shorten() {
        int n = 12345;
        String shorturl = idToShortURL(n);
        System.out.println("Generated short url is " + shorturl);
        System.out.println("Id from url is " +
                shortURLtoID(shorturl));
    }

    // Function to generate a short url from integer ID
    static String idToShortURL(int n)
    {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shorturl = new StringBuffer();

        // Convert given integer id to a base 62 number
        while (n > 0)
        {
            // use above map to store actual character
            // in short url
            shorturl.append(map[n % 62]);
            n = n / 62;
        }

        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }

    // Function to get integer ID back from a short url
    static int shortURLtoID(String shortURL)
    {
        int id = 0; // initialize result

        // A simple base conversion logic
        for (int i = 0; i < shortURL.length(); i++)
        {
            if ('a' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'z')
                id = id * 62 + shortURL.charAt(i) - 'a';
            if ('A' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'Z')
                id = id * 62 + shortURL.charAt(i) - 'A' + 26;
            if ('0' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= '9')
                id = id * 62 + shortURL.charAt(i) - '0' + 52;
        }

        System.out.println("id ::: " + id);
        return id;
    }

    @Test
    public void test() {
        String gatewaySubInfo = "127.0.0.1:2222,1.1.1.1:4444";
        String[] gatewaySubInfoArr = gatewaySubInfo.split(",");

        System.out.println(gatewaySubInfoArr.length);
        System.out.println(gatewaySubInfoArr[0]);



        for(String gatewayInfo : gatewaySubInfoArr) {
            if (gatewayInfo.indexOf(':') == -1) {
                continue;
            }

            String[] ipPortStr = gatewayInfo.split(":");

            HashMap<String, String> map = new HashMap<>();

            map.put("ip", ipPortStr[0]);
            map.put("port", ipPortStr[1]);

            System.out.println(map.toString());
        }


    }

    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    @Test
    public void base64() {
        Base64.Encoder enc2 = Base64.getMimeEncoder();

        System.out.println(enc2.encodeToString("M&Wise:Abcd1234!".getBytes()));
    }



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

    static int factorial(int n) {

//        int result = n;

        System.out.println(n);


        if (n > 1) {
            System.out.println("n : " + n);
            //System.out.println(n + "*" + factorial(n-1));
            return  (n * factorial(n - 1));
        } else {
            System.out.println("nnn : " + n);
            return n;
        }
    }

    public static void main(String[] args) {

        System.out.println(factorial(4));


        long startTime = 0;
        long endTime = 0;

//        String testString = new String("abc");
        String testString ="abc";
        StringBuilder stringBuilder = new StringBuilder("abc");
//        MyStringBuilder myStringBuilder = new MyStringBuilder("abc");

        startTime = System.nanoTime();
        for (int i=0; i<10; i++) {
            testString += "abc";

            System.out.println(testString + " ::: " + testString.hashCode());
        }
        endTime = System.nanoTime();

        System.out.println("String 실행 시간          : " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<10; i++) {
            testString = testString.concat("========");

            System.out.println(testString + " ::: " + testString.hashCode());
        }
        endTime = System.nanoTime();

        System.out.println("String 실행 시간          : " + (endTime - startTime));
        startTime = System.nanoTime();
        for (int i=0; i<10; i++) {
            stringBuilder.append("abc");

            System.out.println(stringBuilder+ " ::: " + stringBuilder.hashCode());
        }
        endTime = System.nanoTime();

        System.out.println("StringBuilder 실행 시간   : " + (endTime - startTime));


//        String testString = "";
//        for(int i = 0; i < 10000; i++){
//            testString += "|test|";
//        }

        System.out.println(testString);

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