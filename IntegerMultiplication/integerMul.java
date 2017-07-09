package IntegerMultiplication;
/**
 * Created by CalvinNguyen on 7/7/17.
 */
/**
 * The class IntegerMul will implement 2 different ways  to multiply 2 nth-digit nunbers
 */
public class integerMul {
    private String firstNum, secondNum;
    String[][] num0, num;


    integerMul(String a, String b) {
        firstNum = a;
        secondNum = b;
    }
    integerMul() {
        this("","");
    }

    void initializeArray(String[][] input,int size, int size2, String... value) {
        input = new String[size][size2];
        for (int i = 0; i < size; i++) {
            input[i] = value[i].split("");
        }
    }

    String addition(int index, String res, String[][] numbers) {
        int sum = 0;
        String result = res;
        if (index < 0) {
            return result;
        }

        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i][index]);
        }
        int temp1 = sum % 10;
        result = Integer.toString(temp1) + result;
        if (sum >= 10) {
            if (index == 0) {
                result = Integer.toString(sum / 10) + result;
                return result;
            } else {
                int temp2 = Integer.parseInt(numbers[0][index - 1]) + (sum / 10);
                numbers[0][index - 1] = Integer.toString(temp2);
            }
        }
        if (sum < 10 && index == 0) {
            return result;
        }
        return addition(index - 1, result, numbers);
    }
    void splitString(String val1, String val2) {

    }

    /**
     * This functions run the Karatsuba Algorithm
     * @param val1 First value
     * @param val2
     * @return
     */
    String mul(String val1, String val2) {
        String a,b,c,d;
        String step1, step2, step3, step4, step5;
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
        a = val1.substring(0, val1.length()/2);
        b = val1.substring(val1.length()/2, val1.length());
        c = val2.substring(0, val2.length()/2);
        d = val2.substring(val2.length()/2, val2.length());
//        splitString(val1,val2);

        step1 = mul(a,c);
        step2 = mul(b,d);
        step3 = mul(a,d);
        step4 = mul(b,c);

        int max = Math.max(step3.length(), step4.length());
        while (step3.length() < max) {
            step3 = "0" + step3;
        }
        while (step4.length() < max) {
            step4 = "0" + step4;
        }

        num0 = new String[2][max];
        num0[0] = step3.split("");
        num0[1] = step4.split("");
//        initializeArray(num0, 2, max, step3, step4);

        step5 = addition(step3.length() - 1, "", num0);

        for (int i = 0; i < val1.length(); i++) {
            step1 += "0";
        }
        for (int i = 0; i < val1.length()/2; i++) {
            step5 += "0";
        }

        int max1 = Math.max(step1.length(), step5.length());
        int max2 = Math.max(max1, step2.length());
        while (step1.length() < max2) {
            step1 = "0" + step1;
        }
        while (step2.length() < max2) {
            step2 = "0" + step2;
        }
        while (step5.length() < max2) {
            step5 = "0" + step5;
        }
        num = new String[3][max2];
        num[0] = step1.split("");
        num[1] = step2.split("");
        num[2] = step5.split("");
//        initializeArray(num,3,max2,step1,step2,step5);

        String res = addition(step1.length() - 1, "", num);
        while(res.startsWith("0")) {
            res = res.substring(1);
        }
        return res;
    }

    public static void main(String[] args) {
        integerMul obj = new integerMul("31415926535897932384626433832", "27182818284590452353602874713");
        System.out.println(obj.mul(obj.firstNum,obj.secondNum));

    }





}
