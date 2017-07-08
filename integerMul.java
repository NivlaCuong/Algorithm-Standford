/**
 * Created by CalvinNguyen on 7/7/17.
 */
import java.util.*;
/**
 * The class IntegerMul will implement 2 different ways  to multiply 2 nth-digit nunbers
 */
public class integerMul {
    //        3141592653589793238462643383279502884197169399375105820974944592
//        2718281828459045235360287471352662497757247093699959574966967627
    private String firstNum, secondNum, result;

    public integerMul(String a, String b) {
        firstNum = a;
        secondNum = b;
    }
    public integerMul() {
        this("","");
    }

    public String mul(String val1, String val2) {
        if (val1.length() == 1 && val2.length() == 1) {
            long res = Long.parseLong(val1) * Long.parseLong(val2);
            return Long.toString(res);
        }
        while (val1.length() < val2.length()) {
            val1 = "0" + val1;
        }
        while (val2.length() < val1.length()) {
            val2 = "0" + val2;
        }
        if (val1.length() % 2 != 0) {
            val1 = "0" + val1;
        }
        if (val2.length() % 2 != 0) {
            val2 = "0" + val2;
        }


        String a = val1.substring(0,val1.length()/2);
        String b = val1.substring(val1.length()/2, val1.length());
        String c = val2.substring(0,val2.length()/2);
        String d = val2.substring(val2.length()/2, val2.length());
        long step1 = Long.parseLong(mul(a,c));
        long step2 = Long.parseLong(mul(b,d));
        long step3 = Long.parseLong(mul(Long.toString(Long.parseLong(a) + Long.parseLong(b)), Long.toString(Long.parseLong(c) + Long.parseLong(d))));
        long step4 = step3 - step2 - step1;
        long result = (long) Math.pow(10, val1.length()) * step1 + step2 + step4 * (long) Math.pow(10, val1.length()/2);
        return Long.toString(result);
    }

    public static void main(String[] args) {
        integerMul obj = new integerMul();

        System.out.println(obj.mul("3141592653589793","2718281828459045"));

    }





}
