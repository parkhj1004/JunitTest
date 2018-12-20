/**
* Created by we on 2018. 5. 9..
*/
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchTest {

    private static final Pattern pattern = Pattern.compile("(?:[&]?)(\\w+)=");

    public static void main(String... args) {


        String test = "From: ddd@bbb.org (The King)";

        Pattern pTest = Pattern.compile("^From: (\\S+) \\(([^()]*)\\)");

        Matcher mTest = pTest.matcher(test);

        if(mTest.find())
        {
            System.out.println(mTest.group(0));
            System.out.println(mTest.group(1));
            System.out.println(mTest.group(2));
        }



        List<Integer> num = new ArrayList<Integer>() {{ add(1); add(2); add(3); add(4); add(5); add(5);  }};

        System.out.println("몇개 :: " + num.stream().filter(x -> x.toString().matches("(^[1-9]*$){1,2}"))
                .filter(x -> x.intValue() <= 45).distinct().count());
//                .reduce((tmp1 , tmp2) -> tmp1.intValue() <= 45 ? tmp2 : tmp1).map(x -> x.intValue()).get().intValue());
        num.stream().filter(x -> x.toString().matches("[1-45]")).forEach(System.out::println);





//        String mode[] = {"ALL" , "AA" , "AP" , "AD" , "ADC","ADS" , "CA","CP","CD","CDC", "CDS"};
        String mode[] = {"ALL" , "AA" ,"ADS" , "CA", "CDS"};

        for(String tmp : mode)
        {
            System.out.println("tmp :: " + tmp + " >>>>> " + tmp.matches("^[A-C]A$"));

            System.out.println("tmp :: " + tmp + "  >>>>> " + tmp.matches("^ALL$|^AA$"));
            System.out.println("tmp :: " + tmp + "  >>>>> " + tmp.matches("^ALL$|^CA$"));
//            System.out.println("tmp :: " + tmp + "  >>>>> " + tmp.matches("^C[A-Z]{2}"));




            System.out.println("tmp :: " + tmp + " 승인 수행 >>>>> " + tmp.matches("^ALL|^A[A-Z]*"));
            System.out.println("tmp :: " + tmp + " 승인 / DB compare >>>>> " + tmp.matches("^ALL|^A[A|D]+[C]*"));
            System.out.println("tmp :: " + tmp + " 승인 / DB settle >>>>> " + tmp.matches("^ALL|^A[A|D]+[S]*"));

            System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " );

            System.out.println("tmp :: " + tmp + " 취소 수행 >>>>> " + tmp.matches("^ALL|^C[A-Z]*"));
            System.out.println("tmp :: " + tmp + " 취소 / DB compare >>>>> " + tmp.matches("^ALL|^C[A|D]+[C]*"));
            System.out.println("tmp :: " + tmp + " 취소 / DB settle >>>>> " + tmp.matches("^ALL|^C[A|D]+[S]*"));

            System.out.println(" ======================================== ");

        }

        System.out.println(Pattern.compile("(A|C)+(DS)+").matcher("CCCCC"));


        String source = "P_STATUS=00&P_AUTH_DT=20180508174821&P_AUTH_NO=00129547&P_RMESG1=성공적으로 처리 하였습니다.&P_RMESG2=00&P_TID=INIMX_CARDwmptest00020180508174821043347&P_FN_CD1=04&P_AMT=400&P_TYPE=CARD&P_UNAME=정dd&&희xx&&인ww&P_MID=wmptest000&P_OID=t1805081090&P_NOTI=&P_NEXT_URL=http://evan.mescrow-dev.wemakeprice.com:8081//inicis/privyMobileCertifyResult&P_MNAME=&P_NOTEURL=&P_CARD_MEMBER_NUM=&P_CARD_NUM=949019154754&P_CARD_ISSUER_CODE=00&P_CARD_PURCHASE_CODE=04&P_CARD_PRTC_CODE=1&P_CARD_INTEREST=0&P_CARD_CHECKFLAG=0&P_CARD_ISSUER_NAME=&P_CARD_PURCHASE_NAME=&P_FN_NM=현대카드&P_MERCHANT_RESERVED=dXNlcG9pbnQ9MCY%3D&P_CARD_APPLPRICE=400";

        Map<String, String> returnMap = MatchTest.parseQueryString(source);

        for (Map.Entry next : returnMap.entrySet()) {
            System.out.println("key  : " + next.getKey());
            System.out.println("value: " + next.getValue());
        }

        Pattern p = Pattern.compile("(?:[0]*)([1-9]*[0-9]*)");

        String amount = "0000000025000";

        Matcher m = p.matcher(amount);

        if(m.find())
        {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
        }


    }



    public static Map<String, String> parseQueryString(String source) {
        Map<String, String> returnMap = new HashMap<String, String>();

        boolean isFirst = true;
        String key = "";
        int prevPatternEndIndex = -1;
        Matcher matcher = pattern.matcher(source);

        while (matcher.find()) {
            if (isFirst) {
                key = matcher.group(1);
                prevPatternEndIndex = matcher.end();
                isFirst = false;
                continue;
            }

            System.out.println(prevPatternEndIndex + " , " + matcher.start());

            returnMap.put(key, source.substring(prevPatternEndIndex, matcher.start()));

            key = matcher.group(1);
            prevPatternEndIndex = matcher.end();
        }

        returnMap.put(key, source.substring(prevPatternEndIndex));
        return returnMap;
    }
}