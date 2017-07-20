package quickSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by CalvinNguyen on 7/18/17.
 */
public class quickSort {

    int[] numbers;
    long totalComparision;

    quickSort(int input) {
        numbers = new int[input];
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] input) {
        numbers = input;
    }
    public long getTotalComparision() {
        return totalComparision;
    }
    public void addTotalComparision(long input) {
        totalComparision += input;
    }

    int chooseFirstElement(int[] input, int first) {
        return input[first];
    }
    int chooseLastElement(int[] input) {
        return input[input.length - 1];
    }
    int chooseMidPivot(int[] input) {
        return 0;
    }

    void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    void quickSort(int[] input, int lo, int hi) {

        if (hi <= lo) return;
        int p = chooseFirstElement(input,lo);
        partition(input, lo, hi);
        int last = lo;
        for (int i = lo; i < input.length; i++) {
            if (input[i] == p) {
                break;
            }
            last++;
        }
        quickSort(input, lo, last - 1);
        quickSort(input, last + 1, hi);
    }

    void partition(int[] input, int low, int hi) {
        int i = low + 1;
        int p = chooseFirstElement(input, low);
        for (int j = low + 1; j <= hi; j++) {
            if (input[j] < p) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, low, i - 1);
    }

    void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public static void main(String[] args) {
        quickSort a = new quickSort(10000);
//        quickSort a = new quickSort(8);

        try(BufferedReader br = new BufferedReader(new FileReader("assignment3.txt"))) {
//            a.numbers = new int[] {3,8,2,0,10,23,9,24,11,5,1,4,7,6};
            String line;
            int count = 0;

            while ((line = br.readLine()) != null && count < 10000) {
                a.numbers[count] = Integer.parseInt(line);
                count++;
            }
            a.quickSort(a.numbers);
            for (int x: a.numbers) {
                System.out.println(x);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
