
import java.math.BigDecimal;

/**
 * Created by we on 2017. 12. 18..
 */
public class BigDecimalTest {

    public static void main(String args[])
    {



        BigDecimal feeRate = new BigDecimal("100").subtract(new BigDecimal("75"));

        System.out.println("feeRate :: " + feeRate);

        BigDecimal optionPriceByfeeRatio = new BigDecimal("0");
        BigDecimal optionPriceByfeeRatio1 = new BigDecimal("0");
        BigDecimal feeAmt = new BigDecimal("0");
        BigDecimal optionPrice = new BigDecimal(String.valueOf("10000"));

        optionPriceByfeeRatio = feeRate.divide(new BigDecimal("100"), 10, BigDecimal.ROUND_CEILING);

        System.out.println("optionPriceByFeeRatio   " + optionPriceByfeeRatio);

        feeAmt = optionPrice.multiply(optionPriceByfeeRatio);
        feeAmt = feeAmt.setScale(0, BigDecimal.ROUND_CEILING);



        optionPriceByfeeRatio1 = new BigDecimal("1").divide(new BigDecimal("10000") , 10 , BigDecimal.ROUND_FLOOR);

        System.out.println("optionPriceByfeeRatio1  :: " + optionPriceByfeeRatio1 +  " ,  " + optionPriceByfeeRatio1.doubleValue());

        System.out.println(Double.parseDouble(optionPriceByfeeRatio1.toString()));



        System.out.println("DDd    " + optionPrice.subtract(optionPrice.multiply(new BigDecimal("40").divide(new BigDecimal("100") , 4 , BigDecimal.ROUND_CEILING))));



        System.out.println("ddddddd   : "  + new BigDecimal(String.valueOf("0.4")).divide(new BigDecimal("2") , 4, BigDecimal.ROUND_CEILING));



        System.out.print("feeAmt::" + feeAmt);
    }
}
