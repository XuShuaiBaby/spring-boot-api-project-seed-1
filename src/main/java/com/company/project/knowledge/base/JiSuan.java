package com.company.project.knowledge.base;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JiSuan {

    /*public static BigDecimal P1;
    public static BigDecimal P0;
    public static BigDecimal A;
    public static BigDecimal d;
    public static BigDecimal d2;
    public static BigDecimal i0;
    public static BigDecimal i2;
    public static BigDecimal R1;
    public static BigDecimal R2;
    public static BigDecimal R3;

    //(P0*(1-A))
    public static BigDecimal tempA =(P0.multiply(new BigDecimal(1).subtract(A)));
    //360*(i0+i2)
    public static BigDecimal tempB = new BigDecimal(360).multiply(i0.add(i2));
    //P0*(R1*R3+R3-R1*R2-R1)
    public static BigDecimal tempC = P0.multiply(R1.multiply(R3).add(R3).subtract(R1.multiply(R2)).subtract(R1));
    //(1-R1*R2-R3-R1*R3)
    public static BigDecimal tempD = new BigDecimal(1).subtract(R1.multiply(R2).subtract(R3).subtract(R1.multiply(R3)));
    //(1+R1)
    public static BigDecimal tempE = new BigDecimal(1).add(R1);*/

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            simpleDateFormat.parse("1970-01-01 23:23:23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*BigDecimal A = price.add(price.multiply(new BigDecimal(1).subtract(bailAmountRate)).multiply(new BigDecimal(days)).multiply(capitalRate.add(rate)).divide(new BigDecimal(360),8, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(1).add(vat));
    BigDecimal B = price.multiply(stampDutyRate.add(vat.multiply(stampDutyRate.subtract(additionalVatRates).subtract(new BigDecimal(1)))));
    BigDecimal C = new BigDecimal(1).subtract(vat.multiply(stampDutyRate.add(additionalVatRates))).subtract(stampDutyRate);
    BigDecimal todayPrice = A.add(B).divide(C,2, BigDecimal.ROUND_HALF_UP);*/

}
