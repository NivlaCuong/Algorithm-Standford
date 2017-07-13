package CountingInversion;
import java.io.*;
/**
 * Created by CalvinNguyen on 7/12/17.
 */
public class countInversion {

    private long numberInv;
    private int[] array;
    private int[] givenArray;

    countInversion(int size) {
        array = new int[size];
        givenArray = new int[size];
        setInitArray(size);
    }

    public int[] mergeSort(int[] input) {
        if (input.length == 1) {
            return input;
        }
        int[] firstHalf = new int[input.length/2], secondhalf = new int[input.length - input.length/2];

        for (int i = 0; i < input.length/2; i++) {
            firstHalf[i] = input[i];
        }
        int count = 0;
        for (int i = input.length/2; count < secondhalf.length && i < input.length; i++) {
            secondhalf[count] = input[i];
            count++;
        }
        return sort(mergeSort(firstHalf), mergeSort(secondhalf));
    }


    int[] sort(int[] a, int[] b) {
        int countInv = 0;
        int size = a.length + b.length;
        int[] result = new int[size];
        int i = 0, j = 0, k;
        for (k = 0; k < size; k++) {
            if (i == a.length || j == b.length) break;
            if (i < a.length && a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else if (j < b.length && a[i] > b[j]) {
                result[k] = b[j];
                    for (int count = 0; count < a.length; count++) {
                        if (a[count] > b[j]) {
                            countInv++;
                        }
                    }
                j++;
            }
        }
        while (i < a.length) {
            result[k] = a[i];
            k++;
            i++;
        }
        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }
        addNumberInv(countInv);
        return result;
    }

    void setInitArray(int size) {
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
    }

    long getNumberInv() {
        return numberInv;
    }

    void addNumberInv(int input) {
        numberInv += input;
    }

    void setArray(int[] input) {
        array = input;
    }
    int[] getArray() {
        return array;
    }

    int[] getGivenArray() {
        return givenArray;
    }
    void setGivenArray(int[] input) {
        givenArray = input;
    }

    void findNum(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                System.out.println("At position " + (i + 1) + ", " + "number " + num + " is found.");
                return;
            }
        }
        System.out.println(num + " is not found!");
        return;
    }

    public static void main(String[] args) {
        countInversion a = new countInversion(100000);

        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null && count < 100000) {
                a.givenArray[count] = Integer.parseInt(line);
                count++;
            }

            a.mergeSort(a.givenArray);
            System.out.println(a.getNumberInv());
//            a.mergeSort(a.givenArray);
//            sout
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
