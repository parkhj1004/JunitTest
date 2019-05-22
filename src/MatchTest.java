/**
* Created by we on 2018. 5. 9..
*/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchTest {

    private static final Pattern pattern = Pattern.compile("(?:[&]?)(\\w+)=");

    @Test
    public void test() {

        String temp = "where A.SUB_RESULT_SEQ = '$RSEQ$' and A.SUB_ECARE_NO = 37 and A.ECARE_NO = 32 and A.ERROR_CD in (250) and B.CLIENT = 'EC' and A.ECARE_NO = B.SERVICE_NO and A.RESULT_SEQ = B.RESULT_SEQ and A.LIST_SEQ = B.LIST_SEQ";

//        temp = temp.toUpperCase().replaceAll( "\\Q\'$RSEQ$\'\\E", "0");
        temp = temp.toUpperCase().replaceAll( "\\Q\'$RSEQ$\'\\E", "0").replaceAll("(?<=A.SUB_ECARE_NO)(.+?)(?=AND)" , "=0 ");

        System.out.println(" temp :: " + temp);

        String tempRegex = "(?<=A.SUB_ECARE_NO)(.+?)(?=AND)";

        final Pattern pattern1 = Pattern.compile(tempRegex);
        final Matcher matcher1 = pattern1.matcher(temp);

        while (matcher1.find()) {
            System.out.println("d     ; " + matcher1.group());
        }


        String defaultTemplate = "[{\"ordering\":1,\"name\":\"버튼1\",\"linkType\":\"WL\",\"linkTypeName\":\"웹링크\",\"linkMo\":\"#{모바일링크1}\",\"linkPc\":\"#{PC링크1}\",\"linkIos\":null,\"linkAnd\":null},{\"ordering\":2,\"name\":\"버튼2\",\"linkType\":\"WL\",\"linkTypeName\":\"웹링크\",\"linkMo\":\"#{모바일링크2}\",\"linkPc\":\"#{PC링크2}\",\"linkIos\":null,\"linkAnd\":null}]";
        //    \Q#[{]\E((?:(?!\Q#[{]\E).)+)\Q[}]\E

//        defaultTemplate  = "\"linkMo\":\"ddd#{모바일링크1}dddd";


        String head = "#[{]";
        String tail = "[}]";
        String headToChange = "<%=(record.getString(\"";
        String tailToChange = "\"))%>";

        String headLiteral = "\\Q" + head + "\\E";
        String tailLiteral = "\\Q" + tail + "\\E";
        String variableRegex = headLiteral + "((?:(?!"  + headLiteral + ").)+)" + tailLiteral;

//        variableRegex = "(?:[,]?)(#\\{(\\w+)}):";
        variableRegex = "\\Q#[{]\\E((?:(?!\\Q#[{]\\E).)+)\\Q[}]\\E";
        variableRegex = "(?<=#[{])(.+?)(?=[}])";


        /**
         * 전방탐색(lookahead)패턴은 일치 영역을 발견해도 그 값을 반환하지 않는 패턴을 말합니다.
         * 전방탐색은 실제로는 하위 표현식이며, 하위 표현식과 같은 형식으로 작성됩니다. 전방탐색 패턴의 구문은 ?=로 시작하고 등호(=) 다음에 일치할 텍스트가 오는 하위 표현식입니다.
         *
         * 텍스트를 반환하기 전에 뒤쪽을 탐색하는 것은 후방탐색(lookbehind)이라고 합니다. 후방탐색 연산은 ?<=입니다.
         * 기본적으로 후방탐색의 사용방법은 전방 탐색과 같습니다. 하위 표현식 안에서 사용하고 일치할 텍스트 앞에 옵니다.
         *
         * ?! 대소문자 무시
         * ?: 그룹에 들어가지 않는다.
         */

//        String[] strs = defaultTemplate.split("(?<=\\})(?=\\#[{])");
//        String[] strs = defaultTemplate.split(",");
//        for (String s : strs) {
//            System.out.println(s);
//        }



        String variableName = "";
        String targetMethod = "";

        final Pattern pattern = Pattern.compile(variableRegex);
        final Matcher matcher = pattern.matcher(defaultTemplate);

        while(matcher.find()) {

//            System.out.println(matcher.group());
//            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//
            variableName = matcher.group(1);
//            variableName = matcher.group(2);


            StringBuilder sb = new StringBuilder();
            sb.append(headToChange);
            sb.append(variableName);
            sb.append(tailToChange);
            targetMethod = sb.toString();
        }

        System.out.println(targetMethod);
    }



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