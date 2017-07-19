package IntegerMultiplication;
/**
 * The class IntegerMul will implement 2 different ways  to multiply 2 nth-digit nunbers
 */
public class integerMul {
    // 2D String Array: Contain an array of many split characters of multiple Strings.
    String[][] array;

    /**
     * This fucntion will convert Strings into String Array and will to basic addition
     * @param index
     * @param res: keep track of result after each recursive call
     * @param numbers: 2D Array of Strings
     * @return the addition of two or 3 numbers in String format.
     */
    public static void main(String[] args) {
    }

    /**
     * This functions run the Karatsuba Algorithm
     * @param val1 First number
     * @param val2 Second number
     * @return the multiplication of 2 numbers
     */
    String mul(String val1, String val2) {
        String a,b,c,d;
        String step1, step2, step3, step4, step5;

        //Base case
        if (val1.length() == 1 && val2.length() == 1) {
            return Long.toString(Long.parseLong(val1) * Long.parseLong(val2));
        }

        //Make all numbers even
        while (val1.length() < val2.length() || val1.length() % 2 != 0) {
            val1 = "0" + val1;
        }
        while (val2.length() < val1.length() || val2.length() % 2 != 0) {
            val2 = "0" + val2;
        }

        //Split numbers into quadrant
        a = val1.substring(0, val1.length()/2);
        b = val1.substring(val1.length()/2, val1.length());
        c = val2.substring(0, val2.length()/2);
        d = val2.substring(val2.length()/2, val2.length());

        /** Begin Karatsuba Algorithm */
        step1 = mul(a,c);
        step2 = mul(b,d);
        step3 = mul(a,d);
        step4 = mul(b,c);

        //Make all numbers even
        int max = Math.max(step3.length(), step4.length());
        step3 = addZeroToFront(step3,max);
        step4 = addZeroToFront(step4, max);

        array = new String[2][max];
        initializeArray(array, 2, step3, step4);

        step5 = addition(step3.length() - 1, "", array);

        step1 = addZeroToEnd(step1,val1.length());
        step5 = addZeroToEnd(step5, val1.length()/2);

        int max2 = Math.max(Math.max(step1.length(), step5.length()), step2.length());

        step1 = addZeroToFront(step1, max2);
        step2 = addZeroToFront(step2, max2);
        step5 = addZeroToFront(step5, max2);

        array = new String[3][max2];
        initializeArray(array, 3, step1, step2, step5);

        String res = addition(step1.length() - 1, "", array);
        while(res.startsWith("0")) {
            res = res.substring(1);
        }
        return res;
    }

    /**
     * Add 0 to the Front of the String
     * @param value: String need to add
     * @param size: Number of 0 to add
     * @return a String with modification
     */
    String addZeroToFront(String value, int size) {
        while (value.length() < size) {
            value = "0" + value;
        }
        return value;
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
        if (sum < 10 && index == 0) {
            return result;
        }
        if (sum >= 10) {
            if (index == 0) {
                return Integer.toString(sum / 10) + result;
            } else {
                int temp2 = Integer.parseInt(numbers[0][index - 1]) + (sum / 10);
                numbers[0][index - 1] = Integer.toString(temp2);
            }
        }
        return addition(index - 1, result, numbers);
    }
    /**
     * Add 0 to the End of the String
     * @param value: String need to add
     * @param size: Number of 0 to add
     * @return a String with modification
     */
    String addZeroToEnd(String value, int size) {
        for (int i = 0; i < size; i++) {
            value += "0";
        }
        return value;
    }

    /**
     * Splits the String into String Array
     * @param input
     * @param size
     * @param value
     */
    void initializeArray(String[][] input, int size, String... value) {
        for (int i = 0; i < size; i++) {
            input[i] = value[i].split("");
        }
    }

}
