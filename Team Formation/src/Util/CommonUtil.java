package Util;

import java.util.ArrayList;

public class CommonUtil {

    public static int formatInteger(int val){
        if(val<10){
            String text = (val < 10 ? "0" : "") + val;
            try{
                val = Integer.parseInt(text);
            }catch (Exception e){
            }
            return val;
        }else {
            return val;
        }
    }

    public static double calculateSD(ArrayList<Double> numArray)
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.size();

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }

    public static Double roundOff(Double value){

       return Math.round(value * 100.0) / 100.0;
    }

}
