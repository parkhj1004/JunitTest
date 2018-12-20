/**
* Created by we on 2017. 6. 7..
*/
public class FormatTest {

    public static void main(String args[])
    {
        String test = "WT46881112346814";

        String temp = "";

        temp = test.length() > 5 ? String.format("%" + test.length() + "s" ,  test.substring(test.length() -5)).replace(' ' , '*') : "ㅇㅇㅇ";

        test = "박효진";

        System.out.println(temp);

        System.out.println(("237").lastIndexOf("5"));

        if( ("235").lastIndexOf("5") == 0)
        {
            System.out.println("ddd");
        }
    }
}